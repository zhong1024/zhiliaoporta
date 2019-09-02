package com.zhiliaoportal.cn.zhiliaoporta.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

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
    public String prosperity() {
        return "prosperity";
    }

    @RequestMapping(value = "/wifidog/auth" ,method = {RequestMethod.POST, RequestMethod.GET})
    public String rz() {
        System.out.println("==========auth==========");
        return "";
    }

    @RequestMapping(value = "authpuppy/web/login",method = {RequestMethod.POST, RequestMethod.GET})
    public void rz1(){
        System.out.println("==========authpuppy=========");
    }


}
