package com.example.jpaonetomany.repository;

import com.example.jpaonetomany.model.Kommune;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface KommuneRepository extends JpaRepository<Kommune, String> {
    @Override
    Page<Kommune> findAll(Pageable pageable);
}
