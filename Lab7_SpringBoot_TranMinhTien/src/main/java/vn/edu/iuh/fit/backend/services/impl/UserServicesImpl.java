package vn.edu.iuh.fit.backend.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vn.edu.iuh.fit.backend.models.User;
import vn.edu.iuh.fit.backend.repositores.UserReositores;
import vn.edu.iuh.fit.backend.services.UserServices;

import java.util.List;

@Service
public class UserServicesImpl implements UserServices {

    @Autowired
    private UserReositores userReositores;
    @Override
    public List<User> getAll_Nopaing() {
        return userReositores.findAll();
    }

    @Override
    public User findById(Long id) {
        return null;
    }

    @Override
    public User save(User user) {
        return userReositores.save(user);
    }

    @Override
    public void deleteById(Long id) {

    }

    @Override
    public User findByEmail(String email) {
        return null;
    }

    @Override
    public User findByMobile(String mobile) {
        return null;
    }

    @Override
    public User findByEmailAndPassword(String email, String password) {
        return null;
    }

    @Override
    public User findByMobileAndPassword(String mobile, String password) {
        return null;
    }

    @Override
    public User findByEmailOrMobile(String email, String mobile) {
        return null;
    }


}
