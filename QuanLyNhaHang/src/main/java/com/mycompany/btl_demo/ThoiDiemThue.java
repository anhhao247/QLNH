/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Enum.java to edit this template
 */
package com.mycompany.btl_demo;

import java.time.LocalDate;

/**
 *
 * @author anhhao
 */
public enum ThoiDiemThue {
    SANG(1, 1) {
        @Override
        public double giaThue(double gia, LocalDate date) {
            if(date.getDayOfWeek().equals(date.getDayOfWeek().SATURDAY) || date.getDayOfWeek().equals(date.getDayOfWeek().SUNDAY)){
                return this.heSo*gia*2;
            }
            return this.heSo*gia;
        }
    },
    CHIEU(2, 1.2) {
        @Override
        public double giaThue(double gia, LocalDate date) {
            if(date.getDayOfWeek().equals(date.getDayOfWeek().SATURDAY) || date.getDayOfWeek().equals(date.getDayOfWeek().SUNDAY)){
                return this.heSo*gia*2;
            }
            return this.heSo*gia;
        }
    },
    TOI(3, 1.5) {
        @Override
        public double giaThue(double gia, LocalDate date) {
            if(date.getDayOfWeek().equals(date.getDayOfWeek().SATURDAY) || date.getDayOfWeek().equals(date.getDayOfWeek().SUNDAY)){
                return this.heSo*gia*2;
            }
            return this.heSo*gia;
        }
    };

    protected LocalDate date;
    protected double heSo;
    protected int id;

    private ThoiDiemThue(int id, double heSo) {
        this.id = id;
        this.heSo = heSo;
    }

    public abstract double giaThue(double gia, LocalDate date);
}
