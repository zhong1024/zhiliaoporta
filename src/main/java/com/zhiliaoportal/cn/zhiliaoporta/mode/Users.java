package com.zhiliaoportal.cn.zhiliaoporta.mode;

/**
 * @author Mr.Zhong
 * @create2019-09-09 14:44
 */
public class Users {

    private String user;

    private String pwd;


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

    public Users(String user, String pwd) {
        this.user = user;
        this.pwd = pwd;
    }

    @Override
    public String toString() {
        return "Users{" +
                "user='" + user + '\'' +
                ", pwd='" + pwd + '\'' +
                '}';
    }
}
