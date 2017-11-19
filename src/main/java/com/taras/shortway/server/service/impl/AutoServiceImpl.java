package com.taras.shortway.server.service.impl;

import com.taras.shortway.server.entity.Auto;
import com.taras.shortway.server.repository.AutoRepository;
import com.taras.shortway.server.service.AutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AutoServiceImpl implements AutoService {

    @Autowired
    private AutoRepository autoRepository;

    @Override
    public Auto getAutoById(int id) {
        return autoRepository.findOne(id);
    }

    @Override
    public List<Auto> getAutos() {
        return autoRepository.findAll();
    }
}
