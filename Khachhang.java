

import java.util.Scanner;

public class Khachhang extends Person{
    private String ngheNghiep;

    public Khachhang(){
    }

    public Khachhang(String ngheNghiep){
        this.ngheNghiep = ngheNghiep;
    }

    public Khachhang(String hoTen, String CMND, int namSinh, String gioiTinh, String email, String SDT, String ngheNghiep){
        this.hoTen = hoTen;
        this.CMND = CMND;
        this.namSinh = namSinh;
        this.gioiTinh = gioiTinh;
        this.email = email;
        this.SDT = SDT;
        this.ngheNghiep = ngheNghiep;
    }

    public String getNgheNghiep() {
        return ngheNghiep;
    }

    public void setNgheNghiep(String ngheNghiep) {
        this.ngheNghiep = ngheNghiep;
    }

    public void nhap(){
        super.nhap();
        System.out.println("Nghe nghiep: ");
        ngheNghiep = sc.nextLine();
    }

    @Override
    public String toString() {
        return "Khachhang [ngheNghiep=" + ngheNghiep + "]";
    }

    
}
