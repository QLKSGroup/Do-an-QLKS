package QLKS;

public abstract class NhanVien extends Person {
    private String maNV; // ma so cua nhan vien
    protected long luong; // tien luong hang thang cua nhan vien
    
    public NhanVien(){
    }

    public NhanVien(String maNV,long luong) {
        this.maNV = maNV;
        this.luong = luong;
    }
    

    public NhanVien(String hoTen, String CMND, String gioiTinh, int namSinh, String email, String SDT, String maNV) {
        super(hoTen, CMND, gioiTinh, namSinh, email, SDT);
        this.maNV = maNV;
       
    }
    
   

    public String getMaNV() {
        return maNV;
    }

    public void setMaNV(String maNV) {
        this.maNV = maNV;
    }

    protected abstract String loaiNhanVien();

    public abstract void tinhLuong();

    @Override
    public String toString() {
        return "NhanVien [maNV=" + maNV + ", luong=" + luong + "]";
    }

    public void nhap(){
        System.out.println("Nhap ma nhan vien: ");
        maNV = sc.nextLine();
        super.nhap();
    }

   
    
    public void xuat(){
        super.xuat();
        System.out.println(toString());
    }



}
