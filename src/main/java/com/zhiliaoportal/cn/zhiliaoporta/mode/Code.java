package com.zhiliaoportal.cn.zhiliaoporta.mode;

/**
 * @author Mr.Zhong
 * @create2019-09-09 15:13
 */
public class Code {

    private String code;

    private String ip;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public Code(String code, String ip) {
        this.code = code;
        this.ip = ip;
    }

    @Override
    public String toString() {
        return "Code{" +
                "code='" + code + '\'' +
                ", ip='" + ip + '\'' +
                '}';
    }
}
