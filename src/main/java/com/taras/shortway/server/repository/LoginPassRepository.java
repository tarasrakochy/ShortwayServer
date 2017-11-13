package com.taras.shortway.server.repository;

import com.taras.shortway.server.entity.LoginPass;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LoginPassRepository extends JpaRepository<LoginPass, Integer> {

}
