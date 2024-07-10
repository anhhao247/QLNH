/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.btl_demo;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author anhhao
 */
public class QuanLyThucPham {

    private List<ThucPham> ds = new ArrayList<>();
    Scanner scan = new Scanner(System.in);

    public QuanLyThucPham() throws FileNotFoundException {
        docFileTA();
        docFileTU();
    }

    public void docFileTA() throws FileNotFoundException {
        try {
            File file = new File("ThucAn.txt");
            Scanner s = new Scanner(file);
            while (s.hasNextLine()) {
                String id = s.nextLine();
                String name = s.nextLine();
                double price = Double.parseDouble(s.nextLine());
                boolean isChay = Boolean.parseBoolean(s.nextLine());
                ThucPham tp = new ThucAn(id, name, price, isChay);
                this.ds.add(tp);
            }
        } catch (Exception e) {
            System.out.println("Danh sach thuc an trong!!!");
        }

    }

    public void docFileTU() throws FileNotFoundException {
        try {
            File file = new File("ThucUong.txt");
            Scanner s = new Scanner(file);
            while (s.hasNextLine()) {
                String id = s.nextLine();
                String name = s.nextLine();
                double price = Double.parseDouble(s.nextLine());
                String nhaSX = s.nextLine();
                ThucPham tp = new ThucUong(id, name, price, nhaSX);
                this.ds.add(tp);
            }
        } catch (Exception e) {
            System.out.println("Danh sach thuc uong trong!!!");
        }

    }

    public void ghiFileTA() throws FileNotFoundException {
        File file = new File("ThucAn.txt");
        try (PrintWriter pw = new PrintWriter(file)) {
            for (ThucPham s : this.ds) {
                if (s instanceof ThucAn) {
                    pw.println(s.getMaTP());
                    pw.println(s.getTenTP());
                    pw.println(s.getGiaTP());
                    pw.println(((ThucAn) s).isIsChay());
                }

            }
        }
    }

    public void ghiFileTU() throws FileNotFoundException {
        File file = new File("ThucUong.txt");
        try (PrintWriter pw = new PrintWriter(file)) {
            for (ThucPham s : this.ds) {
                if (s instanceof ThucUong) {
                    pw.println(s.getMaTP());
                    pw.println(s.getTenTP());
                    pw.println(s.getGiaTP());
                    pw.println(((ThucUong) s).getNhaSX());
                }
            }
        }
    }

    public void them(ThucPham tp) {
        this.ds.add(tp);
    }

    public void xoa(ThucPham tp) {
        this.ds.remove(tp);
    }

    public void capNhat(ThucPham tp) {
        tp.nhapTP();
    }

    public ThucPham timKiemTheoId(String id) {
        for (ThucPham s : this.ds) {
            if (s.getMaTP().equalsIgnoreCase(id)) {
                return s;
            }
        }
        return null;
    }

    public List<ThucPham> timKiem(String kw) {
        List<ThucPham> kq = new ArrayList<>();
        for (ThucPham s : this.ds) {
            if (s.getTenTP().equalsIgnoreCase(kw)) {
                kq.add(s);
            }
        }
        return kq;
    }

    public void hienThi() {
        Collections.sort(this.ds, new Comparator<ThucPham>() {
            @Override
            public int compare(ThucPham o1, ThucPham o2) {
                return o1.getMaTP().compareTo(o2.getMaTP());
            }

        });
        this.ds.forEach(s -> s.hienThi());
    }

    public void menuThucAn() throws FileNotFoundException {
        try {
            int choose;
            do {
                System.out.println("===== QUAN LY THUC AN ===========================================");
                System.out.println("1. Them thuc an");
                System.out.println("2. Xoa thuc an");
                System.out.println("3. Cap nhat thuc an");
                System.out.println("4. Tra cuu thuc an");
                System.out.println("5. Hien thi danh sach thuc an");
                System.out.println("6. Luu thong tin");
                System.out.println("0. Thoat");
                System.out.print(">>>CHON: ");
                choose = Integer.parseInt(scan.nextLine());

                switch (choose) {
                    case 1:
                        ThucPham ta = new ThucAn();
                        ta.nhapTP();
                        them(ta);
                        System.out.println("Them thuc an thanh cong!");
                        break;
                    case 2:
                        System.out.print(">>>Nhap ID thuc an can xoa: ");
                        String id = scan.nextLine();
                        if (timKiemTheoId(id) != null) {
                            xoa(timKiemTheoId(id));
                            System.out.println("Xoa thuc an thanh cong!");
                        } else {
                            System.out.println("Khong tim thay thuc an can xoa");
                        }
                        break;
                    case 3:
                        System.out.print(">>>Nhap ID thuc an can cap nhat: ");
                        String id2 = scan.nextLine();
                        if (timKiemTheoId(id2) != null) {
                            capNhat(timKiemTheoId(id2));
                            System.out.println("Cap nhat thanh cong!");
                        } else {
                            System.out.println("Khong tim thay thuc an can cap nhat!");
                        }
                        break;
                    case 4:
                        System.out.print(">>>Nhap ten thuc an can tra cuu: ");
                        String kw = scan.nextLine();
                        System.out.printf("%-7s%-20s%-12s%-12s\n", "ID", "NAME", "GIA", "AN CHAY");
                        timKiem(kw).forEach(s -> s.hienThi());
                        break;
                    case 5:
                        System.out.printf("%-7s%-20s%-12s%-12s\n", "ID", "NAME", "GIA", "AN CHAY");
                        for (ThucPham s : this.ds) {
                            if (s instanceof ThucAn) {
                                s.hienThi();
                            }
                        }
                        break;
                    case 6:
                        ghiFileTA();
                        break;
                    case 0:
                        break;
                    default:
                        System.out.println("Nhap lai!!!");
                }
            } while (choose != 0);
        } catch (Exception e) {
        }

    }

    public void menuThucUong() throws FileNotFoundException {
        try {
            int choose;
            do {
                System.out.println("===== QUAN LY THUC UONG ========================================");
                System.out.println("1. Them thuc uong");
                System.out.println("2. Xoa thuc uong");
                System.out.println("3. Cap nhat thuc uong");
                System.out.println("4. Tra cuu thuc uong");
                System.out.println("5. Hien thi danh sach thuc uong");
                System.out.println("6. Luu thong tin");
                System.out.println("0. Thoat");
                System.out.print(">>>CHON: ");
                choose = Integer.parseInt(scan.nextLine());

                switch (choose) {
                    case 1:
                        ThucPham tu = new ThucUong();
                        tu.nhapTP();
                        them(tu);
                        System.out.println("Them thuc uong thanh cong!");
                        break;
                    case 2:
                        System.out.print(">>>Nhap ID thuc uong can xoa: ");
                        String id = scan.nextLine();
                        if (timKiemTheoId(id) != null) {
                            xoa(timKiemTheoId(id));
                            System.out.println("Xoa thuc uong thanh cong!");
                        } else {
                            System.out.println("Khong tim thay thuc uong can xoa!");
                        }
                        break;
                    case 3:
                        System.out.print(">>>Nhap ID thuc uong can cap nhat: ");
                        String id2 = scan.nextLine();
                        if (timKiemTheoId(id2) != null) {
                            capNhat(timKiemTheoId(id2));
                            System.out.println("Cap nhat thanh cong!");
                        } else {
                            System.out.println("Khong tim thay thuc uong can cap nhat!");
                        }
                        break;
                    case 4:
                        System.out.print(">>>Nhap ten thuc uong can tra cuu: ");
                        String kw = scan.nextLine();
                        System.out.printf("%-7s%-20s%-12s%-12s\n", "ID", "NAME", "GIA", "NHA SAN XUAT");
                        timKiem(kw).forEach(s -> s.hienThi());
                        break;
                    case 5:
                        System.out.printf("%-7s%-20s%-12s%-12s\n", "ID", "NAME", "GIA", "NHA SAN XUAT");
                        for (ThucPham s : this.ds) {
                            if (s instanceof ThucUong) {
                                s.hienThi();
                            }
                        }
                        break;
                    case 6:
                        ghiFileTU();
                        break;
                    case 0:
                        break;
                    default:
                        System.out.println("Nhap lai!!!");
                }
            } while (choose != 0);
        } catch (Exception e) {
        }

    }

    public void menu() throws FileNotFoundException {
//        docFileTA();
//        docFileTU();
        try {
            int choose;
            do {
                System.out.println("============== QUAN LY THUC PHAM =================");
                System.out.println("1. Quan ly thuc an");
                System.out.println("2. Quan ly thuc uong");
                System.out.println("3. Hien thi menu");
                System.out.println("0. Thoat");
                System.out.print(">>>CHON: ");
                choose = Integer.parseInt(scan.nextLine());

                switch (choose) {
                    case 1:
                        menuThucAn();
                        break;
                    case 2:
                        menuThucUong();
                        break;
                    case 3:
                        hienThi();
                        break;
                    case 0:
                        break;
                    default:
                        System.out.println("Nhap lai!!!");
                }
            } while (choose != 0);
        } catch (Exception e) {
        }

    }

    public List<ThucPham> getDs() {
        return ds;
    }
}
