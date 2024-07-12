package NguoiDung;

import BoKiemDinh.*;
import QuanLyThongTin.QuanLyThongTin;
import Settings.Settings;
import ThongTin.ThongTin;
import TieuChuan.TieuChuan;
import TieuChi.TieuChi;

import java.util.List;


public class TruongPhong extends NguoiDung {
    private boolean capQuyen = false;
    private static int slot;
    private String maTruongPhong = String.format("TruongPhong%02d", ++slot);

    public TruongPhong(String tk, String mk) {
        super(tk, mk);

    }

    public TruongPhong() {

    }

    @Override
    public boolean isCapQuyen() {
        return this.capQuyen;
    }

    @Override
    public void thongTin() {
        System.out.printf("Thu tu truong phong: %s\n", this.maTruongPhong);
        System.out.printf("TK: %s ---- MK: %s\n",this.tenTaiKhoan,this.matKhau);

    }


    public boolean checkTruongPhong(String tk, String mk) {
        return this.tenTaiKhoan.equals(tk) && this.matKhau.equals(mk);
    }

    @Override
    public void capQuyen() {
        this.capQuyen = true;
    }

    public void capQuyen(GiangVien gv) {
        gv.capQuyen();
    }

    public String getMa() {
        return this.maTruongPhong;
    }

    public String getTenTaiKhoan() {
        return this.tenTaiKhoan;
    }

    public void themBoKiemDinh(QuanLyBoKiemDinh boKiemDinh) {

        String temp;
        System.out.printf("Moi ban nhap ten BO KIEM DINH CAN THEM: ");
        temp = Settings.sc.nextLine();
        BoKiemDinh bkd = new BoKiemDinh(temp);
        boKiemDinh.themBoKiemDinh(bkd);


    }

    public void themTieuChuan(QuanLyThongTin thongTin) {

        ThongTin NewTieuChuan;
        String temp1, temp2;
        System.out.printf("Nhap vao ten cua tieu chuan: ");
        temp1 = Settings.sc.nextLine();
        System.out.printf("Nhap vao noi dung tieu chuan: ");
        temp2 = Settings.sc.nextLine();
        NewTieuChuan = new TieuChuan(temp1, temp2);
        thongTin.themThongTin(NewTieuChuan);


    }

    public void themTieuChi(QuanLyThongTin thongTin) {

        ThongTin NewTieuChi;
        String temp1, temp2;
        System.out.printf("Nhap vao ten cua tieu chi: ");
        temp1 = Settings.sc.nextLine();
        System.out.printf("Nhap vao noi dung tieu chi: ");
        temp2 = Settings.sc.nextLine();
        NewTieuChi = new TieuChi(temp1, temp2);
        thongTin.themThongTin(NewTieuChi);

    }

    public void themTieuChiChoTieuChuan(TieuChuan tieuChuan, TieuChi... tieuChi) {
        tieuChuan.themTieuChi(tieuChi);
    }

    public void themTieuChuanChoBoKiemDinh(BoKiemDinh bkd, TieuChuan... tieuChuan) {
        bkd.themTieuChuan(tieuChuan);
    }


}
