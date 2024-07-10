/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.btl_demo;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.StringTokenizer;
import java.util.stream.Collectors;

/**
 *
 * @author anhhao
 */
public class QuanLyBuaTiec {

    private List<BuaTiec> ds = new ArrayList<>();
    DateTimeFormatter f = DateTimeFormatter.ofPattern("dd/MM/yyyy");
    Scanner scan = new Scanner(System.in);

    public QuanLyBuaTiec() {
    }

    public void docFile(List<SanhCuoi> dsS, List<ThucPham> dsTP, List<DichVu> dsDV) throws FileNotFoundException {
        File file = new File("BuaTiec.txt");
        Scanner s = new Scanner(file);
        while (s.hasNextLine()) {
            BuaTiec bt = new BuaTiec();
            StringTokenizer token = new StringTokenizer(s.nextLine(), ";");
            while (token.hasMoreTokens()) {
                bt.setMaBuaTiec(token.nextToken());
                bt.setTenBuaTiec(token.nextToken());
                String kw = token.nextToken();
                for (SanhCuoi sanh : dsS) {
                    if (sanh.getTenSanh().equalsIgnoreCase(kw)) {
                        bt.setSanhThue(sanh);
                    }
                }
                bt.setSoLuongBan(Integer.parseInt(token.nextToken()));
                String kw2 = token.nextToken();
                for (ThoiDiemThue td : ThoiDiemThue.values()) {
                    if (td.name().equalsIgnoreCase(kw2)) {
                        bt.setThoiDiemThue(td);
                    }
                }
                bt.setNgayThue(LocalDate.parse(token.nextToken(), f));
                bt.setGiaThueSanh(Double.parseDouble(token.nextToken()));
                bt.setDonGiaMenu(Double.parseDouble(token.nextToken()));
                bt.setDonGiaDV(Double.parseDouble(token.nextToken()));
                StringTokenizer token2 = new StringTokenizer(token.nextToken(), "#");
                while(token2.hasMoreTokens()){
                    String kw3 = token2.nextToken();
                    for(ThucPham tp : dsTP){
                        if(tp.getMaTP().equalsIgnoreCase(kw3)){
                            bt.getMenu().add(tp);
                        }
                    }
                }
                StringTokenizer token3 = new StringTokenizer(token.nextToken(), "#");
                while(token3.hasMoreTokens()){
                    String kw4 = token3.nextToken();
                    for(DichVu dv : dsDV){
                        if(dv.getMaDV().equalsIgnoreCase(kw4)){
                            bt.getListDV().add(dv);
                        }
                    }
                }
                
            }
            bt.getSanhThue().themBuaTiec(bt);
            this.ds.add(bt);
        }
    }
    
    
    
    public void ghiFile() throws FileNotFoundException{
        File file = new File("BuaTiec.txt");
        PrintWriter pw = new PrintWriter(file);
        for(BuaTiec bt : this.ds){
            pw.println(bt.toString());
        }
        pw.close();
    }
    
    public void themBuaTiec(BuaTiec buaTiec) {
        this.ds.add(buaTiec);
    }

    public void xoaBuaTiec(BuaTiec buaTiec) {
        this.ds.remove(buaTiec);
    }

    public void capNhatBuaTiec(BuaTiec bt) throws FileNotFoundException {
        bt.nhapBuaTiec();
        bt.nhapSanhThue();
        while (true) {
            if (isThue(bt)) {
                System.out.println(bt.getSanhThue().getTenSanh() + " da duoc thue. Moi ban chon lai");
                bt.nhapSanhThue();
            } else {
                break;
            }
        }

        bt.nhapMenu();
        bt.nhapDsDv();
    }

    public BuaTiec timKiemTheoId(String id) {
        for (BuaTiec s : this.ds) {
            if (s.getMaBuaTiec().equalsIgnoreCase(id)) {
                return s;
            }
        }
        return null;
    }

    public List<BuaTiec> timKiem(String kw) {
        List<BuaTiec> kq = new ArrayList<>();
        for (BuaTiec s : this.ds) {
            if (s.getTenBuaTiec().equalsIgnoreCase(kw)) {
                kq.add(s);
            }
        }
        return kq;
    }

    public boolean isThue(BuaTiec bt) {
        for (BuaTiec buaTiec : this.ds) {
            if (buaTiec.getNgayThue().equals(bt.getNgayThue()) && buaTiec.getThoiDiemThue().equals(bt.getThoiDiemThue()) && buaTiec.getSanhThue().getTenSanh().equalsIgnoreCase(bt.getSanhThue().getTenSanh())) {
                return true;
            }
        }
        return false;
    }

    public void xoaBuaTiecTheoSanh(SanhCuoi sanh) throws FileNotFoundException{
        List<BuaTiec> index = new ArrayList<>();
        for(BuaTiec bt : this.ds){
            if(bt.getSanhThue().getMaSanh().equalsIgnoreCase(sanh.getMaSanh())){
//                System.out.println(bt.getMaBuaTiec());
                index.add(bt);
            }
        }
        this.ds.removeAll(index);
        ghiFile();
    }
    
    public void xuatHoaDon(BuaTiec bt){
        System.out.println("====================== HOA DON =========================");
        System.out.printf("Ten bua tiec: %s\nNgay thue: %s\nBuoi thue: %s\nSanh thue: %s\nSo luong ban: %d\n",
                bt.getTenBuaTiec(), f.format(bt.getNgayThue()), bt.getThoiDiemThue(), bt.getSanhThue().getTenSanh(), bt.getSoLuongBan());
        System.out.printf("%-30s%-15s%-15s%-15s\n", "NAME", "DON GIA", "SO LUONG", "THANH TIEN");
        System.out.printf("%-30s%-15.1f%-15d%-15.1f\n", bt.getSanhThue().getTenSanh(), bt.getGiaThueSanh(), 1, bt.getGiaThueSanh());
        for(ThucPham tp : bt.getMenu()){
            System.out.printf("%-30s%-15.1f%-15d%-15.1f\n", tp.getTenTP(), tp.getGiaTP(), bt.getSoLuongBan(), tp.getGiaTP()*bt.getSoLuongBan());
        }
        for(DichVu dv : bt.getListDV()){
            System.out.printf("%-30s%-15.1f%-15d%-15.1f\n", dv.getTenDV(), dv.getGiaDV(), 1, dv.getGiaDV());
        }
        System.out.printf("%-30s%-15.1f\n", "THANH TIEN:", bt.tinhTienBuaTiec(bt));
    }
    
    
    
 
    
    public double doanhThuTheoThang(int thang, int nam){
        double doanhThu = 0;
        for(BuaTiec bt : this.ds){
            if(bt.getNgayThue().getMonthValue() == thang && bt.getNgayThue().getYear() == nam){
                doanhThu += bt.tinhTienBuaTiec(bt);
            }
        }
        return doanhThu;
    }
    
    public double doanhThuTheoQuy(int quy, int nam){
        double doanhThu = 0;
        if(quy == 1){
            for(int i = 1; i <= 3; i++){
                doanhThu += doanhThuTheoThang(i, nam);
            }
        }
        if(quy == 2){
            for(int i = 4; i <= 6 ; i++){
                doanhThu += doanhThuTheoThang(i, nam);
            }
        }
        if(quy == 3){
            for(int i = 7; i <= 9; i++){
                doanhThu += doanhThuTheoThang(i, nam);
            }
        }
        if(quy == 4){
            for(int i = 10; i <= 12; i++){
                doanhThu += doanhThuTheoThang(i, nam);
            }
        }
        return doanhThu;
    }
    
    public void hienThi() {
        this.ds.forEach(s -> s.hienThi());
    }


    
    public void menu() throws FileNotFoundException {
        QuanLySanhCuoi qlS = new QuanLySanhCuoi();
        QuanLyThucPham qlTP = new QuanLyThucPham();
        QuanLyDichVu qlDV = new QuanLyDichVu();
        docFile(qlS.getDs(), qlTP.getDs(), qlDV.getDs());
        int choose;
        do {
            System.out.println("======================= QUAN LY BUA TIEC =================================");
            System.out.println("1. Thue sanh cuoi");
            System.out.println("2. Xoa bua tiec");
            System.out.println("3. Cap nhat bua tiec");
            System.out.println("4. Tra cuu bua tiec");
            System.out.println("5. Hien thi ds bua tiec");
            System.out.println("6. Luu thong tin");
            System.out.println("7. Xuat hoa don");
            System.out.println("8. Bao cao doanh thu theo thang");
            System.out.println("9. Bao cao doanh thu theo quy");
            System.out.println("10. Tan so thue sanh");
            System.out.println("0. Thoat");
            System.out.println(">>>CHON: ");
            choose = Integer.parseInt(scan.nextLine());

            switch (choose) {
                case 1:
                    BuaTiec bt = new BuaTiec();
                    bt.nhapBuaTiec();
                    bt.nhapSanhThue();
                    while (true) {
                        if (isThue(bt)) {
                            System.out.println(bt.getSanhThue().getTenSanh() + " da duoc thue. Moi ban chon lai");
                            bt.nhapSanhThue();
                        } else {
                            break;
                        }
                    }
                    bt.nhapMenu();
                    bt.nhapDsDv();
                    bt.getSanhThue().themBuaTiec(bt);
                    themBuaTiec(bt);
                    System.out.println("Thue sanh thanh cong");
                    break;
                case 2:
                    System.out.print("Nhap ID bua tiec can xoa: ");
                    String id = scan.nextLine();
                    if (timKiemTheoId(id) != null) {
                        xoaBuaTiec(timKiemTheoId(id));
                        System.out.println("Xoa bua tiec thanh cong");
                    } else {
                        System.out.println("Khong tim thay bua tiec can xoa");
                    }
                    break;
                case 3:
                    System.out.print("Nhap ID bua tiec can cap nhat: ");
                    String id2 = scan.nextLine();
                    if (timKiemTheoId(id2) != null) {
                        capNhatBuaTiec(timKiemTheoId(id2));
                        System.out.println("Cap nhat bua tiec thanh cong");
                    } else {
                        System.out.println("Khong tim thay bua tiec can cap nhat");
                    }
                    break;
                case 4:
                    System.out.print("Nhap ten bua tiec can tra cuu: ");
                    String kw = scan.nextLine();
                    timKiem(kw).forEach(s -> hienThi());
                    break;
                case 5:
                    hienThi();
                    break;
                case 6:
                    ghiFile();
                    break;
                case 7:
                    System.out.print("Nhap ID bua tiec xuat hoa don: ");
                    String id3 = scan.nextLine();
                    if(timKiemTheoId(id3) != null){
                        xuatHoaDon(timKiemTheoId(id3));
                    }else{
                        System.out.println("Khong tim thay bua tiec!!!");
                    }
                    break;
                case 8:
                    System.out.print("Nhap nam: ");
                    int nam = Integer.parseInt(scan.nextLine());
                    System.out.println("Doanh thu theo thang cua nam " + nam);
                    for(int i = 1; i <= 12; i++){
                        System.out.printf("Thang %d:%12.1f\n", i, doanhThuTheoThang(i, nam));
                    }
                    break;
                case 9:
                    System.out.print("Nhap nam: ");
                    int nam2 = Integer.parseInt(scan.nextLine());
                    System.out.println("Doanh thu theo quy cua nam " + nam2);
                    for(int i = 1; i <= 4; i++){
                        System.out.printf("Quy %d:%12.1f\n", i, doanhThuTheoQuy(i, nam2));
                    }
                    break;
                case 10:
                    List<SanhCuoi> sx = new ArrayList<>();
                    sx.addAll(qlS.getDs());
                    System.out.println("Nhap nam can kiem tra: ");
                    int nam4 = Integer.parseInt(scan.nextLine());
                    qlS.sapXepSanh(nam4);
                    break;
                case 0:
                    break;

                default:
                    System.out.println("Nhap lai!!!");
            }
        } while (choose != 0);
    }

    public List<BuaTiec> getQl() {
        return ds;
    }
}
