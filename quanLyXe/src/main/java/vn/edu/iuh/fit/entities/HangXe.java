/**
 * @ (#) HangXeRepositories.java      10/24/2024
 * <p>
 * Copyright (c) 2024 IUH. All rights reserved
 */

package vn.edu.iuh.fit.entities;

import jakarta.persistence.*;


@Entity
@Table(name = "hang_xe")
public class HangXe {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long maHangXe;
    private String tenHangXe;
    private String quocGia;
    private String moTa;

    public HangXe(long maHangXe, String tenHangXe, String quocGia, String moTa) {
        this.maHangXe = maHangXe;
        this.tenHangXe = tenHangXe;
        this.quocGia = quocGia;
        this.moTa = moTa;
    }

    public HangXe() {
    }

    public long getMaHangXe() {

        return maHangXe;
    }

    public void setMaHangXe(long maHangXe) {
        this.maHangXe = maHangXe;
    }

    public String getTenHangXe() {
        return tenHangXe;
    }

    public void setTenHangXe(String tenHangXe) {
        this.tenHangXe = tenHangXe;
    }

    public String getQuocGia() {
        return quocGia;
    }

    public void setQuocGia(String quocGia) {
        this.quocGia = quocGia;
    }

    public String getMoTa() {
        return moTa;
    }

    public void setMoTa(String moTa) {
        this.moTa = moTa;
    }
}
