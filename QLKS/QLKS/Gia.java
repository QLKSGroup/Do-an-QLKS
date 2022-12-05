/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package QLKS;
import java.util.Scanner;
/**
 *
 * @author ADMIN
 */
public class Gia {
    private long gia;
    private Scanner sc= new Scanner(System.in);
    public Gia(){
        
    }
    public Gia(int gia)
    {
        this.gia=gia;
    }
    public void setGia()
    {
        do{
        System.out.print("Nhap gia :");
        gia=sc.nextInt();
        if ((gia<=1000)||(gia%500!=0))
        {
            System.out.println("Gia khong hop le hoac khong thuan tien de giao dich !\nMoi nhap lai");
        }
        }
    while ((gia<=1000)||(gia%500!=0));
    }
    public void setGia(String a)
    {
        gia=Integer.parseInt(a);
    }
    @Override
    public String toString()
    {
        return String.format("|%-10d",gia);
    }

    public long getGia() {
        return gia;
    }
    public void xuatGia()
    {
        System.out.print(toString()); 
    }
    }

    
    

