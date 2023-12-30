package com.example.library.repository;

import com.example.library.model.Book;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
@Transactional
public interface BookRepository extends JpaRepository<Book, Long> {
    // You can add custom query methods if needed
}
