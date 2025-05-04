package model;

public class DFS {
  public static boolean buscaDFS(No node, String titulo) {
    Livro livro = node.getLivro();

    if (node == null) {
      return false;
    }

    if (livro.getTitulo().equalsIgnoreCase(titulo)){
      System.out.println("Livro encontrado com DFS!");
      System.out.println("Dados do livro:");
      System.out.println(livro.getDado(livro));
      System.out.println("Dados da árvore:");
      System.out.println(node);
      return true;
    }

    return buscaDFS(node.esquerda, titulo) || buscaDFS(node.direita, titulo);
  }
}
