package com.fit.service;

import com.fit.entity.Book;
import org.springframework.data.domain.Page;

import java.util.Date;
import java.util.List;

public interface BookService {

    public Book addBook(Book book);

    public List<Book> getBooks();

    public Book getBookById(int id);

    public Book updateBook(Book book);

    public boolean deleteBook(int id);

    public List<Book>  findBookByCategoryID(int id);

    public List<Book> search(String keyword);

    public List<Book> searchByDate(Date date);

    public Page<Book> findPaginated(int pageNo, int pageSize, String sortField, String sortDirection);

}
