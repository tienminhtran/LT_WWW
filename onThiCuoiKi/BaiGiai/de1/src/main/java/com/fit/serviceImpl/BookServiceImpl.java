package com.fit.serviceImpl;

import com.fit.entity.Book;
import com.fit.repository.BookRepository;
import com.fit.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class BookServiceImpl implements BookService {

    @Autowired
    private BookRepository bookRepository;

    public BookServiceImpl(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @Override
    public Book addBook(Book book) {
        return bookRepository.save(book);
    }

    @Override
    public List<Book> getBooks() {
        System.out.println("Danh sách sách từ service: " + bookRepository.findAll());
        return bookRepository.findAll();
    }

    @Override
    public Book getBookById(int id) {
        return bookRepository.findById(id).orElse(null);
    }

    @Override
    public Book updateBook(Book book) {
        if(!bookRepository.existsById(book.getId())){
            throw new RuntimeException("Employee not found: " + book.getId());
        }else {
            return bookRepository.save(book);
        }
    }

    @Override
    public boolean deleteBook(int id) {
       if(bookRepository.existsById(id)){
           bookRepository.deleteById(id);
              return true;
       }else{
           throw new RuntimeException("Employee not found: " + id);
       }

    }

    @Override
    public List<Book> findBookByCategoryID(int id) {
        return bookRepository.findByCategoryId(id);
    }

    @Override
    public List<Book> search(String keyword) {
        return bookRepository.search(keyword);
    }

    @Override
    public List<Book> searchByDate(Date date) {
        return bookRepository.searchByDate(date);
    }

    @Override
    public Page<Book> findPaginated(int pageNo, int pageSize, String sortField, String sortDirection) {
        Pageable pageable = PageRequest.of(pageNo - 1, pageSize,
                sortDirection.equalsIgnoreCase("asc")
                        ? Sort.by(sortField).ascending()
                        : Sort.by(sortField).descending());
        return bookRepository.findAll(pageable);
    }

    //pageNo : số trang
    //pageSize : số lượng phần tử trên mỗi trang
    //sortField : trường cần sắp xếp
    //sortDirection : chiều sắp xếp
}
