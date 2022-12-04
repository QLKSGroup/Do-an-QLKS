package QLKS;

public class Khachhang extends Person{
    public static String maKH;

    public Khachhang(){
    }

    public Khachhang(String maKH){
        this.maKH = maKH;
    }

    public Khachhang(String hoTen, String CMND, String gioiTinh, int namSinh, String email, String SDT, String maKH) {
        super(hoTen, CMND, gioiTinh, namSinh, email, SDT);
        this.maKH = maKH;
    }

    public String getFileLine() 
    {
        return getmaKH()+","+getHoten()+","+getCMND()+","+getGioiTinh()+","+getNamSinh()+","+getEmail()+","+getSDT()+"\n";
    }
    public String getmaKH() {
        return maKH;
    }
    public void setmaKH(String maKH){
        this.maKH=maKH;
    }
    public void nhapmaKH(String maKH) {
        int num=1;
        int ma=Integer.parseInt(maKH)+num;
        this.maKH = String.valueOf(ma);
        num++;
    }

    public void setNamSinh(String a)
    {
        namSinh=Integer.parseInt(a);
    }
    
    @Override
    public void nhap(){
        super.nhap();
        setmaKH("1");
    }

    @Override
    public String toString() {
        return(String.format("%-10s|", maKH));
    }

    @Override
    public void xuat(){
        System.out.println("___________________________________________________________________________________________________________________________________________");
        System.out.println(super.toString()+toString());
        System.out.println("___________________________________________________________________________________________________________________________________________");
    }

    

    
}
