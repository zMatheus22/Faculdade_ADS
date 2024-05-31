package util;

import java.util.Scanner;

/**
 * Interface Usuario
 */
public class InterfaceUsuario {
    Scanner scanner = new Scanner(System.in);
    // Métodos

    // Pedir ao usuário o valor do imóvel
    public double pedir_Valor_Imovel(){
        double valor = 0;
        do{
            System.out.println("Informe o valor do imovel: R$ ");
            valor = scanner.nextDouble();

            if (valor <= 0){
                System.out.println("Valor não pode ser negativo!");
            }
            else if(valor < 20000){
                System.out.println("O financiamento deve ser no minimo R$ 20.000,00 (20 mil reais)!");
            }
            else if(valor >= 400000){
                System.out.println("O financiamento tem um limite de R$ 400.000,00 (400 mil reais)!");
            }
        }while (valor < 20000 || valor > 400000);

        return valor;
    }

    // Pedir ao usuário o prazo do financiamento
    public int pedir_Prazo_Financiamento(){
        int prazo = 0;

        do{
            System.out.println("Informe o prazo do financiamento em anos: ");
            prazo = scanner.nextInt();
            if (prazo <= 0){
                System.out.println("O prazo deve ser maior ou igual a 1 ano.");
            }
            else if (prazo >= 40){
                System.out.println("O prazo limete para o financiamento é de 40 anos.");
            }
        }while (prazo <= 0 || prazo >= 40);

        return prazo;
    }

    // Pedir ao usuário a taxa de juros
    public float pedir_Taxa_Juro(){
        float taxa = 0;
        do {
            System.out.println("Informe a taxa de juro em %: ");
            taxa = scanner.nextFloat();

            if (taxa <= 0){
                System.out.println("A taxa de juros não pode ser igual a 0% ou negativa!");
            }
            else if(taxa > 25){
                System.out.println("A taxa de juros não pode utrapassar 25% ao ano!");
            }

        }while (taxa <= 0 || taxa > 25);

        return taxa;
    }
}
