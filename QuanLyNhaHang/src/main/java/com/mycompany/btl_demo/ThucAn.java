/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.btl_demo;

import java.util.Scanner;

/**
 *
 * @author anhhao
 */
public class ThucAn extends ThucPham{
    
    private boolean isChay;
    Scanner scan = new Scanner(System.in);
    

    public ThucAn() {
    }

    public ThucAn(String tenTP, double giaTP, boolean isChay) {
        super(tenTP, giaTP);
        this.isChay = isChay;
    }

    public ThucAn(String maTP, String tenTP, double giaTP, boolean isChay) {
        super(maTP, tenTP, giaTP);
        this.isChay = isChay;
    }

    
    
    
    @Override
    public void nhapTP() {
        System.out.print("Nhap ten thuc an: ");
        setTenTP(scan.nextLine());
        System.out.print("Nhap gia: ");
        setGiaTP(Double.parseDouble(scan.nextLine()));
        System.out.print("Co an chay duoc khong: ");
        this.setIsChay(Boolean.parseBoolean(scan.nextLine()));
    }

    @Override
    public void hienThi() {
        System.out.printf("%-7s%-20s%-12.1f%-12s\n", this.getMaTP(), this.getTenTP(), this.getGiaTP(), this.isChay);
    }

    

    /**
     * @return the isChay
     */
    public boolean isIsChay() {
        return isChay;
    }

    /**
     * @param isChay the isChay to set
     */
    public void setIsChay(boolean isChay) {
        this.isChay = isChay;
    }
    
    
}
