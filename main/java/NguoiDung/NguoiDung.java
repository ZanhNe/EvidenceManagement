package NguoiDung;

public abstract class NguoiDung {
    protected String tenTaiKhoan, matKhau;

    public NguoiDung() {
    }

    public NguoiDung(String tenTK, String matKhau) {
        this.tenTaiKhoan = tenTK;
        this.matKhau = matKhau;
    }

    public abstract boolean isCapQuyen();

    public abstract void thongTin();

    public abstract void capQuyen();

}
