package model;

import java.io.Serializable;

/**
 * Created by ZhangYF on 2017/3/15.
 */
public class AuthorUser implements Serializable{
    private String userid;
    private String password;
    private String role;

    public final static String STUDENT = "ROLE_STUDENT";
    public final static String INSTITUTION = "ROLE_INSTITUTION";
    public final static String MANAGER = "ROLE_MANAGER";

    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
}
