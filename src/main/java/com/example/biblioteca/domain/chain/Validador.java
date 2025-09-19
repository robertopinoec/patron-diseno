package com.example.biblioteca.domain.chain;

import com.example.biblioteca.domain.ILibro;

/**
 * Valida datos de un libro.
 */
public abstract class Validador {
  private Validador siguiente;
  public Validador encadenar(Validador next){ this.siguiente = next; return next; }
  public void validar(ILibro libro){
    ejecutar(libro);
    if(siguiente!=null) siguiente.validar(libro);
  }
  protected abstract void ejecutar(ILibro libro);
}
