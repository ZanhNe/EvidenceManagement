package NguoiDung;


import ThaoTac.ThaoTac;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Admin implements ThaoTac {
    private String taiKhoan, matKhau;
    private List<NguoiDung> dsNguoiDung = new ArrayList<>();

    public Admin() {
        this.taiKhoan = "Zanh0110";
        this.matKhau = "Doanhpro123";
    }

    public void themNguoiDung(NguoiDung... nguoiDungs) {
        this.dsNguoiDung.addAll(Arrays.asList(nguoiDungs));
    }


    public void setTaiKhoan(String tk) {
        this.taiKhoan = tk;
    }

    public String getTaiKhoan() {
        return this.taiKhoan;
    }

    public void setMatKhau(String mk) {
        this.matKhau = mk;
    }

    public String getMatKhau() {
        return this.matKhau;
    }

    public void setDsNguoiDung(List<NguoiDung> nguoiDungList) {
        this.dsNguoiDung = nguoiDungList;
    }

    public TruongPhong taiKhoan(TruongPhong tp, String tk, String mk) {

        return this.dsNguoiDung.stream().filter(nd -> nd instanceof TruongPhong).map(nd -> (TruongPhong) nd).filter(tP -> tP.checkTruongPhong(tk, mk)).findFirst().orElse(null);
    }

    public GiangVien taiKhoan(GiangVien gv, String tk, String mk) {

        return this.dsNguoiDung.stream().filter(nd -> nd instanceof GiangVien).map(nd -> (GiangVien) nd).filter(gV -> gV.checkGiangVien(tk, mk)).findFirst().orElse(null);
    }

    public List<NguoiDung> getDsNguoiDung() {
        return this.dsNguoiDung;
    }

    public TruongPhong timNguoiDung(String a, TruongPhong tp) {
        return this.dsNguoiDung.stream().filter(nd -> nd instanceof TruongPhong).map(nd -> (TruongPhong) nd).filter(tP -> tP.getMa().equals(a)).findFirst().orElse(null);
    }

    public GiangVien timNguoiDung(String a, GiangVien gv) {
        return this.dsNguoiDung.stream().filter(nd -> nd instanceof GiangVien).map(nd -> (GiangVien) nd).filter(gV -> gV.getMa().equals(a)).findFirst().orElse(null);
    }

    public List<TruongPhong> danhSach(TruongPhong tp) {
        List<TruongPhong> dsTP = this.dsNguoiDung.stream().filter(nd -> nd instanceof TruongPhong).map(nd -> (TruongPhong) nd).collect(Collectors.toList());
        return dsTP;
    }

    public List<GiangVien> danhSach(GiangVien gv) {
        List<GiangVien> dsGv = this.dsNguoiDung.stream().filter(nd -> nd instanceof GiangVien).map(nd -> (GiangVien) nd).collect(Collectors.toList());
        return dsGv;
    }


    public void capQuyen(TruongPhong tp) {
        tp.capQuyen();
    }


    public void thongTin(TruongPhong tp) {
        String format = " %-20s  %-30s  %-30s \n";
        System.out.printf("====================================================================================================\n");
        System.out.printf(format, "MA TRUONG PHONG", "TEN TAI KHOAN", "QUYEN HAN");
        System.out.printf("====================================================================================================\n");
        this.dsNguoiDung.stream().filter(nd -> nd instanceof TruongPhong).map(nd -> (TruongPhong) nd).forEach(truongPhong -> System.out.printf(format, truongPhong.getMa(), truongPhong.getTenTaiKhoan(), truongPhong.isCapQuyen() ? "DA CAP QUYEN\n" : "CHUA CAP QUYEN\n"));
        System.out.format("======================DEV=BY=ZANH=AND=DAN============================================================\n");
    }

    public void thongTin(GiangVien gv) {
        String format = " %-20s  %-30s  %-30s \n";
        System.out.printf("====================================================================================================\n");
        System.out.printf(format, "MA GIANG VIEN", "TEN TAI KHOAN", "QUYEN HAN");
        System.out.printf("====================================================================================================\n");
        this.dsNguoiDung.stream().filter(nd -> nd instanceof GiangVien).map(nd -> (GiangVien) nd).forEach(giangVien -> System.out.printf(format, giangVien.getMa(), giangVien.getTenTaiKhoan(), giangVien.isCapQuyen() ? "DA CAP QUYEN\n" : "CHUA CAP QUYEN\n"));
        System.out.format("======================DEV=BY=ZANH=AND=DAN============================================================\n");
    }


    @Override
    public void showListAccount() {
        this.dsNguoiDung.stream().forEach(x -> x.thongTin());
    }
}
