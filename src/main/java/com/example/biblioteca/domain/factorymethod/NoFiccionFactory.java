package com.example.biblioteca.domain.factorymethod;

import com.example.biblioteca.domain.*;

public class NoFiccionFactory implements LibroFactory {
  @Override public ILibro crear(String titulo, String autor) {
    return new LibroDigital(null, titulo, autor, LibroTipo.NO_FICCION);
  }
}
