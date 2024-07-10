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
public abstract class DichVu {

    private static int dem;
    private String maDV;
    private String tenDV;
    private double giaDV;
    Scanner scan = new Scanner(System.in);

    {
        this.maDV = String.format("DV%03d", ++dem);
    }

    public DichVu() {
    }

    public DichVu(String tenDV, double giaDV) {
        this.tenDV = tenDV;
        this.giaDV = giaDV;
    }

    public abstract void nhapDV();

    public abstract void hienThi();

    /**
     * @return the maDV
     */
    public String getMaDV() {
        return maDV;
    }

    /**
     * @param maDV the maDV to set
     */
    public void setMaDV(String maDV) {
        this.maDV = maDV;
    }

    /**
     * @return the tenDV
     */
    public String getTenDV() {
        return tenDV;
    }

    /**
     * @param tenDV the tenDV to set
     */
    public void setTenDV(String tenDV) {
        this.tenDV = tenDV;
    }

    /**
     * @return the giaDV
     */
    public double getGiaDV() {
        return giaDV;
    }

    /**
     * @param giaDV the giaDV to set
     */
    public void setGiaDV(double giaDV) {
        this.giaDV = giaDV;
    }
}
