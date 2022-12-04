package QLKS;

// Nhan vien full time la nhan vien lam toan thoi gian

public class NhanVienFT extends NhanVien {
    private int ngayLamThem; // ngay lam them cua nhan vien
    private String chucVu; // chuc vu la Nhan Vien hoac Quan Ly

    
    public NhanVienFT(){
        super();
    }
    
    
    public NhanVienFT(int ngayLamThem, String chucVu) {
        super();
        this.ngayLamThem = ngayLamThem;
        this.chucVu = chucVu;
    }

    
    public int getNgayLamThem() {
        return ngayLamThem;
    }


    public void setNgayLamThem(int ngayLamThem) {
        this.ngayLamThem = ngayLamThem;
    }


    public String getChucVu() {
        return chucVu;
    }


    public void setChucVu(String chucVu) {
        this.chucVu = chucVu;
    }


    @Override
    public void nhap()
    {
        super.nhap();
        System.out.print("\nChuc vu: ");
        chucVu = sc.nextLine();
        System.out.print("\nSo gio lam them: ");
        ngayLamThem = sc.nextInt();
        
    }
    @Override
    protected String loaiNhanVien() {
            return chucVu + " toan thoi gian" +(ngayLamThem > 0 ?"(Co lam them ngay)":"");
    }

    @Override
    public void tinhLuong() {
        if (chucVu == "Quan ly") // 2. chuc vu la quan ly
            // 1 thang = 5.100.000d ; 1 ngay lam them = 200.000d
             luong = 5100000 + ngayLamThem * 200000;    
        else
            // 1 thang = 7.200.000 ; 1 ngay lam them = 280.000d
            luong = 7200000 + ngayLamThem *  280000;
    }
    

    
}
