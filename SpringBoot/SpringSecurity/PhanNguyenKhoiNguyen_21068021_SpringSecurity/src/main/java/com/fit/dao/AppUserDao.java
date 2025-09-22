package com.fit.dao;

import com.fit.entites.AppUser;
import jakarta.persistence.EntityManager;
import jakarta.persistence.NoResultException;
import jakarta.persistence.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository  //xem đây là một bean, nhận diện đây là một class DAO
@Transactional
public class AppUserDao {

    @Autowired //Tiêm EntityManager vào
    private EntityManager entityManager;

    public AppUser findUserAccount(String userName) {
        try {
            //Tạo câu lệnh truy vấn
            String sql = "Select e from " + AppUser.class.getName() + " e " //
                    + " Where e.userName = :userName ";
            //Tạo đối tượng Query
            Query query = entityManager.createQuery(sql, AppUser.class);
            //Set tham số cho câu lệnh truy vấn
            query.setParameter("userName", userName);
            //Trả về kết quả
            return (AppUser) query.getSingleResult();
        }catch (NoResultException e) {//Nếu không tìm thấy kết quả
            return null;
        }
    }
}


