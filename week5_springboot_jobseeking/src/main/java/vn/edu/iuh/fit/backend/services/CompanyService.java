/*
 * @ {#} CompanyService.java   1.0     08/11/2024
 *
 * Copyright (c) 2024 IUH. All rights reserved.
 */

package vn.edu.iuh.fit.backend.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vn.edu.iuh.fit.backend.models.Address;
import vn.edu.iuh.fit.backend.models.Company;
import vn.edu.iuh.fit.backend.repositories.AddressRepository;
import vn.edu.iuh.fit.backend.repositories.CompanyRepository;

/*
 * @description:
 * @author: Tran Minh Tien
 * @date:   11/11/2024
 * @version:    1.0
 */
@Service
public class CompanyService {
    @Autowired
    private CompanyRepository companyRepository;
    @Autowired
    private AddressRepository addressRepository;
    // Tìm công ty theo id
    public Company findById(Long id) {
        return companyRepository.findById(id).orElse(null);
    }
    // Tìm công ty theo email
    public Company findByEmail(String email) {
        return companyRepository.findByEmail(email).orElse(null);
    }
    // Luu thông tin công ty
    public Company save(Company company) {
        Address address = company.getAddress();
        addressRepository.save(address);

        return companyRepository.save(company);
    }
    // Kiểm tra email đã tồn tại chưa
    public boolean existsByEmail(String email) {
        return companyRepository.existsByEmail(email);
    }
    // Kiểm tra số điện thoại đã tồn tại chưa
    public boolean existsByPhone(String phone) {
        return companyRepository.existsByPhone(phone);
    }
}
