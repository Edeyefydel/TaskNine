package com.Flexisaf.lib_system.service;

import com.Flexisaf.lib_system.models.Book;
import com.Flexisaf.lib_system.repository.BookRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class BookService {
    @Autowired
    private BookRepo bookRepo;

    public List<Book> getBooks(){
        return bookRepo.findAll();
    }

    public Book addBook(@RequestBody Book book){
        return bookRepo.save(book);
    }

    public Book updateBook(@RequestBody Book book){
        return bookRepo.save(book);
    }

    public void deleteBook(Long id){
        if(!bookRepo.existsById(id)){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Book not found");
        }
        bookRepo.deleteById(id);
    }
}
