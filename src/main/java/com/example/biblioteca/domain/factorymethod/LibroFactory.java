package com.example.biblioteca.domain.factorymethod;
import com.example.biblioteca.domain.ILibro;
public interface LibroFactory {
  ILibro crear(String titulo, String autor);
}
