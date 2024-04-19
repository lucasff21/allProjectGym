package com.combo.allProject.repository;

import com.combo.allProject.model.Anamnese;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AnamneseRepository extends JpaRepository<Anamnese, Integer> {
}
