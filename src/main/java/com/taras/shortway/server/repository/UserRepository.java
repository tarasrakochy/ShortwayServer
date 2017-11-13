package com.taras.shortway.server.repository;

import com.taras.shortway.server.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer> {

}
