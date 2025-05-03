package model;

public class No {
  Livro livro;
  No esquerda;
  No direita;

  public No(Livro livro){
    this.livro = livro;
    esquerda = null;
    direita = null;
  }
}
