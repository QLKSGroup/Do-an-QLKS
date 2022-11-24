/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.qlks;

/**
 *
 * @author Dell
 */

import java.util.Scanner;

public class dichvu {

    private String TenDV;
    private String MaDV;
    private long GiaDV;
    /*private static long total = 0;*/
    static Scanner sc = new Scanner(System.in);

    public dichvu() {
    }

    /**
     *
     * @param TenDV
     * @param MaDV
     * @param GiaDV
     */
    public dichvu(String TenDV, String MaDV, long GiaDV) {
        this.TenDV = TenDV;
        this.MaDV = MaDV;
        this.GiaDV = GiaDV;
        /*total += this.giaDV;*/
    }

    dichvu(String MaDV, String TenDV, long GiaDV, int sl) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    /**
     *
     * @return
     */
    public String getTenDV() {
        return TenDV;
    }

    /**
     *
     * @return
     */
    public String getMaDV() {
        return MaDV;
    }

    /**
     *
     * @return
     */
    public long getGiaDV() {
        return GiaDV;
    }

    public void setTenDV(String TenDV) {
        this.TenDV = TenDV;
    }

    /**
     *
     * @param MaDV
     */
    public void setMaDV(String MaDV) {
        this.MaDV = MaDV;
    }

    public void setGiaDV(long GiaDV) {
        this.GiaDV = GiaDV;
    }

   /* public static float getTotal() {
        return total;
    }*/

   /* /**
     *
     * @param total
     */
    /*public static void setTotal(long total) {
        dichvu.total = total;
    }*/

    public void nhap() {
        System.out.println("Moi nhap maDV:");
        //Cách 1 nhập thông qua nhập trực tiếp cho thuộc tính
        MaDV = sc.nextLine();
        // Cách 2: nhập thông qua hàm setname
        //setName(sc.nextLine());
        System.out.println("Moi nhap tenDV:");
        TenDV = sc.nextLine();
        System.out.println("Moi nhap giaDV:");
        // Cách 1 nhập thông qua thuộc tính
        GiaDV = Long.parseLong(sc.nextLine());
        // Cahs 2 nhập sử dụng hàm SetFee
        //setFee(Float.parseFloat(sc.nextLine()));
       /* total += giaDV;*/

    }

    

    @Override
    /*public String toString() {
        return String.format("|%-10s|%-20s|%-30L|", maDV, tenDV, giaDV);
    }*/
    
    public String toString() {
        return  MaDV + " " + TenDV + " " + GiaDV;
    }
    public void xuat() {
        //System.out.println(toString());
        System.out.println(MaDV + " " + TenDV + " " + GiaDV); 
    }

    /*public static void main(String[] args) {
        dichvu dv1 = new dichvu();
        dv1.nhap();
        dichvu dv2 = new dichvu();
        dv2.nhap();
        dichvu dv3 = new dichvu();
        dv3.nhap();
        System.out.printf("|%-10s|%-20s|%-30s|", "maDV", "tenDV", "giaDV");
        dv1.xuat();
        dv2.xuat();
        dv3.xuat();
        
    }

   /* int getSoluong() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    void setMaDV(int i) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }*/

   

    

 
}