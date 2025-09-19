package com.example.biblioteca.domain;

public abstract class LibroBase implements ILibro {
  private Long id;
  private final String titulo;
  private final String autor;
  private final LibroTipo tipo;
  private final LibroFormato formato;
  private LibroEstado estado = LibroEstado.DISPONIBLE;

  protected LibroBase(Long id, String titulo, String autor, LibroTipo tipo, LibroFormato formato) {
    this.id = id; this.titulo = titulo; this.autor = autor; this.tipo = tipo; this.formato = formato;
  }
  @Override public Long getId() { return id; }
  @Override public void setId(Long id) { this.id = id; }
  @Override public String getTitulo() { return titulo; }
  @Override public String getAutor() { return autor; }
  @Override public LibroTipo getTipo() { return tipo; }
  @Override public LibroFormato getFormato() { return formato; }
  @Override public LibroEstado getEstado() { return estado; }
  @Override public void setEstado(LibroEstado estado) { this.estado = estado; }

  @Override public String toString() {
    return "Libro{id=%s, titulo='%s', autor='%s', tipo=%s, formato=%s, estado=%s}"
        .formatted(id, titulo, autor, tipo, formato, estado);
  }
}
