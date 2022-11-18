package QLKS;

// Nhan vien part time la nhan vien lam ban thoi gian

public class NhanVienPT extends NhanVien {
    private int gioLamViec; // tong so gio lam viec cua nhan vien
    

    public NhanVienPT(String hoTen, String CMND, String gioiTinh, int namSinh, String email, String SDT, String maNV,
            long luong, int gioLamViec) {
        super(hoTen, CMND, gioiTinh, namSinh, email, SDT, maNV, luong);
        this.gioLamViec = gioLamViec;
    }
    
    public int getGioLamViec() {
        return gioLamViec;
    }


    public void setGioLamViec(int gioLamViec) {
        this.gioLamViec = gioLamViec;
    }

    @Override
    protected String loaiNhanVien() {
        return "Nhan vien ban thoi gian";
    }

    @Override
    public void tinhLuong() {
        luong = gioLamViec * 21000;   // 1h = 21.000d 
    }



}
