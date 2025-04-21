package model;

import java.util.*;

public class Biblioteca {
  private final Map<Livro, Set<Livro>> livros;

  public Biblioteca(){
    this.livros = new HashMap<>();
  }

  public void addLivro(Livro livro){
    this.livros.putIfAbsent(livro, new HashSet<>());
  }

  public void addRecomendacao(Livro base, Livro recomendado) {
    livros.putIfAbsent(base, new HashSet<>());
    livros.get(base).add(recomendado);
  }

  public Set<Livro> recomendarLivro(Livro livro){
    return livros.getOrDefault(livro, new HashSet<>());
  }

  public void mostrarGrafo(){
    for (Livro livro: livros.keySet()){
      System.out.println("Livro: " + livro.getTitulo());
      for (Livro recomendacao : livros.get(livro)){
        System.out.println(" ↳ Relacionado: " + recomendacao.getTitulo());
      }
    }
  }

  public Set<Livro> getLivros(){
    return livros.keySet();
  }

  public void getDadoLivro(){
    for (Livro livro : livros.keySet()){
      System.out.println("Livro: " + livro.getTitulo() +
                         ", Autor: " + livro.getAutor() +
                         ", Ano: " + livro.getAno() +
                         ", Categoria: " + livro.getCategoria());
    }
  }

  public void getDadoLivro(String titulo){
    for(Livro livro : livros.keySet()){
      if (livro.getTitulo().equalsIgnoreCase(titulo)) {
        System.out.println("Livro: " + livro.getTitulo() +
            ", Autor: " + livro.getAutor() +
            ", Ano: " + livro.getAno() +
            ", Categoria: " + livro.getCategoria());
        return;
      }
    }
  }

  public Livro getLivroPorTitulo(String titulo){
    for(Livro livro : livros.keySet()){
      if (livro.getTitulo().equalsIgnoreCase(titulo)){
        return livro;
      }
    }
    return null;
  }


  public void getLivroPorAutor(String autor){
    boolean achou = false;

    for(Livro livro : livros.keySet()){
      String autorLivro = livro.getAutor().trim();
      if (autorLivro.equalsIgnoreCase(autor.trim())){
        System.out.println("Livro: " + livro.getTitulo() +
                           ", Ano: "+ livro.getAno() +
                           ", Categoria: " + livro.getCategoria());
        return;
      }
    }

    if (!achou){
      System.out.println("Nem um livro encontrado!");
    }
  }
}
