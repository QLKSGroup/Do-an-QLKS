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
    private static Khachhang KH;
    private static String dsDV[];
    private static int n;
    private int sl[];
    private static long soHD=-1;
    private long maHD=0;
    private String maPhong;
    private long totalDV;
    private long totalP;
    private long total;
    private static Scanner sc= new Scanner(System.in);
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
        }
        while (i==0);
    }
    public void traPhong() throws ParseException
    {
//        java. SimpleDateFormat kế thừa lớp java.text.DateFormat.
        System.out.println("------> TRA PHONG <------");
        setNgayRa();
        SoDoPhong sdp=new SoDoPhong();
        sdp.readfile();
        sdp.traPhong(maPhong);
        DateFormat df = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        Date date1 = df.parse(getNgayVao());
        Date date2=df.parse(getNgayRa());
        DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
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
    
    
    public void themDV(){
        System.out.println("------> DICH VU <------");
       System.out.println("Nhap Ma Dich Vu:");
       String maDv;
       DSDichVu ds=new DSDichVu();
       ds.readfile();
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
       }
       else{
           int count=1;
           for (int i=0;i<n;i++){
                    if(dsDV[i].equalsIgnoreCase(maDv)==true){
                        count =0;
                    }
                }
            if (count ==1) n=n+1;
            String dsDV2[]=new String[n];
            for(int i=0; i<n-1; i++){
                dsDV2[i]=dsDV[i];
            }
            for(int i=n-1; i<n; i++){
                if(dsDV[i].equalsIgnoreCase(maDv)==true){
                    sl[i]=sl[i]+1;
                }else{
                    dsDV2[i]=new String();
                    dsDV2[i]=maDv;
                }
            }
            dsDV=new String[n];
            for (int i=0;i<n;i++){
                dsDV[i]=dsDV2[i];
            }
            
        }
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
        return (totalP+totalDV);
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

    public void setDsDV(String[] dsDV) {
        this.dsDV = dsDV;
    }

    public void setMaHD(long maHD) {
        this.maHD = maHD;
    }

    public void setMaPhong(String maPhong) {
        this.maPhong = maPhong;
    }

    public void setTotal(long total) {
        this.total = total;
    }
    public void nhapTT() throws ParseException{
        datPhong();
        themDV();
        traPhong();
    }
    public String ghepdsdv(){
        String s=null;
        for(int i=0; i<n; i++){
            s=s+dsDV[i];
        }
        return s;
    }
    @Override
    public String toString(){
        return String.format("| %-5s | %-10s | %-10s | %-5s | %-30s | %-30s | %-10d |\n", maHD, ngayVao, ngayRa, maPhong, KH.getHoten(), ghepdsdv(),(totalDV+totalP));
    }
}
