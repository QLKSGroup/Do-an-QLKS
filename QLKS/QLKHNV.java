package QLKS;

import java.util.Scanner;
/*import java.io.FileWriter;
import java.io.BufferedWriter;
import java.io.IOException;*/
public class QLKHNV implements Docghifile {//Quan ly danh sach khach hang va nhan vien
    static Person ds[];
    private int n;
    static Scanner sc= new Scanner(System.in);

    public void menu(){
        System.out.println("Chon doi tuong: ");
        System.out.println("1: Khach hang");
        System.out.println("2: Nhan vien");
    }

    public void nhapDS(){
        int chon;
        System.out.print("Nhap so luong doi tuong : ");
        n=Integer.parseInt(sc.nextLine());
        ds=new Person[n];
        for(int i=0; i<n;){
            System.out.println("Moi chon doi tuong "+(i+1)+" :");
            menu();
            chon=Integer.parseInt(sc.nextLine());
            switch(chon){
                case 1:ds[i]=new Khachhang(); break;
                case 2:ds[i]=new NhanVien() {

                    @Override
                    protected String loaiNhanVien() {
                     
                        
                    }

                    @Override
                    public void tinhLuong() {
                      
                        
                    }
                    
                    

                    
                }; break;
                default: System.out.println("Lua chon khong hop le"); break;
            }
            if(chon<=3 && chon>=1){
                ds[i].nhap();
                i++;
            }
        }

        
    }

    

    /*public void xuatDS(){
        int chon;
        for(int i=0; i<n;){
            menu();
            chon=Integer.parseInt(sc.nextLine());
            switch(chon){
                case 1:ds[i]=new Khachhang(); break;
                case 2:ds[i]=new NhanVien() {

                    @Override
                    protected String loaiNhanVien() {
                     
                        return null;
                    }

                    @Override
                    public void tinhLuong() {
                      
                        
                    }
                    
                }; break;
                default: System.out.println("Lua chon khong hop le"); break;
            }
            if(chon<=3 && chon>=1){
                ds[i].xuat();
                i++;
            }
        }
    }*/
     @Override
    public String readfile() {
       
        return null;
    }

    @Override
    public void savefile(String fcontent) {
       
        
    }

    public static void main(String[] args){
        QLKHNV ob = new QLKHNV();
        ob.nhapDS();
        //ob.xuatDS();
    }

    
    
    
}