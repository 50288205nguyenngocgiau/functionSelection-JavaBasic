/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.asm1;

/**
 *
 * @author giau7
 */
public class TruongPhong extends NhanVien{
    private double trachNhiem;

    public TruongPhong(double trachNhiem, String manv, String hoTen, double luong) {
        super(manv, hoTen, luong);
        this.trachNhiem = trachNhiem;
    }

    public TruongPhong(double trachNhiem) {
        this.trachNhiem = trachNhiem;
    }
    
    public TruongPhong(){
        
    }

    public double getTrachNhiem() {
        return trachNhiem;
    }

    public void setTrachNhiem(double trachNhiem) {
        this.trachNhiem = trachNhiem;
    }

    @Override
    public double getThuNhap() {
        return super.getThuNhap()+getTrachNhiem(); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/OverriddenMethodBody
    }

    @Override
    public void xuatThongTin() {
        super.xuatThongTin();
        System.out.println("Luong trach nhiem: "+getTrachNhiem());
    }
    
}
