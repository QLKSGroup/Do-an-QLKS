/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package QLKS;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import static java.lang.Integer.parseInt;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author ADMIN
 */
public class SoDoPhong implements Docghifile {
    private static Phong ds[][];
    private static int soPhong[];          //mang de luu so phong cua 1 tang
    private static int Tang ;
    private static int dem[];
    private static Phong ds1[][];
    private static Scanner sc= new Scanner(System.in);
    public void nhapDSPhong()
    {
        System.out.println("Nhap so tang cua khach san");
        Tang=sc.nextInt();
        System.out.println("Nhap so phong moi tang cua khach san");
        soPhong=new int[Tang];
        ds=new Phong[Tang][];
        for (int i=0;i<Tang;i++)
        {
            System.out.printf("---Tang %d---\n " ,i+1);
            System.out.printf("Nhap so phong cua tang %d\n",i+1);        // dang lam giua chung
            soPhong[i]=sc.nextInt();
            ds[i]=new Phong[soPhong[i]];
            for(int j=0;j<soPhong[i];j++)
            {
                ds[i][j]=new Phong();
                ds[i][j].nhapTTPhong();
            }
        }
    }
    public void xuatDSPhong()
    {
        System.out.println("----Danh sach Phong----");
        for (int i=0;i<Tang;i++)
        {
            System.out.printf("[---Tang %d---]\n",(i+1));
            System.out.printf("|%-10s|%-10s|%-15s|%-10s|%-15s|\n","Ma Phong","Loai Phong","So nguoi toi da","Gia Phong","Tinh trang phong");
            if (soPhong[i]==0) System.out.println("Khong co Phong hoat dong o Tang nay ! ");
            for(int j=0;j<soPhong[i];j++)
            {
                ds[i][j].xuatTTPhong();
            }
    }
    }
    public void ganDSLoc()
            {
                dem=new int[Tang];
                ds1=new Phong[Tang][];
                for (int i=0;i<Tang;i++)
                              {
                                  dem[i]=soPhong[i];
                                  ds1[i]=new Phong[soPhong[i]];
                                for(int j=0;j<soPhong[i];j++)
                              {           
                                  ds1[i][j]=new Phong();
                                  ds1[i][j]=ds[i][j];
                              }
                                }
                
            }
    public void locTinhTrang()
    {
        int dem1[]=new int[Tang];
        Phong dsl[][]=new Phong[Tang][];   
        System.out.println("---Loc Danh Sach---");
                         System.out.printf("Nhap lua chon \n1.Phong Trong\n2.Phong co nguoi\n3.Tat ca\n");
                         int a=0;
                         do 
                         {
                             a=sc.nextInt();
                             sc.nextLine();
                             if ((a<0)||(a>3)) System.out.println("Nhap lai lua chon");
                         }
                         while ((a<0)||(a>3));
                         switch (a) 
                         {
                             case 1:{                          //Phong trong
                                 
                               for (int i=0;i<Tang;i++)
                              {
                                  dem1[i]=0;
                                for(int j=0;j<dem[i];j++)
                              {           
                                  if (ds1[i][j].isTinhTrang()==false)
                                          {
                                              dem1[i]=dem1[i]+1;
                                          }
                              }
                                }
                              
                                for (int i=0;i<Tang;i++)
                              {   
                                  int nDS1=0;
                                  dsl[i]=new Phong[dem1[i]];
                                for(int j=0;j<dem[i];j++)
                              {           
                                  if (ds1[i][j].isTinhTrang()==false)
                                          {
                                              dsl[i][nDS1]=new Phong();
                                              dsl[i][nDS1]=ds1[i][j];
                                              nDS1=nDS1+1;
                                          }
                              }
                              }
                                for (int i=0;i<Tang;i++)       //copy mang da loc sang mang ds1
                              {
                                    dem[i]=dem1[i];
                                  ds1[i]=new Phong[dem1[i]];
                                for(int j=0;j<dem1[i];j++)
                              {      
                                  ds1[i][j]=new Phong();
                                  ds1[i][j]=dsl[i][j];
                              }
                                }
                                break;
                             }
                             case 2:{        //Phong co nguoi
                                  for (int i=0;i<Tang;i++)
                              {
                                  dem1[i]=0;
                                for(int j=0;j<dem[i];j++)
                              {           
                                  if (ds1[i][j].isTinhTrang()==true)
                                          {
                                              dem1[i]=dem1[i]+1;
                                          }
                              }
                                }
                              
                                for (int i=0;i<Tang;i++)
                              {   
                                  int nDS1=0;
                                  dsl[i]=new Phong[dem1[i]];
                                for(int j=0;j<dem[i];j++)
                              {           
                                  if (ds1[i][j].isTinhTrang()==true)
                                          {
                                              dsl[i][nDS1]=new Phong();
                                              dsl[i][nDS1]=ds1[i][j];
                                              nDS1=nDS1+1;
                                          }
                              }
                              }
                                for (int i=0;i<Tang;i++)       //copy mang da loc sang mang ds1
                              {
                                    dem[i]=dem1[i];
                                  ds1[i]=new Phong[dem1[i]];
                                for(int j=0;j<dem1[i];j++)
                              {      
                                  ds1[i][j]=new Phong();
                                  ds1[i][j]=dsl[i][j];
                              }
                                }
                                break;
                             }
                             case 3:
                             {
                                 break;
                             }
                         }
    }
    public void locLoaiPhong()
    {
        int dem1[]=new int[Tang];
        Phong dsl[][]=new Phong[Tang][];   
                        System.out.println("---Loc Danh Sach---");
                         System.out.printf("Nhap lua chon \n1.Phong Vip\n2.Phong Thuong\n3.Tat ca\n");
                         int a=0;
                         do 
                         {
                             a=sc.nextInt();
                             sc.nextLine();
                             if ((a<0)||(a>3)) System.out.println("Nhap lai lua chon");
                         }
                         while ((a<0)||(a>3));
                         switch (a)
                         {
                             case 1:{
                                 
                               for (int i=0;i<Tang;i++)
                              {
                                  dem1[i]=0;
                                for(int j=0;j<dem[i];j++)
                              {           
                                  if (ds1[i][j].getLoaiPhong().equalsIgnoreCase("Vip")==true)
                                          {
                                              dem1[i]=dem1[i]+1;
                                          }
                              }
                                }
                              
                                for (int i=0;i<Tang;i++)
                              {   
                                  int nDS1=0;
                                  dsl[i]=new Phong[dem1[i]];
                                for(int j=0;j<dem[i];j++)
                              {           
                                  if (ds1[i][j].getLoaiPhong().equalsIgnoreCase("Vip")==true)
                                          {
                                              dsl[i][nDS1]=new Phong();
                                              dsl[i][nDS1]=ds1[i][j];
                                              nDS1=nDS1+1;
                                          }
                              }
                              }
                                for (int i=0;i<Tang;i++)       //copy mang da loc sang mang ds1
                              {
                                   dem[i]=dem1[i];
                                  ds1[i]=new Phong[dem1[i]];
                                for(int j=0;j<dem1[i];j++)
                              {      
                                  ds1[i][j]=new Phong();
                                  ds1[i][j]=dsl[i][j];
                              }
                                }
                                break;
                             }
                             case 2:{
                                  for (int i=0;i<Tang;i++)
                              {
                                  dem1[i]=0;
                                for(int j=0;j<soPhong[i];j++)
                              {           
                                  if (ds1[i][j].getLoaiPhong().equalsIgnoreCase("Thuong")==true)
                                          {
                                              dem1[i]=dem1[i]+1;
                                          }
                              }
                                }
                              
                                for (int i=0;i<Tang;i++)
                              {   
                                  int nDS1=0;
                                  dsl[i]=new Phong[dem1[i]];
                                for(int j=0;j<soPhong[i];j++)
                              {           
                                  if (ds1[i][j].getLoaiPhong().equalsIgnoreCase("Thuong")==true)
                                          {
                                              dsl[i][nDS1]=new Phong();
                                              dsl[i][nDS1]=ds1[i][j];
                                              nDS1=nDS1+1;
                                          }
                              }
                              }
                                
                                for (int i=0;i<Tang;i++)       //copy mang da loc sang mang ds1
                              {
                                  dem[i]=dem1[i];
                                  ds1[i]=new Phong[dem1[i]];
                                for(int j=0;j<dem1[i];j++)
                              {      
                                  ds1[i][j]=new Phong();
                                  ds1[i][j]=dsl[i][j];
                              }
                                }
                                break;
                             }
                             case 3:
                             {
                                 break;
                            }
    }
    }
public void locDS()
{
    ganDSLoc();
    int b=1;
    int c=0;
    do
    {
    System.out.printf(">Loc danh sach phong<\n1.Loc theo loai phong\n2.Loc theo tinh trang phong\n3.Reset\n4.Thoat\n");
    System.out.println("Nhap lua chon :");
    int a;
    do 
    {
        a=sc.nextInt();
        sc.nextLine();
        if ((a<1)||(a>4)) System.out.println("Nhap lua chon khong hop le\nNhap lai:");
        if (a==c) System.out.println("Ban da chon lua chon nay truoc do \nNhap lai lua chon:");
    }
    while ((a<1)||(a>4)||(a==c));
    c=a;
    switch (a)
    {
        case 1:locLoaiPhong();xuatDSDaLoc();break;
        case 2:locTinhTrang();xuatDSDaLoc();break;
        case 3:ganDSLoc();xuatDSDaLoc();break;
        case 4:b=0;break;
    }
    }
    while (b==1);
}
public void xuatDSDaLoc()
{
                           for (int i=0;i<Tang;i++)
                         {
                           System.out.printf("[---Tang %d---]\n",(i+1));
                           if(dem[i]==0) System.out.printf("Khong tim thay Phong thoa yeu cau o Tang nay \n");
                         for (int j=0;j<dem[i];j++)
                         {
                             ds1[i][j].xuatTTPhong();
                         }
                         }
}

public void themPhong()
{
 System.out.println("Nhap tang can them phong ");
 int a;
 do
 {
     a=sc.nextInt();
     sc.nextLine();
     if (a-1>Tang) System.out.println("Nhap tang trong gioi han cua Khach San co!\nNhap lai:");
 }
 while (a-1>Tang); 
 System.out.println("So luong phong can them vao :");
 int slT=sc.nextInt();
 Phong dsT[]=new Phong[soPhong[a-1]+slT];
 for (int i=0;i<soPhong[a-1]+slT;i++)
 {
     dsT[i]=new Phong();
     if (i<soPhong[a-1])
     dsT[i]=ds[a-1][i];
     else 
         dsT[i].nhapTTPhong();
 }
 soPhong[a-1]=soPhong[a-1]+slT;
 ds[a-1]=new Phong[soPhong[a-1]];
 for (int i=0;i<soPhong[a-1];i++)
 {
     ds[a-1][i]=dsT[i];
 }
}
public void suaPhong()
{
    System.out.printf("Nhap Ma Phong can sua :\n");
    String maPhong=sc.nextLine();
    int count=0;
    for (int i=0;i<Tang;i++)
    {
        for (int j=0;j<soPhong[i];j++)
        {
            if (ds[i][j].getMaPhong().equalsIgnoreCase(maPhong)==true)
            {
                count =1;
                int b=1;
                do
                {
                System.out.printf("Chon thong tin can sua\n1.Ma Phong\n2.Loai Phong\n3.Gia Phong\n4.So nguoi o\n5.Tinh trang Phong\n6.Thoat");
                int a=0;
                do{
                a=sc.nextInt();
                sc.nextLine();
                if ((a<1)||(a>6)) System.out.println("Nhap lai lua chon ");
                }
                while ((a<1)||(a>6));
                switch (a)
                {
                    case 1:ds[i][j].setMaPhong();break;
                    case 2:ds[i][j].setLoaiPhong();break;
                    case 3:ds[i][j].setGia();break;
                    case 4:ds[i][j].setSoNguoiO();break;
                    case 5:ds[i][j].setTinhTrang();break;
                    case 6:b=0;break;
                }
                }
                while(b==1);
            }
        }
    }
    if (count==0) System.out.println("Ma Phong vua nhap khong ton tai trong danh sach");
}
    @Override
    
    public String readfile()
{
    try{
        FileReader fr=new FileReader("C:\\Users\\User\\OneDrive - 101203\\Desktop\\SGU Study\\HKIII_SGU_2022-2023\\Lập trình hướng đối tượng\\DSPhong.txt");
        BufferedReader br = new BufferedReader(fr);
        Tang=Integer.parseInt(br.readLine());
        soPhong=new int[Tang];
        ds=new Phong[Tang][];
        for (int i=0;i<Tang;i++)
        {
            soPhong[i]=Integer.parseInt(br.readLine());
            ds[i]=new Phong[soPhong[i]];
            for(int j=0;j<soPhong[i];j++)
            {
                ds[i][j]=new Phong();
                 String st=br.readLine();
                 String []s=st.split(" ");
                 ds[i][j].setMaPhong(s[0]);
                ds[i][j].setLoaiPhong(s[1]);
                ds[i][j].setGia(s[2]);
                ds[i][j].setTinhTrang(s[3]);
                ds[i][j].setSoNguoiO(s[4]);
                 
            }
        }
        br.close();
        fr.close();
    }
    catch (IOException e) {}
    return "SOS";
}

    @Override
    public void savefile(String fcontent)
    {
        try {
            FileWriter fo = new FileWriter("C:\\Users\\User\\OneDrive - 101203\\Desktop\\SGU Study\\HKIII_SGU_2022-2023\\Lập trình hướng đối tượng\\DSPhong.txt"); 
            BufferedWriter bo = new BufferedWriter(fo);
            String n=String.valueOf(Tang);
            bo.write(n); 
           
            for (int i=0;i<Tang;i++)
        { 
            bo.newLine();
            String k=String.valueOf(soPhong[i]);
            bo.write(k);
        for (int j=0;j<soPhong[i];j++)
        {
            bo.newLine();
            bo.write(ds[i][j].toStringToWrite());
            
        }
        }
            bo.close();
            fo.close();
        } catch (IOException ex) {
     } 
    } 
public void xoaPhong()
{
    System.out.printf("Nhap Ma Phong can xoa :\n");
    String maPhong=sc.nextLine();
    int count=0;
    int k=0;
    
     for (int i=0;i<Tang;i++)
    {
        for (int j=0;j<soPhong[i];j++)
        {
            if (ds[i][j].getMaPhong().equalsIgnoreCase(maPhong)==true)
            {
                k=i;
                count=1;
            }
        }
        }
     Phong ds2[]=new Phong[soPhong[k]-1];
     int nDS2=0;
     if (count==1)
     {
         for (int j=0;j<soPhong[k];j++)
         {
             if (ds[k][j].getMaPhong().equalsIgnoreCase(maPhong)==false)
             {
                 ds2[nDS2]=new Phong();
                 ds2[nDS2]=ds[k][j];
                 nDS2+=1;
             }
         }
         //Copy mang da duoc xoa sang mang chinh
         ds[k]=new Phong[nDS2];
         soPhong[k]=soPhong[k]-1;
         for (int j=0;j<nDS2;j++)
         {
             ds[k][j]=ds2[j];
         }
     }
     else {
         System.out.println("Ma Phong vua nhap khong co trong danh sach phong !");
     }
    
}
public int timPhong(String mp)
{
    
    int count=0;
    for (int i=0;i<Tang;i++)
    {
        for (int j=0;j<soPhong[i];j++)
        {
            if (ds[i][j].getMaPhong().equalsIgnoreCase(mp)==true)
            {
                count=1;
                if (ds[i][j].isTinhTrang()==false)
                {
                    ds[i][j].setTinhTrangTrue();
                    return 1;
                }
                else {
                    System.out.println("Phong nay da co nguoi");
                    return 0;
                }
            }      
        }
        }
    if (count==0) {
        System.out.println("Ma Phong vua nhap khong co ton tai trong danh sach!");
        return 0;
    }
    return 2;
        }
public void traPhong(String mp)
{
    for (int i=0;i<Tang;i++)
    {
        for (int j=0;j<soPhong[i];j++)
        {
            if (ds[i][j].getMaPhong().equalsIgnoreCase(mp)==true)
            {
                if (ds[i][j].isTinhTrang()==true)
                {
                    ds[i][j].setTinhTrangFalse();
                }
            }
        }
}
}
public long getGiaPhong(String mp)
{
     for (int i=0;i<Tang;i++)
    {
        for (int j=0;j<soPhong[i];j++)
        {
            if (ds[i][j].getMaPhong().equalsIgnoreCase(mp)==true)
            {
                return ds[i][j].getGiaLong();
            }
            
        }
    }
     return 0;
}
}



