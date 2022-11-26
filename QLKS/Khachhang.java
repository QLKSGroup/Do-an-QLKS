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

    @Override
    public void nhap(){
        super.nhap();
        System.out.println("Nhap ma khach hang: ");
        maKH = sc.nextLine();
    }

    @Override
    public String toString() {
        return(String.format("%10s|", maKH));
    }

    @Override
    public void xuat(){
        System.out.println("___________________________________________________________________________________________________________________________________________");
        System.out.println(String.format("|%15s|%20s|%15s|%10s|%35s|%10s|%10s|","Ho va ten","CMND","Gioi Tinh","Nam Sinh","Email","So Dien Thoai","Ma KH"));
        System.out.println("___________________________________________________________________________________________________________________________________________");
        System.out.println(super.toString()+toString());
        System.out.println("___________________________________________________________________________________________________________________________________________");
    }
    public static void main(String[] args) {
        Khachhang kh = new Khachhang();
        kh.nhap();
        kh.xuat();
    }

    

    
}
