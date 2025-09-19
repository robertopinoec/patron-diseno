package com.example.biblioteca.domain.chain;

import com.example.biblioteca.domain.ILibro;

public class ValidadorAutor extends Validador {
  @Override protected void ejecutar(ILibro libro) {
    if(libro.getAutor()==null || libro.getAutor().length()<2)
      throw new IllegalArgumentException("Autor inválido");
  }
}
