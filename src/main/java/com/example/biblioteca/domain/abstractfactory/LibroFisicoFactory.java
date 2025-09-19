package com.example.biblioteca.domain.abstractfactory;

import com.example.biblioteca.domain.*;

public class LibroFisicoFactory implements AbstractLibroFactory {
  @Override public LibroFormato formato(){ return LibroFormato.FISICO; }
  @Override public ILibro crear(Long id, String t, String a, LibroTipo tipo) {
    return new LibroFisico(id, t, a, tipo);
  }
}
