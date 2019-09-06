package com.zhiliaoportal.cn.zhiliaoporta.service;

import com.zhiliaoportal.cn.zhiliaoporta.mode.ModeList;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

/**
 * 巡视处理类
 *
 * @author Mr.Zhong
 * @create2019-09-04 15:10
 */
@Configuration("myScheduled")
@EnableScheduling
public class Patrol {


    private int CYCLE = 300000; //      5*60000

    //private int CYCLER = 18000000;  //  5*60*60000

    @Scheduled(cron = "0/1 * * * * ?")

    public void timmer() {

        long date = System.currentTimeMillis() - CYCLE;

//        long dates = System.currentTimeMillis() - CYCLER;

        new Thread(() -> {

            for (long keys : ModeList.cmds.keySet()) {
                if (keys < date) {
                    //  用户超时处理
                   Maps.removeMap(keys);
                } else {
                    //  没有超时的用户
                    System.out.println("__");
                }
            }
        }).start();


    }
}
