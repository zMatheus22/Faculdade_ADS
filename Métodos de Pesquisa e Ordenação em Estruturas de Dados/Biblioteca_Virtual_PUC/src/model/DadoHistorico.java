package model;

import java.time.LocalDate;
import java.time.LocalTime;

public class DadoHistorico {
  private final String valor;
  private final String opcao;
  private final Usuario usuario;
  private final LocalDate data;
  private final LocalTime time;

  public DadoHistorico(String valor, String opcao, Usuario usuario, LocalDate data, LocalTime time) {
    this.valor = valor;
    this.opcao = opcao;
    this.usuario = usuario;
    this.data = data;
    this.time = time;
  }

  @Override
  public String toString() {
    return "Pesquisa: " + valor +
           ", Tipo de pesquisa: " + opcao +
           ", Usuário: " + usuario.getNome() +
           ", Data: " + data +
           ", Hora: " + time;
  }
}
