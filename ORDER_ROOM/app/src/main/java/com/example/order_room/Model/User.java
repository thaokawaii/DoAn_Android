package com.example.order_room.Model;

public class User {
    private String MATKHAU;
    private String SDT;

    public String getMATKHAU() {
        return MATKHAU;
    }

    public User() {
    }

    @Override
    public String toString() {
        return "User{" +
                "MATKHAU='" + MATKHAU + '\'' +
                ", SDT='" + SDT + '\'' +
                '}';
    }

    public void setMATKHAU(String MATKHAU) {
        this.MATKHAU = MATKHAU;
    }

    public String getSDT() {
        return SDT;
    }

    public void setSDT(String SDT) {
        this.SDT = SDT;
    }

    public User(String MATKHAU, String SDT) {
        this.MATKHAU = MATKHAU;
        this.SDT = SDT;
    }
}
