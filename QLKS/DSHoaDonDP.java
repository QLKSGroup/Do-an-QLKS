package QLKS;
import java.util.Scanner;
import java.io.*;
public class DSHoaDonDP implements Docghifile{
    static Scanner sc=new Scanner(System.in);
    private static HoaDonDP dshd[];
    private static int n;
    private static Gia tongthu=new Gia();
    public void luachon(){
        System.out.println("----SUA DOI DANH SACH HOA DON----");
        System.out.println("1 -- Them vao danh sach --");
        System.out.println("2 -- Xoa bot trong danh sach --");
        System.out.println("3 -- Sua danh sach --");
    }
    public void lcsuaDS(){
        System.out.println("----NOI DUNG MUON SUA----");
        System.out.println("1 -- Ngay vao --");
        System.out.println("2 -- Ngay ra --");
        System.out.println("3 -- Ma Hoa Don --");
        System.out.println("4 -- Khach hang --");
        System.out.println("5 -- Dich vu --");
        System.out.println("6 -- Ma Phong --");
    }
    public void xuatDSHD(){
        System.out.println("-----> DANH SACH HOA DON <-----");
        System.out.printf("| %-1s | %-10s | %-10s | %-10s | %-5s | %-40s | %-40s | %-10s |\n", "STT", "  Ma Hoa Don", "  Ngay vao", "  Ngay ra", "  Ma Phong", "  Khach hang", "  Dich vu", "  Tong chi phi");
        for(int i=0; i<n; i++){
            System.out.println("|  "+(i+1)+"  "+dshd[i]);
        }
        System.out.printf("---------- TONG THU: %d ----------", tongthu());
    }
    public long tongthu(){
        long tongthu=0;
        for(int i=0; i<n; i++){
            tongthu=tongthu+dshd[i].getTotal();
        }
        return tongthu;
    }
    public void SuaDSHD(){
        int chon;
        do{
            System.out.println("Moi nhap lua chon sua hoa don: ");
            luachon();
            chon=sc.nextInt();
            if(chon==1){
                themDSHD();
            }else if(chon==2){
                xoaDSHD();
            }else if(chon==3){
                suaDSHD();
            }else{
                System.out.print("Lua chon khong hop le ! Moi chon lai: ");
                chon=sc.nextInt();
            }
        }while(chon<1 && chon>3);
    }
    public void themDSHD(){
        int plus;
        HoaDonDP a[]=new HoaDonDP[n]; 
        System.out.print("Moi nhap so luong hoa don can them: ");
        plus=sc.nextInt();
        for(int i=0; i<n; i++){
            a[i]=dshd[i];
        }
        n=n+plus;
        HoaDonDP dshd[]=new HoaDonDP[n];
        for(int i=0; i<n-plus; i++){
            dshd[i]=new HoaDonDP();
            if(a[i]!=null){
                dshd[i]=a[i];
            }
        }
        for(int i=n-plus; i<n; i++){
            dshd[i]=new HoaDonDP();
            dshd[i].nhapTTHD();
        }
    }
    public void xoaDSHD(){
        int x;
        HoaDonDP a[]=new HoaDonDP[n]; 
        xuatDSHD();
        System.out.print("Moi chon hoa don can xoa: ");
        x=sc.nextInt();
        for(int i=0; i<n; i++){
            a[i]=dshd[i];
        }
        n=n-1;
        int j=0;
        HoaDonDP dshd[]=new HoaDonDP[n];
        for(int i=0; i<n; i++){
            if(x!=(i+1)){
                dshd[j]=new HoaDonDP();
                dshd[j]=a[i];
                j++;
            }
        }
    }
    public void suaDSHD(){
        xuatDSHD();
        System.out.println("Moi chon hoa don can sua: ");
        int y=sc.nextInt();
        for(int i=0; i<n; i++){
            if(y==(i+1)){
                lcsuaDS();
                System.out.println("Moi chon noi dung muon sua: ");
                int fix=sc.nextInt();
                do{
                    switch(fix){
                    case 1:
                        dshd[i].setNgayVao();
                        break;
                    case 2:
                        dshd[i].setNgayRa();
                        break;
                    case 3:
                    case 4:
                    case 5:
                    case 6:
                    default: 
                        System.out.println("Lua chon khong hop le ! Moi chon lai: ");
                        fix=sc.nextInt();
                        break;
                    }
                }while(fix<1 && fix>6);
            }
        }
    }
    @Override
    public String readfile(){
        String fc="";
        try{
            
        }catch(IOException ex){
            
        }
        return fc;
    }
    public void savefile(String fcontent){
        try{
            FileWriter fsave=new FileWriter("C:\\Users\\User\\OneDrive - 101203\\Desktop\\SGU Study\\HKIII_SGU_2022-2023\\Lập trình hướng đối tượng\\DSChiPhi.txt");
        }catch(IOException ex){
            
        }
    }
}
