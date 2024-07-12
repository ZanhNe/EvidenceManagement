package MinhChung;

import CapPhep.CapPhep;
import PhongBan.PhongBan;
import Settings.Settings;
import TieuChi.TieuChi;
import getSize.getSize;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MinhChung implements getSize  {
    private static int demMinhChung;
    private String maMinhChung = String.format("MinhChung%02d", ++demMinhChung);
    private String tenMinhChung, noiBanHanh;
    private LocalDate ngayBanHanh;
    private List<CapPhep> dsCapPhep = new ArrayList<>();
    private List<TieuChi> dsTieuChi = new ArrayList<>();

    private List<PhongBan> dsPhongBan = new ArrayList<>();


    //Constructor
    public MinhChung() {
    }

    public MinhChung(String ten, String noiBanHanh, String ngayBanHanh) {
        this.tenMinhChung = ten;
        this.noiBanHanh = noiBanHanh;
        this.ngayBanHanh = LocalDate.parse(ngayBanHanh, Settings.formatter);

    }

    public MinhChung(String ten, String noiBanHanh, LocalDate ngayBanHanh) {
        this.ngayBanHanh = ngayBanHanh;
        this.tenMinhChung = ten;
        this.noiBanHanh = noiBanHanh;
    }
    public MinhChung(String ten,String noiBanHanh,String ngayBanHanh,TieuChi ...tc){
        this.tenMinhChung = ten;
        this.noiBanHanh = noiBanHanh;
        this.ngayBanHanh = LocalDate.parse(ngayBanHanh,Settings.formatter);
        this.dsTieuChi.addAll(Arrays.asList(tc));
    }
    public void them(CapPhep ...cp) {
        this.dsCapPhep.addAll(Arrays.asList(cp));
    }

    public void them(TieuChi... tc) {
        this.dsTieuChi.addAll(Arrays.asList(tc));
    }

    public void them(PhongBan... phongBan) {
        this.dsPhongBan.addAll(Arrays.asList(phongBan));
    }

    //Hàm xóa
    public void xoa(TieuChi tc) {
        this.dsTieuChi.remove(tc);
    }

    public boolean xoa(String a,TieuChi tc) {
        return this.dsTieuChi.removeIf(x -> x.getMa().equals(a) || x.getNoiDung().equals(a) || x.getTen().equals(a));
    }

    public void xoa(PhongBan phongBan) {
        this.dsPhongBan.remove(phongBan);
    }

    public boolean xoa(String a,PhongBan pb) {
        return this.dsPhongBan.removeIf(x -> x.getTenPhong().equals(a) || x.getMaPhong().equals(a));
    }
    public void xoa(CapPhep cp) {
        this.dsCapPhep.remove(cp);
    }
    public boolean xoa(String ngayCungCap, String ngayKhoiTao) {
        return this.dsCapPhep.removeIf(x -> x.getNgayCungCap().equals(ngayCungCap)&&x.getNgayKhoiTaoTrenHeThong().equals(ngayKhoiTao));
    }


    //Hàm getter & setter

    public void setDsTieuChi(List<TieuChi> tc) {
        this.dsTieuChi = tc;
    }

    public List<TieuChi> getDsTieuChi() {
        return this.dsTieuChi;
    }

    public void setNgayBanHanh(String ngayBanHanh) {
        this.ngayBanHanh = LocalDate.parse(ngayBanHanh, Settings.formatter);
    }

    public String getNgayBanHanh() {
        return this.ngayBanHanh.format(Settings.formatter);
    }

    public void setCapPhepList(List<CapPhep> capPhep) {
        this.dsCapPhep = capPhep;
    }

    public List<CapPhep> getListCapPhep() {
        return this.dsCapPhep;
    }

    public void setDsPhongBan(List<PhongBan> dsPhongBan) {
        this.dsPhongBan = dsPhongBan;
    }

    public List<PhongBan> getDsPhongBan() {
        return this.dsPhongBan;
    }

    public void setTenMinhChung(String ten) {
        this.tenMinhChung = ten;
    }

    public String getTenMinhChung() {
        return this.tenMinhChung;
    }

    public void setNoiBanHanh(String noiBanHanh) {
        this.noiBanHanh = noiBanHanh;
    }

    public String getNoiBanHanh() {
        return this.noiBanHanh;
    }

    public String getMaMinhChung() {
        return this.maMinhChung;
    }
    public int getNgay(){
        return this.ngayBanHanh.getDayOfMonth();
    }
    @Override
    public int getSize() {
        return this.dsPhongBan.size();
    }

    //END
    public void hienThi() {
        System.out.printf("Ma minh chung: %s - Ten minh chung: %s - Noi ban hanh: %s - Ngay ban hanh: %s\n", this.getMaMinhChung(), this.getTenMinhChung(), this.getNoiBanHanh(), this.getNgayBanHanh());
    }
}
