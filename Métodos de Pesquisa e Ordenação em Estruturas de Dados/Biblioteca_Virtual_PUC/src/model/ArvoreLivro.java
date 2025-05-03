package model;

public class ArvoreLivro {
  private No raiz;

  public ArvoreLivro(){
    raiz = null;
  }

  public void inserirLivro(Livro livro){
    raiz = inserirRecursivo(raiz, livro);
  }

  private No inserirRecursivo(No atual, Livro livro){
    if (atual == null){
      return new No(livro);
    }

    if (livro.getTitulo().compareToIgnoreCase(atual.livro.getTitulo()) < 0){
      atual.esquerda = inserirRecursivo(atual.esquerda, livro);
    }
    else {
      atual.direita = inserirRecursivo(atual.direita, livro);
    }

    return atual;
  }

  public Livro buscar(String valor){
    return buscarRecursivo(raiz, valor);
  }

  private Livro buscarRecursivo(No atual, String valor){
    if (atual == null){
      return null;
    }

    // verifica se a o título ou a categoria;
    int camparaTitulo = valor.compareToIgnoreCase(atual.livro.getTitulo());

    if (camparaTitulo == 0){
      return atual.livro;
    } else if (camparaTitulo < 0) {
      return buscarRecursivo(atual.esquerda, valor);
    }
    else {
      return buscarRecursivo(atual.direita, valor);
    }
  }

  public void remover(String valor){
    raiz = removerRecursivo(raiz, valor);
  }

  private No removerRecursivo(No atual, String valor){
    if (atual == null){
      return null;
    }

    int camparaTitulo = valor.compareToIgnoreCase(atual.livro.getTitulo());

    if (camparaTitulo == 0){
      if (atual.esquerda == null && atual.direita == null){
        return null;
      }

      if (atual.esquerda == null){
        return atual.direita;
      }

      if (atual.direita == null){
        return atual.esquerda;
      }

      Livro maiorLivro = buscarMaiorLivro(atual.esquerda);
      atual.livro = maiorLivro;
      atual.esquerda = removerRecursivo(atual.esquerda, maiorLivro.getTitulo());

      return atual;
    }
    else if (camparaTitulo < 0){
      removerRecursivo(atual.esquerda, valor);
    }else {
      removerRecursivo(atual.direita, valor);
    }

    return atual;
  }

  private Livro buscarMaiorLivro(No raiz){
    while (raiz.direita != null) {
      raiz = raiz.direita;
    }
    return raiz.livro;
  }

  // Mostrar árvore
  public void mostrar() {
    mostrarRecursivo(raiz);
  }

  private void mostrarRecursivo(No raiz) {
    if (raiz != null) {
      mostrarRecursivo(raiz.esquerda);
      System.out.println(raiz.livro.getDado(raiz.livro));
      mostrarRecursivo(raiz.direita);
    }
  }

}
