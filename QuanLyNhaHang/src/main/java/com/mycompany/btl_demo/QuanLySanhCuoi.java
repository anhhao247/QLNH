/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.btl_demo;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author anhhao
 */
public class QuanLySanhCuoi {

    private List<SanhCuoi> ds = new ArrayList<>();
    Scanner scan = new Scanner(System.in);

    public QuanLySanhCuoi() throws FileNotFoundException {
        docFile();
    }

    public void docFile() throws FileNotFoundException {
        try {
            File file = new File("SanhCuoi.txt");
            Scanner s = new Scanner(file);
            while (s.hasNextLine()) {
                SanhCuoi sanh = new SanhCuoi();
                sanh.setMaSanh(s.nextLine());
                sanh.setTenSanh(s.nextLine());
                sanh.setViTri(s.nextLine());
                sanh.setSucChua(Integer.parseInt(s.nextLine()));
                sanh.setGiaCoBan(Double.parseDouble(s.nextLine()));
                this.ds.add(sanh);
            }
        } catch (Exception e) {
            System.out.println("Danh sach sanh cuoi trong!!!");
        }
    }

    public void ghiFile() throws FileNotFoundException {
        File file = new File("SanhCuoi.txt");
        try (PrintWriter pw = new PrintWriter(file)) {
            for (SanhCuoi s : this.ds) {
                pw.println(s.getMaSanh());
                pw.println(s.getTenSanh());
                pw.println(s.getViTri());
                pw.println(s.getSucChua());
                pw.println(s.getGiaCoBan());
            }
        }
    }

    public void themSanh(SanhCuoi sanh) {
        this.ds.add(sanh);
    }

    public void xoaSanh(SanhCuoi sanh) {
        this.ds.remove(sanh);
    }

    public void capNhatSanh(SanhCuoi sanh) {
        sanh.nhapSanh();
    }

    public SanhCuoi timKiemTheoId(String id) {
        for (SanhCuoi s : this.ds) {
            if (s.getMaSanh().equalsIgnoreCase(id)) {
                return s;
            }
        }
        return null;
    }

    public List<SanhCuoi> timKiem(String kw) {
        List<SanhCuoi> kq = new ArrayList<>();
        for (SanhCuoi s : this.ds) {
            if (s.getTenSanh().equalsIgnoreCase(kw) || s.getViTri().equalsIgnoreCase(kw)) {
                kq.add(s);
            }
        }
        return kq;
    }

    public List<SanhCuoi> timKiem(int sucChua) {
        List<SanhCuoi> kq = new ArrayList<>();
        for (SanhCuoi s : this.ds) {
            if (s.getSucChua() == sucChua) {
                kq.add(s);
            }
        }
        return kq;
    }

    public void sapXepSanh(int nam) {
        List<SanhCuoi> sx = new ArrayList<>();
        sx.addAll(this.ds);
        Collections.sort(sx, new Comparator<SanhCuoi>() {
            @Override
            public int compare(SanhCuoi o1, SanhCuoi o2) {
                return o2.tanSoThueSanh(nam) - o1.tanSoThueSanh(nam);
            }
        });
        for (SanhCuoi s : sx) {
            System.out.printf("%-20s%-12d\n", s.getTenSanh(), s.tanSoThueSanh(nam));
        }
    }

    public void hienThi() {
        this.ds.forEach(s -> s.hienThi());
    }

    public void menu() throws FileNotFoundException {
//        docFile();
        try {
            int choose;
            do {
                System.out.println("=============== QUAN LY SANH CUOI ===============");
                System.out.println("1. Them sanh cuoi");
                System.out.println("2. Xoa sanh cuoi");
                System.out.println("3. Cap nhat sanh cuoi");
                System.out.println("4. Tra cuu sanh cuoi");
                System.out.println("5. Hien thi danh sach sanh cuoi");
                System.out.println("6. Luu thong tin");
                System.out.println("0. Thoat");
                System.out.print(">>>CHON: ");
                choose = Integer.parseInt(scan.nextLine());

                switch (choose) {
                    case 1:
                        SanhCuoi sanh = new SanhCuoi();
                        sanh.nhapSanh();
                        themSanh(sanh);
                        System.out.println("Them sanh thanh cong!");
                        break;
                    case 2:
                        QuanLyBuaTiec ql = new QuanLyBuaTiec();
                        QuanLyThucPham qlTP = new QuanLyThucPham();
                        qlTP.docFileTA();
                        qlTP.docFileTU();
                        QuanLyDichVu qlDV = new QuanLyDichVu();
                        qlDV.docFile("Karaoke.txt");
                        qlDV.docFile("TrangTri.txt");
                        qlDV.docFile("ThueCaSi.txt");
                        ql.docFile(this.ds, qlTP.getDs(), qlDV.getDs());
                        System.out.print("Nhap ID sanh cuoi can xoa: ");
                        String id = scan.nextLine();
                        if (timKiemTheoId(id) != null) {
                            ql.xoaBuaTiecTheoSanh(timKiemTheoId(id));
                            xoaSanh(timKiemTheoId(id));
                            System.out.println("Da xoa sanh");
                        } else {
                            System.out.println("Khong tim thay sanh can xoa");
                        }
                        break;
                    case 3:
                        System.out.println("Nhap ID sanh can cap nhat: ");
                        String id2 = scan.nextLine();
                        if (timKiemTheoId(id2) != null) {
                            capNhatSanh(timKiemTheoId(id2));
                            System.out.println("Cap nhat sanh thanh cong!");
                        } else {
                            System.out.println("Khong tim thay sanh can cap nhat!");
                        }
                        break;
                    case 4:
                        int tmp;
                        do {
                            System.out.println("===== TRA CUU SANH =====");
                            System.out.println("1. Tra cuu theo ten");
                            System.out.println("2. Tra cuu theo vi tri");
                            System.out.println("3. Tra cuu theo suc chua");
                            System.out.println("0. Quay lai");
                            System.out.println(">>>CHON: ");
                            tmp = Integer.parseInt(scan.nextLine());
                            switch (tmp) {
                                case 1:
                                    System.out.print("Nhap ten: ");
                                    String kw = scan.nextLine();
                                    System.out.printf("%-7s%-30s%-12s%-12s%-10s\n", "ID", "NAME", "LOCALTION", "SUC CHUA", "GIA CO BAN");
                                    timKiem(kw).forEach(s -> s.hienThi());
                                    break;
                                case 2:
                                    System.out.print("Nhap vi tri: ");
                                    String kw2 = scan.nextLine();
                                    System.out.printf("%-7s%-30s%-12s%-12s%-10s\n", "ID", "NAME", "LOCALTION", "SUC CHUA", "GIA CO BAN");
                                    timKiem(kw2).forEach(s -> s.hienThi());
                                    break;
                                case 3:
                                    System.out.print("Nhap suc chua: ");
                                    int vt = Integer.parseInt(scan.nextLine());
                                    System.out.printf("%-7s%-30s%-12s%-12s%-10s\n", "ID", "NAME", "LOCALTION", "SUC CHUA", "GIA CO BAN");
                                    timKiem(vt).forEach(s -> s.hienThi());
                                    break;
                                case 0:
                                    break;
                                default:
                                    System.out.println("Nhap lai!!!");
                            }
                        } while (tmp != 0);
                        break;
                    case 5:
                        System.out.printf("%-7s%-30s%-12s%-12s%-10s\n", "ID", "NAME", "LOCALTION", "SUC CHUA", "GIA CO BAN");
                        hienThi();
                        break;
                    case 6:
                        ghiFile();
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

    /**
     * @return the ds
     */
    public List<SanhCuoi> getDs() {
        return ds;
    }

}
