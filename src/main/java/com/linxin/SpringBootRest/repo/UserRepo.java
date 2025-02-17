package com.linxin.SpringBootRest.repo;

import com.linxin.SpringBootRest.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepo extends JpaRepository<User, Integer> {
    User findByUsername(String username);
}
