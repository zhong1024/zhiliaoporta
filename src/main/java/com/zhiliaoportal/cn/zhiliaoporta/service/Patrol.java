package com.zhiliaoportal.cn.zhiliaoporta.service;

import com.zhiliaoportal.cn.zhiliaoporta.mode.ModeList;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

/**
 * @author Mr.Zhong
 * @create2019-09-04 15:10
 */
@Configuration("myScheduled")
@EnableScheduling
public class Patrol {

     private int CYCLE = 305000; //      5*60000
    //private int CYCLE = 65000;  //65秒
    //private int CYCLER = 18000000;  //  5*60*60000

    /**
     * 间隔一秒执行
     */
    @Scheduled(cron = "0/1 * * * * ?")

    public void timmer() {

        long date = System.currentTimeMillis() - CYCLE;

//        long dates = System.currentTimeMillis() - CYCLER;

        for (long keys : ModeList.cmds.keySet()) {
            if (keys < date) {
                //  用户超时处理
                try {
                    Maps.removeMap(keys);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }

        for (long keys : ModeList.codes.keySet()) {
            if (keys < date) {
                try {
                    //  验证信息超时处理
                    ModeList.codes.remove(keys);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }


    }
}
