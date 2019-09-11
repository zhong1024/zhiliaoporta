package com.zhiliaoportal.cn.zhiliaoporta.service;

import com.zhiliaoportal.cn.zhiliaoporta.mode.ModeList;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

/**
 * 定时器实现类
 *
 * @author Mr.Zhong
 * @create2019-09-04 15:10
 */
@Configuration("myScheduled")
@EnableScheduling
public class Patrol {

    private int CYCLE = 305000; //      5*60000

    /**
     * 间隔一秒执行
     */
    @Scheduled(cron = "0/1 * * * * ?")

    public void timmer() {

        long date = System.currentTimeMillis() - CYCLE;

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
