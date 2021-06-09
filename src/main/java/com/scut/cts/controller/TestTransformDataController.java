package com.scut.cts.controller;

import lombok.Data;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/problems")
public class TestTransformDataController {
    @PostMapping
    public Result receive(@RequestParam Integer probId, @RequestParam String in,
                          @RequestParam String out) {
        Case1 node = new Case1(1,in,out);
        Result result = new Result(true, null);
        return result;
    }
}

@Data
class Case1 {
    private Integer probId;
    private String in;
    private String out;

    public Case1() {}
    public Case1(Integer probId, String in, String out) {
        this.probId = probId;
        this.in = in;
        this.out = out;
    }
}

class Result {
    boolean status;
    String msg;

    public Result(boolean status, String msg) {
        this.status = status;
        this.msg = msg;
    }
}
