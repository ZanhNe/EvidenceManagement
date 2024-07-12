package ThongTin;

public class ThongTin {
    protected String ten, ma, noiDung;

    public ThongTin(String ten, String ma, String noiDung) {
        this.ten = ten;
        this.ma = ma;
        this.noiDung = noiDung;
    }

    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    public void setMa(String ma) {
        this.ma = ma;
    }

    public String getNoiDung() {
        return noiDung;
    }

    public void setNoiDung(String noiDung) {
        this.noiDung = noiDung;
    }

    public String getMa() {
        return this.ma;
    }

    public void hienThi() {
        System.out.printf("tên: %s - mã: %s - noiDung: %s\n", this.ten, this.ma, this.noiDung);
    }

}
