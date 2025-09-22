package com.fit.repository;

import com.fit.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, Integer> {

    @Query("SELECT e FROM Product e WHERE e.name LIKE %:keyword% " +
            "OR e.code LIKE %:keyword% " +
            "OR CAST(e.id AS string) LIKE %:keyword% "+
            "OR CAST(e.price AS string) LIKE %:keyword% ")
    List<Product> search(@Param("keyword") String keyword);


    @Query("SELECT e FROM Product e WHERE e.registedDate = :date")
    List<Product> searchByDate(@Param("date") Date date);

    @Query("SELECT p FROM Product p WHERE p.category.id = :categoryId")
    List<Product> findByCategoryId(@Param("categoryId") int categoryId);
}
