package util;

import model.Financiamento;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.InputMismatchException;

/**
 * Interface Usuario
 */
public abstract class InterfaceUsuario {
    Scanner scanner = new Scanner(System.in);
    // Métodos

    // Pedir ao usuário o valor do imóvel
    public double pedirValorImovel(){
        int valorMinimoPermitido = 20000;
        int valorMaximoPermitido = 1000000;
        double valor = 0;

        do{
            System.out.print("Informe o valor do imovel: R$ ");

            // Tratamento de erro.
            try{
                valor = scanner.nextDouble();
            }
            catch (InputMismatchException err){
                System.out.print("Você informou um valor incorreto, tente novamente.\n");
                scanner.nextLine();
            }

            if (valor <= 0){
                System.out.println("Valor não pode ser negativo!");
            }
            else if(valor < valorMinimoPermitido){
                System.out.printf("O financiamento deve ser no minimo R$ %d,00!\n", valorMinimoPermitido);
            }
            else if(valor > valorMaximoPermitido){
                System.out.printf("O financiamento tem um limite de R$ %d,00!\n", valorMaximoPermitido);
            }
        }while (valor < valorMinimoPermitido || valor > valorMaximoPermitido);

        return valor;
    }

    // Pedir ao usuário o prazo do financiamento
    public int pedirPrazoFinanciamento(){
        int prazoMinimoPermitido = 1;
        int prazoMaximoPermitido = 40;
        int prazo = 0;

        do{
            System.out.print("Informe o prazo do financiamento em anos: ");

            // Tratamento de erro.
            try{
                prazo = scanner.nextInt();
            }catch (InputMismatchException err){
                System.out.print("Você informou informou um dado incorreto, tente novamente.\n");
                scanner.nextLine();
            }

            if (prazo < prazoMinimoPermitido){
                System.out.printf("O prazo deve ser maior ou igual a %d ano.\n", prazoMinimoPermitido);
            }
            else if (prazo > prazoMaximoPermitido){
                System.out.printf("O prazo limete para o financiamento é de %d anos.\n", prazoMaximoPermitido);
            }
        }while (prazo < prazoMinimoPermitido || prazo > prazoMaximoPermitido);

        return prazo;
    }

    // Pedir ao usuário a taxa de juros
    public float pedirTaxaJuro(){
        int taxaMinimaPermitida = 1;
        int taxaMaximaPermitida = 25;
        float taxa = 0.0f;

        do {
            System.out.print("Informe a taxa de juro em anos, %: ");

            // Tratamento de erro.
            try{
                String input = scanner.next();
                input = input.replace(',','.');
                taxa = Float.parseFloat(input);
            }catch (InputMismatchException err){
                System.out.print("Você informou informou um dado incorreto, tente novamente.\n");
                scanner.nextLine();
            }

            if (taxa < taxaMinimaPermitida){
                System.out.printf("A taxa de juros não pode ser menor que %d%%!\n", taxaMinimaPermitida);
            }
            else if(taxa > taxaMaximaPermitida){
                System.out.printf("A taxa de juros não pode utrapassar %d%% ao ano!\n",taxaMaximaPermitida);
            }
        }while (taxa < taxaMinimaPermitida || taxa > taxaMaximaPermitida);

        return taxa;
    }

    // Leitura/cadastro dos dados básicos do financiamento.
    public ArrayList<Object> cadastroFinanciamento(){
        // Leitura dos valores.
        double valor = this.pedirValorImovel();
        int prazo = this.pedirPrazoFinanciamento();
        float taxa = this.pedirTaxaJuro();

        ArrayList<Object> cadastro = new ArrayList<>();

        // Adicionando os dados no Array.
        cadastro.add(valor);
        cadastro.add(prazo);
        cadastro.add(taxa);

        return cadastro;
    }

    public abstract ArrayList<? extends Financiamento> cadastroFinanciamentoEspecifico();
}
