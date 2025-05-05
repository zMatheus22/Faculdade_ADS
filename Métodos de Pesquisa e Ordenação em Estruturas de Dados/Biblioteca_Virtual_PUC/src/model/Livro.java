package model;

public record Livro(String titulo, String autor, int ano, String categoria) {

  public String getDado(Livro livro) {
    return "Título: " + livro.titulo() +
        ", Ano: " + livro.ano() +
        ", Autor: " + livro.autor() +
        ", Categoria: " + livro.categoria();
  }
}
