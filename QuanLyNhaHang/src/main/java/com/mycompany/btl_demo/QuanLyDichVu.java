/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.btl_demo;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
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
public class QuanLyDichVu {

    private List<DichVu> ds = new ArrayList<>();
    Scanner scan = new Scanner(System.in);

    public QuanLyDichVu() throws FileNotFoundException {
        docFile("Karaoke.txt");
        docFile("TrangTri.txt");
        docFile("ThueCaSi.txt");
    }

    public void docFile(String fileName) throws FileNotFoundException {
        File file = new File(fileName);
        Scanner s = new Scanner(file);
        while (s.hasNextLine()) {
            String id = s.nextLine();
            String tenDV = s.nextLine();
            double gia = Double.parseDouble(s.nextLine());
            if (fileName.equals("Karaoke.txt")) {
                DichVu k = new Karaoke(tenDV, gia);
                k.setMaDV(id);
                this.ds.add(k);
            }
            if (fileName.equals("TrangTri.txt")) {
                DichVu k = new TrangTri(tenDV, gia);
                k.setMaDV(id);
                this.ds.add(k);
            }
            if (fileName.equals("ThueCaSi.txt")) {
                String tenCaSi = s.nextLine();
                DichVu k = new ThueCaSi(tenDV, gia, tenCaSi);
                k.setMaDV(id);
                this.ds.add(k);
            }
        }

    }

    public void ghiFile() throws FileNotFoundException {
        File file1 = new File("Karaoke.txt");
        File file2 = new File("TrangTri.txt");
        File file3 = new File("ThueCaSi.txt");
        PrintWriter pw1 = new PrintWriter(file1);
        PrintWriter pw2 = new PrintWriter(file2);
        PrintWriter pw3 = new PrintWriter(file3);
        // ghi vao file Karaoke
        for (DichVu dv : this.ds) {
            if (dv instanceof Karaoke) {
                pw1.println(dv.toString());
            }
        }
        // ghi vao file TrangTri
        for (DichVu dv : this.ds) {
            if (dv instanceof TrangTri) {
                pw2.println(dv.toString());
            }
        }
        // ghi vao file ThueCaSi
        for (DichVu dv : this.ds) {
            if (dv instanceof ThueCaSi) {
                pw3.println(dv.toString());
            }
        }
        pw1.close();
        pw2.close();
        pw3.close();
    }

    public void themDV(DichVu dv) {
        this.ds.add(dv);
    }

    public void xoaDV(DichVu dv) {
        this.ds.remove(dv);
    }

    public void capNhatDV(DichVu dv) {
        dv.nhapDV();
    }

    public DichVu timKiemTheoId(String id) {
        for (DichVu dv : this.ds) {
            if (dv.getMaDV().equalsIgnoreCase(id)) {
                return dv;
            }
        }
        return null;
    }

    public List<DichVu> timKiem(String kw) {
        List<DichVu> kq = new ArrayList<>();
        for (DichVu dv : this.ds) {
            if (dv.getTenDV().equalsIgnoreCase(kw)) {
                kq.add(dv);
            }
        }
        return kq;
    }

    public void hienThi() {
        Collections.sort(this.ds, new Comparator<DichVu>() {
            @Override
            public int compare(DichVu o1, DichVu o2) {
                return o1.getMaDV().compareTo(o2.getMaDV());
            }

        });
        this.ds.forEach(s -> s.hienThi());
    }

    public void menu() throws FileNotFoundException {
//        docFile("Karaoke.txt");
//        docFile("TrangTri.txt");
//        docFile("ThueCaSi.txt");
        try {
            int choose;
            do {
                System.out.println("============== QUAN LY DICH VU =================");
                System.out.println("1. Them dich vu");
                System.out.println("2. Xoa dich vu");
                System.out.println("3. Cap nhat dich vu");
                System.out.println("4. Tra cuu dich vu theo ten");
                System.out.println("5. Hien thi danh sach dich vu");
                System.out.println("6. Luu thong tin");
                System.out.println("0. Thoat");
                System.out.print(">>>CHON: ");
                choose = Integer.parseInt(scan.nextLine());

                switch (choose) {
                    case 1:
                        int choose2;
                        do {
                            System.out.println("==================== THEM DICH VU ======================");
                            System.out.println("1. Them dich vu Karaoke");
                            System.out.println("2. Them dich vu Trang Tri");
                            System.out.println("3. Them dich vu Thue Ca Si");
                            System.out.println("0. Thoat");
                            System.out.println(">>>CHON: ");
                            choose2 = Integer.parseInt(scan.nextLine());

                            switch (choose2) {
                                case 1:
                                    DichVu k = new Karaoke();
                                    k.nhapDV();
                                    themDV(k);
                                    System.out.println("Them thanh cong!");
                                    break;
                                case 2:
                                    DichVu t = new TrangTri();
                                    t.nhapDV();
                                    themDV(t);
                                    System.out.println("Them thanh cong!");
                                    break;
                                case 3:
                                    DichVu cs = new ThueCaSi();
                                    cs.nhapDV();
                                    themDV(cs);
                                    System.out.println("Them thanh cong!");
                                    break;
                                case 0:
                                    break;
                                default:
                                    System.out.println("Nhap lai!!!");
                            }
                        } while (choose2 != 0);
                        break;
                    case 2:
                        System.out.print(">>>Nhap ID dich vu can xoa: ");
                        String id = scan.nextLine();
                        if (timKiemTheoId(id) != null) {
                            xoaDV(timKiemTheoId(id));
                            System.out.println("Xoa dich vu thanh cong!");
                        } else {
                            System.out.println("Khong tim thay dich vu can xoa!");
                        }
                        break;
                    case 3:
                        System.out.print(">>>Nhap ID dich vu can cap nhat: ");
                        String id2 = scan.nextLine();
                        if (timKiemTheoId(id2) != null) {
                            capNhatDV(timKiemTheoId(id2));
                            System.out.println("Cap nhat dich vu thanh cong!");
                        } else {
                            System.out.println("Khong tim thay dich vu can cap nhat!");
                        }
                        break;
                    case 4:
                        System.out.print(">>>Nhap ten dich vu can tra cuu: ");
                        String kw = scan.nextLine();
                        timKiem(kw).forEach(s -> s.hienThi());
                        break;
                    case 5:
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

    public List<DichVu> getDs() {
        return ds;
    }

}
