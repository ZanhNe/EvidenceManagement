package MinhChung;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class QuanLyMinhChung {
    private List<MinhChung> dsMinhChung = new ArrayList<>();

    public QuanLyMinhChung() {
    }

    public void themMinhChung(MinhChung... mc) {
        this.dsMinhChung.addAll(Arrays.asList(mc));
    }

    public void xoaMinhChung(MinhChung mc) {
        this.dsMinhChung.remove(mc);
    }

    public boolean xoaMinhChung(String a) {
        return this.dsMinhChung.removeIf(x -> x.getTenMinhChung().equals(a) || x.getMaMinhChung().equals(a));
    }

    public void setDsMinhChung(List<MinhChung> mc) {
        this.dsMinhChung = mc;
    }

    public List<MinhChung> timMinhChung(String a) {
        List<MinhChung> minhChungs = new ArrayList<>();
        for (MinhChung mc : this.dsMinhChung) {
            if (mc.getTenMinhChung().equals(a) || mc.getMaMinhChung().equals(a) || mc.getNoiBanHanh().equals(a))
                minhChungs.add(mc);
        }
        return minhChungs;
    }

    public MinhChung timMinhChung(String a, MinhChung minhChung) {
        return this.dsMinhChung.stream().filter(x -> x.getTenMinhChung().equals(a) || x.getMaMinhChung().equals(a)).findFirst().orElse(null);
    }
    public void sapXep(String a) {
        if (a.equals("TEN")) {
           this.dsMinhChung = this.dsMinhChung.stream().sorted(Comparator.comparing(MinhChung::getTenMinhChung)).collect(Collectors.toList());
        }
        else if (a.equals("NGAY")) {
          this.dsMinhChung =  this.dsMinhChung.stream().sorted(Comparator.comparingInt(MinhChung::getNgay)).collect(Collectors.toList());
        }
    }

    public void DanhSachMinhChung() {
        String format = "[ %-20s  %-30s  %-20s %-15s]\n";
        System.out.printf("====================================================================================================\n");
        System.out.printf(format, "MA MINH CHUNG", "TEN MINH CHUNG", "NOI BAN HANH", "NGAY BAN HANH");
        System.out.printf("====================================================================================================\n");
        for (MinhChung mc : this.dsMinhChung) {
            System.out.printf(format, mc.getMaMinhChung(), mc.getTenMinhChung(), mc.getNoiBanHanh(), mc.getNgayBanHanh());
        }
        System.out.format("======================DEV=BY=ZANH=AND=DAN============================================================\n");
    }
}
