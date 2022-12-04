package QLKS;
import java.util.Scanner;
import java.io.*;
import java.text.ParseException;
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
        System.out.println("3 -- Dich vu --");
        System.out.println("4 -- Ma Phong --");
    }
    public void nhapDSHD() throws ParseException{
        System.out.print("Moi nhap so luong hoa don: ");
        this.n=sc.nextInt();
        dshd=new HoaDonDP[n];
        for(int i=0; i<n; i++){
            dshd[i]=new HoaDonDP();
            dshd[i].nhapTTHD();
        }
    }
    public void xuatDSHD(){
        System.out.println("-----> DANH SACH HOA DON <-----");
        System.out.printf("| %-1s | %-10s | %-20s | %-20s | %-10s | %-40s | %-40s | %-10s |\n", "STT", "Ma Hoa Don", "Ngay vao", "Ngay ra", "Ma Phong", "Khach hang", "Dich vu", "Tong chi phi");
        for(int i=0; i<n; i++){
            System.out.println("|  "+(i+1)+"  "+dshd[i]);
        }
        System.out.printf("---------- TONG THU: %d ----------", tongthu());
    }
    public long tongthu(){
        long tong=0;
        for(int i=0; i<n; i++){
            tong=tong+dshd[i].getTotal();
        }
        tongthu.setGia(String.valueOf(tong));
        return tongthu.getGia();
    }
    public void SuaDSHD() throws ParseException{
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
    public void themDSHD() throws ParseException{
        int plus;
        HoaDonDP a[]=new HoaDonDP[n]; 
        System.out.print("Moi nhap so luong hoa don can them: ");
        plus=sc.nextInt();
        for(int i=0; i<n; i++){
            a[i]=dshd[i];
        }
        n=n+plus;
        dshd=new HoaDonDP[n];
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
        dshd=new HoaDonDP[n];
        for(int i=0; i<n+1; i++){
            if(x!=(i+1)){
                dshd[j]=new HoaDonDP();
                dshd[j]=a[i];
                j++;
            }
        }
    }
    public void suaDSHD() throws ParseException{
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
                        dshd[i].tinhtienPhong();
                        break;
                    case 2:
                        dshd[i].setNgayRa();
                        dshd[i].tinhtienPhong();
                        break;
                    case 3:
                        dshd[i].themDV();
                        dshd[i].tinhtienDV();
                        break;
                    case 4:
                        dshd[i].setttphong(dshd[i].getMaPhong());
                        dshd[i].setPhong();
                        break;
                    default: 
                        System.out.println("Lua chon khong hop le ! Moi chon lai: ");
                        fix=sc.nextInt();
                        break;
                    }
                }while(fix<1 && fix>6);
            }
        }
    }
    public int readfilelayn(){
        n=0;
        try{
            FileReader fr=new FileReader("C:\\Users\\downny\\Desktop\\QLKS\\QLKS\\QLKS\\DSHoaDonDP.txt");
            BufferedReader br=new BufferedReader(fr);
            while(br.readLine()!=null){
                n++;
            }
            br.close();
            fr.close();
        }catch(IOException ex){
        }  
        return n;
    }
    @Override
    public String readfile(){
        n=readfilelayn();
        dshd=new HoaDonDP[n];
        try{
            FileReader fr=new FileReader("C:\\Users\\downny\\Desktop\\QLKS\\QLKS\\QLKS\\DSHoaDonDP.txt");
            BufferedReader br=new BufferedReader(fr);
            String fc;
            for(int i=0; i<n; i++){
                if((fc=br.readLine())!=null){
                    if(!(fc.equals(""))){
                        String []Value=fc.split("   ");
                        dshd[i]=new HoaDonDP();
                        dshd[i].setMaHD(Value[1]);
                        dshd[i].setNgayVao(Value[2]);
                        dshd[i].setNgayRa(Value[3]);
                        dshd[i].setMaPhong(Value[4]);
                        dshd[i].setTotal(Value[5]);
                        dshd[i].KH.setHoTen(Value[6]);
                        dshd[i].ghepdsdv(Value[7]);
                }
 
                }
            }
            br.close();
            fr.close();  
        }catch(IOException ex){
            
        }
        return "SOS";
    }
    @Override
    public void savefile(String fcontent){
        String fContent = "";
        try{
            FileWriter fsave=new FileWriter("C:\\Users\\downny\\Desktop\\QLKS\\QLKS\\QLKS\\DSHoaDonDP.txt");
            BufferedWriter fs = new BufferedWriter(fsave);
            for(int i=0; i<n; i++){
                if(dshd[i]!=null){
                    fContent=dshd[i].getMaHD()+"###"+dshd[i].getNgayRa()+"###"+dshd[i].getNgayVao()+"###"+dshd[i].getMaPhong()+"###"+dshd[i].getTotal()+"###"+dshd[i].KH.getHoten()+"###"+dshd[i].ghepdsdv();
                    fs.write(fContent);
                    fs.newLine();
                }
            }
            fs.close();
            fs.close();
        }catch(IOException ex){
            
        }
    }

    public static void main(String[] args) throws ParseException{
        DSHoaDonDP ds = new DSHoaDonDP();
        ds.nhapDSHD();
        ds.xuatDSHD();
        ds.savefile("");
        ds.readfile();
    }
}
