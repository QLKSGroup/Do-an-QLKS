/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package QLKS;
//import java.io.Console;
//import java.lang.System;
//import java.Util.*;
import java.util.Scanner;
import java.io.FileWriter;
import java.io.*;
/**
 *
 * @author Dell
 */
public class DSDichVu implements Docghifile{
   
   private int n,m,l;
   private dichvu [][] Dsdv;
   Scanner sc = new Scanner(System.in);
   
   public DSDichVu(){
       this.Dsdv = new dichvu[3][100];
   }
   public DSDichVu (int n, int m, int l){
       this.n=n;
       this.m=m;
       this.l=l;
   }
   public void Setn(int n){
        this.n=n;
    }
    public int Getn(){
        return this.n;
    }
    public void Setm(int m){
        this.m=m;
    }
    public int getm(){
        return this.m;
    }
    public void setl(int l){
        this.l=l;
    }
    public int getl(int l){
        return this.l;
    }
   public void setDsdv(dichvu [][] Dsdv){
       this.Dsdv = Dsdv;
   }
   
   public void NhapDsdv(){
       //BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Nhap so luong thuc an:");
        String sRead = sc.nextLine();// System.console().readLine();
        this.n = Integer.parseInt(sRead);
//        // nhap DL Tung Phan Tu cua Mang 
        for(int i=0;i<this.n;i++){ 
            dichvu dv = new dichvu();
            dv.nhap();
            this.Dsdv[0][i]=dv;
        }
//        
        System.out.println("Nhap so luong thuc uong:"); 
        String sRead2 = sc.nextLine();//System.console().readLine();
        this.m=Integer.parseInt(sRead2);
        System.out.println("Ban Da Nhap: "+this.m);
        for(int i=0;i<this.m;i++){
            dichvu dv = new dichvu();
            dv.nhap();
            this.Dsdv[1][i]=dv;
        }
        System.out.println("Nhap so luong dich vu phong:");
        String sRead3 = sc.nextLine();//System.console().readLine();
        this.l=Integer.parseInt(sRead3);
        for(int i=0;i<this.l;i++){
            dichvu dv = new dichvu();
            dv.nhap();
            this.Dsdv[2][i]=dv;
        }
        //savefile();
    }
    public void XuatDsdv(){
        //readfile();
        //
        System.out.println("Danh Sach Cac Dich Vu");
        System.out.println(" --- Danh Sach Thuc An ---");
        for(int i=0;i<this.n;i++){
            if(this.Dsdv[0][i]!=null){
                Dsdv[0][i].xuat();
            }
        }
        //\
        System.out.println("---Danh Sach Thuc Uong---");
        for(int i=0;i<this.m;i++){
            if(this.Dsdv[1][i]!=null){
                Dsdv[1][i].xuat();
            }
        }
        System.out.println("---Danh Sach Dich Vu Phong---");
        for(int i=0;i<this.l;i++){
            if(this.Dsdv[2][i]!=null){
                Dsdv[2][i].xuat();
            }
        }        
    }
    public void ThemDsdv(){
        System.out.println("Them dich vu nao 0 la do an, 1 la do uong, 2 la dich vu khac:");
        String sRead = sc.nextLine();
        int k=Integer.parseInt(sRead);
        if(k==0){
            this.n=this.n+1;
            dichvu dv = new dichvu();
            dv.nhap();
            Dsdv[0][this.n-1]=dv;
                 
        }
        if(k==1){
            this.m=this.m+1;
            dichvu dv= new dichvu();
            dv.nhap();
            Dsdv[1][this.m-1]=dv;
        }
        if(k==2){
            this.l=this.l+1;
            dichvu dv=new dichvu();
            dv.nhap();
            Dsdv[2][this.l-1]=dv;
        }       
    }
    public void XoaDsdv(){
        System.out.println("Ma dich vu can xoa:");
        String sRead = sc.nextLine();
        String f=sRead;
        for(int i=0;i<this.n;i++){
            if(this.Dsdv[0][i].getMaDV().equals(f)){
                this.Dsdv[0][i]=null;
                this.n=this.n-1;
            }            
        }
        for(int i=0;i<this.m;i++){
            if(this.Dsdv[1][i].getMaDV().equals(f)){
                this.Dsdv[1][i]=null;
                this.m=this.m-1;
            }
        }
        for(int i=0;i<this.l;i++){
            if(this.Dsdv[2][i].getMaDV().equals(f)){
                this.Dsdv[2][i]=null;
                this.l=this.l-1;
            }
        }
    }
    public void savefile(String fcontent){ 
        String fContent = "";
        try {
            FileWriter writer = new FileWriter("DichVus.txt", true);
            for(int i=0;i<this.n;i++){
                if(this.Dsdv[0][i]!=null){
                    fContent=this.Dsdv[0][i].getMaDV() + "###" + this.Dsdv[0][i].getTenDV() + "###" + this.Dsdv[0][i].getGiaDV();
                    writer.write(fContent);
                    writer.write("\r\n");
                }
            }
            for(int i=0;i<this.m;i++){
                if(this.Dsdv[1][i]!=null){
                    fContent=this.Dsdv[1][i].getMaDV() + "###" + this.Dsdv[1][i].getTenDV() + "###" + this.Dsdv[1][i].getGiaDV();
                    writer.write(fContent);
                    writer.write("\r\n");
                }
            }
            for(int i=0;i<this.l;i++){
                if(this.Dsdv[0][i]!=null){
                    fContent=this.Dsdv[2][i].getMaDV() + "###" + this.Dsdv[2][i].getTenDV() + "###" + this.Dsdv[2][i].getGiaDV();
                    writer.write(fContent);
                    writer.write("\r\n");
                }
            }
            writer.close();
        } catch (Exception   e) {
            System.out.println("Loi");
        }
    }
    public String readfile(){
        String res_ = "";
        this.Dsdv = new dichvu[3][100];
        this.n=0;this.m=0;this.l=0;
        try {
            FileReader reader = new FileReader("DichVus.txt");
            BufferedReader bufferedReader = new BufferedReader(reader);
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                if(!line.equals("")){
                    String []pVal = line.split("###");
//                    System.out.println("so luong "+pVal[0]+"    "+pVal[1]+"    "+pVal[2]+"    ---");
                    if(pVal.length>0){
                        dichvu dv_ = new dichvu();
                        dv_.setMaDV(pVal[0]);
                        dv_.setTenDV(pVal[1]);
                        dv_.setGiaDV(Integer.parseInt(pVal[2]));
//                        
//                        
                        if(pVal[0].indexOf("TA")!=-1){// Add Vao Thuc An
                            this.n++;
                            this.Dsdv[0][this.n-1]=dv_;
                        }
                        if(pVal[0].indexOf("TU")!=-1){// Add Vao Do Uong
                            this.m++;
                            this.Dsdv[1][this.m-1]=dv_;
                        }
                        if(pVal[0].indexOf("P")!=-1){// Add Vao DV Khac
                            this.l++;
                            this.Dsdv[2][this.l-1]=dv_;
                        }
                    }
                }
            }
            reader.close();
 
        } catch (Exception  e) {
            System.out.println("Loi");
        }
        return res_;
    }
}

