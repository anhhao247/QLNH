/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package com.mycompany.btl_demo;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.time.Duration;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author anhhao
 */
public class QuanLyNhaHang {

    private QuanLySanhCuoi qlS;
    private QuanLyThucPham qlTP;
    private QuanLyDichVu qlDV;
    private QuanLyBuaTiec qlBT;

    public void menu() throws FileNotFoundException {
        Scanner s = new Scanner(System.in);
        int choose;
        try {
            do {
                System.out.println("============================= QUAN LY NHA HANG ==================================");
                System.out.println("1. QL sanh cuoi");
                System.out.println("2. QL thuc pham");
                System.out.println("3. QL dich vu");
                System.out.println("4. Thue sanh cuoi");
                System.out.println("0. Thoat");
                System.out.print(">>>CHON: ");
                choose = Integer.parseInt(s.nextLine());

                switch (choose) {
                    case 1:
                        qlS = new QuanLySanhCuoi();
                        qlS.menu();
                        break;
                    case 2:
                        qlTP = new QuanLyThucPham();
                        qlTP.menu();
                        break;
                    case 3:
                        qlDV = new QuanLyDichVu();
                        qlDV.menu();
                        break;
                    case 4:
                        qlBT = new QuanLyBuaTiec();
                        qlBT.menu();
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
}
