package com.example.biblioteca.domain.observer;
import com.example.biblioteca.domain.ILibro;
public record LibroEvent(ILibro libro, String mensaje) {}
