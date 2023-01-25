package com.codeup.blogapp.repositories;//package com.codeup.blogapp.repositories;

import com.codeup.blogapp.model.Post;
import com.codeup.blogapp.model.User;
import org.springframework.data.jpa.repository.JpaRepository;



public interface UserRepository extends JpaRepository<User, Long> {
    User findByUsername(String username);
}
