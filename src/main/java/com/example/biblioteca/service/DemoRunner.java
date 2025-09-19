package com.example.biblioteca.service;

import com.example.biblioteca.domain.*;
import com.example.biblioteca.domain.adapter.LegacyLibro;
import com.example.biblioteca.domain.adapter.LegacyLibroAdapter;
import com.example.biblioteca.domain.abstractfactory.*;
import com.example.biblioteca.domain.builder.LibroBuilder;
import com.example.biblioteca.domain.factorymethod.FiccionFactory;
import com.example.biblioteca.domain.factorymethod.LibroFactory;
import com.example.biblioteca.domain.observer.PrestamoObserver;
import com.example.biblioteca.domain.strategy.SearchByAuthor;
import com.example.biblioteca.domain.strategy.SearchByTitle;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DemoRunner implements CommandLineRunner {
  private final LibroService service;
  public DemoRunner(LibroService service) { this.service = service; }

  @Override public void run(String... args) {
    service.registrarObservador(new PrestamoObserver());
//arma felxible y legible
    AbstractLibroFactory formatoFactory = new LibroDigitalFactory();
    ILibro libro1 = new LibroBuilder()
        .conId(null)
        .conTitulo("El Viaje de la Aurora")
        .conAutor("L. Rivera")
        .conTipo(LibroTipo.FICCION)
        .conFormato(formatoFactory.formato())
        .build();
    service.agregarLibro(libro1);

    LibroFactory ficcionFactory = new FiccionFactory();
    ILibro libro2 = ficcionFactory.crear("Patagonia Azul", "M. Torres");
    service.agregarLibro(libro2);
//adaptar a algo nuevo
    LegacyLibro legacy = new LegacyLibro(999, "Manual Antiguo", "Autor X");
    ILibro adaptado = new LegacyLibroAdapter(legacy, LibroTipo.NO_FICCION, LibroFormato.FISICO);
    service.agregarLibro(adaptado);

    service.buscar(new SearchByTitle(), "Viaje").forEach(System.out::println);
    service.buscar(new SearchByAuthor(), "Torres").forEach(System.out::println);

    service.prestar(libro2.getId());

    service.listar().forEach(System.out::println);
  }
}
