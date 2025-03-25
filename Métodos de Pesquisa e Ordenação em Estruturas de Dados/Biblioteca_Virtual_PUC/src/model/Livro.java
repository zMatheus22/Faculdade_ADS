package model;

public class Livro {
  private final String titulo;
  private final String autor;
  private final int ano;

  public Livro(String titulo, String autor, int ano){
    this.titulo = titulo;
    this.autor = autor;
    this.ano = ano;
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

  public String getLivro(){
    return "Título: " + getTitulo() + ", Autor: " + getAutor() + ", Ano: " + getAno();
  }
}
