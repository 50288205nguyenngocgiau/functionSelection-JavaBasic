/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.asm1;

/**
 *
 * @author giau7
 */
public class TiepThi extends NhanVien{
    private double doanhSo;
    private double hueHong;

    public TiepThi(double doanhSo, double hueHong, String manv, String hoTen, double luong) {
        super(manv, hoTen, luong);
        this.doanhSo = doanhSo;
        this.hueHong = hueHong;
    }

    public TiepThi(double doanhSo, double hueHong) {
        this.doanhSo = doanhSo;
        this.hueHong = hueHong;
    }
    
    public TiepThi(){
        
    }

    public double getDoanhSo() {
        return doanhSo;
    }

    public void setDoanhSo(double doanhSo) {
        this.doanhSo = doanhSo;
    }

    public double getHueHong() {
        return hueHong;
    }

    public void setHueHong(double hueHong) {
        this.hueHong = hueHong;
    }

    @Override
    public double getThuNhap() {
        return super.getThuNhap()+getHueHong()+getDoanhSo(); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/OverriddenMethodBody
    }

    @Override
    public void xuatThongTin() {
        super.xuatThongTin(); 
        System.out.println("Doanh so: "+getDoanhSo());
        System.out.println("Hue hong: "+getHueHong());
    }
    
    
}
