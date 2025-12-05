package com.Flexisaf.lib_system.service;

import com.Flexisaf.lib_system.models.Author;
import com.Flexisaf.lib_system.repository.AuthorRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AuthorService {
    @Autowired
   private  AuthorRepo authorRepo;

   public AuthorService(AuthorRepo authorRepo){
       this.authorRepo = authorRepo;
   }

   public List<Author> getAuthor(){
      return authorRepo.findAll();
   }

   public Author createAuthor(Author author){
       return authorRepo.save(author);
   }

   public void deleteAuthor(Long id){
       if(!authorRepo.existsById(id)){
           throw  new RuntimeException("Author not found");
       }
       authorRepo.deleteById(id);
   }

}
