package QLKS;

public class Khachhang extends Person{
    private String maKH;

    public Khachhang(){
    }

    public Khachhang(String maKH){
        this.maKH = maKH;
    }



    public Khachhang(String hoTen, String CMND, String gioiTinh, int namSinh, String email, String SDT, String maKH) {
        super(hoTen, CMND, gioiTinh, namSinh, email, SDT);
        this.maKH = maKH;
    }

    public String getmaKH() {
        return maKH;
    }

    public void setmaKH(String maKH) {
        this.maKH = maKH;
    }

    public void nhap(){
        super.nhap();
        System.out.println("Nhap ma khach hang: ");
        maKH = sc.nextLine();
    }

    @Override
    public String toString() {
        return "Khachhang [Mã số =" + maKH + "]";
    }

    
}
