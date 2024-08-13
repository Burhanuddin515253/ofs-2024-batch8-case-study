package com.ofss.main.domain;

public class Admin {
    private int admin_id;
    private String admin_name;
    private String admin_login_id;
    private String admin_password;

    public Admin(String admin_name, String admin_login_id, String admin_password) {
        this.admin_name = admin_name;
        this.admin_login_id = admin_login_id;
        this.admin_password = admin_password;
    }

    public int getAdmin_id() {
        return admin_id;
    }

    public void setAdmin_id(int admin_id) {
        this.admin_id = admin_id;
    }

    public String getAdmin_name() {
        return admin_name;
    }

    public void setAdmin_name(String admin_name) {
        this.admin_name = admin_name;
    }

    public String getAdmin_login_id() {
        return admin_login_id;
    }

    public void setAdmin_login_id(String admin_login_id) {
        this.admin_login_id = admin_login_id;
    }

    public String getAdmin_password() {
        return admin_password;
    }

    public void setAdmin_password(String admin_password) {
        this.admin_password = admin_password;
    }

    


    

}
