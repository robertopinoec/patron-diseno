package com.example.biblioteca.domain.decorator;

import com.example.biblioteca.domain.ILibro;
import com.example.biblioteca.domain.LibroEstado;

public class PrestamoDecorator extends LibroDecorator {
  public PrestamoDecorator(ILibro wrappee){ super(wrappee); }
  public void prestar(){
    if(getEstado()==LibroEstado.PRESTADO) throw new IllegalStateException("Ya está prestado");
    setEstado(LibroEstado.PRESTADO);
  }
}
