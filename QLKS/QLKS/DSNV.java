package QLKS;

import java.io.*;
import java.util.Scanner;
import java.util.Arrays;


public class DSNV implements Docghifile{
    int tongNhanVien;
    public String addArray;
    public String deleteString;
    NhanVien[] nhanVien;
    int tongLuong = 0;
    static Scanner sc = new Scanner(System.in);
    


    public void nhapDS(){
        do{
            System.out.print(" So luong nhan vien trong khach san la: ");
            tongNhanVien = Integer.parseInt(sc.nextLine());
        }
        while(tongNhanVien < 0);
       
        nhanVien = new NhanVien[tongNhanVien];
        System.out.println("\n--------Nhap thong tin cho nhan vien----------");
        for(int i = 0; i< tongNhanVien; i++)
        {
           
            System.out.println("\nNhap thong tin nhan vien thu " + (i+1) + ":");
            System.out.println("Chon loai nhan vien");
            System.out.println("1. Nhan vien toan thoi gian.");
            System.out.println("2. Nhan vien ban thoi gian.");
            int choose = sc.nextInt();

            if(choose == 1)
            {
                nhanVien[i]= new NhanVienFT();

            }
            else if(choose == 2)
            {
                nhanVien[i] = new NhanVienPT();

            }
            else
            {
                System.out.println("Loi! Vui long chon dung loai nhan vien.");
            }
            System.out.println("\n------------Bat dau nhap nhan vien thu "+ (i+1)+ "--------------");
            nhanVien[i].nhap();
            nhanVien[i].tinhLuong();
           
        }
    }

    public void addArray() {
        System.out.println("So nhan vien ban muon them la: ");
        int n = sc.nextInt();
       
        for(int j = 0; j< n;j++)
        {
            nhanVien=Arrays.copyOf(nhanVien, nhanVien.length+1);
            int i=nhanVien.length-1;

        
            System.out.println("--------------Ban dang trong muc them nhan vien---------------");
            System.out.println("-----------------Nhap thong tin nhan vien ---------------------");
            System.out.println("Chon loai nhan vien");
            System.out.println("1. Nhan vien toan thoi gian.");
            System.out.println("2. Nhan vien ban thoi gian.");
            int choose = sc.nextInt();
    
            
            if(choose == 1)
            {
                nhanVien[i] = new NhanVienFT();
                
            }
            else if(choose == 2)
            {
                nhanVien[i] = new NhanVienPT();
            }
            else
            {
                System.out.println("Nhap sai lua chon!");
            }
            System.out.print("\n------------Bat dau nhap nhan vien thu "+ (i+1)+ "--------------");
            nhanVien[i].nhap();
            nhanVien[i].tinhLuong();
           
        }
    }
    
    public void editArray() {
        System.out.println("---------------Ban dang trong muc sua thong tin nhan vien--------------");
        System.out.println("So luong nhan vien ban muon sua la: ");
        int n = sc.nextInt();

        for(int i=0; i< n;i++)
        {
            System.out.print("\nNhap ma so nhan vien can sua: ");
            int id = sc.nextInt();
            if(check(id)==false) {
                System.out.println("Khong tim thay ma nhan vien!");
            } 
            else 
            {
                for (int j=0; j< nhanVien.length; j++) 
                {
                    if(nhanVien[j].getMaNV()==id) 
                    {
                        nhanVien[j].nhap();
                    } 
        
                }
                System.out.println("Da sua thanh cong!");
            }
        }
    }
   
    public boolean check(int id) {
        for (NhanVien nv : nhanVien) {
            if(nv.getMaNV() == id) 
            return true;
        }
        return false;
    }
    public void deleteArray() { // xoa du lieu theo ID = ma so nv
        System.out.println("\n--------------Ban dang trong muc xoa nhan vien-----------");
        System.out.print("\nNhap ma nhan vien ban muon xoa: ");
        int id = sc.nextInt();
        if(check(id) == false ) {
            System.out.println("Khong tim thay ma nhan vien nay!");
        }
        else
        {
            for (int i=0; i< nhanVien.length; i++) {
                if(nhanVien[i].getMaNV()==id) {
                    for(int j=i; j < nhanVien.length-1; j++)
                    {
                        nhanVien[j]=nhanVien[j+1];
                    }
                }
                    nhanVien=Arrays.copyOf(nhanVien, nhanVien.length-1);
            } 
            System.out.println("Da xoa thanh cong!");
        }
    }
  
    public void searchArray(){
        System.out.println("---------------Ban dang trong muc sua thong tin nhan vien--------------");
        System.out.println("So luong nhan vien ban muon sua la: ");
        int n = sc.nextInt();

        for(int i=0; i< n;i++)
        {
            System.out.print("\nNhap ma so nhan vien can tim: ");
            int id = sc.nextInt();
            if(check(id)==false) {
                System.out.println("Khong tim thay ma nhan vien!");
            } 
            else 
            {
                for (int j=0; j< nhanVien.length; j++) 
                {
                    if(nhanVien[j].getMaNV()==id) 
                    {
                        nhanVien[j].xuat();
                    } 
        
                }
                System.out.println("Da tim kiem thanh cong!");
            }
        }
    }
     

    public void xuatDS(){
        System.out.println(" ====================Thong tin cua cac nhan vien trong cong ty===================");
        if(nhanVien.length != 0)
        {
            System.out.println("_______________________________________________________________________________________________________________________________________________________________________");
            System.out.println(String.format("|%15s|%15s|%15s|%10s|%25s|%10s|%10s|%15s|%15s|","Ho va ten","CMND","Gioi Tinh","Nam Sinh","Email","So Dien Thoai","Ma nhan vien","Loai nhan vien","Luong"));
            for(int i=0;i <nhanVien.length;i++ )
                 nhanVien[i].xuat();
        }
        
    }

    // public int readfilelayn(){
    //     n=0;
    //     try{
    //         FileReader fr=new FileReader("C:\\Users\\User\\OneDrive - 101203\\Desktop\\SGU Study\\HKIII_SGU_2022-2023\\Lập trình hướng đối tượng\\DSnhanVien.txt");
    //         BufferedReader br=new BufferedReader(fr);
    //         while(br.readLine()!=null){
    //             n++;
    //         }
    //         br.close();
    //         fr.close();
    //     }catch(IOException ex){
            
    //     }
    //     return n;
    // }
    @Override
    public String readfile() {
        nhanVien =new NhanVien[tongNhanVien];
        try {
            FileReader fr = new FileReader("C:\\Users\\Duyen\\OneDrive\\Desktop\\QLKS\\QLKS\\DSNhanVien.txt");
            BufferedReader  br= new BufferedReader(fr);
            String line;
            for(int i = 0; i< tongNhanVien ; i++){
                if((line=br.readLine())!=null){
                    if(!(line.equals(""))){
                        String []s= line.split("###");
                        //System.out.println(s[0]+"   "+s[1]+"   "+s[2]+"   "+s[3]+"   "+s[4]+"   "+s[5]+"   "+s[6]);
                        nhanVien[i].setMaNV(Integer.parseInt(s[0]));
                        nhanVien[i].setHoTen(s[1]);
                        nhanVien[i].setCMND(s[2]);
                        nhanVien[i].setGioiTinh(s[3]);
                        nhanVien[i].setNamSinh(s[4]);
                        nhanVien[i].setEmail(s[5]);
                        nhanVien[i].setSDT(s[6]);
                        //System.out.print(nhanVien[i].getHoten()+" "+nhanVien[i].getCMND()+" "+nhanVien[i].getmaKH()+" "+nhanVien[i].getGioiTinh()+" "+nhanVien[i].getNamSinh()+" "+nhanVien[i].getEmail()+" "+nhanVien[i].getSDT());
                    }
                    
                }
            }
            br.close();
            fr.close();  
        }catch (IOException ex) {

        }
        return null;
    }


    @Override
    public void savefile(String fcontent) {
         String fContent = "";
         try {
             FileWriter fw = new FileWriter("C:\\Users\\Duyen\\OneDrive\\Desktop\\QLKS\\QLKS\\QLKS\\DSNhanVien.txt");
             BufferedWriter bw = new BufferedWriter(fw);
             for(int i = 0 ; i < tongNhanVien ; i++){
                 if(nhanVien[i]!=null){
                        fContent=nhanVien[i].getMaNV()+"###"+nhanVien[i].getHoten()+"###"+nhanVien[i].getCMND()+"###"+nhanVien[i].getGioiTinh()+"###"+nhanVien[i].getNamSinh()+"###"+nhanVien[i].getEmail()+"###"+nhanVien[i].getSDT()+"###"+nhanVien[i].loaiNhanVien()+"###"+nhanVien[i].luong;
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

   

}