/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */

package com.mycompany.asm1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

/**
 *
 * @author giau7
 */
public class Asm1 {
    public static ArrayList<NhanVien> lsNv = new ArrayList();
    public static Scanner sc = new Scanner(System.in);
    
    public static void capNhatThongTinNv(){
        System.out.println("Nhap ma nhan vien can cap nhat");
        String manv = sc.next();
        boolean kt = false;
        int index =0;
        for(NhanVien nv: lsNv){
            if(nv.getManv().equalsIgnoreCase(manv)){
                kt = true;
                System.out.println("Cap nhat thong tin nhan vien (Nhan enter neu muon giu lai thong tin)");
                System.out.print("Ma nhan vien: "+nv.getManv());
                String maNvNew = sc.next();
                if(!maNvNew.equalsIgnoreCase("")){
                    System.out.println("Cap nhat ma nhan vien moi "+maNvNew);
                    nv.setManv(maNvNew);
                }
                System.out.println("Cap nhat ten nhan vien moi: "+nv.getHoTen());
                String tenNew = sc.nextLine();
                if(!tenNew.equalsIgnoreCase("")){
                    System.out.println("Cap nhat ten nhan vien moi");
                    nv.setHoTen(tenNew);
                }
                
                System.out.println("Cap nhat luong nhan vien moi "+nv.getLuong());
                String luongNew = sc.next();
                sc.nextLine();
                if(!luongNew.equalsIgnoreCase("")){
                    System.out.println("Cap nhat luong nhan vien "+luongNew);
                    nv.setLuong(Double.parseDouble(luongNew));
                }
                
                if(nv instanceof TruongPhong){
                    System.out.println("Cap nhat luong trach nhiem "+((TruongPhong) nv).getTrachNhiem());
                    String trachNhiemNew = sc.next();
                    sc.nextLine();
                    if(!trachNhiemNew.equalsIgnoreCase("")){
                        System.out.println("Cap nhat luong trach nhiem moi "+trachNhiemNew);
                        ((TruongPhong) nv).setTrachNhiem(Double.parseDouble(trachNhiemNew));
                    }
                }else if(nv instanceof TiepThi){
                    System.out.println("Cap nhat Doanh so "+((TiepThi) nv).getDoanhSo());
                    String doanhSoNew = sc.next();
                    sc.nextLine();
                    if(!doanhSoNew.equalsIgnoreCase("")){
                        System.out.println("Cap nhat doanh so moi "+((TiepThi) nv).getDoanhSo());
                        ((TiepThi) nv).setDoanhSo(Double.parseDouble(doanhSoNew));
                    }
                }
                
                //cap nhat nhan vien moi vao
                lsNv.set(index, nv);
            }else{
                index++;
            }
        }
        for(int i=0; i<lsNv.size(); i++){
            if(lsNv.get(i) instanceof NhanVien){
                System.out.println("Lop nhan vien");
            }else if(lsNv.get(i) instanceof TruongPhong){
                System.out.println("Lop truong phong");
            }else if(lsNv.get(i) instanceof TiepThi){
                System.out.println("Lop tiep thi");
            }
        }
    }
    public static void nhap(){
        String tt="";
        System.out.println("Nhap nhan vien");
        do{
            System.out.println("Ma nhan vien: ");
            String manv = sc.next();
            System.out.println("Ho ten nhan vien: ");
            String hoTen = sc.next();
            System.out.println("Nhap luong nhan vien: ");
            sc.nextLine();
            double luong = Double.parseDouble(sc.nextLine());
            System.out.println("Chuc vu: 1.Truong phong, 2.Tiep thi");
            int chucVu = Integer.parseInt(sc.nextLine());
            if(chucVu ==1){
                System.out.println("Luong trach nhiem");
                double trachNhiem = Double.parseDouble(sc.nextLine());
                NhanVien tp = new TruongPhong(trachNhiem,manv, hoTen, luong);
                lsNv.add(tp);
            }else if(chucVu==2){
                System.out.println("Doanh so");
                double doanhSo = Double.parseDouble(sc.nextLine());
                System.out.println("Hue hong");
                double hueHong = Double.parseDouble(sc.nextLine());
                NhanVien tiepT = new TiepThi(doanhSo, hueHong, manv, hoTen, luong);
                lsNv.add(tiepT);
            }else{
                NhanVien hc = new NhanVienHanhChinh(manv, hoTen, luong);
                lsNv.add(hc);
            }
            System.out.println("Ban co muon nhap nhan vien tiep khong (y/ n)");
            tt = sc.next();
            sc.nextLine();
        }while(!tt.equalsIgnoreCase("n"));
    }

    public static void nhapNhanVien(){
      
        String tiep;
        do {            
            System.out.println("Chon chuc vu: 1.Truong phong, 2.Tiep thi, 3.Nhan vien hanh chinh");
            int chonCv = Integer.parseInt(sc.nextLine());
            NhanVien nv;
            switch(chonCv){
                case 1:
                    nv = new NhanVienHanhChinh();
//                    nhap(chonCv);
                    lsNv.add(nv);
                    break;
                case 2:
                    nv = new TruongPhong();
//                    nhap(chonCv);
                    lsNv.add(nv);
                    break;
                case 3:
                    nv = new TiepThi();
//                    nhap(chonCv);
                    lsNv.add(nv);
                    break;
            }
            
            System.out.println("Ban co muon nhap nhan vien tiep khong (y/ n)");
            tiep = sc.next();
            sc.nextLine();
        } while (!tiep.equalsIgnoreCase("n"));
    }
    public static void hienThiNhanVien(){
        System.out.println("Danh sach nhan vien");
        for(NhanVien nv: lsNv){
            nv.xuatThongTin();
            System.out.println("===========================");
        }
    }
    public static void timKiemTheoMa(){
        System.out.println("Nhap ma nhan vien muon tim");
        String manv = sc.next();
        sc.nextLine();
        for(NhanVien nv: lsNv){
            if(nv.getManv().equals(manv)){
                nv.xuatThongTin();
            }
        }
    }
    public static void xoaTheoMa(){
        System.out.println("Chon ma nhan vien muon xoa");
        String manv = sc.next();
        sc.nextLine();
        boolean check = false;
        for(NhanVien nv: lsNv){
            if(nv.getManv().equalsIgnoreCase(manv)){
                lsNv.remove(nv);
                System.out.println("Xoa nhan vien theo ma thanh cong nhan vien: "+manv);
                check = true;
                break;
            }
        }
        
        if(!check){
            System.out.println("Khong tim thay ma nv: "+manv);
        }
    }
    public static void timNhanVienTheoKhoangLuong(){
        System.out.println("Tim nhan vien theo khoang luong tu ");
        System.out.println("Luong min ");
        double luongMin = Double.parseDouble(sc.nextLine());
        System.out.println("Luong max");
        double luongMax = Double.parseDouble(sc.nextLine());
        boolean kt = false;
        for(NhanVien nv: lsNv){
            if(nv.getLuong() >=luongMin && nv.getLuong() <=luongMax){
                kt = true;
                nv.xuatThongTin();
                break;
            }
        }
        if(!kt){
            System.out.println("khong tim thay nhan vien theo khoang luong tu "+luongMin+" den "+luongMax);
        }
    }
    public static void sapXepNhanVienTheoHoTen(){
        Collections.sort(lsNv, (args0,args1) -> args0.getHoTen().compareTo(args1.getHoTen()));
    }
    public static void sapXepNhanVienTheoThuNhap(){
        Comparator comp = new Comparator<NhanVien>() {
            @Override
            public int compare(NhanVien o1, NhanVien o2) {
                if(o1.getThuNhap() > o2.getThuNhap()) return 1;
                else return -1;
            }
        };
    }
    public static void xuat5NhanVienThuNhapCao(){
        Collections.sort(lsNv, (a,b) -> (int)(b.getThuNhap() - a.getThuNhap()));
        for(int i=0; i<5; i++){
            lsNv.get(i).xuatThongTin();
            System.out.println("=======================");
        }
    }
    public static void main(String[] args) {
        
        int chon;
        int tiepTuc = 0;
        do {
            System.out.println("================== MOI BAN CHON ==================");
            System.out.println("============================================================");
            System.out.println("=== 1.Nhap danh sach nhan vien tu ban phim.                ||");
            System.out.println("=== 2.Xuat danh sach nhan vien ra man hinh.                ||");
            System.out.println("=== 3.Tim va hien thi nhan vien theo ma nhap tu ban phim   ||");
            System.out.println("=== 4.Xoa nhan vien theo ma nhap tu ban phim.              ||");
            System.out.println("=== 5.Cap nhat thong tin nhan vien theo ma nhap tu ban phim||");
            System.out.println("=== 6.Tim cac nhan vien theo khoang luong                  ||");
            System.out.println("=== 7.Sap xep nhan vien theo ho va ten.                    ||");
            System.out.println("=== 8.Sap xep nhan vien theo thu nhap                      ||");
            System.out.println("=== 9.Xuat 5 nhan vien co thu nhap cao nhat                ||");
            System.out.println("=== 0.Ket thuc                                             ||");
            System.out.println("11.Tiep tuc");
            System.out.println("============================================================");
            chon = Integer.parseInt(sc.nextLine());
            while(chon<0 || chon>9){
                System.out.println("Ban phai chon tu 0 - 9 hoac 11");
                chon = Integer.parseInt(sc.nextLine());
            }
            switch (chon) {
            case 1:
                System.out.println("chon 1");
//                nhapNhanVien();
                nhap();
                break;
            case 2:
                System.out.println("chon 2");
                hienThiNhanVien();
                break;
            case 3: 
                System.out.println("chon 3");
                timKiemTheoMa();
                break;
            case 4:
                System.out.println("chon 4");
                xoaTheoMa();
                break;
            case 5:
                System.out.println("chon 5");
                capNhatThongTinNv();
                break;
            case 6:    
                System.out.println("chon 6");
                timNhanVienTheoKhoangLuong();
                break;
            case 7:    
                System.out.println("chon 7");
                sapXepNhanVienTheoHoTen();
                hienThiNhanVien();
                break;
            case 8:
                System.out.println("chon 8");
                sapXepNhanVienTheoThuNhap();
                hienThiNhanVien();
                break;
            case 9:
                System.out.println("chon 9");
                xuat5NhanVienThuNhapCao();
                break;
            default:
                System.out.println("Chuc nang ban chon khong co, ban vui long chon lai");
        } 
            System.out.println("Nhap 11 neu ban muon chon tiep tuc");
            tiepTuc = Integer.parseInt(sc.nextLine());
        }while(tiepTuc == 11);
        
    }
}
