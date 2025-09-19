package com.example.biblioteca.domain.abstractfactory;

import com.example.biblioteca.domain.*;

public class LibroDigitalFactory implements AbstractLibroFactory {
  @Override public LibroFormato formato(){ return LibroFormato.DIGITAL; }
  @Override public ILibro crear(Long id, String t, String a, LibroTipo tipo) {
    return new LibroDigital(id, t, a, tipo);
  }
}
