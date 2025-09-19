package com.example.biblioteca.domain.builder;

import com.example.biblioteca.domain.*;

public class LibroBuilder {
  private Long id;
  private String titulo;
  private String autor;
  private LibroTipo tipo = LibroTipo.FICCION;
  private LibroFormato formato = LibroFormato.FISICO;

  public LibroBuilder conId(Long id){ this.id=id; return this; }
  public LibroBuilder conTitulo(String t){ this.titulo=t; return this; }
  public LibroBuilder conAutor(String a){ this.autor=a; return this; }
  public LibroBuilder conTipo(LibroTipo t){ this.tipo=t; return this; }
  public LibroBuilder conFormato(LibroFormato f){ this.formato=f; return this; }

  public ILibro build(){
    return (formato==LibroFormato.FISICO)
        ? new LibroFisico(id,titulo,autor,tipo)
        : new LibroDigital(id,titulo,autor,tipo);
  }
}
