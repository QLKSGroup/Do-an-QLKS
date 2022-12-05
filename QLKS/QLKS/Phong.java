/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package QLKS;
import java.util.Scanner;
/**
 *
 * @author ADMIN
 */
public class Phong {
private String maPhong ;
private String loaiPhong;
private Gia gia=new Gia();;
private boolean tinhTrang;
private int soNguoiO;
private static Scanner sc=new Scanner(System.in);
public Phong()
{
    
}
public Phong(String maPhong,String loaiPhong,Gia gia,boolean tinhTrang,int soNguoiO)
{
    this.maPhong=maPhong;
    this.loaiPhong=loaiPhong;
    this.gia=gia;
    this.tinhTrang=tinhTrang;
    this.soNguoiO=soNguoiO;
}
public void setMaPhong()
{
  System.out.print("Nhap Ma Phong: ");
    maPhong=sc.nextLine();  
}
public void setMaPhong(String a)
{
    maPhong=a;
}
public void setLoaiPhong(String a)
{
    loaiPhong=a;
}
public void setGia(String Gia)
{
    gia.setGia(Gia);
}
public void setTinhTrang(String a)
{
    if (a.equalsIgnoreCase("Trong")==true) tinhTrang=false;
    else tinhTrang=true;
}
public void setSoNguoiO(String a)
{
    soNguoiO=Integer.parseInt(a);
}
public void setLoaiPhong()
{
    int chon;
    do{
        System.out.print("Nhap loai phong :\n1.Phong Thuong\n2.Phong Vip\n");
        chon=sc.nextInt();
        switch (chon)
        {
                case 1: loaiPhong="Thuong"; break;
                case 2: loaiPhong="Vip";break;
                default :break;
        }
    }
    while ((chon!=1)&&(chon!=2));
} 

    public String getMaPhong() {
        return maPhong;
    }

    public String getLoaiPhong() {
        return loaiPhong;
    }

    public Gia getGia() {
        return gia;
    }

    public boolean isTinhTrang() {
        return tinhTrang;
    }

    public int getSoNguoiO() {
        return soNguoiO;
    }
    public long getGiaLong()
    {
        return gia.getGia();
    }

public void nhapTTPhong()
{
    setMaPhong();
    setLoaiPhong();
    setGia();
    tinhTrang=false;
    setSoNguoiO();
}
public void setGia()
{
    gia.setGia();
}
public void setTinhTrang()
{
    int a=0;
    do{
        System.out.printf("Nhap Tinh Trang\n1.Trong\n2.Da co nguoi\n ");
        a=sc.nextInt();
        switch (a)
        {
            case 1:tinhTrang=false;break;
            case 2:tinhTrang=true;break;
        }
        if ((a<1)||(a>2)) System.out.println("Nhap lai lua chon hop le!");
    }
    while ((a<1)||(a>2));
}
public void setTinhTrangTrue()
{
    tinhTrang=true;
}
public void setTinhTrangFalse()
{
    tinhTrang=false;
}

    public void setSoNguoiO() {
        do{
            System.out.println("So nguoi o toi da :");
            soNguoiO=sc.nextInt();
             sc.nextLine();
            if(soNguoiO<=0) System.out.println("So nguoi o phai la so duong");
        }
        while (soNguoiO<=0);
    }
@Override
public String toString()
{
    if (tinhTrang==true)
        return (String.format("|%-10s|%-10s|%-15s",maPhong,loaiPhong,soNguoiO)+gia.toString()+String.format("|Da co nguoi"));
    else
        return (String.format("|%-10s|%-10s|%-15s",maPhong,loaiPhong,soNguoiO)+gia.toString()+String.format("|Trong"));
}
public void xuatTTPhong()
{
    System.out.println(toString());
}
public String toStringToWrite()
{
    if (tinhTrang==true)
        return maPhong+" "+loaiPhong+" "+gia.getGia()+" "+"!Trong"+" "+soNguoiO;
     else
        return maPhong+" "+loaiPhong+" "+gia.getGia()+" "+"Trong"+" "+soNguoiO;
}
}

