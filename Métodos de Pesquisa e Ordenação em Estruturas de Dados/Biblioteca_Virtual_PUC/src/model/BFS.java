package model;

import java.util.LinkedList;
import java.util.Queue;

public class BFS {
  public static boolean buscaBFS(No raiz, String titulo) {
    Livro livro = raiz.getLivro();

    if (raiz == null) {
      return false;
    }

    Queue<No> fila = new LinkedList<>();
    fila.add(raiz);

    while (!fila.isEmpty()) {
      No node = fila.poll();

      if (raiz.getLivro().getTitulo().equalsIgnoreCase(titulo)){
        System.out.println("Livro encontrado com BFS!");
        System.out.println("Dados do livro:");
        System.out.println(livro.getDado(livro));
        System.out.println("Dados da árvore:");
        System.out.println(raiz);
        return true;
      }

      if (node.esquerda != null) {
        fila.add(node.esquerda);
      }
      if (node.direita != null) {
        fila.add(node.direita);
      }
    }
    return false;
  }
}
