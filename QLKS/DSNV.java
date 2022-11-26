package QLKS;

import java.util.Scanner;


public class DSNV implements Docghifile{
    private  static int tongNhanVien ;
    NhanVien[] nhanVien = new NhanVien[tongNhanVien];
    int tongLuong = 0;
    static Scanner sc = new Scanner(System.in);
    


    public void nhapDS(int tongNhanVien){
        
        nhanVien = new NhanVien[tongNhanVien];
        System.out.println("--------Nhap thong tin cho nhan vien----------");
        for(int i = 0; i< tongNhanVien; i++)
        {
            System.out.println("Nhap thong tin nhan vien thu" + (i+1) + ":");
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
            nhanVien[i].nhap();
            nhanVien[i].tinhLuong();
           
        }
    }

    public  NhanVien[] addArray(int tongNhanVien){
        System.out.println("Nhap so luong nhan vien ban muon them ");
        int n = sc.nextInt();
        NhanVien newArray[] = new NhanVien[tongNhanVien + n];
        
        for(int i = 0; i< tongNhanVien; i++)
        {
            newArray[i] = nhanVien[i];
        }

        for(int i = tongNhanVien -1 ; i<n;i++)
        {
            System.out.println("--------------Ban dang trong muc them nhan vien---------------");
            System.out.println("-----------------Nhap thong tin nhan vien ---------------------");
            System.out.println("Chon loai nhan vien");
            System.out.println("1. Nhan vien toan thoi gian.");
            System.out.println("2. Nhan vien ban thoi gian.");
            int choose = sc.nextInt();

            
            if(choose == 1)
            {
                newArray[i] = new NhanVienFT();
            }
            else if(choose == 2)
            {
                newArray[i] = new NhanVienPT();
            }
            else
            {
                System.out.println("Nhap sai lua chon!");
            }
            newArray[i].nhap();
                
        }
        return newArray;
            
            
    }

    public void deleteArr(){
        System.out.println("Nhap so luong nhan vien ban can xoa:");
        int n = sc.nextInt();
        
        System.out.println("Nhap ma nhan vien ban can xoa : ");
        String deleteNV =sc.nextLine();
        boolean found=false;
        for (int i=0;i<n;i++){
            if (deleteNV.equalsIgnoreCase(nhanVien[i].getMaNV())){
                found=true;
                break;
            }
        }
        for (int i=0;i<n;i++) {
            nhanVien[i]=nhanVien[i+1];
            n--;
            if (found==true){
                System.out.println("Da xoa thanh cong!");
                nhanVien[i].xuat();
            } 
            else 
            {
                System.out.println("Khong tim thay ma so nhan vien ban da nhap!");
            }
        }
    }
     

    public void xuatDS(int tongNhanVien){
        System.out.println(" -----------------------Thong tin cua cac nhan vien trong cong ty------------------------");
        if(tongNhanVien != 0)
        {
            for(int i = 0; i <= tongNhanVien; i++)
            {
    
                 nhanVien[i].xuat();
            }
        }
        else
        {
            System.out.println("Danh sach nhan vien trong!");
        }
        
    }

    @Override
    public String readfile() {
        return null;
    }

    @Override
    public void savefile(String fcontent) {
        
    }

    public static void main(String[] args){
        DSNV nv = new DSNV();
        System.out.println(" So luong nhan vien ban muon nhap la: ");
        int tongNhanVien = Integer.parseInt(sc.nextLine());
       nv.nhapDS(tongNhanVien);
       // nv.xuatDS(tongNhanVien);
       // nv.addArray(tongNhanVien);
       nv.deleteArr();
        nv.xuatDS(tongNhanVien);
    }

}