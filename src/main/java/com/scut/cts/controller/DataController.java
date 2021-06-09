package com.scut.cts.controller;

import com.scut.cts.pojo.Data;
import com.scut.cts.pojo.RespBean;
import com.scut.cts.service.DataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/data")
public class DataController {
    @Autowired
    private DataService dataService;

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

@lombok.Data
class DataNode {
    private Integer dataId;
    private String in;
    private String out;

    public DataNode() {}

    public DataNode(Integer dataId, String in, String out) {
        this.dataId = dataId;
        this.in = in;
        this.out = out;
    }
}

@lombok.Data
class AddDataNode {
    private String in;
    private String out;

    public AddDataNode() {}

    public AddDataNode(String in, String out) {
        this.in = in;
        this.out = out;
    }
}

@lombok.Data
class DataList {
    private List<AddDataNode> dataList;
}