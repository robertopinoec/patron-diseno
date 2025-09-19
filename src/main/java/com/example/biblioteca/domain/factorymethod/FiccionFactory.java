package com.example.biblioteca.domain.factorymethod;

import com.example.biblioteca.domain.*;

public class FiccionFactory implements LibroFactory {
  @Override public ILibro crear(String titulo, String autor) {
    return new LibroFisico(null, titulo, autor, LibroTipo.FICCION);
  }
}
