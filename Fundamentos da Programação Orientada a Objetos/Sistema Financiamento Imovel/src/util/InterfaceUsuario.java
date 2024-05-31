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
        System.out.println("Informe o valor do imovel: R$ ");

        return scanner.nextDouble();
    }

    // Pedir ao usuário o prazo do financiamento
    public int pedir_Prazo_Financiamento(){
        System.out.println("Informe o prazo do financiamento: ");

        return scanner.nextInt();
    }

    // Pedir ao usuário a taxa de juros
    public float pedir_Taxa_Juro(){
        System.out.println("Informe a taxa de juro em %: ");

        return scanner.nextFloat();
    }
}
