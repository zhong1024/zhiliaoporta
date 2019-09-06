package com.zhiliaoportal.cn.zhiliaoporta.util;
import com.zhiliaoportal.cn.zhiliaoporta.mode.Datas;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.URL;
import java.net.URLConnection;

import java.util.List;
import java.util.Map;

/**
 * @author Mr.Zhong
 * @create2019-09-06 14:18
 */
public class HttpUtilrs {

    /**
     * 向指定URL发送GET方法的请求
     *
     * @return URL 所代表远程资源的响应结果
     */
    public static String sendGet(Datas datas) {
        String result = "";
        BufferedReader in = null;
        try {
            String urlNameString = null;

            if (datas.getType() != 2) {
                urlNameString = "http://" + datas.getGw_address() + ":" + datas.getGw_port() + "/wifidog/logincheck/?authtype=web&user="+datas.getUser()+"&pwd="+datas.getPwd()+"&gw_id=" + datas.getGw_id() + "&gw_address="
                        + datas.getGw_address() + "&gw_port=" + datas.getGw_port() + "&ip=" + datas.getIp() + "&mac=" + datas.getMac() + "&url=";
            } else {
                urlNameString = "http://"+ "localhost:8081/TologinUP";
            }

            URL realUrl = new URL(urlNameString);
// 打开和URL之间的连接
            URLConnection connection = realUrl.openConnection();
// 设置通用的请求属性
            connection.setRequestProperty("accept", "*/*");
            connection.setRequestProperty("connection", "Keep-Alive");
            connection.setRequestProperty("user-agent",
                    "Mozilla/4.0 (compatible; MSIE 6.0; Windows NT 5.1;SV1)");
// 建立实际的连接
            connection.connect();
// 获取所有响应头字段
            Map<String, List<String>> map = connection.getHeaderFields();
// 遍历所有的响应头字段
            for (String key : map.keySet()) {
                System.out.println(key + "--->" + map.get(key));
            }
// 定义 BufferedReader输入流来读取URL的响应
            in = new BufferedReader(new InputStreamReader(
                    connection.getInputStream()));
            String line;
            while ((line = in.readLine()) != null) {
                result += line;
            }
        } catch (Exception e) {
            System.out.println("发送GET请求出现异常！" + e);
            e.printStackTrace();
        }
// 使用finally块来关闭输入流
        finally {
            try {
                if (in != null) {
                    in.close();
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
        return result;
    }

    /**
     * 向指定 URL 发送POST方法的请求
     *
     * @return 所代表远程资源的响应结果
     */
    public static String sendPost(Datas datas) {
        PrintWriter out = null;
        BufferedReader in = null;
        String result = "";
        try {
            URL realUrl = new URL(null);
// 打开和URL之间的连接
            URLConnection conn = realUrl.openConnection();
// 设置通用的请求属性
            conn.setRequestProperty("accept", "*/*");
            conn.setRequestProperty("connection", "Keep-Alive");
            conn.setRequestProperty("user-agent",
                    "Mozilla/4.0 (compatible; MSIE 6.0; Windows NT 5.1;SV1)");
// 发送POST请求必须设置如下两行
            conn.setDoOutput(true);
            conn.setDoInput(true);
// 获取URLConnection对象对应的输出流
            out = new PrintWriter(conn.getOutputStream());
// 发送请求参数
//            out.print(param);
// flush输出流的缓冲
            out.flush();
// 定义BufferedReader输入流来读取URL的响应
            in = new BufferedReader(
                    new InputStreamReader(conn.getInputStream()));
            String line;
            while ((line = in.readLine()) != null) {
                result += line;
            }
        } catch (Exception e) {
            System.out.println("发送 POST 请求出现异常！" + e);
            e.printStackTrace();
        }
//使用finally块来关闭输出流、输入流
        finally {
            try {
                if (out != null) {
                    out.close();
                }
                if (in != null) {
                    in.close();
                }
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
        return result;
    }


}
