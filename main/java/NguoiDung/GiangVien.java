package NguoiDung;

import MinhChung.*;
import TieuChi.TieuChi;
import TieuChuan.TieuChuan;
import Settings.Settings;

import java.util.List;

public class GiangVien extends NguoiDung {
    private boolean capQuyen = false;
    private static int slotGiangVien;
    private String maGiangVien = String.format("GiangVien%02d", ++slotGiangVien);

    public GiangVien(String tk, String mk) {
        super(tk, mk);
    }

    public GiangVien() {
    }

    public String getTenTK() {
        return this.tenTaiKhoan;
    }

    public String getMa() {
        return this.maGiangVien;
    }

    public String getTenTaiKhoan() {
        return this.tenTaiKhoan;
    }

    @Override
    public boolean isCapQuyen() {
        return this.capQuyen;
    }

    @Override
    public void thongTin() {
        System.out.printf("Ma giang vien: %s\n", this.maGiangVien);
        System.out.printf("TK: %s ---- MK: %s\n",this.tenTaiKhoan,this.matKhau);
    }

    @Override
    public void capQuyen() {
        this.capQuyen = true;
    }

    public boolean checkGiangVien(String tk, String mk) {
        return this.tenTaiKhoan.equals(tk) && this.matKhau.equals(mk);
    }

    public void vietBaoCaoTieuChuan(TieuChuan tc) {

        String temp;
        System.out.printf("Nhap vao bao cao: ");
        temp = Settings.sc.nextLine();
        tc.addProperty("report", temp);


    }

    public void themMinhChung(QuanLyMinhChung minhChungs) {

        MinhChung NewMinhChung;
        String tenMinhChung, noiBanHanh, ngayBanHanh;
        System.out.printf("Nhap vao ten minh chung: ");
        tenMinhChung = Settings.sc.nextLine();
        System.out.printf("Nhap vao noi ban hanh: ");
        noiBanHanh = Settings.sc.nextLine();
        System.out.printf("Nhap vao ngay ban hanh: ");
        ngayBanHanh = Settings.sc.nextLine();
        NewMinhChung = new MinhChung(tenMinhChung, noiBanHanh, ngayBanHanh);
        minhChungs.themMinhChung(NewMinhChung);


    }

    public void xoaMinhChung(QuanLyMinhChung minhChungs) {

        String a;
        System.out.printf("NHAP VAO MA MINH CHUNG || TEN MINH CHUNG DE XOA: ");
        a = Settings.sc.nextLine();

        if (minhChungs.xoaMinhChung(a))
            System.out.printf("DA XOA MINH CHUNG\n");
        else System.out.printf("KHONG TIM THAY DE XOA\n");


    }

    public void ganMinhChungChoTieuChi(TieuChi tc, MinhChung mc) {
        if (this.isCapQuyen()) {
            tc.themMinhChung(mc);
        } else System.out.printf("Chua cap quyen de thuc hien\n");
    }

}
