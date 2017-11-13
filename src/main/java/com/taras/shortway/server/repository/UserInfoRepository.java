package com.taras.shortway.server.repository;

import com.taras.shortway.server.entity.UserInfo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserInfoRepository extends JpaRepository<UserInfo, Integer> {

}
