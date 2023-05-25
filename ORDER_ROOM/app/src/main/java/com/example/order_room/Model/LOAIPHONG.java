package com.example.order_room.Model;

import android.icu.text.DecimalFormat;
import android.icu.text.NumberFormat;

import java.util.Locale;

public class LOAIPHONG {
    String ANH,GIA,MAKS,MALOAI,MOTA,SONGUOITOIDA,TENLOAI;

    public String getANH() {
        return ANH;
    }

    public LOAIPHONG(String ANH, String GIA, String MAKS, String MALOAI, String MOTA, String SONGUOITOIDA, String TENLOAI) {
        this.ANH = ANH;
        this.GIA = GIA;
        this.MAKS = MAKS;
        this.MALOAI = MALOAI;
        this.MOTA = MOTA;
        this.SONGUOITOIDA = SONGUOITOIDA;
        this.TENLOAI = TENLOAI;
    }

    public LOAIPHONG() {
    }

    public void setANH(String ANH) {
        this.ANH = ANH;
    }

    public String getGIA() {
        return GIA;
    }

    public void setGIA(String GIA) {
        this.GIA = GIA;
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

    public String getMOTA() {
        return MOTA;
    }

    public void setMOTA(String MOTA) {
        this.MOTA = MOTA;
    }

    public String getSONGUOITOIDA() {
        return SONGUOITOIDA;
    }

    public void setSONGUOITOIDA(String SONGUOITOIDA) {
        this.SONGUOITOIDA = SONGUOITOIDA;
    }

    public String getTENLOAI() {
        return TENLOAI;
    }

    public void setTENLOAI(String TENLOAI) {
        this.TENLOAI = TENLOAI;
    }

}
