package model;

public class ArvoreLivro {
  private No raiz;

  public ArvoreLivro(){
    raiz = null;
  }

  public void inserirLivro(Livro livro){
    raiz = inserirRecursivo(raiz, livro);
  }

  private No inserirRecursivo(No node, Livro livro){
    if (node == null){
      return new No(livro);
    }

    if (livro.titulo().compareToIgnoreCase(node.getLivro().titulo()) < 0){
      node.esquerda = inserirRecursivo(node.esquerda, livro);
    }
    else {
      node.direita = inserirRecursivo(node.direita, livro);
    }

    return node;
  }

  public Livro buscar(String valor){
    return buscarRecursivo(raiz, valor);
  }

  private Livro buscarRecursivo(No node, String valor){
    if (node == null){
      return null;
    }

    int camparaTitulo = valor.compareToIgnoreCase(node.getLivro().titulo());

    if (camparaTitulo == 0){
      return node.getLivro();
    } else if (camparaTitulo < 0) {
      return buscarRecursivo(node.esquerda, valor);
    }
    else {
      return buscarRecursivo(node.direita, valor);
    }
  }

  public void remover(String valor){
    raiz = removerRecursivo(raiz, valor);
  }

  private No removerRecursivo(No node, String valor){
    Livro livro = node.getLivro();

    if (node == null){
      return null;
    }

    int camparaTitulo = valor.compareToIgnoreCase(node.getLivro().titulo());

    if (camparaTitulo == 0){
      if (node.esquerda == null && node.direita == null){
        return null;
      }

      if (node.esquerda == null){
        return node.direita;
      }

      if (node.direita == null){
        return node.esquerda;
      }

      Livro maiorLivro = buscarMaiorLivro(node.esquerda);
      livro = maiorLivro;
      node.esquerda = removerRecursivo(node.esquerda, maiorLivro.titulo());

      return node;
    }
    else if (camparaTitulo < 0){
      removerRecursivo(node.esquerda, valor);
    }else {
      removerRecursivo(node.direita, valor);
    }

    return node;
  }

  private Livro buscarMaiorLivro(No node){
    while (node.direita != null) {
      node = node.direita;
    }
    return node.getLivro();
  }

  // Mostrar árvore
  public void mostrar() {
    mostrarRecursivo(raiz);
  }

  private void mostrarRecursivo(No node) {
    if (node != null) {
      mostrarRecursivo(node.esquerda);
      System.out.println(node.getLivro().getDado(node.getLivro()));
      mostrarRecursivo(node.direita);
    }
  }

  public No getNo(){
    return this.raiz;
  }
}
