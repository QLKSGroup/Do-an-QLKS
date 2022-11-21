package QLKS;

import java.util.Scanner;

public class Person{

    private String hoTen;
    protected String CMND;
    private String gioiTinh;
    private int namSinh;
    private String email;
    private String SDT;
    private String diaChi;
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
            System.out.println("Nhap ho ten: ");
            hoTen = sc.nextLine();
        } while(hoTen.length()==0);
        this.hoTen = hoTen;
    }
    public String getCMND() {
        return CMND;
    }

    public void setCMND(String cMND) {
        while (CMND.length() != 8){
             System.out.println("Nhap CMND:");
            CMND = sc.nextLine();
        }
        this.CMND = cMND;
    }

    public String getGioiTinh() {
        return gioiTinh;
    }
    
    public void setGioitinh(String gioiTinh) 
    {
        do 
        {
            System.out.println("Nhap gioi tinh: ");
            gioiTinh = sc.nextLine();
        } while(!gioiTinh.equalsIgnoreCase("Nam")&&!gioiTinh.equalsIgnoreCase("Nu"));
        this.gioiTinh = gioiTinh;
    }

    public int getNamSinh() {
        return namSinh;
    }

    public void setNamSinh(int namSinh) {
        for(;;){
            if(2022-namSinh>=18) break;
            System.out.println("Moi nhap lai nam sinh:");
            namSinh=Integer.parseInt(sc.nextLine());
        }
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
        while (SDT.length() != 10) {
            System.out.print("Nhap SDT: ");
            SDT = sc.nextLine();
        }
        this.SDT = SDT;
    }

    public String getDiaChi() {
        return diaChi;
    }

    public void setDiaChi(String diaChi) {
        this.diaChi = diaChi;
    }

    public void nhap(){
        setHoTen(hoTen);
        setGioiTinh(gioiTinh);
        setNamSinh(namSinh);
        System.out.println("Moi nhap email:");
        email = sc.nextLine();
        setSDT(SDT);
        System.out.println("Moi nhap dia chi:");
        diaChi = sc.nextLine();
    }

    @Override
    public String toString() {
        return String.format("|%10s|%20s|%10.2f|%10d|%20s|10%s|%5s|", hoTen, CMND, gioiTinh, namSinh, email, SDT, diaChi);
    }
    
    public void xuat(){
        System.out.println(toString());
    }
}

