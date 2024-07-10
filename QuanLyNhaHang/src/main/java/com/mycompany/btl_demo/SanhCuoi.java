/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.btl_demo;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author anhhao
 */
public class SanhCuoi {

    private static int dem;
    private String maSanh;
    private String tenSanh;
    private String viTri;
    private int sucChua;
    private double giaCoBan;
    private double giaThue;
    private ThoiDiemThue thoiDiemThue;
    private List<BuaTiec> listBT;
    Scanner scan = new Scanner(System.in);

    {
        this.maSanh = String.format("S%03d", ++dem);
    }

    public SanhCuoi() {
        this.listBT = new ArrayList<>();
    }

    public SanhCuoi(String tenSanh, String viTri, int sucChua, double giaCoBan) {
        this.tenSanh = tenSanh;
        this.viTri = viTri;
        this.sucChua = sucChua;
        this.giaCoBan = giaCoBan;
    }

    public void nhapSanh() {
        System.out.println("========== NHAP THONG TIN SANH CUOI ===========");
        System.out.print("Nhap ten sanh: ");
        this.tenSanh = scan.nextLine();
        System.out.print("Nhap vi tri: ");
        this.viTri = scan.nextLine();
        System.out.print("Nhap suc chua: ");
        this.sucChua = Integer.parseInt(scan.nextLine());
        System.out.print("Nhap gia co ban: ");
        this.giaCoBan = Double.parseDouble(scan.nextLine());
    }

    public void themBuaTiec(BuaTiec bt){
        this.listBT.add(bt);
    }
    
    public int tanSoThueSanh(int nam){
        int dem = 0;
        for(BuaTiec bt : this.listBT){
            if(bt.getNgayThue().getYear() == nam){
                dem++;
            }
        }
        return dem;
    }
    
    public void hienThi() {
        System.out.printf("%-7s%-30s%-12s%-12d%-10.1f\n",
                this.maSanh, this.tenSanh, this.viTri, this.sucChua, this.giaCoBan);
    }

    
    /**
     * @return the maSanh
     */
    public String getMaSanh() {
        return maSanh;
    }

    /**
     * @param maSanh the maSanh to set
     */
    public void setMaSanh(String maSanh) {
        this.maSanh = maSanh;
    }

    /**
     * @return the tenSanh
     */
    public String getTenSanh() {
        return tenSanh;
    }

    /**
     * @param tenSanh the tenSanh to set
     */
    public void setTenSanh(String tenSanh) {
        this.tenSanh = tenSanh;
    }

    /**
     * @return the viTri
     */
    public String getViTri() {
        return viTri;
    }

    /**
     * @param viTri the viTri to set
     */
    public void setViTri(String viTri) {
        this.viTri = viTri;
    }

    /**
     * @return the sucChua
     */
    public int getSucChua() {
        return sucChua;
    }

    /**
     * @param sucChua the sucChua to set
     */
    public void setSucChua(int sucChua) {
        this.sucChua = sucChua;
    }

    /**
     * @return the giaCoBan
     */
    public double getGiaCoBan() {
        return giaCoBan;
    }

    /**
     * @param giaCoBan the giaCoBan to set
     */
    public void setGiaCoBan(double giaCoBan) {
        this.giaCoBan = giaCoBan;
    }

    /**
     * @return the giaThue
     */
    public double getGiaThue() {
        return giaThue;
    }

    /**
     * @param giaThue the giaThue to set
     */
    public void setGiaThue(double giaThue) {
        this.giaThue = giaThue;
    }

    /**
     * @return the thoiDiemThue
     */
    public ThoiDiemThue getThoiDiemThue() {
        return thoiDiemThue;
    }

    /**
     * @param thoiDiemThue the thoiDiemThue to set
     */
    public void setThoiDiemThue(ThoiDiemThue thoiDiemThue) {
        this.thoiDiemThue = thoiDiemThue;
    }

   

    public List<BuaTiec> getListBT() {
        return listBT;
    }

    public void setListBT(List<BuaTiec> listBT) {
        this.listBT = listBT;
    }
    
    
}
