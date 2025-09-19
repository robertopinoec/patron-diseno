package com.example.biblioteca.domain.abstractfactory;

import com.example.biblioteca.domain.ILibro;
import com.example.biblioteca.domain.LibroFormato;
import com.example.biblioteca.domain.LibroTipo;

public interface AbstractLibroFactory {
  LibroFormato formato();
  ILibro crear(Long id, String titulo, String autor, LibroTipo tipo);
}
