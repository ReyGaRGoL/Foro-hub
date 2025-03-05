package com.Forohub.domain.curso;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CursoRepository extends JpaRepository<Curso, Long>{

    Curso findByNombre(String nombre);
}
