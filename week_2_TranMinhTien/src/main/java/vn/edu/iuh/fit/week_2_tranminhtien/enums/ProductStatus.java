/**
 * @ (#) ProductStatus.java      9/18/2024
 * <p>
 * Copyright (c) 2024 IUH. All rights reserved
 */

package vn.edu.iuh.fit.week2_phantiensinh.enums;

/*
 * @description:
 * @author: Sinh Phan Tien
 * @date: 9/18/2024
 */
public enum ProductStatus {
    ACTIVE(1), IN_ACTIVE(0),TERMINATED(-1) ;
    private int value;

    ProductStatus(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
