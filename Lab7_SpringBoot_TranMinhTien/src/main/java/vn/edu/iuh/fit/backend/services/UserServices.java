package vn.edu.iuh.fit.backend.services;


import vn.edu.iuh.fit.backend.models.User;

import java.util.List;
public interface UserServices{
    List<User> getAll_Nopaing();
    User findById(Long id);
    User save(User user);
    void deleteById(Long id);
    User findByEmail(String email);
    User findByMobile(String mobile);
    User findByEmailAndPassword(String email, String password);
    User findByMobileAndPassword(String mobile, String password);
    User findByEmailOrMobile(String email, String mobile);
}
