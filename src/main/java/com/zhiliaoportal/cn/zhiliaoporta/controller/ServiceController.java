package com.zhiliaoportal.cn.zhiliaoporta.controller;

import com.zhiliaoportal.cn.zhiliaoporta.mode.ModeList;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Controller控制器
 *
 * @author Mr.Zhong
 * @create2019-09-09 10:13
 */
@Controller
public class ServiceController {


    /**
     * 接收验证信息并实现验证
     *
     * @param request
     * @param response
     * @return
     */
    @RequestMapping("/bigbang")
    @ResponseBody
    public String conter(HttpServletRequest request, HttpServletResponse response) {
//        HttpSession session = request.getSession();
//        String mac = (String) session.getAttribute("mac");

        String code = request.getParameter("code");

        /**
         *验证码验证
         */
        for (long key : ModeList.codes.keySet()) {
            if (code.equals(ModeList.codes.get(key).getCode())) {
                for (long keys : ModeList.cmds.keySet()) {
                    if (ModeList.codes.get(key).getIp().equals(ModeList.cmds.get(keys).getIp())) {
                        ModeList.cmds.get(keys).setType(1);
                        break;
                    }
                }
                break;
            } else {
                return "false";
            }
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
