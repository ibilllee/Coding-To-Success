package com.scut.cts.transfer;

import com.scut.cts.data.*;
import com.scut.cts.dto.RespBean;
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
@RequestMapping("data/transfer")
public class DataForwarder {
    @Autowired
    private RestTemplate restTemplate;

    @PostMapping("/add")
    public RespBean addDataForward(@RequestParam Integer probId, DataList dataList) {
        String url = "http://localhost:8081/problems";
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);
        MultiValueMap<String, String> map = new LinkedMultiValueMap<>();
        map.add("probId",String.valueOf(probId));
        map.add("dataList",String.valueOf(dataList));

        ResponseEntity<String> response = null;
        HttpEntity<MultiValueMap<String, String>> request = new HttpEntity<>(map, headers);
        try {
            response = restTemplate.postForEntity(url, request, String.class);
        }catch (Exception e) {
            System.out.println(e.getMessage());
        }
        String body = response.getBody();
        return RespBean.ok("Success",body);
    }

    @PutMapping("/update")
    public RespBean updateDataForward(@RequestParam Integer probId, DataList dataList) {
        String url = "http://localhost:8081/problems";
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);
        MultiValueMap<String, String> map = new LinkedMultiValueMap<>();
        map.add("probId",String.valueOf(probId));
        map.add("dataList",String.valueOf(dataList));

        HttpEntity<MultiValueMap<String, String>> request = new HttpEntity<>(map, headers);
        try {
            restTemplate.put(url, request, String.class);
        }catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return RespBean.ok("Success");
    }

    @DeleteMapping("/delete")
    public RespBean deleteDataForward(@RequestParam Integer probId) {
        String url = "http://localhost:8081/problems";
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);
        MultiValueMap<String, String> map = new LinkedMultiValueMap<>();
        map.add("probId",String.valueOf(probId));
        HttpEntity<MultiValueMap<String, String>> request = new HttpEntity<>(map, headers);
        try {
            restTemplate.delete(url, request, String.class);
        }catch (Exception e) {
            System.out.println("Failed");
            System.out.println(e.getMessage());
        }
        return RespBean.ok("Success");
    }
}
