package com.taras.shortway.server.service.impl;

import com.taras.shortway.server.repository.LoginPassRepository;
import com.taras.shortway.server.service.LoginPassService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LoginPassServiceImpl implements LoginPassService {

    @Autowired
    private LoginPassRepository loginPassRepository;
}
