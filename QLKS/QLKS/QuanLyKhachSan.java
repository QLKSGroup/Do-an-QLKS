/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package QLKS;
import java.text.ParseException;
import java.util.Scanner;

/**
 *
 * @author ADMIN
 */
public class QuanLyKhachSan  { 
    public static void xuat(){
        System.out.println("----SUA DOI DANH SACH----");
        //System.out.println("1 -- Lam moi danh sach");
        System.out.println("2 -- Xuat danh sach");
        System.out.println("3 -- Sua danh sach");
    }
    public static void luachon(){
        System.out.println("Moi nhap lua chon: ");
        System.out.println("1 - Co");
        System.out.println("2 - Khong");
    }
    public static void luachonhd(){
        System.out.println("----> DANH SACH HOA DON <----");
        System.out.println("1 -- Lam moi danh sach --");
        System.out.println("2 -- Xuat danh sach --");
        System.out.println("3 -- Sua danh sach --");
    }
     //static Scanner sc= new Scanner(System.in);
     public static void main(String[] args) throws ParseException {
        Scanner sc=new Scanner(System.in);
         Scanner in=new Scanner(System.in);
         DSKH kh = new DSKH();
         DSDichVu dvu = new DSDichVu();
       SoDoPhong y=new SoDoPhong();
       DSNV nv = new DSNV();
        //kh.readfile();
        y.readfile();
       int c=1;
       int k;
       do{
       System.out.printf("<>Quan Ly Khach San<>\n1.Quan Ly Nhan Vien\n2.Quan Ly Khach Hang\n3.So Do Phong\n4.Danh sach Dich Vu\n5.Dat Phong\n6.Danh sach hoa don\n7.Quan ly thu chi\n8.Thoat\n");
        do{
           k=sc.nextInt();
           if ((k<1)||(k>8)) System.out.println("Nhap lai lua chon hop le ");
           }
       while ((k<1)||(k>8));
        switch (k)
        {
            case 1:
            {
                int b=1;
       do{
       System.out.printf("<>Quan Ly Nhan Vien<>\n1.Nhap danh sach!\n2.Xuat danh sach!\n3.Them nhan vien!\n4.Tim kiem nhan vien\n5.Sua thong tin nhan vien\n6.Xoa thong tin nhan vien\n7.Thoat\n");
       int a;
       do{
           a=sc.nextInt();
           if ((a<1)||(a>7)) System.out.println("Nhap lai lua chon hop le ");
           }
       while ((a<1)||(a>7));
       switch (a)
       {
           case 1:
           {
                nv.nhapDS();
                break;
           }
           case 2:
           {
                nv.xuatDS();
                break;
           }
           case 3:
           {
                nv.addArray();
                break;
           }
           case 4:
           {
                nv.searchArray();
                break;
           }
           case 5:
           {
                nv.editArray(); 
                break;
           }
           case 6:
           {
                nv.deleteArray();
                break;
           }
           case 7:
           {
                b=0;
                break;
           }
       }
       }
       while (b==1);
       sc.close();
    break;
            }
            case 2:{
                
            int b=1;
       do{
       System.out.printf("<>Quan Ly Khach Hang<>\n1.Nhap Danh Sach\n2.Xuat danh sach tat ca Khach Hang\n3.Them Khach Hang\n4.Tim Kiem KH\n5.Sua KH\n6.Xoa KH\n7.Thoat\n");
       int a;
       do{
           a=sc.nextInt();
           if ((a<1)||(a>7)) System.out.println("Nhap lai lua chon hop le ");
           }
       while ((a<1)||(a>7));
       switch (a)
       {
           case 1:kh.nhapDS();break;
           case 2:kh.readfile(); kh.xuatDS(); break;
           case 3:kh.addDS(); break;
           case 4:kh.searchDS();break;
           case 5:kh.editDS();break;
           case 6:kh.deleteDS();break;
           case 7:b=0;break;
       }
       }
       while (b==1);
       break;
            }
            case 4:
            {
        System.out.println("Quan ly dich vu");
        int chon, x;
        do{
            System.out.println("Moi nhap lua chon: ");
            xuat();
            chon=in.nextInt();
            
            do{
                switch(chon){
                    //case 1: a.NhapDS(); break;
                    case 2: dvu.readfile(); dvu.XuatDsdv(); break;
                    case 3: dvu.SuaDS(); dvu.savefile(""); break;
                    default: System.out.println("Lua chon khong hop le ! Moi chon lai: ");
                    chon=in.nextInt();
                }
            }while(chon<1 && chon>3);
            System.out.print("Ban co muon chon them lua chon khong ?");
            luachon();
            x=in.nextInt();
        }while(x==1);
        break;
            }
            case 3:
            {
        int b=1;
        //QLP
        do{
        System.out.printf("<>Quan Ly Phong<>\n1.Nhap Danh Sach\n2.Xuat danh sach tat ca phong\n3.Loc danh sach phong\n4.Them Phong\n5.Sua Phong\n6.Xoa Phong\n7.Save FILE\n8.Thoat\n");
        int a;
        do{
            a=sc.nextInt();
            sc.nextLine();
            if ((a<1)||(a>8)) System.out.println("Nhap lai lua chon hop le ");
            }
        while ((a<1)||(a>8));
        switch (a)
        {
            case 1:y.nhapDSPhong();break;
            case 2:y.xuatDSPhong(); break;
            case 3:y.locDS();break;
            case 4:y.themPhong();break;
            case 5:y.suaPhong();break;
            case 6:y.xoaPhong();break;
            case 7:y.savefile("<3");break;
            case 8:b=0;break;
        }
        }
        while (b==1);
        break;
            }
            case 5:
            {
                HoaDonDP a= new HoaDonDP();
                System.out.println("Thong tin dat phong");
                 a.datPhong();
                 a.themDV();
                 System.out.println("Thong tin tra phong");
                 a.traPhong();
                 System.out.println(a);
                 break;
            }
            case 6:
            {
                DSHoaDonDP a=new DSHoaDonDP();
        int x;
        do{
            luachonhd();
            System.out.print("Moi chon lua chon: ");
            int chon=sc.nextInt();
            do{
                switch(chon){
                case 1:
                    a.nhapDSHD();
                    break;
                case 2:
                    a.xuatDSHD();
                    break;
                case 3:
                    a.SuaDSHD();
                    break;
                default:
                    System.out.print("Lua chon khong dung ! Moi chon lai: "); chon=sc.nextInt(); break;
                }
            }while(chon<1 && chon>3);
            System.out.println("Ban co muon them lua chon khong ?");
            System.out.println("1 -- Co --");
            System.out.println("2 -- Khong --");
            x=sc.nextInt();
        }while(x==1);
            }
            case 7:
            {
                DSChiPhiPhatSinh a=new DSChiPhiPhatSinh();
        int chon, x;
        do{
            System.out.println("Moi nhap lua chon: ");
            xuat();
            chon=in.nextInt();
            
            do{
                switch(chon){
                    case 1: a.NhapDSCP(); break;
                    case 2: a.readfile(); a.XuatDSCP(); break;
                    case 3: a.SuaDSCP(); a.savefile(""); break;
                    default: System.out.println("Lua chon khong hop le ! Moi chon lai: ");
                    chon=in.nextInt();
                }
            }while(chon<1 && chon>3);
            System.out.print("Ban co muon chon them lua chon khong ?");
            luachon();
            x=in.nextInt();
        }while(x==1); break;
    }
    


            
            case 8:c=0;break;
       }
       }
       while (c==1);
       
     
      

     

}
}
