/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.btl_demo;

/**
 *
 * @author anhhao
 */
public class ThueCaSi extends DichVu {

    private String tenCaSi;
    private int soBaiHat;

    public ThueCaSi() {
    }

    public ThueCaSi(String tenDV, double giaDV) {
        super(tenDV, giaDV);
    }

    public ThueCaSi(String tenDV, double giaDV, String tenCaSi) {
        super(tenDV, giaDV);
        this.tenCaSi = tenCaSi;
    }

    public ThueCaSi(String tenDV, double giaDV, String tenCaSi, int soBaiHat) {
        super(tenDV, giaDV * soBaiHat);
        this.tenCaSi = tenCaSi;
        this.soBaiHat = soBaiHat;
    }

    @Override
    public void nhapDV() {
        System.out.print("Nhap ten dich vu: ");
        super.setTenDV(scan.nextLine());
        System.out.print("Nhap ten ca si: ");
        this.setTenCaSi(scan.nextLine());
        System.out.print("Nhap gia thue ca si: ");
        super.setGiaDV(Double.parseDouble(scan.nextLine()));
    }

    @Override
    public void hienThi() {
        System.out.printf("%-8s%-30s%-12.1f%-20s\n", this.getMaDV(), this.getTenDV(), this.getGiaDV(), this.getTenCaSi());
    }

    public void hienThiFull() {
        System.out.printf("%-8s%-30s%-12.1f%-20s%-12d\n", this.getMaDV(), this.getTenDV(), this.getGiaDV(), this.getTenCaSi(), this.soBaiHat);
    }

    public void tinhTien() {
        this.setGiaDV(this.soBaiHat * this.getGiaDV());
    }

    /**
     * @return the tenCaSi
     */
    public String getTenCaSi() {
        return tenCaSi;
    }

    /**
     * @param tenCaSi the tenCaSi to set
     */
    public void setTenCaSi(String tenCaSi) {
        this.tenCaSi = tenCaSi;
    }

    /**
     * @return the soBaiHat
     */
    public int getSoBaiHat() {
        return soBaiHat;
    }

    /**
     * @param soBaiHat the soBaiHat to set
     */
    public void setSoBaiHat(int soBaiHat) {
        this.soBaiHat = soBaiHat;
    }

    @Override
    public String toString() {
        return this.getMaDV() + "\n" + this.getTenDV() + "\n" + this.getGiaDV() + "\n" + this.getTenCaSi();
    }

}
