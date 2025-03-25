package model;

import java.util.LinkedList;
import java.util.Objects;

public class LinkedListBliblioteca {
  private final LinkedList <Livro> livros;

  public LinkedListBliblioteca(){
    livros = new LinkedList<>();
  }

  public void addLivro(Livro livro){
    livros.add(livro);
  }

  public void removeLivro(String titulo) {
    for(Livro livro : livros){
      if (Objects.equals(livro.getTitulo(), titulo)){
        livros.remove(livro);
        return;
      }
    }
  }

  public void getLivros(){
    for(Livro livro : livros){
      System.out.println(livro.getLivro());
    }
  }

  public void getLivroPorTitulo(String titulo){
    for(Livro livro : livros){
      if (Objects.equals(livro.getTitulo(), titulo)){
        System.out.println(livro.getLivro());
        return;
      }
    }
    System.out.println("Nem um livro encontrado!");
  }

  public void getLivroPorAutor(String autor){
    boolean achou = false;

    for(Livro livro : livros){
      String autorLivro = livro.getAutor().trim();
      if (autorLivro.equalsIgnoreCase(autor.trim())){
        System.out.println(livro.getTitulo() + ", "+ livro.getAno());
        achou = true;
      }
    }

    if (!achou){
      System.out.println("Nem um livro encontrado!");
    }
  }
}
