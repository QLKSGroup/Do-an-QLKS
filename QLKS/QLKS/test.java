package QLKS;
import java.text.ParseException;
import java.util.Scanner;
public class test {
    static Scanner sc=new Scanner(System.in);
    public static void luachon(){
        System.out.println("----> DANH SACH HOA DON <----");
        System.out.println("1 -- Lam moi danh sach --");
        System.out.println("2 -- Xuat danh sach --");
        System.out.println("3 -- Sua danh sach --");
    }
    public static void main(String[] args) throws ParseException{
        DSHoaDonDP a=new DSHoaDonDP();
        int x;
        do{
            luachon();
            System.out.print("Moi chon lua chon: ");
            int chon=sc.nextInt();
            do{
                switch(chon){
                case 1:
                    a.nhapDSHD();
                    break;
                case 2:
                    a.xuatDSHD();
                    break;
                case 3:
                    a.SuaDSHD();
                    break;
                default:
                    System.out.print("Lua chon khong dung ! Moi chon lai: "); chon=sc.nextInt(); break;
                }
            }while(chon<1 && chon>3);
            System.out.println("Ban co muon them lua chon khong ?");
            System.out.println("1 -- Co --");
            System.out.println("2 -- Khong --");
            x=sc.nextInt();
        }while(x==1);
    }
}
