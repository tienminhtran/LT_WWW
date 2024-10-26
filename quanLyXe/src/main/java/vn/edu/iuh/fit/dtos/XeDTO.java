/**
 * @ (#) XeDTO.java      10/24/2024
 * <p>
 * Copyright (c) 2024 IUH. All rights reserved
 */

package vn.edu.iuh.fit.dtos;

import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import vn.edu.iuh.fit.entities.HangXe;


public class XeDTO {
    private long maXe;
    private String tenXe;
    private double giaXe;
    private int namSX;

    private String hangXe;

    public XeDTO(long maXe, String tenXe, double giaXe, int namSX, String hangXe) {
        this.maXe = maXe;
        this.tenXe = tenXe;
        this.giaXe = giaXe;
        this.namSX = namSX;
        this.hangXe = hangXe;
    }

    public XeDTO() {
    }

    public XeDTO(String tenXe, double giaXe, int namSX, String hangXe) {
        this.tenXe = tenXe;
        this.giaXe = giaXe;
        this.namSX = namSX;
        this.hangXe = hangXe;
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

    public String getHangXe() {
        return hangXe;
    }

    public void setHangXe(String hangXe) {
        this.hangXe = hangXe;
    }

    @Override
    public String toString() {
        return "XeDTO{" +
                "maXe=" + maXe +
                ", tenXe='" + tenXe + '\'' +
                ", giaXe=" + giaXe +
                ", namSX=" + namSX +
                ", hangXe='" + hangXe + '\'' +
                '}';
    }
}
