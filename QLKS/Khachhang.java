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

    public void setNamSinh(String a)
    {
        namSinh=Integer.parseInt(a);
    }
    
    @Override
    public void nhap(){
        super.nhap();
        System.out.println("Nhap ma khach hang: ");
        maKH = sc.nextLine();
    }

    @Override
    public String toString() {
        return(String.format("%-10s|", maKH));
    }

    @Override
    public void xuat(){
        System.out.println(super.toString() + toString());
    }
    public static void main(String[] args) {
        Khachhang kh = new Khachhang();
        kh.nhap();
        kh.xuat();
    }


    

    
}
