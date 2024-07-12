package PhongBan;

import CapPhep.CapPhep;
import MinhChung.MinhChung;
import getSize.getSize;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PhongBan implements getSize {
    private static int demSoLuongPhongBan;
    private int thuTuPhongBan = ++demSoLuongPhongBan;
    private String maPhong = String.format("MaPhong%02d", thuTuPhongBan);
    private String  tenPhong, diaDiemPhongBan;

    private List<CapPhep> dsCapPhep = new ArrayList<>();

    private List<MinhChung> dsMinhChung = new ArrayList<>();

    //Init

    //Construtor
    public PhongBan(String ten, String diaDiem) {
        this.tenPhong = ten;
        this.diaDiemPhongBan = diaDiem;

    }

    public void themMinhChung(MinhChung... mc) {
        this.dsMinhChung.addAll(Arrays.asList(mc));
    }

    //Hàm getter & setter
    public void setTenPhong(String ten) {
        this.tenPhong = ten;
    }

    public String getTenPhong() {
        return this.tenPhong;
    }

    public void setDiaDiemPhongBan(String diaDiemPhongBan) {
        this.diaDiemPhongBan = diaDiemPhongBan;
    }

    public String getDiaDiemPhongBan() {
        return this.diaDiemPhongBan;
    }

    public int getDemSoLuongPhongBan() {
        return this.thuTuPhongBan;
    }

    public void setCapPhep(List<CapPhep> capPhep) {
        this.dsCapPhep = capPhep;
    }

    public List<CapPhep> getCapPhep() {
        return this.dsCapPhep;
    }

    public String getMaPhong() {
        return this.maPhong;
    }

    public List<MinhChung> getDsMinhChung() {
        return this.dsMinhChung;
    }

    public void setDsMinhChung(List<MinhChung> minhChung) {
        this.dsMinhChung = minhChung;
    }

    //END
    //Hàm hiển thị
    public void hienThiMinhChung() {
        for (MinhChung mc : this.dsMinhChung) {
            mc.hienThi();
        }

    }

    public void hienThi() {
        System.out.printf("Thu tu phong ban: %d | Ma phong ban: %s | Ten phong ban: %s | Dia diem: %s\n", this.thuTuPhongBan, this.maPhong, this.tenPhong, this.diaDiemPhongBan);
    }


    @Override
    public int getSize() {
        return this.dsMinhChung.size();
    }
}
