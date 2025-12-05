package com.Flexisaf.lib_system.repository;

import com.Flexisaf.lib_system.models.Author;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AuthorRepo extends JpaRepository<Author, Long> {}
