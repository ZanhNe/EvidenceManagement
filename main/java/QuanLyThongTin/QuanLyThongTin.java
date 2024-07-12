package QuanLyThongTin;

import ThongTin.ThongTin;
import TieuChi.TieuChi;
import TieuChuan.TieuChuan;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class QuanLyThongTin {
    private List<ThongTin> dsThongTin = new ArrayList<>();

    public void themThongTin(ThongTin... tt) {
        this.dsThongTin.addAll(Arrays.asList(tt));
    }

    public void xoaThongTin(ThongTin thongTin) {
        this.dsThongTin.remove(thongTin);
    }

    public boolean xoaThongTin(String a) {
         return this.dsThongTin.removeIf(x -> x.getMa().equals(a) || x.getTen().equals(a) || x.getNoiDung().equals(a));
    }

    public void thongTin(TieuChi tieuChi) {
        String format = " %-15s  %-30s  %-50s \n";
        System.out.printf("====================================================================================================\n");
        System.out.printf(format, "MA TIEU CHI", "TEN TIEU CHI", "NOI DUNG");
        System.out.printf("====================================================================================================\n");
        for (ThongTin tt : dsThongTin) {
            if (tt instanceof TieuChi) {
                System.out.printf(format, tt.getMa(), tt.getTen(), tt.getNoiDung());
            }
        }
        System.out.format("======================DEV=BY=ZANH=AND=DAN============================================================\n");

    }

    public void thongTin(TieuChuan tieuChuan) {
        String format = " %-20s  %-30s  %-80s  %-50s \n";
        System.out.printf("====================================================================================================\n");
        System.out.printf(format, "MA TIEU CHUAN", "TEN TIEU CHUAN", "NOI DUNG","BAO CAO");
        System.out.printf("====================================================================================================\n");
        for (ThongTin tt : dsThongTin) {
            if (tt instanceof TieuChuan) {
                System.out.printf(format, tt.getMa(), tt.getTen(), tt.getNoiDung(),((TieuChuan) tt).hasReport()?(String) ((TieuChuan) tt).getProperty("report")+"\n":"CHUA CO BAO CAO\n");
            }
        }
        System.out.format("======================DEV=BY=ZANH=AND=DAN============================================================\n");

    }

    public TieuChuan timThongTin(String a,TieuChuan tieuChuan) {
        for (ThongTin tt : this.dsThongTin) {
            if (tt instanceof TieuChuan) {
                if (tt.getNoiDung().equals(a) || tt.getTen().equals(a) || tt.getMa().equals(a))
                    return (TieuChuan) tt;
            }
        }
        return null;
    }

    public TieuChi timThongTin(String a,TieuChi tieuChi) {
        return this.dsThongTin.stream().
                filter(x -> x instanceof TieuChi).
                map(x -> (TieuChi) x).
                filter(x -> x.getMa().
                        equals(a) || x.getTen().equals(a) || x.getNoiDung().equals(a)).findFirst().orElse(null);
    }

    public List<ThongTin> getDsThongTin() {
        return this.dsThongTin;
    }

    public void setDsThongTin(List<ThongTin> thongTinList) {
        this.dsThongTin = thongTinList;
    }


}
