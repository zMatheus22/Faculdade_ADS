/**
   Fundamentos da Programação Orientada a Objetos
   Sistema de Simulação de Financiamentos Imobiliários Banco - PUC-PR
   ATIVIDADE FORMATIVA - Semana 2
   
   @Curso: Análise e Desenvolvimento de Sistemas
   @Autor: Matheus Vinicyus Strada
 */

import java.util.Locale;
import java.util.Scanner;

/**
 * Financiamento
 */
class Financiamento {
    // Atributo
    double valorImovel;
    int prazoFinanciamento;
    double taxaJurosAnual;

    // Construtor
    Financiamento(double valor_Imovel, int prazo_Financiamento, double taxa_Juro){
        this.valorImovel = valor_Imovel;
        this.prazoFinanciamento = prazo_Financiamento;
        this.taxaJurosAnual = taxa_Juro;
    }
    
    // Métodos

    double calcular_Pagamento_Mes(){
        return (this.valorImovel / (this.prazoFinanciamento * 12)) * (1 + (this.taxaJurosAnual / 12));
    }

    double calcular_Total_Pagamento(){
        return calcular_Pagamento_Mes() * this.prazoFinanciamento * 12;
    }
}

/**
 * InterfaceUsuario
 */
class InterfaceUsuario {
    Scanner scanner = new Scanner(System.in);
    // Métodos
    // Pedir ao usuário o valor do imóvel
    double pedir_Valor_Imovel(){
        System.out.println("Informe o valor do imovel: R$ ");

        return scanner.nextDouble();
    }

    // Pedir ao usuário o prazo do financiamento
    int pedir_Prazo_Financiamento(){
        System.out.println("Informe o prazo do financiamento: ");
        
        return scanner.nextInt();
    }

    // Pedir ao usuário a taxa de juros
    float pedir_Taxa_Juro(){
        System.out.println("Informe a taxa de juro em %: ");
        
        return scanner.nextFloat();
    }

}

public class App {
    @SuppressWarnings("deprecation")
    public static void main(String[] args) throws Exception {
        Locale.setDefault(new Locale("pt", "BR"));
        InterfaceUsuario user = new InterfaceUsuario();

        // Leitura dos valores.
        double valor = user.pedir_Valor_Imovel();
        int prazo = user.pedir_Prazo_Financiamento();
        float taxa = user.pedir_Taxa_Juro();

        // Apresentação.
        System.out.printf("Valor do Imovel R$ %.2f\n", valor);
        System.out.printf("O prazo do financiamento %d ano(s)\n", prazo);
        System.out.printf("A taxa de juro: %.2f%% \n", taxa);
        
    }
}
