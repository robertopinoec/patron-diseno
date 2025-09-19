package com.example.biblioteca.web;

import com.example.biblioteca.domain.*;
import com.example.biblioteca.domain.builder.LibroBuilder;
import com.example.biblioteca.domain.strategy.SearchByAuthor;
import com.example.biblioteca.domain.strategy.SearchByTitle;
import com.example.biblioteca.domain.strategy.SearchStrategy;
import com.example.biblioteca.service.LibroService;
import jakarta.validation.constraints.NotBlank;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/libros")
public class LibroController {

  private final LibroService service;
  public LibroController(LibroService service){ this.service = service; }

  @GetMapping
  public List<ILibro> listar(){ return service.listar(); }

  public record LibroRequest(@NotBlank String titulo, @NotBlank String autor,
                             LibroTipo tipo, LibroFormato formato){}

  @PostMapping
  public ResponseEntity<ILibro> agregar(@RequestBody LibroRequest req){
    ILibro libro = new LibroBuilder()
        .conTitulo(req.titulo())
        .conAutor(req.autor())
        .conTipo(req.tipo()==null?LibroTipo.FICCION:req.tipo())
        .conFormato(req.formato()==null?LibroFormato.FISICO:req.formato())
        .build();
    return ResponseEntity.ok(service.agregarLibro(libro));
  }

  @GetMapping("/buscar")
  public List<ILibro> buscar(@RequestParam String tipo, @RequestParam String valor){
    SearchStrategy strategy = switch (tipo.toLowerCase()) {
      case "titulo" -> new SearchByTitle();
      case "autor" -> new SearchByAuthor();
      default -> new SearchByTitle();
    };
    return service.buscar(strategy, valor);
  }

  @PostMapping("/{id}/prestar")
  public ResponseEntity<Void> prestar(@PathVariable Long id){
    service.prestar(id);
    return ResponseEntity.noContent().build();
  }
}
