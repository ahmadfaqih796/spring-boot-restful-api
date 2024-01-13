package com.faqih.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.faqih.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
   boolean existsByUsername(String username);
}
