package model;

import java.time.LocalDate;
import java.time.LocalTime;

public class DadoHistorico {
  private String titulo;
  private Usuario usuario;
  private LocalDate data;
  private LocalTime time;

  public DadoHistorico(String valor, Usuario usuario, LocalDate data, LocalTime time) {
    this.titulo = valor;
    this.usuario = usuario;
    this.data = data;
    this.time = time;
  }

  @Override
  public String toString() {
    return "Livro: " + titulo + ", Usuário: " + usuario.getNome() + ", Data: " + data + ", Hora: " + time;
  }
}
