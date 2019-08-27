package com.zhiliaoportal.cn.zhiliaoporta.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author Mr.Zhong
 * @create2019-08-13 9:25
 */

@Controller
public class InitController {

    @RequestMapping("/")
    public String inti() {

        return "index";
    }

    @RequestMapping("/login")
    public String login() {
        return "login";
    }

    @RequestMapping("/prosperity")
    public String prosperity(){
        return "prosperity";
    }



}
