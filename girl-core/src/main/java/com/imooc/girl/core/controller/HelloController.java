package com.imooc.girl.core.controller;

import com.imooc.girl.core.properties.GirlProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by hmh on 2017/7/31.
 */
@RestController
@RequestMapping("/hello")
public class HelloController {

    @Autowired
    private GirlProperties girlProperties;

//    @GetMapping(value = {"/say"})
//    public String say() {
////        return "Hello Spring Boot!";
//        return girlProperties.getCupSize() + "," + girlProperties.getAge();
////        return "index";
//    }

    @GetMapping(value = {"/say/{id}"})
    public String sayHi(@PathVariable("id") Integer id) {
//        return "Hello Spring Boot!";
//        return girlProperties.getCupSize() + "," + girlProperties.getAge();
//        return "index";
        return "id: "+id;
    }

    @GetMapping(value = {"/say"})
    public String sayHello(@RequestParam(value = "id", required = false, defaultValue = "0") Integer id) {
//        return "Hello Spring Boot!";
//        return girlProperties.getCupSize() + "," + girlProperties.getAge();
//        return "index";
        return "Hello: "+id;
    }

    @GetMapping(value = {"/greeting"})
    public Map greeting() {
        Map data = new HashMap();
        data.put("id", 1);
        data.put("content", "Hello Spring Boot");
        return data;
    }

}
