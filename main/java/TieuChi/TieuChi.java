package TieuChi;

import MinhChung.MinhChung;
import ThongTin.ThongTin;
import TieuChuan.TieuChuan;
import getSize.getSize;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TieuChi extends ThongTin implements getSize {
    private static int dem;
    private int thuTuTieuChi = ++dem;
    private TieuChuan tieuChuan;
    private List<MinhChung> dsMinhChung = new ArrayList<>();

    {
        super.ma = String.format("TieuChi%02d", thuTuTieuChi);

    }

    //Getter & Setter
    public TieuChi(String ten, String noiDung) {
        super(ten, null, noiDung);
    }

    public TieuChi(String ten, String noiDung, TieuChuan tc) {
        super(ten, null, noiDung);
        this.tieuChuan = tc;
    }

    public static int getDem() {
        return dem;
    }
    


    public int getThuTuTieuChi() {
        return thuTuTieuChi;
    }


    public TieuChuan getTieuChuan() {
        return tieuChuan;
    }

    public void setTieuChuan(TieuChuan tieuChuan) {
        this.tieuChuan = tieuChuan;
    }

    public List<MinhChung> getDsMinhChung() {
        return dsMinhChung;
    }

    public void setDsMinhChung(List<MinhChung> dsMinhChung) {
        this.dsMinhChung = dsMinhChung;
    }

    //END
    //Hàm thêm minh chứng
    public void themMinhChung(MinhChung... mc) {
        this.dsMinhChung.addAll(Arrays.asList(mc));
    }

    //Ham xóa minh chứng
    public void xoaMinhChung(MinhChung mc) {
        this.dsMinhChung.remove(mc);
    }

    public boolean xoaMinhChung(String a) {
        return this.dsMinhChung.removeIf(x -> x.getMaMinhChung().equals(a) || x.getTenMinhChung().equals(a));
    }
    public int getSize() {
        return this.dsMinhChung.size();
    }

    //Hàm hiên thị
    @Override
    public void hienThi() {
        System.out.printf("Tiêu chí thứ %d\n", this.thuTuTieuChi);
        super.hienThi();

    }

}
