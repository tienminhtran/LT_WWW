/**
 * @ (#) XeDTO.java      10/24/2024
 * <p>
 * Copyright (c) 2024 IUH. All rights reserved
 */

package vn.edu.iuh.fit.entities;

import jakarta.persistence.*;


@Entity
@Table(name = "xe")
public class Xe {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long maXe;
    private String tenXe;
    private double giaXe;
    private int namSX;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "maHangXe")
    private HangXe maHangXe;

    public Xe() {
    }

    public Xe(String tenXe, double giaXe, int namSX) {
        this.tenXe = tenXe;
        this.giaXe = giaXe;
        this.namSX = namSX;
    }

    public Xe(long maXe, String tenXe, double giaXe, int namSX) {
        this.maXe = maXe;
        this.tenXe = tenXe;
        this.giaXe = giaXe;
        this.namSX = namSX;
    }

    public long getMaXe() {
        return maXe;
    }

    public void setMaXe(long maXe) {
        this.maXe = maXe;
    }

    public String getTenXe() {
        return tenXe;
    }

    public void setTenXe(String tenXe) {
        this.tenXe = tenXe;
    }

    public double getGiaXe() {
        return giaXe;
    }

    public void setGiaXe(double giaXe) {
        this.giaXe = giaXe;
    }

    public int getNamSX() {
        return namSX;
    }

    public void setNamSX(int namSX) {
        this.namSX = namSX;
    }

    public HangXe getMaHangXe() {
        return maHangXe;
    }

    public void setMaHangXe(HangXe maHangXe) {
        this.maHangXe = maHangXe;
    }
}
