package com.taras.shortway.server.service.impl;

import com.taras.shortway.server.repository.UserInfoRepository;
import com.taras.shortway.server.service.UserInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserInfoServiceImpl implements UserInfoService {

    @Autowired
    private UserInfoRepository userInfoRepository;
}
