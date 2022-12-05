/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package QLKS;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;
/**
 *
 * @author ADMIN
 */
public class HoaDonDP {
    private String ngayVao;
    private String ngayRa;
    private Khachhang KH;
    private String dsDV[];
    private int n;
    private int sl[];
    private static long soHD=-1;
    private long maHD=0;
    private String maPhong;
    private long totalDV;
    private long totalP;
    private long total;
    static Scanner sc= new Scanner(System.in);
    public HoaDonDP(){
        
    }
    public static void setsoHD()
    {
        soHD=soHD+1;
    }
    public void datPhong()
    {
        System.out.println("------> THONG TIN DAT PHONG <------");
        setsoHD();
        soHD=maHD;
        setNgayVao();
        DSKH dsKH=new DSKH();
        KH=new Khachhang();
        KH.nhap();
        if(dsKH.timKH(KH)==false){
            dsKH.addDS(KH);
        }else{
            KH.xuat();
        }
        setPhong();
    }
    public String getKH(){
        return KH.getHoten();
    }
    public void traPhong() throws ParseException
    {
//        java. SimpleDateFormat kế thừa lớp java.text.DateFormat.
        System.out.println("------> TRA PHONG <------");
        setNgayRa();
        SoDoPhong sdp=new SoDoPhong();
        sdp.readfile();
        sdp.traPhong(maPhong);
        tinhtienPhong();
        settotal();
    }
    public void tinhtienPhong() throws ParseException{
        SoDoPhong sdp=new SoDoPhong();
        sdp.readfile();
        DateFormat df = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        Date date1 = df.parse(getNgayVao());
        Date date2=df.parse(getNgayRa());
        Calendar c1 = Calendar.getInstance();
        Calendar c2 = Calendar.getInstance();
        c1.setTime(date1);
        c2.setTime(date2);
//        long soDay = (c2.getTime().getTime() - c1.getTime().getTime()) / (24 * 3600 * 1000);
//        long soGio=soDay*24;
        long diff = date2.getTime() - date1.getTime();
//        long diffSeconds = diff / 1000;
//        long diffMinutes = diff / (60 * 1000);
        long diffHours = diff / (60 * 60 * 1000);
        totalP=diffHours*sdp.getGiaPhong(maPhong);
    }
    public void setPhong(){
        SoDoPhong sdp=new SoDoPhong();
        sdp.readfile();
        sdp.xuatDSPhong();
        System.out.println("Ma Phong can dat:");
        int i=0;
        do
        {
        maPhong=sc.nextLine();
        i=sdp.timPhong(maPhong);
        if (i==0) System.out.println("Nhap lai ma phong :"); sdp.savefile("");
        }while (i==0);
    }
    public void setttphong(String ma){
        SoDoPhong sdp=new SoDoPhong();
        sdp.traPhong(ma);
    }
    
    public void themDV(){
        String x;
        DSDichVu ds=new DSDichVu();
        ds.readfile();
        do{
            System.out.println("------> DICH VU <------");
            System.out.println("Nhap Ma Dich Vu:");
            String maDv;
            ds.XuatDsdv();
            do{
                maDv=sc.nextLine();
                if(ds.timDV(maDv)==0) System.out.println("Khong tim thay Ma DV!");
            }while (ds.timDV(maDv)==0);
            if(dsDV==null){
                n=1;
                dsDV =new String[1];
                dsDV[0]=new String();
                dsDV[0]=maDv;
            }else{
                n=n+1;
                String dsDV2[]=new String[n];
                for(int i=0; i<n-1; i++){
                    dsDV2[i]=dsDV[i];
                }
                for(int i=n-1; i<n; i++){                        
                    dsDV2[i]=new String();
                    dsDV2[i]=maDv;
                }
                dsDV=new String[n];
                for(int i=0;i<n;i++){
                    dsDV[i]=dsDV2[i];
                }
            }
            System.out.println("Ban co muon them dich vu su dung khong ?");
            System.out.println("1 -- Co --");
            System.out.println("2 -- Khong --");
            x=sc.nextLine();
        }while(Integer.parseInt(x)==1);
        tinhtienDV();
    }
    public void tinhtienDV(){
        DSDichVu ds=new DSDichVu();
        ds.readfile();
        for(int i=0; i<n; i++){
           if(ds.timDV(dsDV[i])==1){
               totalDV=totalDV+ds.timDVlaygia(dsDV[i]);
           }
       }
    }
    public String getNgayVao() {
        return ngayVao;
    }

    public String getNgayRa() {
        return ngayRa;
    }

    public String[] getDsDV() {
        return dsDV;
    }

    public long getMaHD() {
        return maHD;
    }

    public String getMaPhong() {
        return maPhong;
    }

    public long getTotal() {
        return total;
    }

    public HoaDonDP(String ngayVao, String ngayRa, long maHD, String maPhong, long total) {
        this.ngayVao = ngayVao;
        this.ngayRa = ngayRa;
        this.maHD = maHD;
        this.maPhong = maPhong;
        this.total = total;
    }

    public void setNgayVao(String ngayVao) {
        this.ngayVao = ngayVao;
    }

     public void setNgayVao() {
         String ngay,thang,nam,phut,gio,giay;
         ngay=setNgay();
         thang=setThang();
         nam=setNam();
         gio=setGio();
         phut=setPhut();
         giay=setGiay();
         
        this.ngayVao=ngay+"/"+thang+"/"+nam+" "+gio+":"+phut+":"+giay;
    }
     public void setNgayRa()
     {
         String ngay,thang,nam,phut,gio,giay;
         ngay=setNgay();
         thang=setThang();
         nam=setNam();
         gio=setGio();
         phut=setPhut();
         giay=setGiay();
         
        this.ngayRa=ngay+"/"+thang+"/"+nam+" "+gio+":"+phut+":"+giay;
     }
     public String setNgay()
     {
         String ngay;
         int i;
         System.out.println("Ngay: \n ");
         do{
         ngay=sc.nextLine();
         i=Integer.parseInt(ngay);
         if ((i<1)||(i>31)) System.out.println("Nhap lai ngay hop le !"); 
         }
         while ((i<1)||(i>31));
         return ngay;
         
     }
     public String setThang()
     {
         String thang;
         int i;
         System.out.println("Thang: \n ");
         do{
         thang=sc.nextLine();
         i=Integer.parseInt(thang);
         if ((i<1)&&(i>12)) System.out.println("Nhap lai thang hop le !"); 
         }
         while ((i<1)&&(i>12));
         return thang;
     }
     
     public String setNam()
     {
         String nam;
          int i;
                 System.out.println("Nam: \n ");
         do{
         nam=sc.nextLine();
         i=Integer.parseInt(nam);
         if (i<2022) System.out.println("Nhap lai nam hop le !"); 
         }
         while (i<2022);
         return nam;
     }
     public String setGio()
     {
         String gio;
         int i;
                 System.out.println("Gio: \n ");
         do{
         gio=sc.nextLine();
         i=Integer.parseInt(gio);
         if ((i<0)||(i>23)) System.out.println("Nhap lai thang hop le !"); 
         }
         while ((i<0)||(i>23));
         return gio;
     }
     public String setPhut()
     {
         return "00";
     }
     public String setGiay()
     {
         return "00";
     }
    public void setNgayRa(String ngayRa) {
        this.ngayRa = ngayRa;
    }
    public void settotal(){
        this.total=this.totalDV+this.totalP;
    }
    public void setDsDV(String[] dsDV) {
        this.dsDV = dsDV;
    }

    public void setMaHD(Long maHD) {
        this.maHD = maHD;
    }

    public void setMaPhong(String maPhong) {
        this.maPhong = maPhong;
    }
    public void setKH(String tenKH){
        DSKH kh=new DSKH();
        Khachhang temp=new Khachhang();
        temp=kh.tentimKH(tenKH);
        this.KH=temp;
    }
    public void setTotal(String total){
        this.total = Long.parseLong(total);
    }
    public void nhapTTHD() throws ParseException{
        datPhong();
        themDV();
        traPhong();
    }
    public String ghepdsdv(){
        String s="";
        for(int i=0; i<n; i++){
            s=s+dsDV[i];
            s=s+" ";
        }
        return s;
    }
    public void setdv(String a){
        String []tempdv=a.split(" ");
        n=tempdv.length;
        this.dsDV=new String[n];
        for(int j=0; j<n; j++){
            dsDV[j]=new String();
            dsDV[j]=tempdv[j];
        }
    }
    @Override
    public String toString(){
        return String.format("| %-10s | %-20s | %-20s | %-10s | %-40s | %-40s | %-10d |\n", maHD, ngayVao, ngayRa, maPhong, KH.getHoten(), ghepdsdv(),total);
    }
}
