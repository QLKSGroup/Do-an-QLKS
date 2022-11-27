package QLKS;

// Nhan vien part time la nhan vien lam ban thoi gian

public class NhanVienPT extends NhanVien {
    private int gioLamViec; // tong so gio lam viec cua nhan vien
    

    public NhanVienPT() {
        super();
    }
    public NhanVienPT(int gioLamViec){
        super();
        this.gioLamViec = gioLamViec;
    }
    
    public int getGioLamViec() {
        return gioLamViec;
    }
    public void setGioLamViec(int gioLamViec) {
        this.gioLamViec = gioLamViec;
    }
   
    @Override
    public void nhap(){
        super.nhap();
        System.out.print("\nNhap so gio lam them: ");
        gioLamViec = sc.nextInt();
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
