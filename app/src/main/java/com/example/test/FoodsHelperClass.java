package com.example.test;

public class FoodsHelperClass {

    String email, password,company ,phone;

    public FoodsHelperClass() {
    }

    public FoodsHelperClass(String email, String password,String phone ,String company) {
        this.password = password;
        this.email = email;
        this.phone = phone;
        this.company = company;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}
