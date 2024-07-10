/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.btl_demo;

/**
 *
 * @author anhhao
 */
public class TrangTri extends DichVu {

    private String yeuCau;

    public TrangTri() {
    }

    public TrangTri(String tenDV, double giaDV) {
        super(tenDV, giaDV);
    }

    public TrangTri(String tenDV, double giaDV, String yeuCau) {
        super(tenDV, giaDV);
        this.yeuCau = yeuCau;
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
        System.out.printf("%-8s%-30s%-12.1f%-30s\n", this.getMaDV(), this.getTenDV(), this.getGiaDV(), this.yeuCau);
    }

    /**
     * @return the yeuCau
     */
    public String getYeuCau() {
        return yeuCau;
    }

    /**
     * @param yeuCau the yeuCau to set
     */
    public void setYeuCau(String yeuCau) {
        this.yeuCau = yeuCau;
    }

    @Override
    public String toString() {
        return this.getMaDV() + "\n" + this.getTenDV() + "\n" + this.getGiaDV();
    }

}
