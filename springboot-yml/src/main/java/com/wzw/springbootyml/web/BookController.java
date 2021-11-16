package com.wzw.springbootyml.web;

import com.wzw.springbootyml.domain.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BookController {
    @Autowired
    Book book;

    @RequestMapping("/getBook")
    public String getBook(){
        return book.toString();
    }
}
