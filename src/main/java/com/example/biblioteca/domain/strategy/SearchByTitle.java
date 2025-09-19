package com.example.biblioteca.domain.strategy;

import com.example.biblioteca.domain.ILibro;
import java.util.List;
import java.util.stream.Collectors;

public class SearchByTitle implements SearchStrategy {
  @Override public List<ILibro> buscar(List<ILibro> fuente, String criterio) {
    return fuente.stream()
      .filter(l -> l.getTitulo()!=null && l.getTitulo().toLowerCase().contains(criterio.toLowerCase()))
      .collect(Collectors.toList());
  }
}
