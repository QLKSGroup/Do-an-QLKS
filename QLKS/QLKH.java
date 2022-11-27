package QLKS;
import java.util.Scanner;
public class QLKH  {
    public static void main(String[] args) {
       Scanner sc=new Scanner(System.in);
       DSKH kh = new DSKH();
       int b=1;
       kh.readfile();
       kh.savefile("");       
       do{
       System.out.printf("<>Quan Ly Khach Hang<>\n1.Nhap Danh Sach\n2.Xuat danh sach tat ca phong\n3.Them Khach Hang\n4.Tim Kiem Phong\n5.Sua Phong\n6.Xoa Phong\n7.Thoat\n");
       int a;
       do{
           a=sc.nextInt();
           if ((a<1)||(a>7)) System.out.println("Nhap lai lua chon hop le ");
           }
       while ((a<1)||(a>72));
       switch (a)
       {
           case 1:kh.nhapDS();break;
           case 2:kh.xuatDS(); break;
           case 3:kh.addDS();;break;
           case 4:kh.searchDS();break;
           case 5:kh.editDS();break;
           case 6:kh.deleteDS();break;
           case 7:b=0;break;
       }
       }
       while (b==1);
       
   
}
    
}

