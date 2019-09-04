package com.zhiliaoportal.cn.zhiliaoporta.mode;

/**
 * @author Mr.Zhong
 * @create2019-09-03 16:43
 */
public class Datas {

    private String gw_address;

    private String gw_port;

    private String gw_id;

    private String ip;

    private String mac;

    private String url;

    private String token;

    private String authtype;

//    private Long jointime;


    public Datas() {

    }

    public Datas(String gw_address, String gw_port, String gw_id, String ip, String mac, String url, String token, String authtype) {
        this.gw_address = gw_address;
        this.gw_port = gw_port;
        this.gw_id = gw_id;
        this.ip = ip;
        this.mac = mac;
        this.url = url;
        this.token = token;
        this.authtype = authtype;
//        this.jointime = jointime;
    }

//    public Long getJointime() {
//        return jointime;
//    }
//
//    public void setJointime(Long jointime) {
//        this.jointime = jointime;
//    }

    public String getGw_address() {
        return gw_address;
    }

    public void setGw_address(String gw_address) {
        this.gw_address = gw_address;
    }

    public String getGw_port() {
        return gw_port;
    }

    public void setGw_port(String gw_port) {
        this.gw_port = gw_port;
    }

    public String getGw_id() {
        return gw_id;
    }

    public void setGw_id(String gw_id) {
        this.gw_id = gw_id;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public String getMac() {
        return mac;
    }

    public void setMac(String mac) {
        this.mac = mac;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getAuthtype() {
        return authtype;
    }

    public void setAuthtype(String authtype) {
        this.authtype = authtype;
    }

    @Override
    public String toString() {
        return "Datas{" +
                "gw_address='" + gw_address + '\'' +
                ", gw_port='" + gw_port + '\'' +
                ", gw_id='" + gw_id + '\'' +
                ", ip='" + ip + '\'' +
                ", mac='" + mac + '\'' +
                ", url='" + url + '\'' +
                ", token='" + token + '\'' +
                ", authtype='" + authtype + '\'' +
                '}';
    }
}
