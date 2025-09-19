package com.example.biblioteca;

import com.example.biblioteca.domain.*;
import com.example.biblioteca.domain.builder.LibroBuilder;
import com.example.biblioteca.service.LibroService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.jupiter.api.Assertions.*;

//@SpringBootTest
class BibliotecaApplicationTests {

  @Autowired LibroService service;

 // @Test @Transactional
  void contextLoadsAndBasicFlow() {
    ILibro libro = new LibroBuilder()
        .conTitulo("Test Title")
        .conAutor("Autor Prueba")
        .conTipo(LibroTipo.FICCION)
        .conFormato(LibroFormato.FISICO)
        .build();
    ILibro guardado = service.agregarLibro(libro);
    assertNotNull(guardado.getId());
    assertFalse(service.listar().isEmpty());
    service.prestar(guardado.getId());
    assertEquals(LibroEstado.PRESTADO,
        service.listar().stream().filter(l->l.getId().equals(guardado.getId())).findFirst().get().getEstado());
  }
}
