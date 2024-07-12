
import File.DocFile;
import MinhChung.*;
import PhongBan.PhongBan;
import QuanLyThongTin.QuanLyThongTin;
import Settings.Settings;
import ThongTin.ThongTin;
import TieuChi.TieuChi;
import TieuChuan.TieuChuan;
import NguoiDung.*;
import INPUT_OUTPUT.InOut;

import BoKiemDinh.*;
import CapPhep.*;
import PhongBan.*;


import javax.print.Doc;
import java.util.ArrayList;
import java.util.List;


public class main {
    public static void main(String[] args) {
        int luaChon;
        int luaChonLogin;
        String tk, mk, temp;

        // Tao nguoi dung
        Admin admin = new Admin(); //Admin
        List<NguoiDung> dsNd = new ArrayList<>(); //Danh sach nguoi dung
        TruongPhong nd = new TruongPhong();
        GiangVien nd2 = new GiangVien();
        DocFile.docDuLieu("Data/DataTruongPhong.txt", nd, dsNd);
        DocFile.docDuLieu("Data/DataGiangVien.txt", nd2, dsNd);


        admin.setDsNguoiDung(dsNd); // set danh sach nguoi dung cho admin quan ly


        //TẠO TIÊU CHUẨN
        List<ThongTin> dsTT = new ArrayList<>(); //danh sach thong tin
        DocFile.docDuLieu("Data/DataTieuChuan.txt", dsTT);
        DocFile.docDuLieu("Data/DataTieuChi.txt", dsTT);
        QuanLyThongTin thongTin = new QuanLyThongTin();
        thongTin.setDsThongTin(dsTT); // set danh sach thong tin vao quan ly thong tin


        //Tạo bộ kiểm định


        QuanLyBoKiemDinh dsBoKd = new QuanLyBoKiemDinh();


        //============================MINH CHỨNG==============================================//
        List<MinhChung> dsMC = new ArrayList<>();
        MinhChung minhChung = new MinhChung();
        DocFile.docDuLieu("Data/DataMinhChung.txt", minhChung, dsMC);


        //Tao danh sach minh chung de quan ly
        QuanLyMinhChung dsMinhChung = new QuanLyMinhChung();
        dsMinhChung.setDsMinhChung(dsMC);

        //=============================PHÒNG BAN===========================================//
        List<PhongBan> dsPB = new ArrayList<>();
        PhongBan phongBan = new PhongBan(null, null);
        DocFile.docDuLieu("Data/DataPhongBan.txt", phongBan, dsPB);
        QuanLyPhongBan dsPhongBan = new QuanLyPhongBan();
        dsPhongBan.setPhongBanList(dsPB);


        //==============================CUNG CẤP =========================================//
        List<CapPhep> dsCapPhep = new ArrayList<>();
        CapPhep capPhep = new CapPhep();
        DocFile.docDuLieu("Data/DataCapPhep.txt", capPhep, dsCapPhep);

        //Phan nay tro di la set co dinh de co truoc cau truc mot bo kiem dinh
        //TAO TRUOC BO KIEM DINH
        BoKiemDinh boKiemDinh = new BoKiemDinh("IKO");
        //TAO TRUOC TIEU CHUAN
        ThongTin tieuChuanQuanLy = new TieuChuan("QuanLy", "Dua tren cac dieu kien san co");
        ThongTin tieuChuanHeThong = new TieuChuan("Kiem cuc", "Chia ra phan khu he thong");
        //TAO TRUOC TIEU CHI
        ThongTin tieuChiQuanLy = new TieuChi("QuanLy", "Kiem soat chat che cac noi dung", (TieuChuan) tieuChuanQuanLy);

        ThongTin tieuChiNganhHoc = new TieuChi("Nganh hoc", "Phu hop voi xu huong nganh", (TieuChuan) tieuChuanQuanLy);

        ThongTin tieuChiCungCap = new TieuChi("Cung cap", "Phan hoi xay dung", (TieuChuan) tieuChuanHeThong);
        ThongTin tieuChiTrinhDo = new TieuChi("Trinh do", "Giang vien lien tuc nang cao kha nang giang day va trinh do", (TieuChuan) tieuChuanQuanLy);
        ThongTin tieuChiCoSo = new TieuChi("Co so vat chat", "Dap ung nhu cau tieu chuan cho hoc tap", (TieuChuan) tieuChuanHeThong);
        ((TieuChuan) tieuChuanQuanLy).themTieuChi((TieuChi) tieuChiQuanLy, (TieuChi) tieuChiNganhHoc, ((TieuChi) tieuChiTrinhDo));
        ((TieuChuan) tieuChuanHeThong).themTieuChi((TieuChi) tieuChiCungCap, (TieuChi) tieuChiCoSo);
        //TAO TRUOC MINH CHUNG
        MinhChung minhChungQuanLy = new MinhChung("Quan ly", "TPHCM", "12/10/2020", (TieuChi) tieuChiQuanLy, (TieuChi) tieuChiNganhHoc, (TieuChi) tieuChiCungCap);
        ((TieuChi) tieuChiCungCap).themMinhChung(minhChungQuanLy);
        ((TieuChi) tieuChiNganhHoc).themMinhChung(minhChungQuanLy);
        ((TieuChi) tieuChiQuanLy).themMinhChung(minhChungQuanLy);
        minhChungQuanLy.them((TieuChi) tieuChiNganhHoc, (TieuChi) tieuChiCungCap, (TieuChi) tieuChiQuanLy);
        MinhChung minhChungDaoTao = new MinhChung("Dao tao", "TPHCM", "25/12/2021", (TieuChi) tieuChiTrinhDo, (TieuChi) tieuChiCoSo);
        ((TieuChi) tieuChiCoSo).themMinhChung(minhChungDaoTao);
        ((TieuChi) tieuChiTrinhDo).themMinhChung(minhChungDaoTao);
        //TAO TRUOC PHONG BAN
        PhongBan phongBan1 = new PhongBan("PhongBanQuanLy", "TPHCM");
        PhongBan phongBan2 = new PhongBan("PhongBanHeThong", "NASA");
        dsPhongBan.themPhongBan(phongBan1, phongBan2);
        phongBan1.themMinhChung(minhChungQuanLy, minhChungDaoTao);
        minhChungQuanLy.them(phongBan1);
        minhChungDaoTao.them(phongBan1);
        CapPhep capPhep1 = new CapPhep("12/05/2022", "23/06/2022");
        capPhep1.setPhongBan(phongBan1);
        boKiemDinh.themTieuChuan((TieuChuan) tieuChuanQuanLy, (TieuChuan) tieuChuanHeThong);
        dsBoKd.themBoKiemDinh(boKiemDinh);
        dsMinhChung.themMinhChung(minhChungQuanLy, minhChungDaoTao);


        TieuChuan tc1 = new TieuChuan(null,null);
        TieuChi tchi1 = new TieuChi(null,null);
        boKiemDinh.hienThi();
        thongTin.thongTin(tc1);
        thongTin.thongTin(tchi1);


        dsMinhChung.DanhSachMinhChung();
        dsPhongBan.danhSachPhongBan();



        //MENU DANG NHAP

        do {

            System.out.printf("=============  MENU LOGIN=================\n");
            System.out.printf("=============  1.ADMIN       =============\n");
            System.out.printf("=============  2.TRUONGPHONG =============\n");
            System.out.printf("=============  3.GIANG VIEN  =============\n");
            System.out.printf("=============  4.THOAT       =============\n");
            System.out.printf("----->BAN MUON DANG NHAP VOI VAI TRO NAO\n");
            luaChonLogin = InOut.getAnInteger("LUA CHON: ", "VUI LONG NHAP LAI ( SO NGUYEN )");
            switch (luaChonLogin) {
                case 1: {
                    System.out.printf("Tai khoan: ");
                    tk = Settings.sc.nextLine();
                    System.out.printf("Mat khau: ");
                    mk = Settings.sc.nextLine();
                    if (admin.getTaiKhoan().equals(tk) && admin.getMatKhau().equals(mk)) {
                        System.out.printf("Dang nhap thanh cong\n");
                        do {
                            System.out.printf("1.TAO TAI KHOAN TRUONG PHONG\n");
                            System.out.printf("2.TAO TAI KHOAN GIANG VIEN\n");
                            System.out.printf("3.CAP QUYEN TRUONG PHONG\n");
                            System.out.printf("4.HIEN THI THONG TIN BKD BAT KI\n");
                            System.out.printf("5.TIM KIEM MINH CHUNG THEO MA || TEN\n");
                            System.out.printf("6.TIM KIEM MINH CHUNG THEO PHONG BAN\n");
                            System.out.printf("7.SAP XEP MINH CHUNG THEO TEN\n");
                            System.out.printf("8.SAP XEP THEO NGAY\n");
                            System.out.printf("9.THONG TIN TAI KHOAN CAC USERS\n");
                            System.out.printf("10.THOAT\n");

                            luaChon = InOut.getAnInteger("LUA CHON: ", "VUI LONG NHAP LAI ( SO NGUYEN )");
                            switch (luaChon) {
                                case 1: {
                                    NguoiDung nguoiDungMoi;
                                    System.out.printf("Nhap ten TK: ");
                                    tk = Settings.sc.nextLine();
                                    System.out.printf("Nhap mk: ");
                                    mk = Settings.sc.nextLine();
                                    nguoiDungMoi = new TruongPhong(tk, mk);
                                    admin.themNguoiDung(nguoiDungMoi);
                                    System.out.printf("DA TAO THANH CONG\n");
                                    break;
                                }
                                case 2: {
                                    NguoiDung nguoiDungMoi;
                                    System.out.printf("Nhap ten TK: ");
                                    tk = Settings.sc.nextLine();
                                    System.out.printf("Nhap mk: ");
                                    mk = Settings.sc.nextLine();
                                    nguoiDungMoi = new GiangVien(tk, mk);
                                    admin.themNguoiDung(nguoiDungMoi);
                                    System.out.printf("DA TAO THANH CONG\n");
                                    break;
                                }
                                case 3: {
                                    String a;
                                    TruongPhong tp = new TruongPhong(null, null);
                                    admin.thongTin(tp); //Show ra list Trưởng Phòng
                                    System.out.printf("Nhap ten truong phong hoac ma truong phong can cap quyen: ");
                                    a = Settings.sc.nextLine();
                                    tp = admin.timNguoiDung(a, tp); // Tìm người dùng trưởng phòng để tra ve
                                    if (tp != null)
                                        admin.capQuyen(tp); //Admin cap quyen cho truong phong
                                    else System.out.printf("Khong tim thay");
                                    break;
                                }
                                case 4: {
                                    if (dsBoKd.getSize() == 0)
                                        System.out.printf("CHUA TON TAI BO KIEM DINH NAO, VUI LONG THEM\n");
                                    else {
                                        dsBoKd.listBoKiemDinh();
                                        System.out.printf("NHAP TEN BO KIEM DINH CAN TRA THONG TIN: ");
                                        String tenBKD = Settings.sc.nextLine();
                                        BoKiemDinh boKiemDinh1 = dsBoKd.timBoKiemDinh(tenBKD);
                                        if (boKiemDinh1 != null) {
                                            boKiemDinh1.hienThi();
                                            int soTieuChuan = boKiemDinh1.getSize();
                                            if (soTieuChuan == 0)
                                                System.out.printf("KHONG CO TIEU CHUAN TRONG BO KIEM DINH\n");
                                            else {
                                                for (TieuChuan tc : boKiemDinh1.getDsTieuChuan()) {
                                                    tc.hienThi();
                                                    if (tc.getSize() != 0) {
                                                        for (TieuChi tchi : tc.getDsTieuChi()) {
                                                            tchi.hienThi();
                                                            if (tchi.getSize() != 0) {
                                                                for (MinhChung minhChung1 : tchi.getDsMinhChung()) {
                                                                    minhChung1.hienThi();
                                                                    if (minhChung1.getSize() != 0) {
                                                                        for (PhongBan phongBan3 : minhChung1.getDsPhongBan()) {
                                                                            phongBan3.hienThi();
                                                                        }

                                                                    } else
                                                                        System.out.printf("KHONG TON TAI DANH SACH PHONG BAN\n");
                                                                }
                                                            } else
                                                                System.out.printf("KHONG TON TAI DANH SACH MINH CHUNG\n");
                                                        }

                                                    } else System.out.printf("KHONG TON TAI DANH SACH TIEU CHI\n");
                                                }
                                            }
                                        }
                                    }
                                    break;
                                }
                                case 5: {
                                    String a;
                                    System.out.printf("Nhap vao ma || ten || noi ban hanh: ");
                                    a = Settings.sc.nextLine();

                                    MinhChung minhChung1 = new MinhChung();
                                    minhChung1 = dsMinhChung.timMinhChung(a, minhChung1);
                                    if (minhChung1 != null) minhChung1.hienThi();
                                    else System.out.printf("Khong ton tai minh chung\n");


                                    break;


                                }
                                case 6: {
                                    String a;
                                    System.out.printf("Nhap vao ten phong ban: ");
                                    a = Settings.sc.nextLine();

                                    PhongBan phongBan3 = new PhongBan(null, null);
                                    phongBan3 = dsPhongBan.timPhongBan(a, phongBan3);
                                    if (phongBan3 != null)
                                        phongBan3.hienThiMinhChung();
                                    else System.out.printf("KHONG TON TAI PHONG BAN\n");

                                    break;
                                }
                                case 7:{
                                    System.out.printf("SAP XEP THEO TEN\n");
                                    dsMinhChung.sapXep("TEN");
                                    dsMinhChung.DanhSachMinhChung();
                                    break;
                                }
                                case 8:{
                                    System.out.printf("SAP XEP THEO NGAY\n");
                                    dsMinhChung.sapXep("NGAY");
                                    dsMinhChung.DanhSachMinhChung();
                                    break;
                                }
                                case 9: {
                                    admin.showListAccount();
                                    break;
                                }
                                default: {
                                    System.out.printf("VUI LONG NHAP LAI\n");
                                }


                            }
                        } while (luaChon != 10);
                    } else System.out.printf("KHONG DUNG TAI KHOAN HOAC MAT KHAU\n");
                    break;
                }
                case 2: {
                    System.out.printf("Tai khoan: ");
                    tk = Settings.sc.nextLine();
                    System.out.printf("Mat khau: ");
                    mk = Settings.sc.nextLine();

                    TruongPhong nDung = new TruongPhong();
                    nDung = admin.taiKhoan(nDung, tk, mk);


                    if (nDung != null) {
                        if (nDung.isCapQuyen()) {
                            do {
                                System.out.printf("1.CAP QUYEN GIANG VIEN\n");
                                System.out.printf("2.THEM BO KIEM DINH\n");
                                System.out.printf("3.THEM TIEU CHUAN\n");
                                System.out.printf("4.THEM TIEU CHI\n");
                                System.out.printf("5.THEM TIEU CHUAN CHO BO KIEM DINH\n");
                                System.out.printf("6.THEM TIEU CHI CHO TIEU CHUAN\n");
                                System.out.printf("7.THOAT\n");

                                luaChon = InOut.getAnInteger("LUA CHON: ", "VUI LONG NHAP LAI ( SO NGUYEN )");

                                switch (luaChon) {
                                    case 1: {
                                        GiangVien gv = new GiangVien();
                                        admin.thongTin(gv);
                                        System.out.printf("Nhap vao ma giang vien can cap: ");
                                        temp = Settings.sc.nextLine();

                                        gv = admin.timNguoiDung(temp, gv);
                                        if (gv != null)
                                            nd.capQuyen(gv); // cap quyen giang vien
                                        else System.out.printf("Khong tim thay giang vien\n");
                                        break;
                                    }
                                    case 2: {
                                        System.out.printf("Nhap vao ten bo kiem dinh: ");
                                        temp = Settings.sc.nextLine();
                                        BoKiemDinh Bkd = new BoKiemDinh(temp);
                                        dsBoKd.themBoKiemDinh(Bkd);
                                        System.out.printf("DA THEM THANH CONG\n");
                                        break;
                                    }
                                    case 3: {
                                        System.out.printf("Nhap ten tieu chuan: ");
                                        temp = Settings.sc.nextLine();
                                        System.out.printf("Nhap noi dung tieu chuan: ");
                                        String a = Settings.sc.nextLine();
                                        ThongTin tchuan = new TieuChuan(temp, a);
                                        thongTin.themThongTin(tchuan);
                                        System.out.printf("THEM TIEU CHUAN THANH CONG\n");
                                        break;
                                    }
                                    case 4: {
                                        System.out.printf("Nhap ten tieu chi: ");
                                        temp = Settings.sc.nextLine();
                                        System.out.printf("Nhap noi dung tieu chi: ");
                                        String a = Settings.sc.nextLine();
                                        ThongTin tchi = new TieuChi(temp, a);
                                        thongTin.themThongTin(tchi);
                                        System.out.printf("THEM TIEU CHI THANH CONG\n");
                                        break;
                                    }
                                    case 5: {
                                        BoKiemDinh Bkd;
                                        dsBoKd.listBoKiemDinh();
                                        System.out.printf("============================================\n");
                                        System.out.printf("Nhap ten bo kiem dinh de them tieu chuan: ");
                                        temp = Settings.sc.nextLine();

                                        Bkd = dsBoKd.timBoKiemDinh(temp);
                                        if (Bkd != null) {
                                            TieuChuan tieuChuan_temp = new TieuChuan(null,null);
                                            thongTin.thongTin(tieuChuan_temp);
                                            System.out.printf("Nhap vao ma tieu chuan || ten tieu chuan trong ds.Tieu Chuan can them vao BKD: ");
                                            String a = Settings.sc.nextLine();
                                            TieuChuan tieuChuan = new TieuChuan(null, null);
                                            tieuChuan = thongTin.timThongTin(a,tieuChuan_temp);
                                            if (tieuChuan != null) {
                                                Bkd.themTieuChuan(tieuChuan);
                                                System.out.printf("DA THEM TIEU CHUAN VAO BKD\n");
                                            } else System.out.printf("KHONG TON TAI TIEU CHUAN\n");
                                        } else System.out.printf("KHONG TON TAI BO KIEM DINH\n");
                                        break;

                                    }
                                    case 6: {

                                        TieuChuan tieuChuan_temp = new TieuChuan(null,null);
                                        thongTin.thongTin(tieuChuan_temp);
                                        System.out.printf("Nhap vao ten tieu chuan || ma tieu chuan can lay ra: ");
                                        temp = Settings.sc.nextLine();
                                        TieuChuan tieuChuan = thongTin.timThongTin(temp,tieuChuan_temp);
                                        if (tieuChuan != null) {
                                            TieuChi tieuChi_temp = new TieuChi(null,null);
                                            thongTin.thongTin(tieuChi_temp);
                                            System.out.printf("Nhap vao ten tieu chi || ma tieu chi can lay ra: ");
                                            temp = Settings.sc.nextLine();
                                            TieuChi tieuChi = thongTin.timThongTin(temp,tieuChi_temp);
                                            if (tieuChi != null) {
                                                tieuChuan.themTieuChi(tieuChi);
                                                System.out.printf("DA THEM TIEU CHI VAO TIEU CHUAN\n");
                                            } else System.out.printf("KHONG TIM THAY TIEU CHI\n");
                                        } else System.out.printf("KHONG TIM THAY TIEU CHUAN\n");
                                        break;
                                    }
                                    default: {
                                        System.out.printf("VUI LONG NHAP LAI\n");
                                    }


                                }

                            } while (luaChon != 7);
                        } else System.out.printf("CHUA CAP QUYEN\n");

                    } else System.out.printf("KHONG DUNG TK VA MK\n");
                    break;
                }

                case 3: {
                    System.out.printf("Tai khoan: ");
                    temp = Settings.sc.nextLine();
                    System.out.printf("Mat khau: ");
                    String a = Settings.sc.nextLine();
                    GiangVien giangVien = new GiangVien(null, null);
                    giangVien = admin.taiKhoan(giangVien, temp, a);
                    if (giangVien != null) {
                        if (giangVien.isCapQuyen()) {
                            do {
                                System.out.printf("1.VIET BAO CAO CHO TIEU CHUAN\n");
                                System.out.printf("2.THEM MINH CHUNG\n");
                                System.out.printf("3.XOA MINH CHUNG\n");
                                System.out.printf("4.CAP NHAT PHONG BAN CHO MINH CHUNG\n");
                                System.out.printf("5.CAP NHAT TIEU CHI CHO MINH CHUNG\n");
                                System.out.printf("6.CAP NHAT MINH CHUNG CHO TIEU CHI\n");
                                System.out.printf("7.THOAT\n");

                                luaChon = InOut.getAnInteger("LUA CHON: ", "VUI LONG NHAP LAI ( SO NGUYEN )");

                                switch (luaChon) {
                                    case 1: {
                                        TieuChuan tieuChuan_temp = new TieuChuan(null,null);
                                        thongTin.thongTin(tieuChuan_temp);
                                        System.out.printf("NHAP VAO TEN TIEU CHUAN || MA TIEU CHUAN CAN LAY RA: ");
                                        temp = Settings.sc.nextLine();
                                        TieuChuan tieuChuan = thongTin.timThongTin(temp,tieuChuan_temp);
                                        if (tieuChuan != null && !tieuChuan.hasReport()) {
                                            giangVien.vietBaoCaoTieuChuan(tieuChuan);
                                        } else if (tieuChuan.hasReport() == true) {
                                            System.out.printf("TIEU CHUAN DA CO BAO CAO\n");
                                        } else System.out.printf("KHONG TIM THAY TIEU CHUAN\n");
                                        thongTin.thongTin(tieuChuan_temp);
                                        break;
                                    }
                                    case 2: {
                                        String tenMC, noiBanHanh, ngayBanHanh;

                                        int soLan = InOut.getAnInteger("Ban muon them bao nhieu minh chung: ", "Vui long nhap lai ( so nguyen )");

                                        for (int i = 0; i < soLan; i++) {

                                            giangVien.themMinhChung(dsMinhChung);
                                        }
                                        System.out.printf("DA THEM THANH CONG MINH CHUNG VAO DANH SACH MINH CHUNG\n");
                                        break;
                                    }
                                    case 3: {


                                        giangVien.xoaMinhChung(dsMinhChung);
                                        dsMinhChung.DanhSachMinhChung();
                                        break;
                                    }
                                    case 4: {
                                        System.out.printf("Nhap vao ten phong ban can lay ra: ");
                                        temp = Settings.sc.nextLine();
                                        PhongBan pb = new PhongBan(null, null);
                                        pb = dsPhongBan.timPhongBan(temp, pb);
                                        if (pb != null) {
                                            System.out.printf("Nhap vao ten minh chung || ma minh chung can lay ra: ");
                                            temp = Settings.sc.nextLine();
                                            MinhChung minhChung1 = new MinhChung();
                                            minhChung1 = dsMinhChung.timMinhChung(temp, minhChung);
                                            if (minhChung1 != null) {
                                                minhChung1.them(pb);
                                                System.out.printf("DA THEM THANH CONG PHONG BAN CHO MINH CHUNG\n");
                                            } else System.out.printf("KHONG TIM THAY MINH CHUNG");
                                        } else System.out.printf("KHONG TIM THAY PHONG BAN\n");
                                        break;
                                    }
                                    case 5: {
                                        TieuChi tieuChi_temp = new TieuChi(null,null);
                                        System.out.printf("Nhap vao ten tieu chi || ma tieu chi de lay ra: ");
                                        temp = Settings.sc.nextLine();
                                        TieuChi tieuChi = thongTin.timThongTin(temp,tieuChi_temp);
                                        if (tieuChi != null) {
                                            System.out.printf("Nhap vao ten minh chung || ma minh chung can lay ra: ");
                                            temp = Settings.sc.nextLine();
                                            MinhChung mc = new MinhChung();
                                            mc = dsMinhChung.timMinhChung(temp, mc);
                                            if (mc != null) {
                                                mc.them(tieuChi);
                                                System.out.printf("DA THEM THANH CONG TIEU CHI CHO MINH CHUNG\n");
                                            } else System.out.printf("KHONG TIM THAY MINH CHUNG\n");
                                        } else System.out.printf("KHONG TIM THAY TIEU CHI\n");
                                        break;
                                    }
                                    case 6: {
                                        TieuChi tieuChi_temp = new TieuChi(null,null);
                                        System.out.printf("Nhap vao ten tieu chi || ma tieu chi de lay ra: ");
                                        temp = Settings.sc.nextLine();
                                        TieuChi tieuChi = thongTin.timThongTin(temp,tieuChi_temp);
                                        if (tieuChi != null) {
                                            System.out.printf("Nhap vao ten minh chung || ma minh chung can lay ra: ");
                                            temp = Settings.sc.nextLine();
                                            MinhChung mc = new MinhChung();
                                            mc = dsMinhChung.timMinhChung(temp, mc);
                                            if (mc != null) {
                                                tieuChi.themMinhChung(mc);
                                                System.out.printf("DA THEM THANH CONG MINH CHUNG CHO TIEU CHI\n");
                                            } else System.out.printf("KHONG TIM THAY MINH CHUNG\n");
                                        } else System.out.printf("KHONG TIM THAY TIEU CHI\n");
                                        break;

                                    }
                                    default: {
                                        System.out.printf("VUI LONG NHAP LAI\n");
                                    }

                                }
                            } while (luaChon != 7);
                        } else if (giangVien.isCapQuyen() == false) {
                            System.out.printf("GIANG VIEN CHUA CAP QUYEN\n");
                        }

                    } else System.out.printf("TAI KHOAN HOAC MAT KHAU KHONG CHINH XAC\n");
                    break;
                }
                case 4:
                    System.out.printf("CAM ON VI DA SU DUNG\n");
                    break;
            }

        } while (luaChonLogin != 4);


    }
}
