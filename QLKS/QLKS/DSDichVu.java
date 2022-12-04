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
   static Scanner cn=new Scanner(System.in);
   
   public DSDichVu(){
       this.Dsdv = new dichvu[3][100];
   }
   public DSDichVu (int n, int m, int l){
       this.n=n;
       this.m=m;
       this.l=l;
   }
   public int timDV(String maDV)
   {
       readfile();
       if(maDV.indexOf("TA")!=-1){
           for (int i=0;i<n;i++){
                if ((Dsdv[0][i].getMaDV()).compareTo(maDV)==0){
                    return 1;
                }
            }
       }else if(maDV.indexOf("TU")!=-1){
           for (int i=0;i<m;i++){
                if ((Dsdv[1][i].getMaDV()).compareTo(maDV)==0){
                    return 1;
                }
            }
       }else if(maDV.indexOf("P")!=-1){
           for (int i=0;i<l;i++){
                if ((Dsdv[2][i].getMaDV()).compareTo(maDV)==0){
                    return 1;
                }
            }
       }else{
           return 0;
       }
       return 0;
   }
   public long timDVlaygia(String maDV)
   {
       readfile();
       if(maDV.indexOf("TA")!=-1){
           for (int i=0;i<n;i++){
                if ((Dsdv[0][i].getMaDV()).compareTo(maDV)==0){
                    return Dsdv[0][i].getGiaDV();
                }
            }
       }else if(maDV.indexOf("TU")!=-1){
           for (int i=0;i<m;i++){
                if ((Dsdv[1][i].getMaDV()).compareTo(maDV)==0){
                    return Dsdv[1][i].getGiaDV();
                }
            }
       }else if(maDV.indexOf("P")!=-1){
           for (int i=0;i<l;i++){
                if ((Dsdv[2][i].getMaDV()).compareTo(maDV)==0){
                    return Dsdv[2][i].getGiaDV();
                }
            }
       }else{
           return 0;
       }
       return 0;
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
   public void luachon(){
       System.out.println("------> SUA DANH SACH DICH VU <-----");
       System.out.println("1 -- Them dich vu");
       System.out.println("2 -- Xoa dich vu");
   }
   public void themdv(){
       System.out.println("------> THEM DICH VU <-----");
       System.out.println("1 -- Thuc an");
       System.out.println("2 -- Thuc uong");
       System.out.println("3 -- Phong");
   }
   public void NhapDsdv(){
       //BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Nhap so luong thuc an:");
        String sRead = cn.nextLine();// System.console().readLine();
        this.n = Integer.parseInt(sRead);
//        // nhap DL Tung Phan Tu cua Mang 
        System.out.println("***** LUU Y: Ma Thuc An viet theo kieu: TA + ma so *****");
        for(int i=0;i<this.n;i++){ 
            dichvu dv = new dichvu();
            dv.nhap();
            this.Dsdv[0][i]=dv;
        }
//        
        System.out.println("Nhap so luong thuc uong:"); 
        String sRead2 = cn.nextLine();//System.console().readLine();
        this.m=Integer.parseInt(sRead2);
        //System.out.println("Ban Da Nhap: "+this.m);
        System.out.println("***** LUU Y: Ma Thuc Uong viet theo kieu: TU + ma so *****");
        for(int i=0;i<this.m;i++){
            dichvu dv = new dichvu();
            dv.nhap();
            this.Dsdv[1][i]=dv;
        }
        System.out.println("Nhap so luong dich vu phong:");
        String sRead3 = cn.nextLine();//System.console().readLine();
        this.l=Integer.parseInt(sRead3);
        System.out.println("***** LUU Y: Ma Dich Vu Phong viet theo kieu: P + ma so *****");
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
        System.out.println("----- DANH SACH CAC DICH VU -----");
        System.out.println(" -----> THUC AN <-----");
        System.out.printf("| %-10s | %-40s | %-10s |\n","Ma Dich Vu","Ten Dich Vu","So tien");
        for(int i=0;i<this.n;i++){
            if(this.Dsdv[0][i]!=null){
                Dsdv[0][i].xuat();
            }
        }
        //\
        System.out.println("-----> THUC UONG <-----");
        System.out.printf("| %-10s | %-40s | %-10s |\n","Ma Dich Vu","Ten Dich Vu","So tien");
        for(int i=0;i<this.m;i++){
            if(this.Dsdv[1][i]!=null){
                Dsdv[1][i].xuat();
            }
        }
        System.out.println("-----> PHONG <-----");
        System.out.printf("| %-10s | %-40s | %-10s |\n","Ma Dich Vu","Ten Dich Vu","So tien");
        for(int i=0;i<this.l;i++){
            if(this.Dsdv[2][i]!=null){
                Dsdv[2][i].xuat();
            }
        }        
    }
    public void SuaDS(){
        int chon;
        luachon();
        System.out.println("Moi chon lua chon: ");
        chon=cn.nextInt();
        switch(chon){
            case 1: ThemDsdv(); break;
            case 2: XoaDsdv(); break;
            default: System.out.println("Lua chon khong hop le, moi chon lai"); chon=cn.nextInt(); break;
        }
    }
    public void ThemDsdv(){
        themdv();
        System.out.println("Moi nhap lua chon: ");
        int k=cn.nextInt();
        if(k==1){
            System.out.println("***** LUU Y: Ma Thuc An viet theo kieu: TA + ma so *****");
            this.n=this.n+1;
            dichvu dv = new dichvu();
            dv.nhap();
            Dsdv[0][this.n-1]=dv;
                 
        }
        if(k==2){
            System.out.println("***** LUU Y: Ma Thuc Uong viet theo kieu: TU + ma so *****");
            this.m=this.m+1;
            dichvu dv= new dichvu();
            dv.nhap();
            Dsdv[1][this.m-1]=dv;
        }
        if(k==3){
            System.out.println("***** LUU Y: Ma Dich Vu Phong viet theo kieu: P + ma so *****");
            this.l=this.l+1;
            dichvu dv=new dichvu();
            dv.nhap();
            Dsdv[2][this.l-1]=dv;
        }       
    }
    public void XoaDsdv(){
        System.out.println("Ma dich vu can xoa:");
        XuatDsdv();
        String sRead = cn.nextLine();
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
    @Override
    public void savefile(String fcontent){ 
        String fContent = "";
        try {
            FileWriter writer = new FileWriter("C:\\Users\\User\\OneDrive - 101203\\Desktop\\SGU Study\\HKIII_SGU_2022-2023\\Lập trình hướng đối tượng\\DSDichVu.txt");
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
        } catch (IOException   ex) {
            System.out.println("Loi");
        }
    }
    @Override
    public String readfile(){
        String res_ = "";
        this.Dsdv = new dichvu[3][100];
        this.n=0;this.m=0;this.l=0;
        try {
            FileReader reader = new FileReader("C:\\Users\\User\\OneDrive - 101203\\Desktop\\SGU Study\\HKIII_SGU_2022-2023\\Lập trình hướng đối tượng\\DSDichVu.txt");
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
            bufferedReader.close();
            reader.close();
        } catch (IOException  ex) {
            System.out.println("Loi");
        }
        return res_;
    }
}

