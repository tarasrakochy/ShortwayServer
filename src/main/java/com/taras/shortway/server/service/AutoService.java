package com.taras.shortway.server.service;

import com.taras.shortway.server.entity.Auto;

import java.util.List;

public interface AutoService {
    Auto getAutoById(int id);

    List<Auto> getAutos();
}
