package com.example.conflict_tracker.domain;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ConflictRepository extends JpaRepository <Conflict, Long>{ }
