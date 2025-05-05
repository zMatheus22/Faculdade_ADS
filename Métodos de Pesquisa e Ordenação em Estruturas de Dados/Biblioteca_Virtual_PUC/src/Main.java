/**
 * Métodos de Pesquisa e Ordenação em Estruturas de Dados |
 * Sistema de gerenciamento para uma biblioteca virtual | PUC-PR
 *
 * @ATIVIDADE_SOMATIVA_-_Semana_8

 * @Curso: Análise e Desenvolvimento de Sistemas
 * @Autor: Matheus Vinicyus Strada
 */

import model.*;
import java.util.HashMap;
import java.util.Objects;
import java.util.Scanner;
import java.util.Set;

public class Main {
  private static final Biblioteca biblioteca = new Biblioteca();
  private static final FilaEspera espera = new FilaEspera();
  private static final HistoricoNavegacao historico = new HistoricoNavegacao();
  private static final ArvoreLivro arvoreLivros = new ArvoreLivro();
  private static final BubbleSort bs = new BubbleSort();
  private static final MergeSort ms = new MergeSort();
  private static final Scanner scanner = new Scanner(System.in);
  private static Usuario usuario;

  public static void main(String[] args) {
    inicializarSistema();
    exibirMenu();
    scanner.close();
  }

  private static void inicializarSistema() {
    System.out.println("Informe seu nome: ");
    usuario = new Usuario(scanner.nextLine());

    Livro[] livros = criarLivros();
    for (Livro l : livros) {
      // Adicionando os livros na biblioteca (grafo).
      biblioteca.addLivro(l);
      // Adicionando os livros na biblioteca (Árvore).
      arvoreLivros.inserirLivro(l);
    }

    criarRelacionamentos(livros);
  }

  private static Livro[] criarLivros() {
    return new Livro[] {
      new Livro("Clean Code", "Robert C. Martin", 2008, "Engenharia de Software"),
      new Livro("The Pragmatic Programmer", "Andrew Hunt", 1999, "Engenharia de Software"),
      new Livro("Design Patterns", "Erich Gamma", 1994, "Padrões de Projeto"),
      new Livro("Refactoring", "Martin Fowler", 1999, "Refatoração"),
      new Livro("Code Complete", "Steve McConnell", 1993, "Engenharia de Software"),
      new Livro("You Don’t Know JS", "Kyle Simpson", 2014, "JavaScript"),
      new Livro("Eloquent JavaScript", "Marijn Haverbeke", 2011, "JavaScript"),
      new Livro("Java: The Complete Reference", "Herbert Schildt", 2018, "Java"),
      new Livro("Effective Java", "Joshua Bloch", 2018, "Java"),
      new Livro("Head First Design Patterns", "Eric Freeman", 2004, "Padrões de Projeto"),
    };
  }

  private static void criarRelacionamentos(Livro[] livros) {
    for (Livro livroBase : livros) {
      for (Livro livroRelacao : livros) {
        if (!livroBase.equals(livroRelacao) &&
            (Objects.equals(livroBase.categoria(), livroRelacao.categoria()) ||
                Objects.equals(livroBase.autor(), livroRelacao.autor()))) {
          biblioteca.addRecomendacao(livroBase, livroRelacao);
          biblioteca.addRecomendacao(livroRelacao, livroBase);
        }
      }
    }
  }

  private static void exibirMenu() {
    int opcao = -1;
    while (opcao != 0) {
      System.out.println("\n=== MENU BIBLIOTECA ===");
      System.out.println("1. Listar todos os livros");
      System.out.println("2. Listar relacionamentos");
      System.out.println("3. Buscar livro");
      System.out.println("4. Emprestar livro");
      System.out.println("5. Histórico");
      System.out.println("6. Ver árvore");
      System.out.println("7. Comparar algoritmos");
      System.out.println("0. Sair");
      System.out.print("Escolha uma opção: ");
      try {
        opcao = scanner.nextInt();
      }catch (Exception e){
        System.out.println("Opção informada não é valida, tente novamente!");
      }
      scanner.nextLine();

      switch (opcao) {
        case 1: listarLivros(); break;
        case 2: listarRelacionamentos(); break;
        case 3: menuBusca(); break;
        case 4: emprestarLivro(); break;
        case 5: historico.exibirHistorico(); break;
        case 6: arvoreLivros.mostrar(); break;
        case 7: compararOrdenacoes(); break;
        case 0: System.out.println("Saindo..."); break;
        default: System.out.println("Opção inválida.");
      }
    }
  }

  private static void listarLivros(){
    biblioteca.getDadoLivro();
    System.out.println("Pressione 'ENTER' para continuar!");
    scanner.nextLine();
  }

  private static void listarRelacionamentos(){
    biblioteca.mostrarGrafo();
    System.out.println("Pressione 'ENTER' para continuar!");
    scanner.nextLine();
  }

  private static void menuBusca(){
    int opcao = -1;
    while (opcao != 0){
      System.out.println("\n=== MENU BUSCA DE LIVRO ===");
      System.out.println("1. Busca por título do livro");
      System.out.println("2. Buscar por autor");
      System.out.println("3. Buscar relacionamento de livro");
      System.out.println("4. Procurar livro na árvore");
      System.out.println("5. Busca BFS");
      System.out.println("6. Busca DFS");
      System.out.println("7. Recomendação por título");
      System.out.println("0. Voltar ao menu");
      System.out.print("Escolha uma opção: ");
      try {
        opcao = scanner.nextInt();
      } catch (Exception e){
        System.out.println("Opção informada não é valida, tente novamente!");
      }
      scanner.nextLine();

      switch (opcao){
        case 1: buscaLivroPorTitulo(); break;
        case 2: buscaLivroPorAutor();  break;
        case 3: buscaRelacionamento(); break;
        case 4: buscaLivroArvore(); break;
        case 5: buscaBFS(); break;
        case 6: buscaDFS(); break;
        case 7: recomendarPorTitulo(); break;
        case 0: System.out.println("Voltando para o menu!"); break;
        default: System.out.println("Opção inválida. Tente novamente.");
      }
    }
  }

  private static void emprestarLivro(){
    System.out.print("Digite o título do livro a ser emprestado: ");
    String titulo = scanner.nextLine();
    espera.entrarNaFila(usuario);
    espera.atendimento(titulo, biblioteca);
    historico.adicionarHistorico(titulo, "Emprestimo de livro", usuario);
    if (espera.estaVazia()) {
      System.out.println("Atendimento realizado com sucesso.");
    }
  }

  private static void compararOrdenacoes(){
    System.out.println("\n=== Comparação de BubbleSort vs MergeSort ====");
    int quantidade = 10000;
    String[] nomesAleatorio = GeradorDeLivros.gerarNomes(quantidade);

    bs.ordenar(nomesAleatorio.clone());
    int quantidadeBSOrdenacao = bs.getComparacoes();
    System.out.println("Bubble Sort - Comparações: " + quantidadeBSOrdenacao);

    ms.ordenar(nomesAleatorio.clone());
    int quantidadeMSOrdenacao = ms.getComparacoes();
    System.out.println("Merge Sort - Comparações: " + quantidadeMSOrdenacao);
  }

  private static void buscaLivroPorTitulo(){
    System.out.print("Digite o título do livro: ");
    String valor = scanner.nextLine();
    historico.adicionarHistorico(valor, "Pesquisa de título", usuario);
    biblioteca.getDadoLivro(valor);
  }

  private static void buscaLivroPorAutor(){
    System.out.print("Digite o nome do autor: ");
    String valor = scanner.nextLine();
    historico.adicionarHistorico(valor, "Pesquisa de autor", usuario);
    biblioteca.getLivroPorAutor(valor);
  }

  private static void buscaRelacionamento(){
    System.out.print("Digite o título do livro que você leu ou do seu interesse: ");
    String valor = scanner.nextLine();
    historico.adicionarHistorico(valor, "Pesquisa de relacionamento", usuario);
    Livro livroBase = biblioteca.getLivroPorTitulo(valor);

    if (livroBase != null) {
      Set<Livro> recomendados = biblioteca.recomendarLivro(livroBase);
      System.out.println("Sugestões baseadas em '" + livroBase.titulo() + "':");
      for (Livro rec : recomendados) {
        System.out.println("- " + rec.titulo());
      }
    } else {
      System.out.println("Livro não encontrado.");
    }
  }

  private static void buscaLivroArvore(){
    System.out.print("Digite o título do livro a buscar na árvore: ");
    String busca = scanner.nextLine();
    historico.adicionarHistorico(busca, "Pesquisa na árvore de livros", usuario);
    Livro encontrado = arvoreLivros.buscar(busca);
    if (encontrado != null) {
      System.out.println("Livro encontrado: " + encontrado.getDado(encontrado));
    } else {
      System.out.println("Livro não encontrado na árvore.");
    }
  }

  private static void buscaBFS(){
    System.out.print("Digite o nome do livro a ser buscado: ");
    String busca = scanner.nextLine();
    historico.adicionarHistorico(busca, "Pesquisa BFS", usuario);
    System.out.println("\n--- Busca em Largura (BFS) ---");
    if (!BFS.buscaBFS(arvoreLivros.getNo(), busca)) {
      System.out.println("Livro não encontrado com BFS.");
    }
  }

  private static void buscaDFS(){
    System.out.print("Digite o nome do livro a ser buscado: ");
    String busca = scanner.nextLine();
    historico.adicionarHistorico(busca, "Pesquisa BFS", usuario);
    System.out.println("\n--- Busca em Largura (DFS) ---");
    if (!DFS.buscaDFS(arvoreLivros.getNo(), busca)) {
      System.out.println("Livro não encontrado com DFS.");
    }
  }

  private static void recomendarPorTitulo(){
    System.out.print("Digite o título do livro para ver recomendações: ");
    String busca = scanner.nextLine();
    Livro base = biblioteca.getLivroPorTitulo(busca);
    historico.adicionarHistorico(busca, "Pesquisa BFS", usuario);
    if (base != null) {
      HashMap<Livro, Set<Livro>> grafo = biblioteca.getLivros();
      biblioteca.recomendarLivro(base, grafo);
    } else {
      System.out.println("Livro não encontrado.");
    }
  }
}
