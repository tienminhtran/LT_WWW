package vn.edu.iuh.fit.week1.beans;

import vn.edu.iuh.fit.week1.dao.loginDao;

public class LoginBean {
//    private loginDao dao;

    public boolean checkLogin(String username, String password){
        if(username.equals("ty") && password.equals("123")){
            return true;
        }
        return false;
    }

//    public boolean validate(String username, String password) {
//        entityLogin entityLogin = dao.checkLogin(username, password);
//
//        if(entityLogin != null){
//            return entityLogin.getUsername().equals(username) && entityLogin.getPassword().equals(password);
//        }
//        return false;
//
//    }

}
