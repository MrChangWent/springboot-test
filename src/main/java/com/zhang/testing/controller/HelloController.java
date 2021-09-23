package com.zhang.testing.controller;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/name")
public class HelloController {


    @GetMapping(value = "/say")
    public String say(@RequestParam(value = "id", required = false, defaultValue = "0") Integer id) {
        return "idid:" + id;
    }

    @RequestMapping(value = {"/hello", "hi"}, method = RequestMethod.GET)
    public String returnName(@RequestParam(value = "name1", required = false, defaultValue = "10") String name1) {
        return "name: " + name1;
    }

}