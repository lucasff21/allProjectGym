package com.combo.allProject.repository;

import com.combo.allProject.model.Aluno;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface AlunoRepository extends JpaRepository<Aluno, Integer> {

    Aluno findByEmail(String email);
}
