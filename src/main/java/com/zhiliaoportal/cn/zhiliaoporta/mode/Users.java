package com.zhiliaoportal.cn.zhiliaoporta.mode;

/**
 * 登陆用户初始化实现类
 *
 * @author Mr.Zhong
 * @create2019-09-09 14:44
 */
public class Users {

    //用户名
    private String user;

    //密码
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
