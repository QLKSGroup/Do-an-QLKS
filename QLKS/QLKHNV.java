package QLKS;


import java.util.Scanner;
public class QLKHNV implements Docghifile {//Quan ly danh sach khach hang va nhan vien
    private static Person ds[][];
    Scanner sc = new Scanner(System.in);
    public void nhapDS(){
        int op;
        ds = new Person[2][];
        System.out.println("Moi lua chon : \n1.Khach hang \n2.Nhan vien");
        System.out.println("Nhap chon lua: ");
        op = Integer.parseInt(sc.nextLine());
        switch(op){
            case 1:System.out.println("Nhap so phan tu cua danh sach khach hang : ");
            int n = Integer.parseInt(sc.nextLine());
            for(int i = 0;i<n;i++){
                ds[0][i] = new Khachhang();
                ds[0][i].nhap();
            }
            break;
            case 2:System.out.println("Nhap so phan tu cua danh sach nhan vien : ");
            int m = Integer.parseInt(sc.nextLine());
            for(int j = 0;j<m;j++){
                ds[1][j] = new NhanVien(){
                @Override
                protected String loaiNhanVien(){
                    return null;
                }
                @Override
                public void tinhLuong(){
                }
                };
                ds[1][j].nhap();
            }
            break;
            case 3:break;
        }
    }
    @Override
    public String readfile() {
        // TODO Auto-generated method stub
        return null;
    }
    @Override
    public void savefile(String fcontent) {
        // TODO Auto-generated method stub
        
    }


}