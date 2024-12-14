/*
 * @ {#} CompanyRepository.java   1.0     08/11/2024
 *
 * Copyright (c) 2024 IUH. All rights reserved.
 */

package vn.edu.iuh.fit.backend.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import vn.edu.iuh.fit.backend.models.Company;

import java.util.Optional;

/*
 * @description:
 * @author: Tran Minh Tien
 * @date:   11/11/2024
 * @version:    1.0
 */
public interface CompanyRepository extends JpaRepository<Company, Long> {
    // Tìm công ty theo email
    Optional<Company> findByEmail(String email);
    // Kiểm tra email đã tồn tại chưa
    boolean existsByEmail(String email);
    // Kiểm tra số điện thoại đã tồn tại chưa
    boolean existsByPhone(String phone);
}
