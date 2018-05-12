package com.springdatajpa.demo;

import com.springdatajpa.demo.Model.Book;
import com.springdatajpa.demo.repository.BookRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Optional;


import static org.assertj.core.api.Assertions.*;

@RunWith(SpringRunner.class)
//@DataJpaTest
@SpringBootTest
public class DemoApplicationTests {

    @Autowired
    BookRepository bookRepository;

    @Test
    public void testFindByIsbn() {

        Book book = new Book();
        book.setIsbn("123");

        Optional<Book> book123 = bookRepository.findByIsbn("123");

        assertThat(book123).isEmpty();

        Book saveBook = bookRepository.save(book);

        assertThat(saveBook.getId()).isNotNull();

        assertThat(bookRepository.findByIsbn("123")).isNotEmpty();



    }

}
