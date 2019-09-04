package com.zhiliaoportal.cn.zhiliaoporta.controller;

import com.zhiliaoportal.cn.zhiliaoporta.mode.Datas;
import com.zhiliaoportal.cn.zhiliaoporta.mode.ModeList;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.*;

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

//    @RequestMapping("/login")
//    public String login(HttpServletRequest request, final HttpServletResponse response) {
//
//        System.out.println("TOKEN:"+  request.getParameter("token"));
//
//        try {
//
//            response.sendRedirect("http://wportal.meauth.cn:8080/wifidog/logincheck/?authtype=web&user=admins&pwd=admins&gw_id=br-lan&"+
//                    "gw_address=wportal.meauth.cn&gw_port=2060&ip="+request.getParameter("ip")+"&mac="+request.getParameter("mac")+"+&url="+request.getParameter("url"));
//
//        } catch (final Exception e) {
//            e.printStackTrace();
//        }
//        return "login";
//    }


    @RequestMapping("/login")
    public String login(HttpServletRequest request, Model model, final HttpServletResponse response) throws Exception {

        Datas datas = new Datas(request.getParameter("gw_address"), request.getParameter("gw_port"), request.getParameter("gw_id"),
                request.getParameter("ip"), request.getParameter("mac"), request.getParameter("url"), request.getParameter("token"), request.getParameter("authtype"));
        model.addAttribute("data", datas);
        ModeList.cmds.put(System.currentTimeMillis(), datas);
        System.out.println(datas.toString());


        try {

            response.sendRedirect("http://wportal.meauth.cn:8080/wifidog/logincheck/?authtype=web&user=admins&pwd=admins&gw_id=br-lan&" +
                    "gw_address=wportal.meauth.cn&gw_port=2060&ip=" + request.getParameter("ip") + "&mac=" + request.getParameter("mac") + "+&url=" + request.getParameter("url"));

        } catch (final Exception e) {
            e.printStackTrace();
        }


        return "login";

    }


    @RequestMapping("/loginOK")
    public String loginOk(HttpServletRequest request) throws Exception {

        Datas datas = new Datas(request.getParameter("gw_address"), request.getParameter("gw_port"), request.getParameter("gw_id"),
                request.getParameter("ip"), request.getParameter("mac"), request.getParameter("url"), request.getParameter("token"), request.getParameter("authtype"));
//        ModeList.cmds.put(System.currentTimeMillis(),datas);
        System.out.println(datas.toString());

        return "prosperity";

    }


    @RequestMapping("/prosperity")
    public String prosperity() {
        return "prosperity";
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
