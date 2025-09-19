package com.example.biblioteca.domain.adapter;

import com.example.biblioteca.domain.*;

public class LegacyLibroAdapter implements ILibro {
  private final LegacyLibro legacy;
  private Long id;
  private final LibroTipo tipo;
  private final LibroFormato formato;
  private LibroEstado estado = LibroEstado.DISPONIBLE;

  public LegacyLibroAdapter(LegacyLibro legacy, LibroTipo tipo, LibroFormato formato){
    this.legacy=legacy; this.tipo=tipo; this.formato=formato; this.id = (long) legacy.getCodigo();
  }
  @Override public Long getId(){ return id; }
  @Override public void setId(Long id){ this.id = id; }
  @Override public String getTitulo(){ return legacy.getNombreObra(); }
  @Override public String getAutor(){ return legacy.getEscritor(); }
  @Override public LibroTipo getTipo(){ return tipo; }
  @Override public LibroFormato getFormato(){ return formato; }
  @Override public LibroEstado getEstado(){ return estado; }
  @Override public void setEstado(LibroEstado estado){ this.estado = estado; }
}
