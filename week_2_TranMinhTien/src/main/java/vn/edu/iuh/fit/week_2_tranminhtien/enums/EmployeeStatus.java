/**
 * @ (#) EmployeeStatus.java      9/18/2024
 * <p>
 * Copyright (c) 2024 IUH. All rights reserved
 */

package vn.edu.iuh.fit.week2_phantiensinh.enums;

/*
 * @description:
 * @author: Sinh Phan Tien
 * @date: 9/18/2024
 */
public enum EmployeeStatus {
    ACTIVE(1), IN_ACTIVE(0),TERMINATED(-1) ;
    private int value;

    EmployeeStatus(int value) {
        this.value = value;
    }
    public int getValue(){
        return value;
    }

    /**
     * Convert int value to enum
     * @param value
     * @return
     */
    public static EmployeeStatus convertEnum(int value) {
        for (EmployeeStatus status : EmployeeStatus.values()) {
            if (status.getValue() == value) {
                return status;
            }
        }
        throw new IllegalArgumentException("No enum constant for value: " + value);
    }
}
