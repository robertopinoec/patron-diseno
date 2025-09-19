package com.example.biblioteca.service;

import com.example.biblioteca.domain.*;
import com.example.biblioteca.domain.chain.Validador;
import com.example.biblioteca.domain.chain.ValidadorAutor;
import com.example.biblioteca.domain.chain.ValidadorTitulo;
import com.example.biblioteca.domain.decorator.PrestamoDecorator;
import com.example.biblioteca.domain.observer.LibroEvent;
import com.example.biblioteca.domain.observer.Observer;
import com.example.biblioteca.domain.strategy.SearchStrategy;
import com.example.biblioteca.infra.jpa.LibroEntity;
import com.example.biblioteca.infra.jpa.LibroRepository;
import com.example.biblioteca.infra.jdbc.JdbcLibroAuditRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class LibroService {

  private final LibroRepository repo;
  private final JdbcLibroAuditRepository auditRepo = new JdbcLibroAuditRepository();
  private final List<Observer> observers = new ArrayList<>();

  public LibroService(LibroRepository repo) { this.repo = repo; }

  public void registrarObservador(Observer obs){ observers.add(obs); }
  private void notificar(ILibro libro, String msg){
    observers.forEach(o -> o.onNotify(new LibroEvent(libro, msg)));
  }

  @Transactional
  public ILibro agregarLibro(ILibro libro){
    Validador chain = new ValidadorTitulo();
    chain.encadenar(new ValidadorAutor());
    chain.validar(libro);

    LibroEntity e = mapToEntity(libro);
    LibroEntity guardado = repo.save(e);
    libro.setId(guardado.getId());
    return libro;
  }

  @Transactional(readOnly = true)
  public List<ILibro> buscar(SearchStrategy strategy, String criterio){
    List<ILibro> all = repo.findAll().stream().map(this::mapToDomain).collect(Collectors.toList());
    return strategy.buscar(all, criterio);
  }

  @Transactional(readOnly = true)
  public List<ILibro> listar(){
    return repo.findAll().stream().map(this::mapToDomain).toList();
  }

  @Transactional
  public void prestar(Long id){
    LibroEntity e = repo.findById(id).orElseThrow(() -> new NoSuchElementException("No existe libro id="+id));
    ILibro libro = mapToDomain(e);
    PrestamoDecorator decorator = new PrestamoDecorator(libro);
    decorator.prestar();
    e.setEstado(libro.getEstado());
    repo.save(e);
    auditRepo.registrarPrestamo(e.getId(), e.getTitulo());
    notificar(libro, "Libro prestado");
  }

  private LibroEntity mapToEntity(ILibro l){
    LibroEntity e = new LibroEntity();
    e.setId(null);
    e.setTitulo(l.getTitulo());
    e.setAutor(l.getAutor());
    e.setTipo(l.getTipo());
    e.setFormato(l.getFormato());
    e.setEstado(l.getEstado());
    return e;
  }
  private ILibro mapToDomain(LibroEntity e){
    ILibro l = (e.getFormato()==LibroFormato.FISICO)
        ? new LibroFisico(e.getId(), e.getTitulo(), e.getAutor(), e.getTipo())
        : new LibroDigital(e.getId(), e.getTitulo(), e.getAutor(), e.getTipo());
    l.setEstado(e.getEstado());
    return l;
  }
}
