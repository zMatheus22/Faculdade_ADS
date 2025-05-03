/**
 * Métodos de Pesquisa e Ordenação em Estruturas de Dados |
 * Sistema de gerenciamento para uma biblioteca virtual | PUC-PR
 *
 * @ATIVIDADE_Formativa_-_Semana_6

 * @Curso: Análise e Desenvolvimento de Sistemas
 * @Autor: Matheus Vinicyus Strada
 */

import model.*;
import java.util.Objects;
import java.util.Scanner;
import java.util.Set;

public class Main {
  public static void main(String[] args) {
    Biblioteca biblioteca = new Biblioteca();
    FilaEspera espera = new FilaEspera();
    HistoricoNavegacao historico = new HistoricoNavegacao();
    ArvoreLivro arvoreLivros = new ArvoreLivro();
    BubbleSort bs = new BubbleSort();
    MergeSort ms = new MergeSort();

    Scanner scanner = new Scanner(System.in);
    int opcao = -1;
    int opcaoLivro;
    String valor;

    // Criando os livros
    Livro l1 = new Livro("Clean Code", "Robert C. Martin", 2008, "Engenharia de Software");
    Livro l2 = new Livro("The Pragmatic Programmer", "Andrew Hunt", 1999, "Engenharia de Software");
    Livro l3 = new Livro("Design Patterns", "Erich Gamma", 1994, "Padrões de Projeto");
    Livro l4 = new Livro("Refactoring", "Martin Fowler", 1999, "Refatoração");
    Livro l5 = new Livro("Code Complete", "Steve McConnell", 1993, "Engenharia de Software");
    Livro l6 = new Livro("You Don’t Know JS", "Kyle Simpson", 2014, "JavaScript");
    Livro l7 = new Livro("Eloquent JavaScript", "Marijn Haverbeke", 2011, "JavaScript");
    Livro l8 = new Livro("Java: The Complete Reference", "Herbert Schildt", 2018, "Java");
    Livro l9 = new Livro("Effective Java", "Joshua Bloch", 2018, "Java");
    Livro l10 = new Livro("Head First Design Patterns", "Eric Freeman", 2004, "Padrões de Projeto");

    Livro[] livros = {l1, l2, l3, l4, l5, l6, l7, l8, l9, l10};

    // Adicionando os livros na biblioteca (grafo).
    for (Livro livro : livros) {
      biblioteca.addLivro(livro);
    }
    // Adicionando os livros na biblioteca (Árvore).
    for (Livro livro : livros) {
      arvoreLivros.inserirLivro(livro);
    }

    // Criando os relacionamentos dos livros com base na Categoria ou Autor!
    for (Livro livroBase : livros) {
      for (Livro livroRelacao : livros) {
        // Evita recomendar o próprio livro & verifica a Categoria e Autor!
        if (!livroBase.equals(livroRelacao) &&
            (Objects.equals(livroBase.getCategoria(), livroRelacao.getCategoria()) ||
             Objects.equals(livroBase.getAutor(), livroRelacao.getAutor()))) {
          biblioteca.addRecomendacao(livroBase, livroRelacao);
          biblioteca.addRecomendacao(livroRelacao, livroBase);
        }
      }
    }

    // Inicio do programa!
    System.out.println("\n=== BIBLIOTECA VIRTUAL ===");
    System.out.println("Informe o seu nome: ");
    Usuario usuario = new Usuario(scanner.nextLine());

    while (opcao != 0) {
      System.out.println("\n=== MENU BIBLIOTECA ===");
      System.out.println("1. Listar todos os livros");
      System.out.println("2. Listar todos os relaciamentos");
      System.out.println("3. Buscar livro");
      System.out.println("4. Emprestar um livro");
      System.out.println("5. Exibir histórico de navegação");
      System.out.println("6. Exibir árvore de livro");
      System.out.println("7. Comparação de BubleSort vs MergeSort");
      System.out.println("0. Sair");
      System.out.print("Escolha uma opção: ");
      opcao = scanner.nextInt();
      scanner.nextLine();

      switch (opcao) {
        case 1:
          biblioteca.getDadoLivro();
          System.out.println("Pressione 'ENTER' para continuar!");
          scanner.nextLine();
          break;

        case 2:
          biblioteca.mostrarGrafo();
          System.out.println("Pressione 'ENTER' para continuar!");
          scanner.nextLine();
          break;

        case 3:
          opcaoLivro = -1;
          while (opcaoLivro != 0){
            System.out.println("\n=== MENU BUSCA DE LIVRO ===");
            System.out.println("1. Busca por título do livro");
            System.out.println("2. Buscar por autor");
            System.out.println("3. Buscar relacimento de livro");
            System.out.println("4. Procurar livro na árvore");
            System.out.println("0. Voltarn ao menu");
            System.out.print("Escolha uma opção: ");
            opcaoLivro = scanner.nextInt();
            scanner.nextLine();
            switch (opcaoLivro){
              case 1:
                System.out.print("Digite o título do livro: ");
                valor = scanner.nextLine();
                historico.adicionarHistorico(valor, "Pesquisa de título", usuario);
                biblioteca.getDadoLivro(valor);
                break;
              case 2:
                System.out.print("Digite o nome do autor: ");
                valor = scanner.nextLine();
                historico.adicionarHistorico(valor, "Pesquisa de autor", usuario);
                biblioteca.getLivroPorAutor(valor);
                break;
              case 3:
                System.out.print("Digite o título do livro que você leu ou do seu interesse: ");
                valor = scanner.nextLine();
                historico.adicionarHistorico(valor, "Pesquisa de relacionamento", usuario);
                Livro livroBase = biblioteca.getLivroPorTitulo(valor);

                if (livroBase != null) {
                  Set<Livro> recomendados = biblioteca.recomendarLivro(livroBase);
                  System.out.println("Sugestões baseadas em '" + livroBase.getTitulo() + "':");
                  for (Livro rec : recomendados) {
                    System.out.println("- " + rec.getTitulo());
                  }
                } else {
                  System.out.println("Livro não encontrado.");
                }
                break;
              case 4:
                System.out.print("Digite o título do livro a buscar na árvore: ");
                String busca = scanner.nextLine();
                historico.adicionarHistorico(busca, "Pesquisa na árvore de livros", usuario);
                Livro encontrado = arvoreLivros.buscar(busca);
                if (encontrado != null) {
                  System.out.println("Livro encontrado: " + encontrado.getDado(encontrado));
                } else {
                  System.out.println("Livro não encontrado na árvore.");
                }
                break;
              case 0:
                System.out.println("Voltando para o menu!");
                break;
              default:
                System.out.println("Opção inválida. Tente novamente.");
            }
          }
          break;

        case 4:
          System.out.print("Digite o título do livro a ser emprestado: ");
          String titulo = scanner.nextLine();
          espera.entrarNaFila(usuario);
          espera.atentimento(titulo, biblioteca);
          historico.adicionarHistorico(titulo, "Emprestimo de livro", usuario);
          if (espera.estaVazia()) {
            System.out.println("Atentimento realizado com sucesso.");
          }
          break;

        case 5:
          historico.exibirHistorico();
          break;

        case 6:
          System.out.println("\n=== LIVROS EM ORDEM ===");
          arvoreLivros.mostrar();
          break;

        case 7:
          System.out.println("\n=== Comparação de BubleSort vs MergeSort ====");
          int quantidade = 10000;
          String[] nomesAleatorio = GeradorDeLivros.gerarNomes(quantidade);

          bs.ordenar(nomesAleatorio.clone());
          int quantidadeBSOrdenacao = bs.getComparacoes();
          System.out.println("Bubble Sort - Comparações: " + quantidadeBSOrdenacao);

          ms.ordenar(nomesAleatorio.clone());
          int quantidadeMSOrdenacao = ms.getComparacoes();
          System.out.println("Merge Sort - Comparações: " + quantidadeMSOrdenacao);

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
