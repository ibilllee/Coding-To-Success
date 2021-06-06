package com.scut.cts.controller;

import com.scut.cts.pojo.Code;
import com.scut.cts.pojo.UserCode;
import com.scut.cts.pojo.RespBean;
import com.scut.cts.service.CodeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/code")
public class CodeController
{
	@Autowired
	private CodeService codeService;

	@Autowired
	private RestTemplate restTemplate;

	@PostMapping
	public RespBean testCode(@RequestParam(value = "userCode") String userCode,
							 @RequestParam(value = "probId") int probId) {
		Code code = new Code(userCode, probId);

		String url = "http://localhost:8081/judger";
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);
		MultiValueMap<String, String> map = new LinkedMultiValueMap<>();
		map.add("probId", String.valueOf(probId));
		map.add("userCode", userCode);

		HttpEntity<MultiValueMap<String, String>> request = new HttpEntity<>(map, headers);
		ResponseEntity<String> response = restTemplate.postForEntity(url, request, String.class);

		String body = response.getBody();
		if ("cases".equals(body.substring(2, 7)))
			return RespBean.ok("编译成功", body);
		return RespBean.ok("编译失败", null);
	}

	@PostMapping
	public RespBean transfromData(@RequestParam String data, @RequestParam Integer probId) {
		String url = "http://localhost:8081/judger";
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);
		MultiValueMap<String, String> map = new LinkedMultiValueMap<>();
		map.add("probId", String.valueOf(probId));
		map.add("data", data);

		HttpEntity<MultiValueMap<String, String>> request = new HttpEntity<>(map, headers);
		ResponseEntity<String> response = restTemplate.postForEntity(url, request, String.class);

		return RespBean.ok("数据已转发");
	}

	@PostMapping("/save")
	public RespBean saveCode(UserCode userCode){
		boolean result;
		try {
			result=codeService.saveCode(userCode);
		}catch (Exception e){
			return RespBean.unprocessable("代码暂存失败！"+e.getMessage());
		}
		if (result)
			return RespBean.ok("代码暂存成功！");
		return RespBean.unprocessable("代码暂存失败！");
	}

	@GetMapping("/get/{probId}/{userId}")
	public RespBean getCode(@PathVariable int probId,@PathVariable String userId){
		UserCode code;
		try {
			code = codeService.getCode(userId, probId);
		}catch (Exception e){
			return RespBean.unprocessable("代码获取失败！"+e.getMessage());
		}
		if(code.getCode()!=null)
		return RespBean.ok("代码获取成功！",code.getCode());
		return RespBean.unprocessable("代码获取失败！缓存中没有指定代码");
	}
}
