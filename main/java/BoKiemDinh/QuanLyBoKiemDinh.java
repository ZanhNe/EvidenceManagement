package BoKiemDinh;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class QuanLyBoKiemDinh {
    private List<BoKiemDinh> dsBoKiemDinh = new ArrayList<>();

    public QuanLyBoKiemDinh() {
    }

    public void themBoKiemDinh(BoKiemDinh... bkd) {
        this.dsBoKiemDinh.addAll(Arrays.asList(bkd));
    }

    public void xoaBoKiemDinh(BoKiemDinh bkd) {
        this.dsBoKiemDinh.remove(bkd);
    }

    public boolean xoaBoKiemDinh(String a) {
        return this.dsBoKiemDinh.removeIf(x -> x.getTenBoKiemDinh().equals(a));
    }

    public BoKiemDinh timBoKiemDinh(String a) {
        return this.dsBoKiemDinh.stream()
                .filter(x -> x.getTenBoKiemDinh().equals(a)).findFirst().orElse(null);
    }
    public int getSize(){
        return this.dsBoKiemDinh.size();
    }

    //Hàm getter & setter
    public void setDsBoKiemDinh(List<BoKiemDinh> boKiemDinhList) {
        this.dsBoKiemDinh = boKiemDinhList;
    }


    public List<BoKiemDinh> getDsBoKiemDinh() {
        return this.dsBoKiemDinh;
    }

    public void listBoKiemDinh() {
        this.dsBoKiemDinh.stream().forEach(x -> x.hienThi());
    }
}
