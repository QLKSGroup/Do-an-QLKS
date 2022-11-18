package QLKS;

// Nhan vien full time la nhan vien lam toan thoi gian

public class NhanVienFT extends NhanVien {
    private int ngayLamThem; // ngay lam them cua nhan vien
    private String chucVu; // chuc vu la Nhan Vien hoac Quan Ly

    
    public NhanVienFT(String hoTen, String CMND, String gioiTinh, int namSinh, String email, String SDT, String maNV,
            long luong, int ngayLamThem, String chucVu) {
        super(hoTen, CMND, gioiTinh, namSinh, email, SDT, maNV, luong);
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
        do {
            System.out.println("Moi nhap chuc vu: ");
            chucVu = sc.nextLine();
        } while (chucVu != "Nhan vien " || chucVu != "Quan ly");
        this.chucVu = chucVu;
    }


    @Override
    protected String loaiNhanVien() {
            return chucVu + " toan thoi gian" +(ngayLamThem > 0 ?"(Co lam them ngay)":"");
    }

    @Override
    public void tinhLuong() {
        if (chucVu == "Nhan vien")
            // 1 thang = 5.100.000d ; 1 ngay lam them = 200.000d
             luong = 5100000 + ngayLamThem * 200000;    
        else
            // 1 thang = 7.200.000 ; 1 ngay lam them = 280.000d
            luong = 7200000 + ngayLamThem *  280000;
        
    }

    
}
