package com.example.conflict_tracker.service;

import com.example.conflict_tracker.web.ConflictDto;

import java.util.List;

public interface ConflictService {
    List<ConflictDto> findAll();
    ConflictDto findById(int id);
    ConflictDto create(ConflictDto conflictDto);
    ConflictDto update(int id, ConflictDto conflictDto);
    void delete(int id);
}
