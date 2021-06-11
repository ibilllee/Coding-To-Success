package com.scut.cts.controller;

import com.alibaba.fastjson.JSONObject;
import com.scut.cts.config.HostConfig;
import com.scut.cts.pojo.Data;
import com.scut.cts.dto.RespBean;
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
import java.util.List;

@RestController
@RequestMapping("/data")
public class DataController {
    @Autowired
    private DataService dataService;
    @Autowired
    private RestTemplate restTemplate;

    @PostMapping("/add")
    public RespBean addData(@RequestParam Integer probId, DataList dataList) {
        List<AddDataNode> addList = dataList.getDataList();
        for (int i = 0; i < addList.size(); i++) {
            Data data = null;
            try {
                Integer maxDataId= dataService.selectMaxDataIdInProbId(probId);
                if (maxDataId==null) maxDataId=0;
                data = new Data(probId,maxDataId+1,
                        addList.get(i).getIn(), addList.get(i).getOut());
                dataService.addData(data);
            }catch (Exception e) {
                return RespBean.unprocessable("测试数据添加失败"+e.getMessage());
            }
        }

        String url = HostConfig.getJudgerAddress()+ "problem";
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);
        MultiValueMap<String, String> map = new LinkedMultiValueMap<>();
        map.add("probId", String.valueOf(probId));
        map.add("cases", String.valueOf(dataList));

        HttpEntity<MultiValueMap<String, String>> request = new HttpEntity<>(map, headers);
        ResponseEntity<String> response = null;
        try {
            response = restTemplate.postForEntity(url, request, String.class);
        }catch (Exception e) {
            return RespBean.unprocessable("数据转发失败"+e.getMessage());
        }
        return RespBean.ok("测试数据添加成功!");
    }

    @DeleteMapping("/delete/{dataIds}")
    public RespBean deleteData(@PathVariable String dataIds, @RequestParam Integer probId) {
        String[] idsArray = dataIds.split("&");
        for (int i = 0; i < idsArray.length; i++) {
            try {
                dataService.deleteDataByDataId(probId,Integer.parseInt(idsArray[i]));
            }catch (Exception e) {
                return RespBean.unprocessable("测试数据删除失败"+e.getMessage());
            }
        }

        String url = HostConfig.getJudgerAddress()+"problem";
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

        return RespBean.ok("测试数据删除成功");
    }

    @GetMapping("/get/{probId}")
    public RespBean getDataByProbId(@PathVariable Integer probId) {
        List<Data> dataList = new ArrayList<>();
        try {
            dataList = dataService.selectDataByProbId(probId);
        }catch (Exception e) {
            return RespBean.unprocessable("测试数据获取失败"+e.getMessage(),dataList);
        }
        for (int i = 0; i < dataList.size(); i++) {
            if(dataList.get(i) == null) {
                return RespBean.unprocessable("测试数据获取失败",dataList.get(i));
            }
        }
        List<DataNode> dataNodeList = new ArrayList<>();
        for (int i = 0; i < dataList.size(); i++) {
            Data data = dataList.get(i);
            dataNodeList.add(new DataNode(data.getDataId(), data.getDataIn(), data.getDataOut()));
        }
        return RespBean.ok("测试数据获取成功",dataNodeList);
    }

    @PutMapping("/modify/{dataId}")
    public RespBean updateData(@PathVariable Integer dataId, @RequestParam String in,
                               @RequestParam String out, @RequestParam Integer probId) {
//        List<AddDataNode> updateList = dataList.getDataList();
//        for (int i = 0; i < updateList.size(); i++) {
//            com.scut.cts.pojo.Data newData = new com.scut.cts.pojo.Data();
//            try {
//                com.scut.cts.pojo.Data oldData = dataService.selectDataByDataId(probId,dataId);
//                newData.setId(oldData.getId());
//                newData.setDataIn(updateList.get(i).getIn());
//                newData.setDataOut(updateList.get(i).getOut());
//                dataService.updateData(newData);
//            }catch (Exception e) {
//                return RespBean.unprocessable("数据修改失败"+e.getMessage(),newData);
//            }
//        }
        com.scut.cts.pojo.Data newData = new com.scut.cts.pojo.Data();
        com.scut.cts.pojo.Data oldData = dataService.selectDataByDataId(probId,dataId);
        newData.setId(oldData.getId());
        newData.setDataIn(in);
        newData.setDataOut(out);
        try {
            dataService.updateData(newData);
        }catch (Exception e) {
            return RespBean.unprocessable("修改失败"+e.getMessage(),newData);
        }

        String url = HostConfig.getJudgerAddress()+"problem";
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);
        MultiValueMap<String, String> map = new LinkedMultiValueMap<>();
        map.add("probId", String.valueOf(probId));
        map.add("cases", String.valueOf(newData));

        HttpEntity<MultiValueMap<String, String>> request = new HttpEntity<>(map, headers);
        try {
            restTemplate.put(url, request, String.class);
        }catch (Exception e) {
            return RespBean.unprocessable("数据转发失败"+e.getMessage());
        }

        return RespBean.ok("修改成功");
    }
}





