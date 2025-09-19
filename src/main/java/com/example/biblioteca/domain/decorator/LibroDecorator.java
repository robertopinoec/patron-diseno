package com.example.biblioteca.domain.decorator;

import com.example.biblioteca.domain.ILibro;

public abstract class LibroDecorator implements ILibro {
  protected final ILibro wrappee;
  protected LibroDecorator(ILibro wrappee){ this.wrappee = wrappee; }
  @Override public Long getId(){ return wrappee.getId(); }
  @Override public void setId(Long id){ wrappee.setId(id); }
  @Override public String getTitulo(){ return wrappee.getTitulo(); }
  @Override public String getAutor(){ return wrappee.getAutor(); }
  @Override public com.example.biblioteca.domain.LibroTipo getTipo(){ return wrappee.getTipo(); }
  @Override public com.example.biblioteca.domain.LibroFormato getFormato(){ return wrappee.getFormato(); }
  @Override public com.example.biblioteca.domain.LibroEstado getEstado(){ return wrappee.getEstado(); }
  @Override public void setEstado(com.example.biblioteca.domain.LibroEstado e){ wrappee.setEstado(e); }
}
