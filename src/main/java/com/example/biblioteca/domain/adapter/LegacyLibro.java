package com.example.biblioteca.domain.adapter;
public class LegacyLibro {
  private final int codigo;
  private final String nombreObra;
  private final String escritor;
  public LegacyLibro(int codigo, String nombreObra, String escritor){
    this.codigo=codigo; this.nombreObra=nombreObra; this.escritor=escritor;
  }
  public int getCodigo(){ return codigo; }
  public String getNombreObra(){ return nombreObra; }
  public String getEscritor(){ return escritor; }
}
