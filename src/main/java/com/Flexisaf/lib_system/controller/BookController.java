package com.Flexisaf.lib_system.controller;

import com.Flexisaf.lib_system.models.Book;
import com.Flexisaf.lib_system.service.AuthorService;
import com.Flexisaf.lib_system.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/Books")
public class BookController {
    @Autowired
    private BookService bookService;

    @GetMapping
    public List<Book> getBooks(){
        return bookService.getBooks();
    }

    @PostMapping
    public ResponseEntity<Book> addBook(@RequestBody Book book){
        return new ResponseEntity<>(bookService.addBook(book), HttpStatus.CREATED) ;
    }

    @PutMapping
    public ResponseEntity <Book> updateBook(@RequestBody Book book){
        return new ResponseEntity<>(bookService.updateBook(book),  HttpStatus.OK) ;
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteBook(Long id){
        bookService.deleteBook(id);
        return new ResponseEntity<>("Book deleted", HttpStatus.OK) ;
    }
}
