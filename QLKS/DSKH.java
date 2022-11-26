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
public class DSKH extends Khachhang implements Docghifile{

    static Person ds[];//khoi tao mang ds cua lop Person
    private int n;
    public String editKH;//sua thong tin khach hang
    public String deleteKH;//xoa thong tin khach hang
    public String searchKH;//tim kiem thong tin khach hang
    static Scanner sc = new Scanner(System.in);
    

    public void nhapDS(){
        System.out.println("Moi nhap so luong khach hang: ");
        n= Integer.parseInt(sc.nextLine());
        ds=new Khachhang[n];
        for(int i=0;i<n;i++){
            if(n>1){System.out.println("Moi nhap khach hang thu "+(i+1)+" :");}
            ds[i]=new Khachhang();
            ds[i].nhap();
        }
        
    }

    public void xuatDS(){
        System.out.println("=============================================DANH SACH KHACH HANG============================================");
        for(int i=0;i<n;i++){
            if(ds[i]!=null)
                ds[i].xuat();
        }
    }

    /*public void editDS(){
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
        for (int i=0;i<ds.length;i++){
            
            if (editKH.equals(ds[i].getHoten())){
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

    public void searchDS(){
        System.out.println("Nhap ten khach hang can tim: ");
        searchKH=sc.nextLine();
        boolean found=false;
        for (int i=0;i<n;i++){
            if (searchKH.equalsIgnoreCase(ds[i].getHoten())){
                System.out.printf("\n\n============================================================ NHAN VIEN DA DUOC TIM THAY ============================================================\n");
                ds[i].xuat();
                found=true;
                System.out.printf("====================================================================================================================================================\n");
                break;
            }
        }
        if (found==false) System.out.println("Khong tim thay khach hang !");
    }

    public void deleteDS(){
        System.out.println("Nhap Ten Khach Han Ban Can Xoa: ");
        deleteKH=sc.nextLine();
        boolean found=false;
        for (int i=0;i<n;i++){
           if (deleteKH.equalsIgnoreCase(ds[i].getHoten())){
                found=true;
                break;
           }
        }
        for (int i=0;i<n;i++) {
            ds[i]=ds[i+1];
            n--;
        if (found==true){
            System.out.println("Da Xoa Theo Yeu Cau");
            ds[i].xuat();
        } 
        else System.out.println("Khong Tim Thay Ten Khach Hang Can Xoa");
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
