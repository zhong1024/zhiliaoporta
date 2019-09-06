package com.zhiliaoportal.cn.zhiliaoporta.controller;

import com.zhiliaoportal.cn.zhiliaoporta.mode.Datas;
import com.zhiliaoportal.cn.zhiliaoporta.mode.ModeList;
import com.zhiliaoportal.cn.zhiliaoporta.service.Maps;
import com.zhiliaoportal.cn.zhiliaoporta.util.HttpClient;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

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
    public void login(HttpServletRequest request) throws Exception {

        Datas datas = new Datas();
        datas.setUrl(request.getParameter("url"));
        datas.setMac(request.getParameter("mac"));
        datas.setIp(request.getParameter("ip"));
        datas.setGw_id(request.getParameter("gw_id"));
        datas.setGw_address(request.getParameter("gw_address"));
        datas.setGw_port(request.getParameter("gw_port"));
        datas.setToken(request.getParameter("token"));
        datas.setAuthtype(request.getParameter("authtype"));
        datas.setType(0);
        datas.setUser("users");
        datas.setPwd("users");

        Maps.addMap(datas);

    }


    @RequestMapping("/TologinOK")
    public String loginOK(HttpServletRequest request) {

        String ip = request.getHeader("x-real-ip");
        if (ip == null) {
            ip = request.getRemoteAddr();
        }
        // 过滤反向代理的IP
        String[] stemps = ip.split(",");
        if (stemps != null && stemps.length >= 1) {
            // 得到第一个IP，即客户端真实IP
            ip = stemps[0];
        }
        ip = ip.trim();
        if (ip.length() > 23) {
            ip = ip.substring(0, 23);
        }

        HttpSession session = request.getSession();
        session.setAttribute("ip", ip);
        System.out.println("IP:" + ip);

        return "login";

    }


    @RequestMapping("TologinUP")
    public String loginUP() {
        return "loginUP";
    }


    @RequestMapping("/prosperity")
    public String prosperity(HttpServletRequest request) throws Exception {

        HttpSession session = request.getSession();
        String ip = (String) session.getAttribute("ip");

        System.out.println("IP--"+ip);

        Datas datas = new Datas();
        for (long keys : ModeList.cmds.keySet()) {
            if (ip.equals(ModeList.cmds.get(keys).getIp())) {
                datas = ModeList.cmds.get(keys);
                break;
            }
        }
        if (datas.getIp() != null) {
            datas.setType(1);
            datas.setUser("admins");
            datas.setPwd("admins");
        }

        System.out.println("DATA:" + datas);

        return "prosperity";
    }


    @RequestMapping("/text")
    public void text(){
        System.out.println("START");

        Datas datas = new Datas();
        datas.setType(2);
        HttpClient.doGet(datas);

    }























    @RequestMapping(value = "/wifidog/auth", method = {RequestMethod.POST, RequestMethod.GET})
    public String rz() {
        System.out.println("==========auth==========");
        return "";
    }

    @RequestMapping(value = "authpuppy/web/login", method = {RequestMethod.POST, RequestMethod.GET})
    public void rz1() {
        System.out.println("==========authpuppy=========");
    }


}
