package model;

public class MergeSort {
  private int comparacoes = 0;

  public String[] ordenar(String[] oldArr) {
    String[] arr = oldArr.clone();
    if (arr.length < 2) {
      return arr;
    }

    int meio = arr.length / 2;
    String[] esquerda = new String[meio];
    String[] direita = new String[arr.length - meio];

    System.arraycopy(arr, 0, esquerda, 0, meio);
    System.arraycopy(arr, meio, direita, 0, arr.length - meio);

    esquerda = ordenar(esquerda);
    direita = ordenar(direita);

    return merge(esquerda, direita);
  }

  private String[] merge(String[] esquerda, String[] direita) {
    String[] resultado = new String[esquerda.length + direita.length];
    int i = 0, j = 0, k = 0;

    while (i < esquerda.length && j < direita.length) {
      comparacoes++;
      if (esquerda[i].compareTo(direita[j]) <= 0) {
        resultado[k++] = esquerda[i++];
      } else {
        resultado[k++] = direita[j++];
      }
    }

    while (i < esquerda.length) {
      resultado[k++] = esquerda[i++];
    }

    while (j < direita.length) {
      resultado[k++] = direita[j++];
    }

    return resultado;
  }

  public int getComparacoes() {
    return comparacoes;
  }
}
