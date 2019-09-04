package com.zhiliaoportal.cn.zhiliaoporta.service;

import com.zhiliaoportal.cn.zhiliaoporta.server.Server;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

/**
 * 服务管理实现类
 *
 * @author Mr.Zhong
 * @create2019-08-29 17:07
 */
@Component
@Lazy(value = false)
public class InitServer {

    /**
     * 初始化服务端
     */
    @PostConstruct
    public void init() {

//        new Thread(() -> {
//            Server server = new Server();
//            server.init();
//        }).start();

    }

    /**
     * 关闭服务时执行
     */
    @PreDestroy
    public void destroy() {
        System.out.println("############Close Server#############");
    }


}