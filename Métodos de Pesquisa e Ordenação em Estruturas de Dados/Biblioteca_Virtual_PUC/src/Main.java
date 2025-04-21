/**
 * Métodos de Pesquisa e Ordenação em Estruturas de Dados |
 * Sistema de gerenciamento para uma biblioteca virtual | PUC-PR
 *
 * @ATIVIDADE FORMATIVA - Semana 3

 * @Curso: Análise e Desenvolvimento de Sistemas
 * @Autor: Matheus Vinicyus Strada
 */

import model.*;
import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Bliblioteca biblioteca = new Bliblioteca();
    FilaEspera espera = new FilaEspera();
    HistoricoNavegacao historico = new HistoricoNavegacao();

    Scanner scanner = new Scanner(System.in);
    System.out.println("\n=== BIBLIOTECA VIRTUAL ===");
    System.out.println("Informe o seu nome: ");
    Usuario usuario = new Usuario(scanner.nextLine());

    biblioteca.addLivro(new Livro("Clean Code", "Robert C. Martin", 2008));
    biblioteca.addLivro(new Livro("The Pragmatic Programmer", "Andrew Hunt & David Thomas", 1999));
    biblioteca.addLivro(new Livro("Design Patterns", "Erich Gamma, Richard Helm, Ralph Johnson, John Vlissides", 1994));
    biblioteca.addLivro(new Livro("Refactoring", "Martin Fowler", 1999));
    biblioteca.addLivro(new Livro("Code Complete", "Steve McConnell", 1993));
    biblioteca.addLivro(new Livro("The Clean Coder", "Robert C. Martin", 2011));
    biblioteca.addLivro(new Livro("You Don’t Know JS", "Kyle Simpson", 2014));
    biblioteca.addLivro(new Livro("Introduction to the Theory of Computation", "Michael Sipser", 1997));
    biblioteca.addLivro(new Livro("Java: The Complete Reference", "Herbert Schildt", 2018));
    biblioteca.addLivro(new Livro("Eloquent JavaScript", "Marijn Haverbeke", 2011));

    int opcao = -1;
    int opcaoLivro;

    while (opcao != 0) {
      System.out.println("\n=== MENU BIBLIOTECA ===");
      System.out.println("1. Listar todos os livros");
      System.out.println("2. Buscar livro");
      System.out.println("3. Emprestar um livro");
      System.out.println("4. Exibir histórico de navegação");
      System.out.println("0. Sair");
      System.out.print("Escolha uma opção: ");
      opcao = scanner.nextInt();
      scanner.nextLine(); // limpar buffer

      switch (opcao) {
        case 1:
          biblioteca.getDadoLivros();
          break;

        case 2:
          opcaoLivro = -1;
          while (opcaoLivro != 0){
            System.out.println("\n=== MENU BUSCA DE LIVRO ===");
            System.out.println("1. Busca por título do livro");
            System.out.println("2. Buscar por autor");
            System.out.println("0. Voltarn ao menu");
            System.out.print("Escolha uma opção: ");
            opcaoLivro = scanner.nextInt();
            scanner.nextLine(); // limpar buffer
            switch (opcaoLivro){
              case 1:
                System.out.print("Digite o título do livro: ");
                String tituloBusca = scanner.nextLine();
                biblioteca.getLivroPorTitulo(tituloBusca);
                historico.adicionarHistorico(tituloBusca, usuario);
                break;
              case 2:
                System.out.print("Digite o nome do autor: ");
                String autorBusca = scanner.nextLine();
                biblioteca.getLivroPorAutor(autorBusca);
                break;
              case 0:
                System.out.println("Voltando para o menu!");
                break;
              default:
                System.out.println("Opção inválida. Tente novamente.");
            }
          }
          break;

        case 3:
          System.out.print("Digite o título do livro a ser emprestado: ");
          String titulo = scanner.nextLine();
          espera.atentimento(titulo, biblioteca);
          historico.adicionarHistorico(titulo, usuario);
          if (espera.estaVazia()) {
            System.out.println("Atentimento realizado com sucesso.");
          }
          break;

        case 4:
          historico.exibirHistorico();
          break;

        case 0:
          System.out.println("Saindo da biblioteca. Até mais!");
          break;

        default:
          System.out.println("Opção inválida. Tente novamente.");
      }
    }

    scanner.close();
  }
}
