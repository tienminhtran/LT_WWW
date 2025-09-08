/**
 * @ (#) SinhVien.java      9/8/2025
 * <p>
 * Copyright (c) 2025 IUH. All rights reserved
 */

package vn.edu.iuh.fit.gk_qlsv.model;
import jakarta.persistence.*;
import lombok.*;

import java.util.Date;
import java.util.List;
/*
 * @description:
 * @author: Tien Minh Tran
 * @date: 9/8/2025
 */

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class SinhVien {
    private String mssv;
    private String hoten;
    private Date ngaysinh; // java.util.Date
    private double diem;
    private Lop lop;


}