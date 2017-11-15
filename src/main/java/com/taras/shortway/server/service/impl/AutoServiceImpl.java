package com.taras.shortway.server.service.impl;

import com.taras.shortway.server.repository.AutoRepository;
import com.taras.shortway.server.service.AutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AutoServiceImpl implements AutoService {

    @Autowired
    private AutoRepository autoRepository;
}
