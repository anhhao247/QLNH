/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.btl_demo;

/**
 *
 * @author anhhao
 */
public abstract class ThucPham {
    private static int dem;
    private String maTP;
    private String tenTP;
    private double giaTP;

    {
        this.maTP = String.format("F%03d", ++dem);
    }
    
    public ThucPham() {
    }
    
    public ThucPham(String tenTP, double giaTP) {
        this.tenTP = tenTP;
        this.giaTP = giaTP;
    }

    public ThucPham(String maTP, String tenTP, double giaTP) {
        this.maTP = maTP;
        this.tenTP = tenTP;
        this.giaTP = giaTP;
    }

    
    
    public abstract void nhapTP();
    public abstract void hienThi();
    
    /**
     * @return the tenTP
     */
    public String getTenTP() {
        return tenTP;
    }

    /**
     * @param tenTP the tenTP to set
     */
    public void setTenTP(String tenTP) {
        this.tenTP = tenTP;
    }

    /**
     * @return the giaTP
     */
    public double getGiaTP() {
        return giaTP;
    }

    /**
     * @param giaTP the giaTP to set
     */
    public void setGiaTP(double giaTP) {
        this.giaTP = giaTP;
    }

    /**
     * @return the maTP
     */
    public String getMaTP() {
        return maTP;
    }

    /**
     * @param maTP the maTP to set
     */
    public void setMaTP(String maTP) {
        this.maTP = maTP;
    }
    
    
}
