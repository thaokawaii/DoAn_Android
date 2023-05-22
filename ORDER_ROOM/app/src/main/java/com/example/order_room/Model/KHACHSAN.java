package com.example.order_room.Model;

public class KHACHSAN {
    String ANH,DIACHI,EMAIL,SDT,TENKS;

    @Override
    public String toString() {
        return "KHACHSAN{" +
                "ANH='" + ANH + '\'' +
                ", DIACHI='" + DIACHI + '\'' +
                ", EMAIL='" + EMAIL + '\'' +
                ", SDT='" + SDT + '\'' +
                ", TENKS='" + TENKS + '\'' +
                '}';
    }

    public String getANH() {
        return ANH;
    }

    public KHACHSAN(String ANH, String DIACHI, String EMAIL, String SDT, String TENKS) {
        this.ANH = ANH;
        this.DIACHI = DIACHI;
        this.EMAIL = EMAIL;
        this.SDT = SDT;
        this.TENKS = TENKS;
    }

    public KHACHSAN() {
    }

    public void setANH(String ANH) {
        this.ANH = ANH;
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

    public String getSDT() {
        return SDT;
    }

    public void setSDT(String SDT) {
        this.SDT = SDT;
    }

    public String getTENKS() {
        return TENKS;
    }

    public void setTENKS(String TENKS) {
        this.TENKS = TENKS;
    }
}
