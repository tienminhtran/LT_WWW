package com.fit.repository;

import com.fit.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Date;
import java.util.List;

public interface BookRepository extends JpaRepository<Book, Integer> {

    @Query("SELECT b FROM Book b WHERE b.category.id = :categoryId")
    List<Book> findByCategoryId(@Param("categoryId") int categoryId);


    @Query("SELECT b FROM Book b WHERE b.title LIKE %:keyword% OR b.author LIKE %:keyword% OR CAST(b.id AS string) LIKE %:keyword% OR CAST(b.price AS string) LIKE %:keyword% ")
    List<Book> search(@Param("keyword") String keyword);


    @Query("SELECT e FROM Book e WHERE e.publishDate = :date")
    List<Book> searchByDate(@Param("date") Date date);
}
