package com.zhiliaoportal.cn.zhiliaoporta.service;

import com.zhiliaoportal.cn.zhiliaoporta.mode.Datas;
import com.zhiliaoportal.cn.zhiliaoporta.mode.ModeList;
import com.zhiliaoportal.cn.zhiliaoporta.util.HttpApi;


/**
 * 数据管理实现类
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
     * @param datas
     * @return
     */
    public static Datas addDatas(Datas datas) {
        String keys = String.valueOf(ModeList.total % 10);
        ModeList.total++;
        datas.setUser(ModeList.user.get(keys).getUser());
        datas.setPwd(ModeList.user.get(keys).getPwd());
        return datas;
    }

    /**
     * 从Map中移除
     *
     * @param keys
     */
    public static void removeMap(long keys) throws Exception {

        Datas datas = ModeList.cmds.get(keys);
        System.out.println("REMOVE1:" + datas);

        if (datas.getType() == 0) {
            datas.setType(2);
        }

        System.out.println("REMOVE2:" + datas);
        ModeList.cmds.remove(keys);
        HttpApi.Get(addDatas(datas));
        //  实体
    }


}
