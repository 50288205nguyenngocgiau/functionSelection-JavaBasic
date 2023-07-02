/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.asm1;

import static com.mycompany.asm1.Asm1.lsNv;
import static com.mycompany.asm1.Asm1.sc;

/**
 *
 * @author giau7
 */
public class NhanVien {
    private String manv;
    private String hoTen;
    private double luong;

    public NhanVien(String manv, String hoTen, double luong) {
        this.manv = manv;
        this.hoTen = hoTen;
        this.luong = luong;
    }
    public NhanVien(){
        
    }

    public String getManv() {
        return manv;
    }

    public void setManv(String manv) {
        this.manv = manv;
    }

    public String getHoTen() {
        return hoTen;
    }

    public void setHoTen(String hoTen) {
        this.hoTen = hoTen;
    }

    public double getLuong() {
        return luong;
    }

    public void setLuong(double luong) {
        this.luong = luong;
    }
    public double getThuNhap(){
        return getLuong()-((getLuong()*getThueThuNhap()) /100);
    }
    public double getThueThuNhap(){
        double luong = getLuong();
        if(luong < 9){
            return 0;
        }else if(luong >=9 && luong <=15){
            return 10;
        }
        return 12;
    }
    public void xuatThongTin(){
        System.out.println("Ma nhan vien: "+getManv());
        System.out.println("Ten nhan vien: "+getHoTen());
        System.out.println("Luong nhan vien: "+getLuong());
        System.out.println("Thue thu nhap: "+getThueThuNhap());
        System.out.println("Thu nhap: "+getThuNhap());
    }
    public static void nhap(){
          
    }
}
