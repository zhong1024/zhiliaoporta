package com.zhiliaoportal.cn.zhiliaoporta.controller;

import com.zhiliaoportal.cn.zhiliaoporta.mode.Datas;
import com.zhiliaoportal.cn.zhiliaoporta.mode.ModeList;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Map;

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
    public void conter(HttpServletRequest request, HttpServletResponse response) {

        Map<String, Object> map = new HashMap<>();
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
                    datas = ModeList.cmds.get(keys);
                    break;
                }
            }

            if (datas.getMac() != null && datas.getIp() != null) {
                String keys = String.valueOf(ModeList.total % 10);
                try {
                    map.put("type", "登陆成功");
                    ModeList.total++;
                    response.sendRedirect("http://" + datas.getGw_address() + ":8080/wifidog/logincheck/?authtype=web&user=" + ModeList.user.get(keys).getUser() + "&pwd=" + ModeList.user.get(keys).getPwd() + "&gw_id=br-lan&" +
                            "gw_address=" + datas.getGw_address() + "&gw_port=" + datas.getGw_port() + "&ip=" + datas.getIp() + "&mac=" + datas.getMac() + "+&url=" + datas.getUrl());
                } catch (final Exception e) {
                    e.printStackTrace();
                }
            } else {
                map.put("type", "登陆失败");
            }
        }
//        return map;
    }


}
