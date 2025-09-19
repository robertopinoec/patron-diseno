package com.example.biblioteca.domain.strategy;

import com.example.biblioteca.domain.ILibro;
import java.util.List;

public interface SearchStrategy {
  List<ILibro> buscar(List<ILibro> fuente, String criterio);
}
