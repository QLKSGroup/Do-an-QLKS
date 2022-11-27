package QLKS;
import java.util.Scanner;

public class QLNV  {
    public static void main(String[] args) {
       Scanner sc=new Scanner(System.in);
       DSNV nv = new DSNV();
       int b=1;
       nv.readfile(); 
       nv.savefile("");   
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
    }
   
}

