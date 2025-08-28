/**
 * @ (#) LoaiThuoc.java      8/28/2025
 * <p>
 * Copyright (c) 2025 IUH. All rights reserved
 */

package vn.edu.iuh.fit.thuoc_tien.model;

/*
 * @description:
 * @author: Tien Minh Tran
 * @date: 8/28/2025
 */
public class LoaiThuoc {
    private int maLoai;
    private String tenLoai;


    public LoaiThuoc() {}


    public LoaiThuoc(int maLoai, String tenLoai) {
        this.maLoai = maLoai;
        this.tenLoai = tenLoai;
    }


    public int getMaLoai() { return maLoai; }
    public void setMaLoai(int maLoai) { this.maLoai = maLoai; }


    public String getTenLoai() { return tenLoai; }
    public void setTenLoai(String tenLoai) { this.tenLoai = tenLoai; }
}