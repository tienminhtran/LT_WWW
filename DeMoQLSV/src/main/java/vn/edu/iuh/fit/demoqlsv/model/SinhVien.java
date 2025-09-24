/**
 * @ (#) SinhVien.java      9/13/2025
 * <p>
 * Copyright (c) 2025 IUH. All rights reserved
 */

package vn.edu.iuh.fit.demoqlsv.model;

/*
 * @description:
 * @author: Tien Minh Tran
 * @date: 9/13/2025
 */

import lombok.*;
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class SinhVien {

    private String mssv;
    private String hoten;
    private String ngaysinh;
    private double diem;
    private Lop lop;
}