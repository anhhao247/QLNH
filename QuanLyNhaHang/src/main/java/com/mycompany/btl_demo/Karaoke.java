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
public class Karaoke extends DichVu {

    private double thoiGianThue;
    Scanner scan = new Scanner(System.in);

    public Karaoke() {
    }

    public Karaoke(String tenDV, double giaDV) {
        super(tenDV, giaDV);
    }

    public Karaoke(String tenDV, double giaDV, double thoiGianThue) {
        super(tenDV, giaDV * thoiGianThue);
        this.thoiGianThue = thoiGianThue;
    }

    @Override
    public void nhapDV() {
        System.out.print("Nhap ten dich vu: ");
        super.setTenDV(scan.nextLine());
        System.out.print("Nhap gia dich vu: ");
        super.setGiaDV(Double.parseDouble(scan.nextLine()));
    }

    @Override
    public void hienThi() {
        System.out.printf("%-8s%-30s%-12.1f\n", this.getMaDV(), this.getTenDV(), this.getGiaDV());
    }

    public void hienThiFull() {
        System.out.printf("%-8s%-30s%-12.1f%-12d\n", this.getMaDV(), this.getTenDV(), this.getGiaDV(), this.thoiGianThue);
    }

    public void tinhTien() {
        this.setGiaDV(this.thoiGianThue * this.getGiaDV());
    }

    /**
     * @return the thoiGianThue
     */
    public double getThoiGianThue() {
        return thoiGianThue;
    }

    /**
     * @param thoiGianThue the thoiGianThue to set
     */
    public void setThoiGianThue(double thoiGianThue) {
        this.thoiGianThue = thoiGianThue;
    }

    @Override
    public String toString() {
        return this.getMaDV() + "\n" + this.getTenDV() + "\n" + this.getGiaDV();
    }
}
