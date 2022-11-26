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
public class DSKH implements Docghifile{

    static Person ds[];//khoi tao mang ds cua lop Person
    private int n;
    public int soLuong;
    static Scanner sc = new Scanner(System.in);
    
    public void nhapDS(){
        System.out.println("Moi nhap so luong khach hang: ");
        n= Integer.parseInt(sc.nextLine());
        ds=new Khachhang[n];
        for(int i=0;i<ds.length;i++){
            System.out.println("Moi nhap khach hang thu "+(i+1)+" :");
            ds[i]=new Khachhang();
            ds[i].nhap();
        }
        
    }

    public void xuatDS(){
        for(int i=0;i<ds.length;i++){
            ds[i].xuat();
        }
    }

    @Override
    public String readfile() {
        return null;
        
    }

    @Override
    public void savefile(String fcontent) {
        
    }
    
    
    
    
}
