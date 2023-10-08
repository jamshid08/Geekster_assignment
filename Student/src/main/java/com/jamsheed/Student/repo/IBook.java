package com.jamsheed.Student.repo;

import com.jamsheed.Student.model.Address;
import com.jamsheed.Student.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IBook extends JpaRepository<Book,String> {
}
