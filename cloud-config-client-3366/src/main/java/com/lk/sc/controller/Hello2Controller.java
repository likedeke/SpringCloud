package com.lk.sc.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author likeLove
 * @time 2020-09-16  19:26
 */
@RestController
@RefreshScope
public class Hello2Controller {

    @Value("${config.info}")
    private String configInfo;
    @GetMapping("/configinfo")
    public String getConfigInfo() {
        return  configInfo;
    }
}
