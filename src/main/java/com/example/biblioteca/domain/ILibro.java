package com.example.biblioteca.domain;

public interface ILibro {
  Long getId();
  void setId(Long id);
  String getTitulo();
  String getAutor();
  LibroTipo getTipo();
  LibroFormato getFormato();
  LibroEstado getEstado();
  void setEstado(LibroEstado estado);
}
