package com.example.biblioteca.domain;
public final class LibroFisico extends LibroBase {
  public LibroFisico(Long id, String titulo, String autor, LibroTipo tipo) {
    super(id, titulo, autor, tipo, LibroFormato.FISICO);
  }
}
