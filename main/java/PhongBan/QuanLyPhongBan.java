package PhongBan;


import getSize.getSize;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class QuanLyPhongBan implements getSize {
    private List<PhongBan> phongBanList = new ArrayList<>();

    public QuanLyPhongBan() {
    }

    public void themPhongBan(PhongBan... phongBans) {
        this.phongBanList.addAll(Arrays.asList(phongBans));
    }

    public void xoaPhongBan(PhongBan phongBan) {
        this.phongBanList.remove(phongBan);
    }

    public boolean xoaPhongBan(String a) {
         return  this.phongBanList.removeIf(x -> x.getTenPhong().equals(a) || x.getDiaDiemPhongBan().equals(a) || x.getMaPhong().equals(a));
    }

    public void setPhongBanList(List<PhongBan> phongBanList) {
        this.phongBanList = phongBanList;
    }

    public List<PhongBan> getPhongBanList() {
        return this.phongBanList;
    }

    public List<PhongBan> timPhongBan(String a) {
        return this.phongBanList.stream().filter(x -> x.getTenPhong().equals(a) || x.getDiaDiemPhongBan().equals(a) || x.getMaPhong().equals(a)).collect(Collectors.toList());
    }

    public PhongBan timPhongBan(String a, PhongBan pb) {
        return this.phongBanList.stream().filter(x -> x.getTenPhong().equals(a) || x.getMaPhong().equals(a)).findFirst().orElse(null);
    }

    public int getSize() {
        return this.phongBanList.size();
    }

    public void listMinhChung() {
        for (PhongBan phongBan : this.phongBanList) {
            phongBan.hienThiMinhChung();
        }
    }

    public void danhSachPhongBan() {
        String format = " %-30s  %-30s  %-30s \n";
        System.out.printf("====================================================================================================\n");
        System.out.printf(format, "MA PHONG BAN", "TEN PHONG BAN", "DIA DIEM PHONG BAN");
        System.out.printf("====================================================================================================\n");

        for (PhongBan pb : this.phongBanList) {
            System.out.printf(format, pb.getMaPhong(), pb.getTenPhong(), pb.getDiaDiemPhongBan());

        }
        System.out.format("======================DEV=BY=ZANH=AND=DAN============================================================\n");
    }
}
