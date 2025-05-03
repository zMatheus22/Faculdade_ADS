package model;

public class Livro {
  private final String titulo;
  private final String autor;
  private final int ano;
  private final String categoria;

  public Livro(String titulo, String autor, int ano, String categoria){
    this.titulo = titulo;
    this.autor = autor;
    this.ano = ano;
    this.categoria = categoria;
  }

  public String getTitulo(){
    return this.titulo;
  }

  public String getAutor(){
    return this.autor;
  }

  public int getAno(){
    return this.ano;
  }

  public String getCategoria(){
    return this.categoria;
  }

  public String getDado(Livro livro){
    return "Título: " + livro.getTitulo() +
        ", Ano: " + livro.getAno() +
        ", Autor: " + livro.getAutor()+
        ", Categoria: " + livro.getCategoria();
  }
}
