package ThaoTac;

import NguoiDung.GiangVien;
import NguoiDung.TruongPhong;

import java.util.List;

public interface ThaoTac {
     void showListAccount();
     List<TruongPhong> danhSach(TruongPhong tp);
     List<GiangVien> danhSach(GiangVien gv);
     void thongTin(TruongPhong tp);
     void thongTin(GiangVien gv);

}
