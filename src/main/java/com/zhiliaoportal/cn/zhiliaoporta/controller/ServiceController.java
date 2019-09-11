package com.zhiliaoportal.cn.zhiliaoporta.controller;

import com.zhiliaoportal.cn.zhiliaoporta.mode.Datas;
import com.zhiliaoportal.cn.zhiliaoporta.mode.ModeList;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * @author Mr.Zhong
 * @create2019-09-09 10:13
 */
@Controller
public class ServiceController {


    /**
     * @param request
     * @param response
     * @return
     */
    @RequestMapping("/bigbang")
    @ResponseBody
    public String conter(HttpServletRequest request, HttpServletResponse response) {

        HttpSession session = request.getSession();
        String mac = (String) session.getAttribute("mac");

        String code = request.getParameter("code");

        /**
         *验证码验证
         */
        Datas datas = new Datas();
        if ("1256".equals(code)) {
            for (long keys : ModeList.cmds.keySet()) {
                if (mac.equals(ModeList.cmds.get(keys).getMac())) {
                    ModeList.cmds.get(keys).setType(1);
//                    datas = ModeList.cmds.get(keys);
                    try {
                        //Maps.removeMap(keys);   //数据添加后移除
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    break;
                }
            }
//            if (datas.getMac() != null && datas.getIp() != null) {
//                String keys = String.valueOf(ModeList.total % 10);
//                try {
//                    ModeList.total++;
//                    response.sendRedirect("http://" + datas.getGw_address() + ":8080/wifidog/logincheck/?authtype=web&user=" + ModeList.user.get(keys).getUser() + "&pwd=" + ModeList.user.get(keys).getPwd() + "&gw_id=" + datas.getGw_id() + "&" +
//                            "gw_address=" + datas.getGw_address() + "&gw_port=" + datas.getGw_port() + "&ip=" + datas.getIp() + "&mac=" + datas.getMac() + "+&url=" + datas.getUrl());
//                    return "true";
//                } catch (final Exception e) {
//                    e.printStackTrace();
//                }
//            } else {
//                return "error";
//            }
        } else {
            return "false";
        }
        return "true";
    }


    /**
     * 转发到异常显示界面
     *
     * @return
     */
    @RequestMapping("/ToError")
    public String ToError() {

        return "error";
    }


}
