package model;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Stack;

public class HistoricoNavegacao {
  private Stack<String> historico = new Stack<>();

  public void adicionarHistorico(String valor, String opcao, Usuario user){
    LocalDate data = LocalDate.now();
    LocalTime time = LocalTime.now();
    DadoHistorico  dado = new DadoHistorico(valor, opcao, user, data, time);
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
    Stack<String> copia = (Stack<String>) historico.clone();
    System.out.println("Histórico de navegação:");
    while (!copia.isEmpty()) {
      System.out.println("- " + copia.pop());
    }
  }


  public boolean estaVazio(){
    return this.historico.isEmpty();
  }

}
