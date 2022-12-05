package QLKS;
import java.util.Scanner;
public class ChiPhiPhatSinh{
    private Gia sotien=new Gia();
    private String noidung;
    private Boolean trangthai;
    static Scanner sc= new Scanner(System.in);
    public ChiPhiPhatSinh(){
        
    }
    public ChiPhiPhatSinh(String sotien, String noidung, Boolean trangthai){
        this.sotien.setGia(sotien);
        this.noidung=noidung;
        this.trangthai=trangthai;
    }
    public Gia getsotien(){
        return sotien;
    }
    public String getnoidung(){
        return noidung;
    }
    public Boolean gettrangthai(){
        return trangthai;
    }
    public void setsotien(String sotien){
        this.sotien.setGia(sotien);
    }
    public void setnoidung(String noidung){
        this.noidung=noidung;
    }
    public void settrangthai(String trangthai){
        if(trangthai.equalsIgnoreCase("co")==true){
            this.trangthai=true;
        }else if(trangthai.equalsIgnoreCase("khong")==true){
            this.trangthai=false;
        }
    }
    public void nhapsotien(){
        this.sotien.setGia();
    }
    public void nhapnoidung(){
        System.out.print("Noi dung: ");
        this.noidung=sc.nextLine();
    }
    public void nhaptrangthai(){
        System.out.print("Trang thai: ");
        String tt=sc.nextLine();
        if(tt.equalsIgnoreCase("co")==true){
            this.trangthai=true;
        }else if(tt.equalsIgnoreCase("khong")==true){
            this.trangthai=false;
        }else{
            System.out.print("Khong hop le ! Moi nhap lai !");
            nhaptrangthai();
        }
    }
    public void nhapTT(){
        nhapsotien();
        nhapnoidung();
        nhaptrangthai();
    }
    public void xuatTT(){
        System.out.println("Gia tien: "+sotien);
        System.out.println("Noi dung: "+noidung);
        System.out.println("Trang thai: "+trangthai);
    }
    @Override
    public String toString(){
        if(this.trangthai==true){
            return String.format("| %-20s | %-10d | %-10s |", noidung, sotien.getGia(), "Co");
        }else{
            return String.format("| %-20s | %-10d | %-10s |", noidung, sotien.getGia(), "Khong");
        }
    }
}
