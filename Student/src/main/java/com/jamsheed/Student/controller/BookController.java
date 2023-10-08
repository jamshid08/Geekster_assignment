package com.jamsheed.Student.controller;

import com.jamsheed.Student.model.Address;
import com.jamsheed.Student.model.Book;
import com.jamsheed.Student.service.BookService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@Validated
public class BookController {

    @Autowired
    BookService bookService;

    @PostMapping("book")
    public String addBook(@RequestBody @Valid Book newBook){

        return bookService.addBook(newBook);
    }

    @PutMapping("book/id/{id}")
    public String updateBookById(@PathVariable @Valid String id, @RequestBody @Valid  Book updateBook){
        return bookService.updateBookById(id,updateBook);
    }

    @DeleteMapping("book/id/{id}")
    public String deleteById(@PathVariable @Valid String  id){
        return bookService.deleteById(id);
    }

    @GetMapping("books")
    public List<Book> getAllBooks(){
        return bookService.getAllBooks();
    }


    @GetMapping("book/id/{id}")
    public Book getBookById(@PathVariable @Valid String  id){
        return bookService.getBookById(id);
    }

}
