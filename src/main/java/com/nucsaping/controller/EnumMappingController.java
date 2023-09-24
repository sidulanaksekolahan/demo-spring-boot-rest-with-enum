package com.nucsaping.controller;

import com.nucsaping.model.Level;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/enummapping")
public class EnumMappingController {

    // localhost:8080/enummapping/get?level=MEDIUM works
    // localhost:8080/enummapping/get?level=Medium does not work
    @GetMapping(value = "/get")
    public String getByLevel(@RequestParam(required = false)Level level) {
        return level.name();
    }
}

