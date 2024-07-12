package BoKiemDinh;

import TieuChuan.TieuChuan;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class BoKiemDinh {
    private String tenBoKiemDinh = "BKD";
    private List<TieuChuan> dsTieuChuan = new ArrayList<>();

    public BoKiemDinh(String ten) {
        this.tenBoKiemDinh = ten;
    }

    public void themTieuChuan(TieuChuan... tc) {
        this.dsTieuChuan.addAll(Arrays.asList(tc));
    }

    public void xoaTieuChuan(TieuChuan tc) {
        this.dsTieuChuan.remove(tc);
    }

    public void xoaTieuChuan(String a) {
        this.dsTieuChuan.removeIf(x -> x.getMa().equals(a) || x.getTen().equals(a) || x.getNoiDung().equals(a));
    }

    public void setTenBoKiemDinh(String ten) {
        this.tenBoKiemDinh = ten;
    }

    public String getTenBoKiemDinh() {
        return this.tenBoKiemDinh;
    }

    public void setDsTieuChuan(List<TieuChuan> tieuChuanList) {
        this.dsTieuChuan = tieuChuanList;
    }

    public List<TieuChuan> getDsTieuChuan() {
        return this.dsTieuChuan;
    }
    public int getSize() {
        return this.dsTieuChuan.size();
    }

    public void hienThi() {
        System.out.printf("Ten bo kiem dinh: %s\n", this.tenBoKiemDinh);
    }
}
