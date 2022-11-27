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
import java.util.Arrays;


import java.io.FileWriter;
import java.io.IOException;
import java.io.*;
public class DSKH implements Docghifile{
    private static int n;
    static Khachhang khachHang[]=new Khachhang[n];//khoi tao mang khachHang 
    static Scanner sc = new Scanner(System.in);
    

    public void nhapDS(){
        System.out.println("Moi nhap so luong khach hang: ");
        n= Integer.parseInt(sc.nextLine());
        khachHang = new Khachhang[n];
        for(int i=0;i<n;i++){
            if(n>1){System.out.println("Moi nhap khach hang thu "+(i+1)+" :");}
            khachHang[i]=new Khachhang();
            khachHang[i].nhap();
        }
        
    }

    public void xuatDS(){
        System.out.println("====================================================DANH SACH KHACH HANG==================================================================================");
        System.out.println(String.format("|%-15s|%-20s|%-15s|%-10s|%-35s|%-10s|%-10s|","Ho va ten","CMND","Gioi Tinh","Nam Sinh","Email","So Dien Thoai","Ma KH"));
        for(int i=0;i<n;i++){
            if(khachHang[i]!=null)
                khachHang[i].xuat();
        }
    }
    
    public  void addDS(){
            System.out.println("Nhap so luong khach hang ban muon them : ");
            int sl = sc.nextInt();
            Khachhang newArray[] = new Khachhang[n + sl];
            for(int i = n-1; i<sl; i++)
            {
                newArray[i] = khachHang[i];
                newArray[i].nhap();
                newArray[i].xuat();
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
                        case 2:khachHang[i].setHoTen(sc.nextLine());break;
                        case 3:khachHang[i].setCMND(sc.nextLine());break;
                        case 4:khachHang[i].setGioiTinh(sc.nextLine());break;
                        case 5:khachHang[i].setNamSinh(sc.nextInt());break;
                        case 6:khachHang[i].setEmail(sc.nextLine());break;
                        case 7:khachHang[i].setSDT(sc.nextLine());break;
                        case 8:b=0;break;
                    }
                    }
                    while(b==1);
                }
        }
        if (count==0) System.out.println("Ma Phong vua nhap khong ton tai trong danh sach");
    }

    public boolean check(String maKH) {
        for (Khachhang kh : khachHang) {
            if(kh.getmaKH().equalsIgnoreCase(maKH)) 
                return true;
        }
        return false;
    }
    public void searchDS(){
        System.out.println("Nhap ma khach hang can tim: ");
        String maKH=sc.nextLine();
        boolean found=false;
        khachHang = new Khachhang[n];
        for (int i=n-1;i<=khachHang.length;i++){
            if (maKH.equalsIgnoreCase(khachHang[i].getmaKH())){
                System.out.printf("\n\n============================================================ KHACH HANG DA DUOC TIM THAY ============================================================\n");
                khachHang[i].xuat();
                found=true;
                System.out.printf("====================================================================================================================================================\n");
                break;
            }
        }
        if (found==false) System.out.println("Khong tim thay khach hang !");
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

    
    


    @Override
    public String readfile()
    {
        try{
            FileReader fr=new FileReader("DSKhachhang.txt");
            BufferedReader br = new BufferedReader(fr);
            n=Integer.parseInt(br.readLine());
            khachHang=new Khachhang[n];
            for (int i=0;i<n;i++)
            {
                khachHang[i]=new Khachhang();
                String st = br.readLine();
                String []s = st.split("");
                khachHang[i].setmaKH(s[0]);
                khachHang[i].setHoTen(s[1]);
                khachHang[i].setCMND(s[2]);
                khachHang[i].setNamSinh(s[3]);
                khachHang[i].setGioiTinh(s[4]);
                khachHang[i].setEmail(s[5]);
                khachHang[i].setSDT(s[6]);
            }
            br.close();
            fr.close();
        }
        catch (IOException e) {}
        return "SOS";
    }
        
    

    @Override
    public void savefile(String fcontent) {
        String fContent = "";
        try {
            FileWriter writer = new FileWriter("DSKhachhang.txt", true);
            for(int i=0;i<n;i++){
                if(khachHang[i]!=null){
                    fContent=khachHang[i].getmaKH() + "###" + khachHang[i].getHoten() + "###" + khachHang[i].getCMND() + "###" + khachHang[i].getGioiTinh() + "###" + khachHang[i].getNamSinh() + "###" + khachHang[i].getEmail() + "###" + khachHang[i].getSDT();
                    writer.write(fContent);
                    writer.write("\r\n");
                }
            }
            writer.close();
        } catch (Exception   e) {
            System.out.println("Loi");
        }
    }

    
    
    
    
    
}