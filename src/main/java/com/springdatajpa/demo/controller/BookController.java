package com.springdatajpa.demo.controller;

import com.springdatajpa.demo.Model.Book;
import com.springdatajpa.demo.Model.LoginForm;
import com.springdatajpa.demo.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
public class BookController {

    @Autowired
    BookRepository bookRepository;

    @RequestMapping(value = "/ping", method = RequestMethod.GET)
    @ResponseStatus(value = HttpStatus.OK)
    public String isRunning() {
        return "I'm Alive!";
    }

    @RequestMapping(value = "/findByIsbn", method = RequestMethod.GET)
    @ResponseBody
    public Optional<Book> findByIsbn() {
        Optional<Book> book = bookRepository.findByIsbn("123");
        return book;
    }

    @RequestMapping(value = "/saveBook", method = RequestMethod.GET)
    @ResponseBody
    public Book saveBook() {
        Book book = new Book();
        book.setIsbn("123");
        return bookRepository.save(book);
    }


    @PostMapping("/request")
    @ResponseBody
    /*public ResponseEntity postController(
            @RequestBody LoginForm loginForm) {

        return ResponseEntity.ok(HttpStatus.OK);
    }*/
    public LoginForm postResponseController(
            @RequestBody LoginForm loginForm) {
        return loginForm;
    }

}
