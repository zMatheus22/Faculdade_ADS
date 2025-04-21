package model;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.LinkedList;
import java.util.Stack;

public class HistoricoNavegacao {
  private Stack<String> historico = new Stack<>();

  public void adicionarHistorico(String titulo, Usuario user){
    LocalDate data = LocalDate.now();
    LocalTime time = LocalTime.now();
    DadoHistorico  dado = new DadoHistorico(titulo, user, data, time);
    this.historico.addLast(String.valueOf(dado));
  }

  public String removerHistorico(){
    if(!this.estaVazio()){
      return this.historico.removeLast();
    }
    else {
      return null;
    }
  }

  public void exibirHistorico() {
    for (int i = historico.size() - 1; i >= 0; i--) {
      System.out.println(historico.get(i));
    }
  }

  public boolean estaVazio(){
    return this.historico.isEmpty();
  }

}
