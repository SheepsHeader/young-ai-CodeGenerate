package com.youngheart.youngaicodegenerate.controller;

import com.youngheart.youngaicodegenerate.common.BaseResponse;
import com.youngheart.youngaicodegenerate.common.ResultUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TesstController {
    @GetMapping("/test")
    public BaseResponse<String> test() {
        return ResultUtils.success("test");
    }
}
