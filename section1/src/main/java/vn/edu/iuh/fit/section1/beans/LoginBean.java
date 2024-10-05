package vn.edu.iuh.fit.section1.beans;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import vn.edu.iuh.fit.section1.dao.impl.DaoImpl;
import vn.edu.iuh.fit.section1.dao.impl.daoLogin;
import vn.edu.iuh.fit.section1.entity.entityLogin;

public class LoginBean {
    private DaoImpl dao;
    LoginBean(){
        dao = new daoLogin();
    }

    public boolean validate(String username, String password) {
        entityLogin entityLogin = dao.checkName(username);

        if(entityLogin.getUsername().equals(username) && entityLogin.getPassword().equals(password))
            return true;
        return false;

    }

}
