package CapPhep;

import MinhChung.MinhChung;
import PhongBan.PhongBan;
import Settings.Settings;

import java.time.LocalDate;
import java.util.Set;


public class CapPhep {
    private LocalDate ngayCungCap, ngayKhoiTaoTrenHeThong;
    private PhongBan phongBan;
    private MinhChung minhChung;

    public CapPhep() {

    }

    public CapPhep(String ngayCungCap, String ngayKhoiTao) {
        this.ngayCungCap = LocalDate.parse(ngayCungCap, Settings.formatter);
        this.ngayKhoiTaoTrenHeThong = LocalDate.parse(ngayKhoiTao, Settings.formatter);
    }

    public CapPhep(PhongBan phongBan, MinhChung minhChung, String ngayCungCap, String ngayKhoiTao) {
        this.phongBan = phongBan;
        this.minhChung = minhChung;
        this.ngayCungCap = LocalDate.parse(ngayCungCap, Settings.formatter);
        this.ngayKhoiTaoTrenHeThong = LocalDate.parse(ngayKhoiTao, Settings.formatter);
    }

    public CapPhep(PhongBan phongBan, MinhChung minhChung, LocalDate ngayCungCap, LocalDate ngayKhoiTaoTrenHeThong) {
        this.phongBan = phongBan;
        this.minhChung = minhChung;
        this.ngayCungCap = ngayCungCap;
        this.ngayKhoiTaoTrenHeThong = ngayKhoiTaoTrenHeThong;
    }

    public void thongTin() {
        System.out.printf("Phong ban: %s\n", phongBan.getTenPhong());
        System.out.printf("Minh chung: %s\n", minhChung.getMaMinhChung());
        System.out.printf("Ngay cung cap: %s\n", this.ngayCungCap.format(Settings.formatter));
        System.out.printf("Ngay khoi tao: %s\n", this.ngayKhoiTaoTrenHeThong.format(Settings.formatter));
    }

    public void setPhongBan(PhongBan phongBan) {
        this.phongBan = phongBan;
    }

    public PhongBan getPhongBan() {
        return this.phongBan;
    }

    public void setMinhChung(MinhChung minhChung) {
        this.minhChung = minhChung;
    }

    public MinhChung getMinhChung() {
        return this.minhChung;
    }

    public void setNgayCungCap(LocalDate ngayCungCap) {
        this.ngayCungCap = ngayCungCap;
    }

    public void setNgayCungCap(String ngayCungCap) {
        this.ngayCungCap = LocalDate.parse(ngayCungCap, Settings.formatter);
    }

    public String getNgayCungCap() {
        return this.ngayCungCap.format(Settings.formatter);
    }

    public void setNgayKhoiTaoTrenHeThong(LocalDate ngayKhoiTaoTrenHeThong) {
        this.ngayKhoiTaoTrenHeThong = ngayKhoiTaoTrenHeThong;
    }

    public void setNgayKhoiTaoTrenHeThong(String ngayKhoiTao) {
        this.ngayKhoiTaoTrenHeThong = LocalDate.parse(ngayKhoiTao, Settings.formatter);
    }

    public String getNgayKhoiTaoTrenHeThong() {
        return this.ngayKhoiTaoTrenHeThong.format(Settings.formatter);
    }
}
