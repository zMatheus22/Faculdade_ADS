package model;

public class BubbleSort {
  private int comparacoes = 0;

  public String[] ordenar(String[] oldArr) {
    int n = oldArr.length;
    String[] arr = oldArr.clone();
    for (int i = 0; i < n - 1; i++) {
      for (int j = 0; j < n - i - 1; j++) {
        comparacoes++;
        if (arr[j].compareTo(arr[j + 1]) > 0) {
          String temp = arr[j];
          arr[j] = arr[j + 1];
          arr[j + 1] = temp;
        }
      }
    }
    return arr;
  }

  public int getComparacoes() {
    return comparacoes;
  }
}
