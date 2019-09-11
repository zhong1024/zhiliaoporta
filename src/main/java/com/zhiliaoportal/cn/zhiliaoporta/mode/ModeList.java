package com.zhiliaoportal.cn.zhiliaoporta.mode;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Mr.Zhong
 * @create2019-09-04 14:41
 */
public class ModeList {

    public static Map<Long, Datas> cmds = new HashMap<>();

    public static Map<String, Users> user = new HashMap<>();

    public static Map<Long, Code> codes = new HashMap<>();

    public static int total;


    static {
        try {

            total = 0;

            user.put("0", new Users("admin0", "admin0"));
            user.put("1", new Users("admin1", "admin1"));
            user.put("2", new Users("admin2", "admin2"));
            user.put("3", new Users("admin3", "admin3"));
            user.put("4", new Users("admin4", "admin4"));
            user.put("5", new Users("admin5", "admin5"));
            user.put("6", new Users("admin6", "admin6"));
            user.put("7", new Users("admin7", "admin7"));
            user.put("8", new Users("admin8", "admin8"));
            user.put("9", new Users("admin9", "admin9"));

            codes.put(1111L, new Code("0825", "192.168.1.190"));

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
