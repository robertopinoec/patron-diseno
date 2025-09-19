package com.example.biblioteca.infra.jpa;

import com.example.biblioteca.domain.LibroEstado;
import com.example.biblioteca.domain.LibroFormato;
import com.example.biblioteca.domain.LibroTipo;
import jakarta.persistence.*;

@Entity @Table(name="libros")
public class LibroEntity {
  @Id @GeneratedValue(strategy=GenerationType.IDENTITY)
  private Long id;
  private String titulo;
  private String autor;
  @Enumerated(EnumType.STRING) private LibroTipo tipo;
  @Enumerated(EnumType.STRING) private LibroFormato formato;
  @Enumerated(EnumType.STRING) private LibroEstado estado = LibroEstado.DISPONIBLE;

  public Long getId(){ return id; } public void setId(Long id){ this.id=id; }
  public String getTitulo(){ return titulo; } public void setTitulo(String t){ this.titulo=t; }
  public String getAutor(){ return autor; } public void setAutor(String a){ this.autor=a; }
  public LibroTipo getTipo(){ return tipo; } public void setTipo(LibroTipo t){ this.tipo=t; }
  public LibroFormato getFormato(){ return formato; } public void setFormato(LibroFormato f){ this.formato=f; }
  public LibroEstado getEstado(){ return estado; } public void setEstado(LibroEstado e){ this.estado=e; }
}
