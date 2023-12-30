package com.example.library.repository;

import com.example.library.model.User;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
@Transactional
public interface UserRepository extends JpaRepository<User, Long> {
    User findByUsername(String username);
    // You can add custom query methods if needed
}
