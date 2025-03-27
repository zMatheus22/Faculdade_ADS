package model;

import java.util.LinkedList;
import java.util.Objects;

public class LinkedListBliblioteca {
  private final LinkedList <Livro> livros;

  public LinkedListBliblioteca(){
    this.livros = new LinkedList<>();
  }

  public void addLivro(Livro livro){
    this.livros.add(livro);
  }

  public void removeLivro(String titulo) {
    for(Livro livro : this.livros){
      if (Objects.equals(livro.getTitulo(), titulo)){
        this.livros.remove(livro);
        return;
      }
    }
  }

  public LinkedList<Livro> getLivros(){
    return livros;
  }

  public Livro getLivro(Livro livro){
    return livro;
  }

  public void getDadoLivros(){
    for (Livro livro : livros){
      System.out.println("Livro: " + livro.getTitulo() +", Autor: " + livro.getAutor() + ", Ano: " + livro.getAno());
    }
  }

  public void getLivroPorTitulo(String titulo){
    for(Livro livro : this.livros){
      if (Objects.equals(livro.getTitulo(), titulo)){
        System.out.println(livro.getLivro());
        return;
      }
    }
    System.out.println("Nem um livro encontrado!");
  }

  public void getLivroPorAutor(String autor){
    boolean achou = false;

    for(Livro livro : this.livros){
      String autorLivro = livro.getAutor().trim();
      if (autorLivro.equalsIgnoreCase(autor.trim())){
        System.out.println(livro.getTitulo() + ", "+ livro.getAno());
        return;
      }
    }

    if (!achou){
      System.out.println("Nem um livro encontrado!");
    }
  }
}
