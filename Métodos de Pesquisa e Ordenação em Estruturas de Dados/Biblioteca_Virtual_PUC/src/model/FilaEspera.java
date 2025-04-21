package model;

import java.util.LinkedList;
import java.util.Objects;
import java.util.Queue;

public class FilaEspera {
  private Queue<Usuario> fila;

  public FilaEspera(){
    this.fila = new LinkedList<>();
  }

  public void entrarNaFila(Usuario user){
    this.fila.add(user);
  }

  public void desnfilerar(){
    if(!estaVazia()){
      this.fila.poll();
    }
    else {
      System.out.println("Fila vazia!");
    }
  }

  public int atentimento(String titulo, Bliblioteca livrosBiblioteca){
    boolean livroEncontrado = false;
    Usuario user = fila.element();
    for (Livro livro : livrosBiblioteca.getLivros()){
      if (Objects.equals(livro.getTitulo(), titulo)) {
        livroEncontrado = true;
        break;
      }
    }
    desnfilerar();
    if (!livroEncontrado){
      System.out.println("Livro informado não catalogado.");
      return -1;
    }
    else {
      System.out.println("O Usuário: " + user.getNome() + ", emprestou o livro: " + titulo);
      return 0;
    }
  }

  public void exibeFila(){
    if(estaVazia()){
      System.out.println("Fila está vazia!");
    }
    else {
      for (Usuario user : this.fila){
        System.out.println("- " + user.getNome());
      }
    }
  }

  public boolean estaVazia(){
    return this.fila.isEmpty();
  }
}
