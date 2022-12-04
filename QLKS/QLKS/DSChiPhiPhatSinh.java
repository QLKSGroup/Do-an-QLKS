package QLKS;
import java.util.Scanner;
import java.io.*;
public class DSChiPhiPhatSinh implements Docghifile{
    private ChiPhiPhatSinh ds[];
    private static int n;
    private Gia tongchi=new Gia();
    static Scanner sc= new Scanner(System.in);
    public DSChiPhiPhatSinh(){
        
    }
    public DSChiPhiPhatSinh(ChiPhiPhatSinh ds[], Gia tongchi){
        this.ds=ds;
        this.tongchi=tongchi;
    }
    public void luachon(){
        System.out.println("----SUA DOI DANH SACH CHI PHI----");
        System.out.println("1 -- Them vao danh sach --");
        System.out.println("2 -- Xoa bot trong danh sach --");
        System.out.println("3 -- Sua danh sach --");
    }
    public void suaDS(){
        System.out.println("----NOI DUNG MUON SUA----");
        System.out.println("1 -- Noi dung --");
        System.out.println("2 -- So tien --");
        System.out.println("3 -- Trang thai --");
    }
    public long tongchiCP(){
        String a="0";
        tongchi.setGia(a);
        long tongchi=this.tongchi.getGia();//
        for(int i=0; i<n; i++){
            long sotien=ds[i].getsotien().getGia();
            tongchi=tongchi+sotien;
        }
        this.tongchi.setGia(String.valueOf(tongchi));
        return this.tongchi.getGia();
    }
    public void NhapDSCP(){
        System.out.print("Moi nhap so luong chi phi phat sinh: ");
        n=sc.nextInt();
        ds=new ChiPhiPhatSinh[n];
        for(int i=0; i<n; ){
            ds[i]=new ChiPhiPhatSinh();
            System.out.println("***CHI PHI PHAT SINH THU "+(i+1)+" : ");
            ds[i].nhapTT();
            i++;
        }
    }
    public void XuatDSCP(){
        System.out.println("---->Danh sach Chi Phi Phat Sinh<----");
        System.out.printf("| %-1s | %-20s | %-10s | %-10s |\n","STT","Noi dung","So tien","Trang thai");
        for(int i=0; i<n; i++){
            System.out.println("|  "+(i+1)+"  "+ds[i]);
        }
        System.out.println("------TOTAL: "+tongchiCP()+"------");
    }
    public void SuaDSCP(){
        int chon;
        System.out.println("Moi chon lua chon sua danh sach: ");
        luachon();
        chon=sc.nextInt();
        if(chon==1){
            int plus;
            ChiPhiPhatSinh a[]=new ChiPhiPhatSinh[n];
            System.out.print("Moi nhap them so luong chi phi phat sinh: ");
            plus=sc.nextInt();
            for(int i=0; i<n; i++){
                a[i]=ds[i];
            }
            n=n+plus;
            ds=new ChiPhiPhatSinh[n];
            for(int i=0; i<(n-plus); i++){
                if(a[i]!=null){
                    ds[i]=a[i];
                }
            }
            for(int i=n-plus; i<n; i++){
                ds[i]=new ChiPhiPhatSinh();
                ds[i].nhapTT();
            }
            //tongchi();
        }else if(chon==2){
            ChiPhiPhatSinh a[]=new ChiPhiPhatSinh[n];
            System.out.println("Moi chon chi phi phat sinh can xoa: ");
            XuatDSCP();
            int x=sc.nextInt();
            for(int i=0; i<n; i++){
                a[i]=ds[i];
            }
            n=n-1;
            ds=new ChiPhiPhatSinh[n];
            int j=0;
            for(int i=0; i<n+1; i++){
                if(x!=(i+1)){
                    ds[j]=new ChiPhiPhatSinh();
                    ds[j]=a[i];
                    j++;
                }
            }
            //tongchi();
        }else if(chon==3){
            System.out.println("Moi chon chi phi phat sinh can sua: ");
            XuatDSCP();
            int y=sc.nextInt();
            for(int i=0; i<n; i++){
                if(y==(i+1)){
                    int fix;
                    do{ 
                        System.out.println("Moi chon phan chi phi phat sinh can sua: ");
                        suaDS();
                        fix=sc.nextInt();
                        switch(fix){
                            case 1: ds[i].nhapnoidung(); break;
                            case 2: ds[i].nhapsotien(); break;
                            case 3: ds[i].nhaptrangthai(); break;
                            default: System.out.println("Lua chon khong dung ! Moi chon lai :");
                                fix=sc.nextInt();
                                break;
                        }
                    }while( fix<1 && fix>3);
                    //tongchi();
                }
            }
        }
    }
    @Override
    public void savefile(String fcontent){
        String fc="";
        try{
            FileWriter fsave=new FileWriter("C:\\Users\\User\\OneDrive - 101203\\Desktop\\SGU Study\\HKIII_SGU_2022-2023\\Lập trình hướng đối tượng\\DSChiPhi.txt");
            BufferedWriter fs=new BufferedWriter(fsave);
            for(int i=0; i<n; i++){
                if(ds[i]!=null){
                    if(ds[i].gettrangthai()==true){
                        fc=(i+1)+"   "+ds[i].getnoidung()+"   "+ds[i].getsotien().getGia()+"   "+"Co";
                    }else{
                        fc=(i+1)+"   "+ds[i].getnoidung()+"   "+ds[i].getsotien().getGia()+"   "+"Khong";
                    }
                    fs.write(fc);
                    fs.newLine();
                }
            }
            fs.close();
            fsave.close();
        }catch(IOException ex){
            
        }
    }
    @Override
    public String readfile(){
        String fcontent="";
        ds=new ChiPhiPhatSinh[100];
        n=0;
        try{
            FileReader fread=new FileReader("C:\\Users\\User\\OneDrive - 101203\\Desktop\\SGU Study\\HKIII_SGU_2022-2023\\Lập trình hướng đối tượng\\DSChiPhi.txt");
            BufferedReader fr=new BufferedReader(fread);
            String fc;
            while((fc=fr.readLine())!=null){
                if(!fc.equals("")){
                    String []Value=fc.split("   ");
                    if(Value.length>0){
                        ds[n] =new ChiPhiPhatSinh();
                        ds[n].setnoidung(Value[1]);
                        ds[n].setsotien(Value[2]);
                        ds[n].settrangthai(Value[3]);
                        n++;
                    }
                }
            }
            fr.close();
            fread.close();
        }catch(IOException ex){
            
        }
//        try{
//            FileReader fread=new FileReader("C:\\Users\\User\\OneDrive - 101203\\Desktop\\SGU Study\\HKIII_SGU_2022-2023\\Lập trình hướng đối tượng\\DSChiPhi.txt");
//            BufferedReader fr=new BufferedReader(fread);
//            String fc;
//            n=Integer.parseInt(fr.readLine());
//            System.out.println(n);
//            DSChiPhiPhatSinh.ds=new ChiPhiPhatSinh[n];
//            for(int i=0; i<n; i++){
//                fc=fr.readLine();
//                String[] Val=fc.split("   ");
//                ds[i]=new ChiPhiPhatSinh();
//                ds[i].setnoidung(Val[1]);
//                ds[i].setsotien(Float.parseFloat(Val[2]));
//                ds[i].settrangthai(Val[3]);
//            }
//            fr.close();
//            fread.close();
//        }catch(IOException ex){
//            
//        }
        return fcontent;
    }
}
