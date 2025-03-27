import model.FilaEspera;
import model.LinkedListBliblioteca;
import model.Livro;
import model.Usuario;

/**
 * Métodos de Pesquisa e Ordenação em Estruturas de Dados |
 * Sistema de gerenciamento para uma biblioteca virtual | PUC-PR
 *
 * @ATIVIDADE FORMATIVA - Semana 2

 * @Curso: Análise e Desenvolvimento de Sistemas
 * @Autor: Matheus Vinicyus Strada
 */

public class Main {
  public static void main(String[] args) {
    LinkedListBliblioteca biblioteca = new LinkedListBliblioteca();
    FilaEspera espera = new FilaEspera();

    String autor = "Robert C. Martin";
    String livroRemover = "Design Patterns";
    String dadoLivro = "You Don’t Know JS";

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
    System.out.println("\n");

    //System.out.println("Lista de livros na biblioteca:");
    biblioteca.getDadoLivros();
    System.out.println("\n");

    //System.out.println("Removido um livro da biblioteca: " + livroRemover);
    //biblioteca.removeLivro(livroRemover);
    //System.out.println("\n");

    //System.out.println("Dados de um livro: ");
    //biblioteca.getLivroPorTitulo(dadoLivro);
    //System.out.println("\n");

    //System.out.println("Lista de livro(s) do autor: " + autor);
    //biblioteca.getLivroPorAutor(autor);
    //System.out.println("\n");

    Usuario user;
    user = new Usuario("Matheus");
    espera.entrarNaFila(user);
    user = new Usuario("Joao");
    espera.entrarNaFila(user);
    user = new Usuario("Joao2");
    espera.entrarNaFila(user);
    user = new Usuario("Joao3");
    espera.entrarNaFila(user);
    user = new Usuario("Joao4");
    espera.entrarNaFila(user);
    user = new Usuario("Joao5");
    espera.entrarNaFila(user);

    int status = 0;
    while (!espera.estaVazia()){
      if (status != 0){
        break;
      }
      status = espera.atentimento(livroRemover, biblioteca);
    }

  }
}