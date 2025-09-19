package com.example.biblioteca.domain.observer;

public class PrestamoObserver implements Observer {
  @Override public void onNotify(LibroEvent event) {
    System.out.println("[OBSERVADOR] " + event.mensaje() + " -> " + event.libro());
  }
}
