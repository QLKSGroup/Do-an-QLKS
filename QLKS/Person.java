
package QLKS;

import java.util.Scanner;

public class Person{

    private String hoTen;
    protected String CMND;
    private String gioiTinh;
    protected int namSinh;
    private String email;
    private String SDT;
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

    public void setHoTen(String hoTen) 
    {
        do 
        {
            System.out.print("\nHo va ten: ");
            hoTen = sc.nextLine();
        } while(hoTen.length()== 0);
        this.hoTen = hoTen;
    }
    public String getCMND() {
        return CMND;
    }

    public void setCMND(String CMND) {


        do{
            System.out.print("\nSo CMND:");
            CMND = sc.nextLine();
           } while (CMND.length() != 12);
        this.CMND = CMND;
    }

    public String getGioiTinh() {
        return gioiTinh;
    }
    
    public void setGioiTinh(String gioiTinh) 
    {
        do 
        {
            System.out.print("\nGioi tinh: ");
            gioiTinh = sc.nextLine();
        } while(!gioiTinh.equalsIgnoreCase("Nam")&&!gioiTinh.equalsIgnoreCase("Nu"));
        this.gioiTinh = gioiTinh;
    }

    public int getNamSinh() {
        return namSinh;
    }

    public void setNamSinh(int namSinh) {
        do{
            System.out.print("\nNam sinh:");
            namSinh=Integer.parseInt(sc.nextLine());
        }
        while(2022 - namSinh < 18 );
        this.namSinh = namSinh;
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

    public void setSDT(String SDT) {
        do {
            System.out.println("Nhap SDT: ");
            SDT = sc.nextLine();
           } while (SDT.length() != 10);
        this.SDT = SDT;
    }



    public void nhap(){
        setHoTen(hoTen);
        setCMND(CMND);
        setGioiTinh(gioiTinh);
        setNamSinh(namSinh);
        System.out.print("\nMoi nhap email: ");
        email = sc.nextLine();
        System.out.print("\nSo dien thoai: ");
        SDT = sc.nextLine();
    }

  
    
    @Override
    public String toString() {
        return(String.format("|%15s|%15s|%10s|%10d|%25s|%10s|", hoTen, CMND, gioiTinh, namSinh, email, SDT));
    }

    public void xuat(){
        System.out.println("________________________________________________________________________________________________________________________");
        System.out.println(String.format("|%15s|%15s|%10s|%10d|%25s|%10s|","Ho va ten","CMND","Gioi Tinh","Nam Sinh","Email","So Dien Thoai"));
        System.out.println("________________________________________________________________________________________________________________________");
        System.out.println(toString());
        System.out.println("________________________________________________________________________________________________________________________");
    }

    public static void main(String[] args){
        Person ps = new Person();
        ps.nhap();
        ps.xuat();
    }
    
}


