package com.jamsheed.Student.service;

import com.jamsheed.Student.model.Address;
import com.jamsheed.Student.model.Book;
import com.jamsheed.Student.repo.IBook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService {

    @Autowired
    IBook bookRepo;

    public String addBook(Book newBook) {
        bookRepo.save(newBook);
        return "book added";
    }

    public String updateBookById(String id, Book updateBook) {
        bookRepo.findById(id).orElseThrow();
        bookRepo.save(updateBook);
        return "book with ID : "+id+" updated";
    }

    public String deleteById(String  id) {
        bookRepo.findById(id).orElseThrow();
        bookRepo.deleteById(id);
        return "book with ID : "+id+" deleted";
    }

    public List<Book> getAllBooks() {
        return bookRepo.findAll();
    }

    public Book getBookById(String id) {
       return bookRepo.findById(id).orElseThrow();


    }
}
