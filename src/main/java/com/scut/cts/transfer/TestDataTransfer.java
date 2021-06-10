package com.scut.cts.transfer;

import lombok.Data;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/problems")
public class TestDataTransfer {
    @PostMapping
    public TestResult dealWithAdding(@RequestParam Integer probId, @RequestParam String dataList) {/*
        TestResult testResult = new TestResult();
        testResult.setResult("Success");
        return testResult;*/
        return new TestResult(true);
    }

    @PutMapping
    public TestResult dealWithPutting(@RequestParam Integer probId, @RequestParam String dataList) {
        return new TestResult(true);
    }

    @DeleteMapping
    public TestResult dealWithDeleting(@RequestParam Integer probId) {
        return new TestResult(true);
    }

}

@Data
class TestResult {
    boolean status;
    String msg;

    public TestResult() {}
    public TestResult(boolean status) {
        this.status = status;
    }
    public TestResult(boolean status, String msg) {
        this.status = status;
        this.msg = msg;
    }
}
