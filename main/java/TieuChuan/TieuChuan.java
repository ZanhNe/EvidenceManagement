package TieuChuan;
import ThongTin.ThongTin;
import TieuChi.TieuChi;
import getSize.getSize;

import java.util.Map;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;

public class TieuChuan extends ThongTin implements getSize {
    private static int demTieuChuan;
    private int thuTuTieuChuan = ++demTieuChuan;
    private Map<String,Object> propertise = new HashMap<>();
    private List<TieuChi> dsTieuChi = new ArrayList<>();

    {
        super.ma = String.format("TieuChuan%02d",thuTuTieuChuan);
    }

    //thêm bao cao
    public void addProperty(String key, Object value) {
        propertise.put(key,value);
    }
    public Object getProperty(String key){
        return propertise.get(key);
    }
    public boolean hasReport() {
        return propertise.containsKey("report");
    }
    public void baoCao(){
        if (this.hasReport()) System.out.printf((String) this.getProperty("report")+"\n");
        System.out.printf("Chua co bao cao\n");
    }
    
    public TieuChuan(String ten,String noiDung){
        super(ten,null,noiDung);
    }


    //Hàm thêm tiêu chí
    public void themTieuChi(TieuChi ...a) {
        dsTieuChi.addAll(Arrays.asList(a));
    }
    //Hàm xóa tiêu chí
    public void xoaTieuChi(TieuChi tc) {
        this.dsTieuChi.remove(tc);
    }
    public boolean xoaTieuChi(String a) {
       
        return this.dsTieuChi.removeIf(x->x.getMa().equals(a)||x.getTen().equals(a)||x.getNoiDung().equals(a));
    }

    //Hàm liệt kê tiêu chí
    public void lietKeTieuChi() {
        dsTieuChi.forEach(s->s.hienThi());
    }
    @Override
    public void hienThi() {
        System.out.printf("Tieu chuan thu: %d",this.thuTuTieuChuan);
        super.hienThi();
        System.out.printf("Tinh trang bao cao : %s",this.hasReport()?(String) this.getProperty("report")+"\n":"CHUA CO\n");

    }
    @Override
    public int getSize()
    {
        return this.dsTieuChi.size();
    }


    public static int getDemTieuChuan() {
        return demTieuChuan;
    }



    public int getThuTuTieuChuan() {
        return thuTuTieuChuan;
    }



    public List<TieuChi> getDsTieuChi() {
        return dsTieuChi;
    }

    public void setDsTieuChi(List<TieuChi> dsTieuChi) {
        this.dsTieuChi = dsTieuChi;
    }
}
