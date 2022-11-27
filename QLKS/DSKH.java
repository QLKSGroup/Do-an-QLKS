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
public class DSKH implements Docghifile{

    static Khachhang khachHang[];//khoi tao mang khachHang 
    private static int n;
    public String editKH;//sua thong tin khach hang
    public String deleteKH;//xoa thong tin khach hang
    public String searchKH;//tim kiem thong tin khach hang
    static Scanner sc = new Scanner(System.in);
    

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
    public  void addDS(int n){
        
        System.out.println("Nhap so luong khach hang ban muon them : ");
        int sl = sc.nextInt();
        Khachhang newArray[] = new Khachhang[n + sl];
        for(int i = n-1; i<sl; i++)
        {
            newArray[i] = khachHang[i];
            newArray[i].nhap();
        }    
    }
    /*public void searchkhachHang(){
        
        System.out.println("Nhap ma khach hang can tim: ");
        searchKH=sc.nextLine();
        boolean found=false;
        for (int i=0;i<=n;i++){
            if (searchKH.equalsIgnoreCase(khachHang[i].getmaKH())){
                System.out.printf("\n\n============================================================ NHAN VIEN DA DUOC TIM THAY ============================================================\n");
                khachHang[i].xuat();
                found=true;
                System.out.printf("====================================================================================================================================================\n");
                break;
            }
        }
        if (found==false) System.out.println("Khong tim thay khach hang !");
    }

    public void deletekhachHang(){

        System.out.println("Nhap Ten Khach Han Ban Can Xoa: ");
        deleteKH=sc.nextLine();
        boolean found=false;
        for (int i=0;i<=n;i++){
           if (deleteKH.equalsIgnoreCase(khachHang[i].getHoten())){
                found=true;
                break;
           }
        }
        for (int i=0;i<=n;i++) {
            khachHang[i]=khachHang[i+1];
            n--;
        if (found==true){
            System.out.println("Da Xoa Theo Yeu Cau");
            khachHang[i].xuat();
        } 
        else System.out.println("Khong Tim Thay Ten Khach Hang Can Xoa");
        }
    }*/

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
                khachHang[i].setGioitinh(s[4]);
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
