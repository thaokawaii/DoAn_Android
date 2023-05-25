package com.example.order_room.Model;

public class PHONG {
    String ANH,MAKS,MALOAI,MAPHONG,MOTA,TENPH,TINHTRANG;

    public String getANH() {
        return ANH;
    }

    public void setANH(String ANH) {
        this.ANH = ANH;
    }

    public String getMAKS() {
        return MAKS;
    }

    public void setMAKS(String MAKS) {
        this.MAKS = MAKS;
    }

    public String getMALOAI() {
        return MALOAI;
    }

    public void setMALOAI(String MALOAI) {
        this.MALOAI = MALOAI;
    }

    public String getMAPHONG() {
        return MAPHONG;
    }

    public void setMAPHONG(String MAPHONG) {
        this.MAPHONG = MAPHONG;
    }

    public String getMOTA() {
        return MOTA;
    }

    public void setMOTA(String MOTA) {
        this.MOTA = MOTA;
    }

    public String getTENPH() {
        return TENPH;
    }

    public void setTENPH(String TENPH) {
        this.TENPH = TENPH;
    }

    public String getTINHTRANG() {
        return TINHTRANG;
    }

    public void setTINHTRANG(String TINHTRANG) {
        this.TINHTRANG = TINHTRANG;
    }

    public PHONG(String ANH, String MAKS, String MALOAI, String MAPHONG, String MOTA, String TENPH, String TINHTRANG) {
        this.ANH = ANH;
        this.MAKS = MAKS;
        this.MALOAI = MALOAI;
        this.MAPHONG = MAPHONG;
        this.MOTA = MOTA;
        this.TENPH = TENPH;
        this.TINHTRANG = TINHTRANG;
    }

    public PHONG() {
    }
}
