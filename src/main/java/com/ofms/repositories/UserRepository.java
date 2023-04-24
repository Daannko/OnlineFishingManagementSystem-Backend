package com.ofms.repositories;


import com.ofms.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.*;

public interface UserRepository extends JpaRepository <User,Long>{
    List<User> findAll();
    Optional<User> findByEmail(String email);
}
