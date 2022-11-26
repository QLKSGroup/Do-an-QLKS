package QLKS;

public abstract class NhanVien extends Person {
    
    private String maNV; // ma so cua nhan vien
    protected long luong; // tien luong hang thang cua nhan vien
   
    public NhanVien() {
        super();

    }

    public NhanVien(String hoTen, String CMND, String gioiTinh, int namSinh, String email, String SDT, String maNV, int luong) {
        super(hoTen, CMND, gioiTinh, namSinh, email, SDT);
        this.maNV = maNV;
       this.luong = luong;
    }
    
    public String getMaNV() {
        return maNV;
    }

    public void setMaNV(String maNV) {
        do{
            System.out.println("Nhap ma nhan vien: ");
            maNV = sc.nextLine();
        }
        while(maNV.length() == 0);
        this.maNV = maNV;
    }
    public long getLuong() {
        return luong;
    }

    public void setLuong(long luong) {
        this.luong = luong;
    }
  
    protected abstract String loaiNhanVien();
    
    public abstract void tinhLuong();

    @Override
    public String toString() {
        super.toString();
        return  maNV + "#" + loaiNhanVien() + "#" + luong ;
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
