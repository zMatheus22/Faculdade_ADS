package model;

public class No {
  private final Livro livro;
  public No esquerda;
  public No direita;

  public No(Livro livro){
    this.livro = livro;
    this.esquerda = null;
    this.direita = null;
  }

  public Livro getLivro(){
    return livro;
  }
}
