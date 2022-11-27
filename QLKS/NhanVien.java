package QLKS;

public abstract class NhanVien extends Person {
    
    private int maNV; // ma so cua nhan vien
    protected long luong; // tien luong hang thang cua nhan vien
   
    public NhanVien() {
        super();

    }

    public NhanVien(String hoTen, String CMND, String gioiTinh, int namSinh, String email, String SDT, int maNV, int luong) {
        super(hoTen, CMND, gioiTinh, namSinh, email, SDT);
        this.maNV = maNV;
       this.luong = luong;
    }
    
    public int getMaNV() {
        return maNV;
    }

    public void setMaNV(int maNV) {
        do{
            System.out.print("\nMa nhan vien: ");
            maNV = Integer.parseInt(sc.nextLine());
        }
        while(maNV < 0 ||  maNV > 1000);
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
       
        return  super.toString() + (String.format("|%10d|%30s|%15d|", maNV, loaiNhanVien(), luong));
    }

    public void nhap(){
        super.nhap();
        setMaNV(maNV);
    }

    
    public void xuat(){
       
        System.out.println("_____________________________________________________________________________________________________________________________________");
        System.out.println(toString());
        System.out.println("_____________________________________________________________________________________________________________________________________");
    }

  

}
