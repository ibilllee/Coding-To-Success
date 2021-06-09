package com.scut.cts.controller;

import com.scut.cts.pojo.Data;
import com.scut.cts.pojo.RespBean;
import com.scut.cts.service.DataService;
import com.scut.cts.data.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/data")
public class DataController {
    @Autowired
    private DataService dataService;
    @Autowired
    private RestTemplate restTemplate;

    @PostMapping("add")
    public RespBean addData(@RequestParam Integer probId, DataList dataList) {
        List<AddDataNode> addList = dataList.getDataList();
        for (int i = 0; i < addList.size(); i++) {
            Data data = null;
            try {
                data = new Data(probId,dataService.selectMaxDataIdInProbId(probId)+1,
                        addList.get(i).getIn(), addList.get(i).getOut());
                dataService.addData(data);
            }catch (Exception e) {
                return RespBean.unprocessable("数据添加失败");
            }
        }

        String url = "http://localhost:8081/problems";
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);
        MultiValueMap<String, String> map = new LinkedMultiValueMap<>();
        map.add("probId", String.valueOf(probId));
        map.add("dataList", String.valueOf(dataList));

        HttpEntity<MultiValueMap<String, String>> request = new HttpEntity<>(map, headers);
        ResponseEntity<String> response = null;
        try {
            response = restTemplate.postForEntity(url, request, String.class);
        }catch (Exception e) {
            return RespBean.unprocessable("数据转发失败"+e.getMessage());
        }
        return RespBean.ok("数据添加成功");
    }

    @DeleteMapping("delete/{dataIds}/{probId}")
    public RespBean deleteData(@PathVariable String dataIds, @PathVariable Integer probId) {
        String[] idsArray = dataIds.split("&");
        for (int i = 0; i < idsArray.length; i++) {
            try {
                dataService.deleteDataByDataId(probId,Integer.parseInt(idsArray[i]));
            }catch (Exception e) {
                return RespBean.unprocessable("数据删除失败"+e.getMessage());
            }
        }

        String url = "http://localhost:8081/problems";
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);
        MultiValueMap<String, String> map = new LinkedMultiValueMap<>();
        map.add("probId",String.valueOf(probId));
        HttpEntity<MultiValueMap<String, String>> request = new HttpEntity<>(map, headers);
        try {
            restTemplate.delete(url, request, String.class);
        }catch (Exception e) {
            System.out.println(e.getMessage());
        }

        return RespBean.ok("数据删除成功");
    }

    @GetMapping("/get/{probId}")
    public RespBean getDataByProbId(@PathVariable Integer probId) {
        List<Data> dataList = new ArrayList<>();
        try {
            dataList = dataService.selectDataByProbId(probId);
        }catch (Exception e) {
            return RespBean.unprocessable("数据获取失败"+e.getMessage(),dataList);
        }
        for (int i = 0; i < dataList.size(); i++) {
            if(dataList.get(i) == null) {
                return RespBean.unprocessable("数据获取失败",dataList.get(i));
            }
        }
        List<DataNode> dataNodeList = new ArrayList<>();
        for (int i = 0; i < dataList.size(); i++) {
            Data data = dataList.get(i);
            dataNodeList.add(new DataNode(data.getDataId(), data.getDataIn(), data.getDataOut()));
        }
        return RespBean.ok("数据获取成功",dataNodeList);
    }
}





