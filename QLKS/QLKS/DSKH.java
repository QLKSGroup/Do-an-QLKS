/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package QLKS;

/**
 *
 * @author downny
 */
import java.util.Scanner;
import java.io.FileWriter;
import java.io.IOException;
import java.io.*;
import java.util.Arrays;
public class DSKH implements Docghifile{

    static Khachhang khachHang[];//khoi tao mang khachHang 
    private static int n;
    public String editKH;//sua thong tin khach hang
    public String deleteKH;//xoa thong tin khach hang
    public String searchKH;//tim kiem thong tin khach hang
    static Scanner sc = new Scanner(System.in);

    public static Khachhang[] getKhachHang() {
        return khachHang;
    }

    public static int getN() {
        return n;
    }
    

    public void nhapDS(){
        System.out.println("Moi nhap so luong khach hang: ");
        n= Integer.parseInt(sc.nextLine());
        khachHang=new Khachhang[n];
        for(int i=0;i<n;i++){
            if(n>1){System.out.println("Moi nhap khach hang thu "+(i+1)+" :");}
            khachHang[i]=new Khachhang();
            khachHang[i].nhap();
        }
        
    }

    public void xuatDS(){
        System.out.println("=============================================DANH SACH KHACH HANG============================================");
        for(int i=0;i<n;i++){
            if(khachHang[i]!=null)
                khachHang[i].xuat();
        }
    }

    /*public void editkhachHang(){
        int e;
        Khachhang k[];
        k = new Khachhang[n];
        System.out.println("Vui long nhap ten khach hang can thay doi thong tin: ");
        editKH = sc.nextLine();
        System.out.println("Ban muon thay doi thong tin nao ?");
        System.out.println("1.Ma Khach Hang");
        System.out.println("2.CMND");
        System.out.println("3.Gioi Tinh");
        System.out.println("4.Nam Sinh");
        System.out.println("5.Email");
        System.out.println("6.So Dien Thoai");
        System.out.print("Lua chon cua ban: ");
        e=Integer.parseInt(sc.nextLine());
        while (e<1 || e>5){
            System.out.print("Hay Chon Lai: ");
            e=Integer.parseInt(sc.nextLine());
        }
        e=Integer.parseInt(sc.nextLine());
        for (int i=0;i<khachHang.length;i++){
            
            if (editKH.equals(khachHang[i].getHoten())){
                if (e==1){   
                    k[i]=new Khachhang();
                    System.out.print("Nhap thay doi: ");
                    k[i].setmaKH(sc.nextLine());
                }
                else if (e==2){
                    System.out.print("Nhap thay doi: ");
                    k[i].setCMND(sc.nextLine());
                }
                else if (e==3){
                    System.out.print("Nhap thay doi: ");
                    k[i].setGioitinh(sc.nextLine());
                }
                else if (e==4){
                    System.out.print("Nhap thay doi: ");
                    k[i].setNamSinh(sc.nextInt());
                }
                else if (e==5){
                    System.out.print("Nhap thay doi: ");
                    k[i].setEmail(sc.nextLine());
                }
                else {
                    System.out.print("Nhap thay doi: ");
                    k[i].setSDT(sc.nextLine());
                }
                
            }   
        }
    }*/
    public void addDS(){
        
        System.out.println("Nhap so luong khach hang ban muon them : ");
        int sl = sc.nextInt();
        Khachhang newArray[] = new Khachhang[n];
        for(int i = 0; i<n; i++)
        {
            newArray[i]=new Khachhang();
            newArray[i] = khachHang[i];
        }    
        n=n+sl;
        khachHang=new Khachhang[n];
        for(int i=0;i<(n-sl); i++){
            khachHang[i]=new Khachhang();
            khachHang[i]=newArray[i];
        }
        for(int i = n-sl; i<n; i++)
        {
            khachHang[i]=new Khachhang();
            khachHang[i].nhap();
        }    
        
    }
    public void addDS(Khachhang khMoi){
        readfile();
        if(khachHang[0]==null){
            n=1;
            khachHang=new Khachhang[1];
            khachHang[0]=new Khachhang();
//            khMoi.setHoTen("");
//            khMoi.setCMND("");
//            khMoi.setGioiTinh("");
//            khMoi.setNamSinh("");
//            khMoi.setSDT("");
//            khMoi.setEmail();
//            String maKH="0";
//            khMoi.setmaKH(maKH);
            khachHang[0]=khMoi;
            savefile("");
        }else{
//            khMoi.setHoTen("");
            int count=0;
            do{
                count=0;
//                khMoi.setCMND("");
                for (int i=0;i<khachHang.length;i++){
                    if (khachHang[i].getCMND().equalsIgnoreCase(khMoi.getCMND())==true){
                        count =1;
                    }
                }
                if (count==1) System.out.println("CMND da ton tai!\nNhap lai CMND:");
            }while (count==1);
//            khMoi.setGioiTinh("");
//            khMoi.setNamSinh("");
//            khMoi.setSDT("");
//            khMoi.setEmail();
//            //String maKH=String.valueOf(1+Integer.parseInt(khachHang[n].getmaKH()));
//            khMoi.setmaKH("1");
            if (count==0){
                Khachhang newArray[] = new Khachhang[n];
                for(int i = 0; i<n; i++){
                    newArray[i]=new Khachhang();
                    newArray[i] = khachHang[i];
                }    
                n=n+1;
                khachHang=new Khachhang[n];
                for(int i = 0; i<n-1; i++){
                    khachHang[i]=new Khachhang();
                    khachHang[i]=newArray[i];
                }
                for(int i = n-1; i<n; i++){
                    khachHang[i]=new Khachhang();
                    khachHang[i]=khMoi;
                }   
                savefile("");
            }
        }
    }
     public void editDS()
    {

        System.out.printf("Nhap Ma Khach Hang can sua :\n");
        String maKH=sc.nextLine();
        int count=0;
        for (int i=0;i<n;i++)
        {
            
                if (khachHang[i].getmaKH().equalsIgnoreCase(maKH)==true)
                {
                    count = 1;
                    int b=1;
                    do
                    {
                    System.out.printf("Chon thong tin can sua\n1.Ma KH\n2.Ho Ten\n3.CMND\n4.Gioi Tinh\n5.Nam Sinh\n6.Email\n7.SDT\n8.Thoat\n");
                    int e=0;
                    do{
                    e=sc.nextInt();
                    if ((e<1)||(e>8)) System.out.println("Nhap lai lua chon ");
                    }
                    while ((e<1)||(e>8));
                    switch (e)
                    {
                        case 1:khachHang[i].setmaKH(sc.nextLine());break;
                        case 2:khachHang[i].setHoTen();break;
                        case 3:khachHang[i].setCMND();break;
                        case 4:khachHang[i].setGioiTinh();break;
                        case 5:khachHang[i].setNamSinh();break;
                        case 6:khachHang[i].setEmail();break;
                        case 7:khachHang[i].setSDT();break;
                        case 8:b=0;break;
                    }
                    }
                    while(b==1);
                }
        }
        if (count==0) System.out.println("Ma khach hang vua nhap khong ton tai trong danh sach");
    }

    public boolean check(String maKH) {
        for (Khachhang kh : khachHang) {
            if(kh.getmaKH().equalsIgnoreCase(maKH)) 
                return true;
        }
        return false;
    }
    public boolean timKH(Khachhang khachhang) {
        readfile();
        if(khachHang[0]==null){
            return false;
        }else{
            for (int i=0; i<n; i++) {
                if(khachHang[i].getCMND().equalsIgnoreCase(khachhang.getCMND())==true){
                    return true;
                } 
            }
        }
        return false;
    }
    public void searchDS(){
        System.out.println("Nhap ma khach hang can tim: ");
        String maKH=sc.nextLine();
        boolean flag=false;
        for (int i=0;i<n;i++){
            if (maKH.equalsIgnoreCase(khachHang[i].getmaKH())){
                System.out.printf("\n\n============================================================ KHACH HANG DA DUOC TIM THAY ============================================================\n");
                khachHang[i].xuat();
                flag=true;
                System.out.printf("====================================================================================================================================================\n");
                break;
            }
        }
        if (flag==false) System.out.println("Khong Tim Thay Khach Hang Co Ten Nhu Tren");
    }
        public void deleteDS() { // xoa du lieu theo ma khach hang
        System.out.println("Nhap Ma Khach Hang ban can xoa: ");
        String maKH=sc.nextLine();
        if(check(maKH)==false) {
            System.out.println("Khong tim thay ma khach hang!");
        } else {
            
            for (int i=0; i< khachHang.length;) {
                if(khachHang[i].getmaKH() == maKH) {
                    for(int j=i; j < khachHang.length-1; j++)
                        khachHang[j]=khachHang[j+1];  
                } 
                khachHang=Arrays.copyOf(khachHang, khachHang.length-1); 
                break;
            }
            System.out.println("Da xoa!");
            }
    }
    public int readfilelayn(){
        n=0;
        try{
            FileReader fr=new FileReader("C:\\Users\\User\\OneDrive - 101203\\Desktop\\SGU Study\\HKIII_SGU_2022-2023\\Lập trình hướng đối tượng\\DSKhachhang.txt");
            BufferedReader br=new BufferedReader(fr);
            while(br.readLine()!=null){
                n++;
            }
            br.close();
            fr.close();
        }catch(IOException ex){
            
        }
        return n;
    }
  
   

    @Override
    public String readfile() {
        n=readfilelayn();
        khachHang=new Khachhang[n];
        try {
            FileReader fr = new FileReader("C:\\Users\\User\\OneDrive - 101203\\Desktop\\SGU Study\\HKIII_SGU_2022-2023\\Lập trình hướng đối tượng\\DSKhachhang.txt");
            BufferedReader  br= new BufferedReader(fr);
            String line;
            for(int i=0; i<n; i++){
                if((line=br.readLine())!=null){
                    if(!(line.equals(""))){
                        khachHang[i]=new Khachhang();
                        String []s= line.split("###");
                        //System.out.println(s[0]+"   "+s[1]+"   "+s[2]+"   "+s[3]+"   "+s[4]+"   "+s[5]+"   "+s[6]);
                        khachHang[i].setmaKH(s[0]);
                        khachHang[i].setHoTen(s[1]);
                        khachHang[i].setCMND(s[2]);
                        khachHang[i].setGioiTinh(s[3]);
                        khachHang[i].setNamSinh(s[4]);
                        khachHang[i].setEmail(s[5]);
                        khachHang[i].setSDT(s[6]);
                        //System.out.print(khachHang[i].getHoten()+" "+khachHang[i].getCMND()+" "+khachHang[i].getmaKH()+" "+khachHang[i].getGioiTinh()+" "+khachHang[i].getNamSinh()+" "+khachHang[i].getEmail()+" "+khachHang[i].getSDT());
                    }
                    
                }
            }
            br.close();
            fr.close();  
        }catch (IOException ex) {

        }
        return "SOS"; 
    }
    

    @Override
   public void savefile(String fcontent) {
        String fContent = "";
        try {
            FileWriter fw = new FileWriter("C:\\Users\\User\\OneDrive - 101203\\Desktop\\SGU Study\\HKIII_SGU_2022-2023\\Lập trình hướng đối tượng\\DSKhachhang.txt");
            BufferedWriter bw = new BufferedWriter(fw);
            for(int i=0; i<n; i++){
                if(khachHang[i]!=null){
                    fContent=khachHang[i].getmaKH()+"###"+khachHang[i].getHoten()+"###"+khachHang[i].getCMND()+"###"+khachHang[i].getGioiTinh()+"###"+khachHang[i].getNamSinh()+"###"+khachHang[i].getEmail()+"###"+khachHang[i].getSDT();
                    bw.write(fContent);
                    bw.newLine();
                }
            }
            bw.close();
            fw.close();
        } catch (IOException ex) {
            System.out.println("Loi doc file!");
        }
    }
    
    /*public static void main(String[] args){
        DSKH kh = new DSKH();
        kh.nhapDS();
        //kh.xuatDS();
        //kh.searchkhachHang();
        kh.addDS(n);
        kh.xuatDS();
        //kh.deletekhachHang();
        //kh.xuatkhachHang();
        kh.savefile("");
        kh.readfile();
        
    }*/
    
    
}
