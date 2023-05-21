package com.example.order_room.Model;

public class KHACHHANG {
    String HOTEN,DIACHI,EMAIL,GT,MATKHAU,SDT;

    public String getSDT() {
        return SDT;
    }

    public void setSDT(String SDT) {
        this.SDT = SDT;
    }

    public String getHOTEN() {
        return HOTEN;
    }

    public KHACHHANG() {
    }

    public KHACHHANG(String DIACHI, String EMAIL, String GT, String HOTEN,String MATKHAU,String SDT) {
        this.HOTEN = HOTEN;
        this.DIACHI = DIACHI;
        this.EMAIL = EMAIL;
        this.GT = GT;
        this.MATKHAU = MATKHAU;
        this.SDT=SDT;
    }

    public void setHOTEN(String HOTEN) {
        this.HOTEN = HOTEN;
    }

    public String getDIACHI() {
        return DIACHI;
    }

    public void setDIACHI(String DIACHI) {
        this.DIACHI = DIACHI;
    }

    public String getEMAIL() {
        return EMAIL;
    }

    public void setEMAIL(String EMAIL) {
        this.EMAIL = EMAIL;
    }

    public String getGT() {
        return GT;
    }

    public void setGT(String GT) {
        this.GT = GT;
    }

    public String getMATKHAU() {
        return MATKHAU;
    }

    public void setMATKHAU(String MATKHAU) {
        this.MATKHAU = MATKHAU;
    }
}
