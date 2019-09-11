package com.zhiliaoportal.cn.zhiliaoporta.controller;

import com.zhiliaoportal.cn.zhiliaoporta.mode.Code;
import com.zhiliaoportal.cn.zhiliaoporta.mode.Datas;
import com.zhiliaoportal.cn.zhiliaoporta.mode.ModeList;
import com.zhiliaoportal.cn.zhiliaoporta.service.Maps;
import com.zhiliaoportal.cn.zhiliaoporta.util.HttpApi;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

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


    /**
     * @param request
     * @return
     * @throws Exception
     */
    @RequestMapping("/login")
    public String login(HttpServletRequest request) throws Exception {

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

        HttpSession session = request.getSession();
        session.setAttribute("mac", datas.getMac());


        if (Maps.addMap(datas)) {
            HttpApi.Get(datas);
            //  ok
        } else {
            //  判断是否重复链接
        }

        return "login";

    }

    @RequestMapping("/ToWin")
    public String loginOK(HttpServletRequest request) {

//        String ip = request.getHeader("x-real-ip");
//        if (ip == null) {
//            ip = request.getRemoteAddr();
//        }
//        // 过滤反向代理的IP
//        String[] stemps = ip.split(",");
//        if (stemps != null && stemps.length >= 1) {
//            // 得到第一个IP，即客户端真实IP
//            ip = stemps[0];
//        }
//        ip = ip.trim();
//        if (ip.length() > 23) {
//            ip = ip.substring(0, 23);
//        }
//        HttpSession session = request.getSession();
//        session.setAttribute("ip", ip);
//        System.out.println("IP:" + ip);
        return "prosperity";
    }


    @RequestMapping("/ToCode")
    public void ToCode(HttpServletRequest request) {

        Code code = new Code();
        code.setIp(request.getParameter("ip"));
        code.setCode(request.getParameter("code"));
        ModeList.codes.put(System.currentTimeMillis(), code);

    }


    @RequestMapping("/prosperity")
    public String prosperity(HttpServletRequest request) throws Exception {

        HttpSession session = request.getSession();
        String ip = (String) session.getAttribute("ip");

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


}
