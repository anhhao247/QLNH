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
public class ThucUong extends ThucPham{
    
    private String nhaSX;
    Scanner scan = new Scanner(System.in);
    

    public ThucUong() {
    }

    public ThucUong(String tenTP, double giaTP, String nhaSX) {
        super(tenTP, giaTP);
        this.nhaSX = nhaSX;
    }

    public ThucUong(String maTP, String tenTP, double giaTP, String nhaSX) {
        super(maTP, tenTP, giaTP);
        this.nhaSX = nhaSX;
    }
    
    
    
    @Override
    public void nhapTP() {
        System.out.print("Nhap ten thuc uong: ");
        setTenTP(scan.nextLine());
        System.out.print("Nhap gia: ");
        setGiaTP(Double.parseDouble(scan.nextLine()));
        System.out.print("Nhap nha san xuat: ");
        this.setNhaSX(scan.nextLine());
    }

    @Override
    public void hienThi() {
        System.out.printf("%-7s%-20s%-12.1f%-12s\n", this.getMaTP(), this.getTenTP(), this.getGiaTP(), this.getNhaSX());
    }

   

    /**
     * @return the nhaSX
     */
    public String getNhaSX() {
        return nhaSX;
    }

    /**
     * @param nhaSX the nhaSX to set
     */
    public void setNhaSX(String nhaSX) {
        this.nhaSX = nhaSX;
    }
    
    
}
