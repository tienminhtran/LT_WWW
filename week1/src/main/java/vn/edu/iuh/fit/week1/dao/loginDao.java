package vn.edu.iuh.fit.week1.dao;

import vn.edu.iuh.fit.week1.entity.entityLogin;

public interface loginDao {


    public boolean checkLogin(String username, String password);

    public boolean insertLogin(entityLogin login);
}
