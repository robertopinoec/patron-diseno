package com.example.biblioteca.domain.chain;

import com.example.biblioteca.domain.ILibro;

public class ValidadorTitulo extends Validador {
  @Override protected void ejecutar(ILibro libro) {
    if(libro.getTitulo()==null || libro.getTitulo().isBlank())
      throw new IllegalArgumentException("El título no puede estar vacío");
  }
}
