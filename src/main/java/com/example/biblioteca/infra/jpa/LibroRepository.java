package com.example.biblioteca.infra.jpa;

import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface LibroRepository extends JpaRepository<LibroEntity, Long> {
  List<LibroEntity> findByTituloContainingIgnoreCase(String titulo);
  List<LibroEntity> findByAutorContainingIgnoreCase(String autor);
}
