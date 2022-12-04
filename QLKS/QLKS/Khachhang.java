package QLKS;

public class Khachhang extends Person{
    public String maKH;

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
    public void setmaKH(String maKH){
        do{
            System.out.println("Nhap ma khach hang:");
           maKH = sc.nextLine();
       } while(maKH.length() != 3);
        this.maKH=maKH;
    }
    /*public void nhapmaKH(String maKH) {
        int num=1;
        int ma=Integer.parseInt(maKH)+num;
        this.maKH = String.valueOf(ma);
        num++;
    }*/

    public void setNamSinh(String a)
    {
        namSinh=Integer.parseInt(a);
    }
    
    @Override
    public void nhap(){
        super.nhap();
        setmaKH(maKH);
    }

    @Override
    public String toString() {
        return(String.format("%-13s|", maKH));
    }

    @Override
    public void xuat(){
        System.out.println("___________________________________________________________________________________________________________________________________________");
        System.out.println(super.toString()+toString());
        System.out.println("___________________________________________________________________________________________________________________________________________");
    }

    

    
}
