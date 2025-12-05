package com.Flexisaf.lib_system.repository;


import com.Flexisaf.lib_system.models.Book;
import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;

@Repository
public interface BookRepo extends JpaRepository<Book,Long> {
}
