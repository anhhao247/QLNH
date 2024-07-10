/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.btl_demo;

import java.io.FileNotFoundException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author anhhao
 */
public class BuaTiec {

    private static int dem;
    private String maBuaTiec;
    private String tenBuaTiec;
    private SanhCuoi sanhThue;
    private double giaThueSanh;
    private ThoiDiemThue thoiDiemThue;
    private LocalDate ngayThue;
    private List<ThucPham> menu = new ArrayList<>();
    private List<DichVu> listDV = new ArrayList<>();
    private double donGiaMenu;
    private double donGiaDV;
    private int soLuongBan;
    DateTimeFormatter f = DateTimeFormatter.ofPattern("dd/MM/yyyy");
    Scanner scan = new Scanner(System.in);

    {
        this.setMaBuaTiec(String.format("BT%03d", ++dem));
    }

    public BuaTiec() {
    }

    public void nhapBuaTiec() {
        System.out.print(">>> Nhap ten bua tiec: ");
        this.tenBuaTiec = scan.nextLine();
        System.out.print(">>> Nhap ngay thue (dd/MM/yyyy): ");
        LocalDate tmp = LocalDate.parse(scan.nextLine(), f);
        while (true) {
            if (LocalDate.now().isAfter(tmp)) {
                System.out.println("Nhap lai!!");
                System.out.print(">>> Nhap ngay thue (dd/MM/yyyy): ");
                tmp = LocalDate.parse(scan.nextLine(), f);
            } else {
                break;
            }
        }
        this.ngayThue = tmp;
        for (ThoiDiemThue t : ThoiDiemThue.values()) {
            System.out.println(t.id + ". " + t);
        }
        System.out.print(">>> Chon buoi thue: ");
        int td = Integer.parseInt(scan.nextLine());
        for (ThoiDiemThue t : ThoiDiemThue.values()) {
            if (t.id == td) {
                this.thoiDiemThue = t;
            }
        }
    }

    public void nhapSanhThue() throws FileNotFoundException {
        QuanLySanhCuoi qlS = new QuanLySanhCuoi();
//        qlS.docFile();
        qlS.getDs().forEach(s -> s.hienThi());
        System.out.println(">>>Chon sanh cuoi (ID): ");
        String id = scan.nextLine();
        for (SanhCuoi s : qlS.getDs()) {
            if (s.getMaSanh().equalsIgnoreCase(id)) {
                this.sanhThue = s;
            }
        }
        this.giaThueSanh = this.getThoiDiemThue().giaThue(this.getSanhThue().getGiaCoBan(), this.ngayThue);
        while (true) {

            try {
                System.out.print(">>>Nhap so luong ban: ");
                int tmp = Integer.parseInt(scan.nextLine());
                if (tmp > this.sanhThue.getSucChua()) {
                    System.out.println("Qua suc chua cua " + this.sanhThue.getTenSanh());
                } else {
                    this.soLuongBan = tmp;
                    break;
                }
            } catch (Exception e) {
            }

        }

    }

    public void nhapMenu() throws FileNotFoundException {
        QuanLyThucPham qlTP = new QuanLyThucPham();
        qlTP.hienThi();
        System.out.print(">>>Chon thuc pham (ID), an 0 de hoan tat: ");
        while (true) {
            String idTA = scan.nextLine();
            if (idTA.equalsIgnoreCase("0")) {
                break;
            } else {
                for (ThucPham s : qlTP.getDs()) {
                    if (s.getMaTP().equalsIgnoreCase(idTA)) {
                        getMenu().add(s);
                    }
                }
            }
        }
        for (ThucPham tp : getMenu()) {
            this.donGiaMenu += tp.getGiaTP();
        }
    }

    public void nhapDsDv() throws FileNotFoundException {
        QuanLyDichVu qlDV = new QuanLyDichVu();
//        qlDV.docFile("Karaoke.txt");
//        qlDV.docFile("ThueCaSi.txt");
//        qlDV.docFile("TrangTri.txt");
        qlDV.hienThi();
        System.out.print(">>>Chon dich vu (ID), an 0 de hoan tat: ");
        while (true) {
            String idDV = scan.nextLine();
            if (idDV.equalsIgnoreCase("0")) {
                break;
            } else {
                for (DichVu dv : qlDV.getDs()) {
                    if (idDV.equalsIgnoreCase(dv.getMaDV())) {
                        if (dv instanceof Karaoke) {
                            System.out.print("Nhap thoi gian thue: ");
                            ((Karaoke) dv).setThoiGianThue(Double.parseDouble(scan.nextLine()));
                            ((Karaoke) dv).tinhTien();
                        }
                        if (dv instanceof TrangTri) {
                            System.out.print("Nhap yeu cau: ");
                            ((TrangTri) dv).setYeuCau(scan.nextLine());
                        }
                        if (dv instanceof ThueCaSi) {
                            System.out.print("Nhap so luong bai hat: ");
                            ((ThueCaSi) dv).setSoBaiHat(Integer.parseInt(scan.nextLine()));
                            ((ThueCaSi) dv).tinhTien();
                        }
                        this.listDV.add(dv);
                    }
                }
            }
        }
        for (DichVu dv : getListDV()) {
            this.donGiaDV += dv.getGiaDV();
        }
    }

    public void hienThi() {
        System.out.println("===========================================================================");
        System.out.printf("%-20s%s\n", "Ma bua tiec:", this.getMaBuaTiec());
        System.out.printf("%-20s%s\n%-20s%s\n%-20s%d\n%-20s%.1f\n%-20s%s\n%-20s%s\n",
                "Ten bua tiec:", this.tenBuaTiec, "Sanh cuoi:", this.sanhThue.getTenSanh(), "So ban:", this.soLuongBan, "Don gia thue sanh:", this.giaThueSanh, "Thoi diem thue:", this.thoiDiemThue, "Ngay thue:", f.format(this.ngayThue));
        System.out.println("********************** MEMU **********************");
        System.out.println("THUC AN");
        for (ThucPham tp : getMenu()) {
            if (tp instanceof ThucAn) {
                tp.hienThi();
            }
        }
        System.out.println("THUC UONG");
        for (ThucPham tp : getMenu()) {
            if (tp instanceof ThucUong) {
                tp.hienThi();
            }
        }
        System.out.printf("Don gia menu: %.1f\n", this.getDonGiaMenu());
        System.out.println("********************* DICH VU ********************");
        getListDV().forEach(s -> s.hienThi());
        System.out.printf("Don gia dich vu: %.1f\n", this.getDonGiaDV());
    }

    public double tinhTienBuaTiec(BuaTiec bt) {
        return bt.getGiaThueSanh() + bt.getDonGiaMenu() * bt.getSoLuongBan() + bt.getDonGiaDV();
    }

    /**
     * @return the tenBuaTiec
     */
    public String getTenBuaTiec() {
        return tenBuaTiec;
    }

    /**
     * @param tenBuaTiec the tenBuaTiec to set
     */
    public void setTenBuaTiec(String tenBuaTiec) {
        this.tenBuaTiec = tenBuaTiec;
    }

    /**
     * @return the sanhThue
     */
    public SanhCuoi getSanhThue() {
        return sanhThue;
    }

    /**
     * @param sanhThue the sanhThue to set
     */
    public void setSanhThue(SanhCuoi sanhThue) {
        this.sanhThue = sanhThue;
    }

    /**
     * @return the giaThueSanh
     */
    public double getGiaThueSanh() {
        return giaThueSanh;
    }

    /**
     * @param giaThueSanh the giaThueSanh to set
     */
    public void setGiaThueSanh(double giaThueSanh) {
        this.giaThueSanh = giaThueSanh;
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

    /**
     * @return the ngayThue
     */
    public LocalDate getNgayThue() {
        return ngayThue;
    }

    /**
     * @param ngayThue the ngayThue to set
     */
    public void setNgayThue(LocalDate ngayThue) {
        this.ngayThue = ngayThue;
    }

    /**
     * @return the menu
     */
    public List<ThucPham> getMenu() {
        return menu;
    }

    /**
     * @param menu the menu to set
     */
    public void setMenu(List<ThucPham> menu) {
        this.menu = menu;
    }

    /**
     * @return the listDV
     */
    public List<DichVu> getListDV() {
        return listDV;
    }

    /**
     * @param listDV the listDV to set
     */
    public void setListDV(List<DichVu> listDV) {
        this.listDV = listDV;
    }

    /**
     * @return the donGiaMenu
     */
    public double getDonGiaMenu() {
        return donGiaMenu;
    }

    /**
     * @param donGiaMenu the donGiaMenu to set
     */
    public void setDonGiaMenu(double donGiaMenu) {
        this.donGiaMenu = donGiaMenu;
    }

    /**
     * @return the donGiaDV
     */
    public double getDonGiaDV() {
        return donGiaDV;
    }

    /**
     * @param donGiaDV the donGiaDV to set
     */
    public void setDonGiaDV(double donGiaDV) {
        this.donGiaDV = donGiaDV;
    }

    /**
     * @return the maBuaTiec
     */
    public String getMaBuaTiec() {
        return maBuaTiec;
    }

    /**
     * @param maBuaTiec the maBuaTiec to set
     */
    public void setMaBuaTiec(String maBuaTiec) {
        this.maBuaTiec = maBuaTiec;
    }

    public int getSoLuongBan() {
        return soLuongBan;
    }

    public void setSoLuongBan(int soLuongBan) {
        this.soLuongBan = soLuongBan;
    }

    @Override
    public String toString() {
        String kw = "";
        kw = this.maBuaTiec + ";" + this.tenBuaTiec + ";" + this.sanhThue.getTenSanh() + ";" + this.soLuongBan + ";" + this.thoiDiemThue + ";"
                + this.f.format(this.ngayThue) + ";" + this.giaThueSanh + ";" + this.donGiaMenu + ";" + this.donGiaDV + ";";
        for (ThucPham tp : menu) {
            kw += tp.getMaTP() + "#";
        }
        kw += ";";
        for (DichVu dv : listDV) {
            kw += dv.getMaDV() + "#";
        }
        kw += ";";
        return kw;
    }
}
