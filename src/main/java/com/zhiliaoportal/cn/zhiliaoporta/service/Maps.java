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
    public static boolean addMap(Datas datas) {

        if (ModeList.cmds.size() == 0) {
            ModeList.cmds.put(System.currentTimeMillis(), datas);
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
            } else {
                try {
                    return false;
                } catch (final Exception e) {
                    e.printStackTrace();
                }
            }
        }

        return true;

    }

    /**
     * 从Map中移除
     *
     * @param keys
     */
    public static void removeMap(long keys) {
        Datas datas;
        datas = ModeList.cmds.get(keys);
        System.out.println("REMOVE:" + datas);
//        if (datas.getType() == 1) {
//            HttpApi.Get(datas);
//        }
        ModeList.cmds.remove(keys);
        //  实体
    }


}
