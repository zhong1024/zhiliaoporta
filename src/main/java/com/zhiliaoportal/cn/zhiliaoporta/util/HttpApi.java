package com.zhiliaoportal.cn.zhiliaoporta.util;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.sun.org.apache.xpath.internal.SourceTree;
import com.zhiliaoportal.cn.zhiliaoporta.mode.Datas;

import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Map;

/**
 * @author Mr.Zhong
 * @create2019-09-06 11:03
 */
public class HttpApi {

    static String uri = "http://";


    /**
     * Get方法
     *
     * @param datas
     */
    public static void Get(Datas datas) {
        System.out.println("GET:" + datas);
        try {
            URL url;
            if (datas.getType() != 2) {
                url = new URL(uri + datas.getGw_address() + ":8080/wifidog/logincheck/?authtype=web&user=" + datas.getUser() + "&pwd=" + datas.getPwd() + "&gw_id=" + datas.getGw_id() + "&gw_address="
                        + datas.getGw_address() + "&gw_port=" + datas.getGw_port() + "&ip=" + datas.getIp() + "&mac=" + datas.getMac() + "&url=");
            } else {
                url = new URL(uri + "localhost:8081/ToError");
            }
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();

            connection.setDoOutput(true); // 设置该连接是可以输出的
            connection.setRequestMethod("GET"); // 设置请求方式
            connection.setRequestProperty("Content-Type", "application/x-www-form-urlencoded; charset=UTF-8");

            BufferedReader br = new BufferedReader(new InputStreamReader(connection.getInputStream(), "utf-8"));
            String line = null;
            StringBuilder result = new StringBuilder();
            while ((line = br.readLine()) != null) { // 读取数据
                result.append(line + "\n");
            }
            connection.disconnect();

            System.out.println(result.toString());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    /**
     * Post方法发送form表单
     *
     * @param datas
     */
    public static void PostForm(Datas datas) {
        try {
            URL url = new URL(uri + "/test1");
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();

            connection.setDoInput(true); // 设置可输入
            connection.setDoOutput(true); // 设置该连接是可以输出的
            connection.setRequestMethod("POST"); // 设置请求方式
            connection.setRequestProperty("Content-Type", "application/x-www-form-urlencoded; charset=UTF-8");

            PrintWriter pw = new PrintWriter(new BufferedOutputStream(connection.getOutputStream()));
            pw.write("code=001&name=测试");
            pw.flush();
            pw.close();

            BufferedReader br = new BufferedReader(new InputStreamReader(connection.getInputStream(), "utf-8"));
            String line = null;
            StringBuilder result = new StringBuilder();
            while ((line = br.readLine()) != null) { // 读取数据
                result.append(line + "\n");
            }
            connection.disconnect();

            System.out.println(result.toString());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    /**
     * Post方法发送json数据
     *
     * @param data
     * @param datas
     */
    public static void PostJson(Map<String, Object> data, Datas datas) {
        try {
            URL url = new URL(uri + "/test2");
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();

            connection.setDoInput(true); // 设置可输入
            connection.setDoOutput(true); // 设置该连接是可以输出的
            connection.setRequestMethod("POST"); // 设置请求方式
            connection.setRequestProperty("Content-Type", "application/json;charset=UTF-8");

            ObjectMapper objectMapper = new ObjectMapper();
            PrintWriter pw = new PrintWriter(new BufferedOutputStream(connection.getOutputStream()));
            pw.write(objectMapper.writeValueAsString(data));
            pw.flush();
            pw.close();

            BufferedReader br = new BufferedReader(new InputStreamReader(connection.getInputStream(), "utf-8"));
            String line = null;
            StringBuilder result = new StringBuilder();
            while ((line = br.readLine()) != null) { // 读取数据
                result.append(line + "\n");
            }
            connection.disconnect();

            System.out.println(result.toString());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


}
