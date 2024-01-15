package com.example.mywebsockets.repos;

import com.example.mywebsockets.domain.user.Status;
import com.example.mywebsockets.domain.user.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserRepository extends JpaRepository<User, Long> {
    List<User> findAllByStatusAndIsDeletedIsFalse(Status status);
}
