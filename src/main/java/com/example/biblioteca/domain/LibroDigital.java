package com.example.biblioteca.domain;
public final class LibroDigital extends LibroBase {
  public LibroDigital(Long id, String titulo, String autor, LibroTipo tipo) {
    super(id, titulo, autor, tipo, LibroFormato.DIGITAL);
  }
}
