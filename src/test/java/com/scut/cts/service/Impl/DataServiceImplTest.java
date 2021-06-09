package com.scut.cts.service.Impl;

import com.scut.cts.pojo.Data;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DataServiceImplTest {
    @Autowired
    private DataServiceImpl dataService;

    @Test
    public void addData() {
        Data data1 = new Data(1,1,"1","1");
        Data data2 = new Data(1,2,"2","2");
        Data data3 = new Data(2,1,"1 1", "1 2");
        Data data4 = new Data(2,2,"2 1","2 2");
        dataService.addData(data1);
        dataService.addData(data2);
        dataService.addData(data3);
        dataService.addData(data4);
    }

    @Test
    public void selectDataByDataId() {
        System.out.println(dataService.selectDataByDataId(2,1));
    }

    @Test
    public void selectDataByProbId() {
        System.out.println(dataService.selectDataByProbId(1));
    }

    @Test
    public void updateData() {
        Data dataNew = new Data(1,1,"2",null);
        dataService.updateData(dataNew);
    }

    @Test
    public void deleteDataByDataId() {
        dataService.deleteDataByDataId(1,1);
    }

    @Test
    public void deleteDataByProbId() {
        dataService.deleteDataByProbId(1);
    }
}
