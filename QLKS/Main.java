/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package QLKS;

/**
 *
 * @author Dell
 */


public class Main 
{

   
    public static void main(String[] args){
        System.out.println("Quan ly dich vu");
        DSDichVu dvu = new DSDichVu();
        dvu.NhapDsdv();
        dvu.savefile("");
        dvu.readfile();
        dvu.XuatDsdv();
        dvu.ThemDsdv();
        dvu.XuatDsdv();
        dvu.XoaDsdv();
        dvu.XuatDsdv();
       
        
    }
    
    
    
    
    
    
    /*
    
    static void menu1() {
        System.out.println("===Chon muc can quan ly===");
        System.out.println("1. Quan ly dich vu.");
        System.out.println("6. Thoat quan ly.");
    }
    static void menuquanlydichvu() {
        System.out.println("==Quan ly dich vu==");
        System.out.println("1. Them");
        System.out.println("2. Xoa");
        System.out.println("3. Sua");
        //System.out.println("4. Tim kiem");
        System.out.println("5. Danh sach");
        System.out.println("6. Thoat.");
    }
    
    public static void main(String[] args) {
        DSDichVu dss = new DSDichVu();
        int n,n1,n2,n3,n4,n5;
        String ht, key;
        dsdv.readfile();     // danh sách sách
         menu1();
            n=Integer.parseInt(sc.nextLine());
            switch(n) {
                case 1:  // quản lý sách
                    do {
                        menuquanlydichvu();
                        System.out.println("Nhap muc can chon:");
                        n1=Integer.parseInt(sc.nextLine());
                        switch(n1) {
                            case 1:     // thêm 
                                if(dss.isempty()) {
                                    dss.input();
                                } else {
                                    dss.add();
                                }
                                break;
                            case 2:     // xóa 
                                dss.delete();
                                break;
                            case 3:     // sửa
                                dss.edit();
                                break;
                            case 4:     // tìm kiếm
                                System.out.println("Nhap tu khoa: ");
                                key=sc.nextLine();
                                dss.timkiem(key);
                                break;
                            case 5:     // xuất danh sách
                                System.out.println("==Danh sach sach==");
                                dss.output();
                                break;
                            case 6:     // thoát
                                dss.savefile();
                                break;
                            default: System.out.println("Nhap sai. Moi nhap lai!"); break;         
                        }
                    } while(n1!=6);   
                    break;
    }
    }
    public String Doctxt(){
        return "";
    }
    public void Luutxt(String txtSave) {
        
    }
    
    
    
    
    */
    
}
