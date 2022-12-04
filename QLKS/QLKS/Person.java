
package QLKS;

import java.util.Scanner;

public class Person{

    private String hoTen; //Họ tên 
    protected String CMND; //CMND 
    private String gioiTinh; //giới tính
    protected int namSinh; //năm sinh
    private String email; //email
    private String SDT; //SDT
    static Scanner sc = new Scanner(System.in);

    public Person() {
    }

    public Person(String hoTen, String CMND, String gioiTinh, int namSinh, String email, String SDT) {
        this.hoTen = hoTen;
        this.CMND = CMND;
        this.gioiTinh = gioiTinh;
        this.namSinh = namSinh;
        this.email = email;
        this.SDT = SDT;
    }
    
    public String getHoten() 
    {
        return hoTen;
    }

    public void setHoTen() 
    {
        do 
        {
            System.out.print("\n-> Ho va ten: ");
            hoTen = sc.nextLine();
        } while(hoTen.length()==0);
        this.hoTen = hoTen;
    }
    public void setHoTen(String hoten){
        this.hoTen=hoten;
    }
    public String getCMND() {
        return CMND;
    }

    public void setCMND() {
        do{
             System.out.print("\n-> Can cuoc cong dan: ");
            CMND = sc.nextLine();
        } while(CMND.length() != 12);
        this.CMND = CMND;
    }
    public void setCMND(String cmnd){
        this.CMND=cmnd;
    }
    public String getGioiTinh() {
        return gioiTinh;
    }
    
    public void setGioiTinh() 
    {
        do 
        {
            System.out.print("\n-> Gioi tinh: ");
            gioiTinh = sc.nextLine();
        } while(!gioiTinh.equalsIgnoreCase("Nam")&&!gioiTinh.equalsIgnoreCase("Nu"));
        this.gioiTinh = gioiTinh;
    }
    public void setGioiTinh(String gt){
        this.gioiTinh=gt;
    }
    public int getNamSinh() {
        return namSinh;
    }

    public void setNamSinh() {
        do{
            System.out.print("\n-> Nam sinh: ");
            this.namSinh=Integer.parseInt(sc.nextLine());
        }
        while((2022 - namSinh) <18);
    }
    public void setNamSinh(String namsinh){
        this.namSinh=Integer.parseInt(namsinh);
    }
    public void setEmail()
    {
        String email;
        do
        {
            System.out.print("\n-> Email: ");
            email=sc.nextLine();
            if (email.contains("@gmail.com")==false)
            {
                System.out.println("Email phai co duoi @gmail.com!\nNhap lai Email:");
            }
        }
        while (email.contains("@gmail.com")==false);
    }
    public String getEmail() {
        return email;
    }
    

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSDT() {
        return SDT;
    }

    public void setSDT() {
        do {
            System.out.print("\n-> So dien thoai: ");
            SDT = sc.nextLine();
           } while (SDT.length() != 10);
        this.SDT = SDT;
    }
    public void setSDT(String sdt){
        this.SDT=sdt;
    }

    public void nhap(){
        setHoTen();
        setCMND();
        setGioiTinh();
        setNamSinh();
        setEmail();
        setSDT();
    }


    @Override
    public String toString() {
         return(String.format("|%-15s|%-20s|%-15S|%-10d|%-35s|%-10s|", hoTen, CMND, gioiTinh, namSinh, email, SDT));
    }

   public void xuat(){
        System.out.println("________________________________________________________________________________________________________________________");
        System.out.println(String.format("|%-15s|%-20s|%-15s|%-10s|%-35s|%-10s|","Ho va ten","CMND","Gioi Tinh","Nam Sinh","Email","So Dien Thoai"));
        System.out.println("________________________________________________________________________________________________________________________");
        System.out.println(toString());
        System.out.println("________________________________________________________________________________________________________________________");
    }


    
}



