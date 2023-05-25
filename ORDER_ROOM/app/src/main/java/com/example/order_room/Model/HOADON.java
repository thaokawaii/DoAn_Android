package com.example.order_room.Model;

public class HOADON {
    String MAKH;
    String MAKS;
    String MALOAI;
    String MAPH;
    String NGAYDAT;
    String NGAYNHAN;
    String NGAYTRA;

    public HOADON(String MAKH, String MAKS, String MALOAI, String MAPH, String NGAYDAT, String NGAYNHAN, String NGAYTRA, String TINHTRANG, String TONGTIEN) {
        this.MAKH = MAKH;
        this.MAKS = MAKS;
        this.MALOAI = MALOAI;
        this.MAPH = MAPH;
        this.NGAYDAT = NGAYDAT;
        this.NGAYNHAN = NGAYNHAN;
        this.NGAYTRA = NGAYTRA;
        this.TINHTRANG = TINHTRANG;
        this.TONGTIEN = TONGTIEN;
    }

    String TINHTRANG;
    String TONGTIEN;

    public String getTINHTRANG() {
        return TINHTRANG;
    }

    public void setTINHTRANG(String TINHTRANG) {
        this.TINHTRANG = TINHTRANG;
    }

    public String getMAKH() {
        return MAKH;
    }

    public void setMAKH(String MAKH) {
        this.MAKH = MAKH;
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

    public String getMAPH() {
        return MAPH;
    }

    @Override
    public String toString() {
        return "HOADON{" +
                "MAKH='" + MAKH + '\'' +
                ", MAKS='" + MAKS + '\'' +
                ", MALOAI='" + MALOAI + '\'' +
                ", MAPH='" + MAPH + '\'' +
                ", NGAYDAT='" + NGAYDAT + '\'' +
                ", NGAYNHAN='" + NGAYNHAN + '\'' +
                ", NGAYTRA='" + NGAYTRA + '\'' +
                ", TONGTIEN='" + TONGTIEN + '\'' +
                '}';
    }

    public void setMAPH(String MAPH) {
        this.MAPH = MAPH;
    }

    public String getNGAYDAT() {
        return NGAYDAT;
    }

    public void setNGAYDAT(String NGAYDAT) {
        this.NGAYDAT = NGAYDAT;
    }

    public String getNGAYNHAN() {
        return NGAYNHAN;
    }

    public void setNGAYNHAN(String NGAYNHAN) {
        this.NGAYNHAN = NGAYNHAN;
    }

    public String getNGAYTRA() {
        return NGAYTRA;
    }

    public void setNGAYTRA(String NGAYTRA) {
        this.NGAYTRA = NGAYTRA;
    }

    public String getTONGTIEN() {
        return TONGTIEN;
    }

    public void setTONGTIEN(String TONGTIEN) {
        this.TONGTIEN = TONGTIEN;
    }

    public HOADON() {
    }
}
