/*
 * @ {#} ProductDTO.java   1.0     05/10/2024
 *
 * Copyright (c) 2024 IUH. All rights reserved.
 */

package vn.edu.iuh.fit.backend.dtos;


import lombok.*;

@ToString
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class ProductDTO {
    private int id;
    private String name;
    private String description;
    private String imgPath;
    private double price;


}
