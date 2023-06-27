package com.jack.springbootjpat.repository;

import com.jack.springbootjpat.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer> {
}
