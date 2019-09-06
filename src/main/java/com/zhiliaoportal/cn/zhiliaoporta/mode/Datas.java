package com.zhiliaoportal.cn.zhiliaoporta.mode;

/**
 * 持久化数据
 *
 * @author Mr.Zhong
 * @create2019-09-03 16:43
 */
public class Datas {

    private String remindFlag;

    private String wportal_page_type;

    private String page_title;

    private String wel_info;

    private String copyright;

    private String background;

    private String external_url;

    private String remind_type;

    private String remind_page_title;

    private String remind_page_content;

    private String remindGoUrl;

    private String authtype;

    private String token;

    private String mac;

    private String ip;

    private String url;

    private String status;

    private String onlineTime;

    private String expireTime;

    private String gw_address;

    private String gw_id;

    private String gw_port;

    private String finish_url;

    private Integer type;

    private String typeUrl;

    private String user;

    private String pwd;


    public Datas() {

    }

    public String getRemindFlag() {
        return remindFlag;
    }

    public void setRemindFlag(String remindFlag) {
        this.remindFlag = remindFlag;
    }

    public String getWportal_page_type() {
        return wportal_page_type;
    }

    public void setWportal_page_type(String wportal_page_type) {
        this.wportal_page_type = wportal_page_type;
    }

    public String getPage_title() {
        return page_title;
    }

    public void setPage_title(String page_title) {
        this.page_title = page_title;
    }

    public String getWel_info() {
        return wel_info;
    }

    public void setWel_info(String wel_info) {
        this.wel_info = wel_info;
    }

    public String getCopyright() {
        return copyright;
    }

    public void setCopyright(String copyright) {
        this.copyright = copyright;
    }

    public String getBackground() {
        return background;
    }

    public void setBackground(String background) {
        this.background = background;
    }

    public String getExternal_url() {
        return external_url;
    }

    public void setExternal_url(String external_url) {
        this.external_url = external_url;
    }

    public String getRemind_type() {
        return remind_type;
    }

    public void setRemind_type(String remind_type) {
        this.remind_type = remind_type;
    }

    public String getRemind_page_title() {
        return remind_page_title;
    }

    public void setRemind_page_title(String remind_page_title) {
        this.remind_page_title = remind_page_title;
    }

    public String getRemind_page_content() {
        return remind_page_content;
    }

    public void setRemind_page_content(String remind_page_content) {
        this.remind_page_content = remind_page_content;
    }

    public String getRemindGoUrl() {
        return remindGoUrl;
    }

    public void setRemindGoUrl(String remindGoUrl) {
        this.remindGoUrl = remindGoUrl;
    }

    public String getAuthtype() {
        return authtype;
    }

    public void setAuthtype(String authtype) {
        this.authtype = authtype;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getMac() {
        return mac;
    }

    public void setMac(String mac) {
        this.mac = mac;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getOnlineTime() {
        return onlineTime;
    }

    public void setOnlineTime(String onlineTime) {
        this.onlineTime = onlineTime;
    }

    public String getExpireTime() {
        return expireTime;
    }

    public void setExpireTime(String expireTime) {
        this.expireTime = expireTime;
    }

    public String getGw_address() {
        return gw_address;
    }

    public void setGw_address(String gw_address) {
        this.gw_address = gw_address;
    }

    public String getGw_id() {
        return gw_id;
    }

    public void setGw_id(String gw_id) {
        this.gw_id = gw_id;
    }

    public String getGw_port() {
        return gw_port;
    }

    public void setGw_port(String gw_port) {
        this.gw_port = gw_port;
    }

    public String getFinish_url() {
        return finish_url;
    }

    public void setFinish_url(String finish_url) {
        this.finish_url = finish_url;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public String getTypeUrl() {
        return typeUrl;
    }

    public void setTypeUrl(String typeUrl) {
        this.typeUrl = typeUrl;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    public Datas(String remindFlag, String wportal_page_type, String page_title, String wel_info, String copyright, String background, String external_url, String remind_type, String remind_page_title, String remind_page_content, String remindGoUrl, String authtype, String token, String mac, String ip, String url, String status, String onlineTime, String expireTime, String gw_address, String gw_id, String gw_port, String finish_url, Integer type, String typeUrl, String user, String pwd) {
        this.remindFlag = remindFlag;
        this.wportal_page_type = wportal_page_type;
        this.page_title = page_title;
        this.wel_info = wel_info;
        this.copyright = copyright;
        this.background = background;
        this.external_url = external_url;
        this.remind_type = remind_type;
        this.remind_page_title = remind_page_title;
        this.remind_page_content = remind_page_content;
        this.remindGoUrl = remindGoUrl;
        this.authtype = authtype;
        this.token = token;
        this.mac = mac;
        this.ip = ip;
        this.url = url;
        this.status = status;
        this.onlineTime = onlineTime;
        this.expireTime = expireTime;
        this.gw_address = gw_address;
        this.gw_id = gw_id;
        this.gw_port = gw_port;
        this.finish_url = finish_url;
        this.type = type;
        this.typeUrl = typeUrl;
        this.user = user;
        this.pwd = pwd;
    }

    @Override
    public String toString() {
        return "Datas{" +
                "remindFlag='" + remindFlag + '\'' +
                ", wportal_page_type='" + wportal_page_type + '\'' +
                ", page_title='" + page_title + '\'' +
                ", wel_info='" + wel_info + '\'' +
                ", copyright='" + copyright + '\'' +
                ", background='" + background + '\'' +
                ", external_url='" + external_url + '\'' +
                ", remind_type='" + remind_type + '\'' +
                ", remind_page_title='" + remind_page_title + '\'' +
                ", remind_page_content='" + remind_page_content + '\'' +
                ", remindGoUrl='" + remindGoUrl + '\'' +
                ", authtype='" + authtype + '\'' +
                ", token='" + token + '\'' +
                ", mac='" + mac + '\'' +
                ", ip='" + ip + '\'' +
                ", url='" + url + '\'' +
                ", status='" + status + '\'' +
                ", onlineTime='" + onlineTime + '\'' +
                ", expireTime='" + expireTime + '\'' +
                ", gw_address='" + gw_address + '\'' +
                ", gw_id='" + gw_id + '\'' +
                ", gw_port='" + gw_port + '\'' +
                ", finish_url='" + finish_url + '\'' +
                ", type=" + type +
                ", typeUrl='" + typeUrl + '\'' +
                ", user='" + user + '\'' +
                ", pwd='" + pwd + '\'' +
                '}';
    }
}
