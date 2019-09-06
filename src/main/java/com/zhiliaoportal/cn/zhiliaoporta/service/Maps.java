package com.zhiliaoportal.cn.zhiliaoporta.service;

import com.zhiliaoportal.cn.zhiliaoporta.mode.Datas;
import com.zhiliaoportal.cn.zhiliaoporta.mode.ModeList;
import com.zhiliaoportal.cn.zhiliaoporta.util.HttpApi;


/**
 * Map管理实现类
 *
 * @author Mr.Zhong
 * @create2019-09-05 10:18
 */
public class Maps {


    /**
     * 数据添加到Map中
     *
     * @param datas
     */
    public static void addMap(Datas datas) {

        if (ModeList.cmds.size() == 0) {
            ModeList.cmds.put(System.currentTimeMillis(), datas);
            try {
                HttpApi.Get(datas);
            } catch (final Exception e) {
                e.printStackTrace();
            }
            System.out.println("添加一条信息：" + datas.toString());
        } else {
            int s = 0;
            for (long keys : ModeList.cmds.keySet()) {
                if (datas.getMac().equals(ModeList.cmds.get(keys).getMac())) {
                    break;
                }
                s++;
            }
            if (s == ModeList.cmds.size()) {
                ModeList.cmds.put(System.currentTimeMillis(), datas);
                try {
                    HttpApi.Get(datas);
                } catch (final Exception e) {
                    e.printStackTrace();
                }
                System.out.println("添加一条信息：" + datas.toString());
            } else {
                try {
                    Datas datas1 = new Datas();
                    datas1.setType(2);
                    HttpApi.Get(datas1);
                } catch (final Exception e) {
                    e.printStackTrace();
                }
            }
        }


    }

    /**
     * 从Map中移除
     *
     * @param keys
     */
    public static void removeMap(long keys) {
        Datas datas = new Datas();
        datas = ModeList.cmds.get(keys);
        if (datas.getType() == 1) {
            HttpApi.Get(datas);
        }
        ModeList.cmds.remove(keys);
        //  实体
    }


}
