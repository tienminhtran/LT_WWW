/**
 * @ (#) Thuoc.java      8/28/2025
 * <p>
 * Copyright (c) 2025 IUH. All rights reserved
 */

package vn.edu.iuh.fit.thuoc_tien.model;

/*
 * @description:
 * @author: Tien Minh Tran
 * @date: 8/28/2025
 */
import java.math.BigDecimal;
public class Thuoc {
    private int maThuoc;
    private String tenThuoc;
    private BigDecimal gia;
    private Integer namNX; // có thể null
    private int maLoai;


    public Thuoc() {}


    public Thuoc(int maThuoc, String tenThuoc, BigDecimal gia, Integer namNX, int maLoai) {
        this.maThuoc = maThuoc;
        this.tenThuoc = tenThuoc;
        this.gia = gia;
        this.namNX = namNX;
        this.maLoai = maLoai;
    }


    public int getMaThuoc() { return maThuoc; }
    public void setMaThuoc(int maThuoc) { this.maThuoc = maThuoc; }


    public String getTenThuoc() { return tenThuoc; }
    public void setTenThuoc(String tenThuoc) { this.tenThuoc = tenThuoc; }


    public BigDecimal getGia() { return gia; }
    public void setGia(BigDecimal gia) { this.gia = gia; }


    public Integer getNamNX() { return namNX; }
    public void setNamNX(Integer namNX) { this.namNX = namNX; }


    public int getMaLoai() { return maLoai; }
    public void setMaLoai(int maLoai) { this.maLoai = maLoai; }
}