package model;

import java.util.*;

public class Biblioteca {
  private final HashMap<Livro, Set<Livro>> livros;

  public Biblioteca(){
    this.livros = new HashMap<>();
  }

  public void addLivro(Livro livro){
    this.livros.putIfAbsent(livro, new HashSet<>());
  }

  public void addRecomendacao(Livro base, Livro recomendado) {
    livros.putIfAbsent(base, new HashSet<>());
    livros.putIfAbsent(recomendado, new HashSet<>());
    livros.get(base).add(recomendado);
  }

  public Set<Livro> recomendarLivro(Livro livro){
    return livros.getOrDefault(livro, new HashSet<>());
  }

  public static void recomendarLivro(Livro origem, HashMap<Livro, Set<Livro>> grafo) {
    Map<Livro, Integer> distancias = djikstraSimples(grafo, origem);

    System.out.println("Recomendações a partir do livro: " + origem.titulo());
    distancias.entrySet().stream()
      .sorted(Map.Entry.comparingByValue())
      .forEach(entry -> {
        System.out.println("Livro: " + entry.getKey().titulo() + " | Distância: " + entry.getValue());
      });
  }

  public static Map<Livro, Integer> djikstraSimples(HashMap<Livro, Set<Livro>> grafo, Livro origem) {
    Map<Livro, Integer> distancias = new HashMap<>();
    Queue<Livro> fila = new LinkedList<>();

    distancias.put(origem, 0); // como não temos pesos entre os nós, o peso padrão é 0
    fila.add(origem);

    while (!fila.isEmpty()) {
      Livro atual = fila.poll();
      int distanciaAtual = distancias.get(atual);

      for (Livro vizinho : grafo.getOrDefault(atual, new HashSet<>())) {
        if (!distancias.containsKey(vizinho)) {
          distancias.put(vizinho, distanciaAtual + 1);
          fila.add(vizinho);
        }
      }
    }
    return distancias;
  }

  public void mostrarGrafo(){
    for (Livro livro: livros.keySet()){
      System.out.println("Livro: " + livro.titulo());
      for (Livro recomendacao : livros.get(livro)){
        System.out.println(" ↳ Relacionado: " + recomendacao.titulo());
      }
    }
  }

  public Set<Livro> getLivro(){
    return livros.keySet();
  }

  public void getDadoLivro(){
    for (Livro livro : livros.keySet()){
      System.out.println("Livro: " + livro.titulo() +
                         ", Autor: " + livro.autor() +
                         ", Ano: " + livro.ano() +
                         ", Categoria: " + livro.categoria());
    }
  }

  public void getDadoLivro(String titulo){
    for(Livro livro : livros.keySet()){
      if (livro.titulo().equalsIgnoreCase(titulo)) {
        System.out.println("Livro: " + livro.titulo() +
            ", Autor: " + livro.autor() +
            ", Ano: " + livro.ano() +
            ", Categoria: " + livro.categoria());
        return;
      }
    }
  }

  public Livro getLivroPorTitulo(String titulo){
    for(Livro livro : livros.keySet()){
      if (livro.titulo().equalsIgnoreCase(titulo)){
        return livro;
      }
    }
    return null;
  }

  public HashMap<Livro, Set<Livro>> getLivros() {
    return livros;
  }

  public void getLivroPorAutor(String autor){
    boolean achou = false;

    for(Livro livro : livros.keySet()){
      String autorLivro = livro.autor().trim();
      if (autorLivro.equalsIgnoreCase(autor.trim())){
        System.out.println("Livro: " + livro.titulo() +
                           ", Ano: "+ livro.ano() +
                           ", Categoria: " + livro.categoria());
        return;
      }
    }

    if (!achou){
      System.out.println("Nem um livro encontrado!");
    }
  }
}
