package util;

import model.Apartamento;
import model.Financiamento;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class InterfaceApartamento extends InterfaceUsuario{
    Scanner scanner = new Scanner(System.in);

    // Pedir ao usuário o número do apartamento.
    public int pedirNumeroApartamento() {
        int numeroApartamentoMinimo = 1;
        int numeroApartamentoMaximo = 500;
        int apartamento = 0;

        do{
            System.out.print("Informa o número do apartamento: ");

            try{
                apartamento = scanner.nextInt();
            }
            catch (InputMismatchException err){
                System.out.print("Você não informou um número de apartamento correto, tente novamente.\n");
                scanner.nextLine();
            }

        }while (apartamento < numeroApartamentoMinimo || apartamento > numeroApartamentoMaximo);

        return apartamento;
    }

    // Pedir ao usuário o número do apartamento.
    public int pedirNumeroAndar() {
        int numeroAndarMinimo = 1;
        int numeroAndarMaximo = 20;
        int andar = 0;

        do{
            System.out.print("Informa o número do andar: ");

            try{
                andar = scanner.nextInt();
            }
            catch (InputMismatchException err){
                System.out.print("Você não informou um número de andar correto, tente novamente.\n");
                scanner.nextLine();
            }

        }while (andar < numeroAndarMinimo || andar > numeroAndarMaximo);

        return andar;
    }

    public int pedirQuantidadeVaga(){
        int quantidadeVagaMinimo = 0;
        int quantidadeVagaMaximo = 5;
        int quantidadeVaga = 0;

        do {
            System.out.print("Informa a quantidade de vaga(s) na garagem do apartamento: ");

            try{
                quantidadeVaga = scanner.nextInt();
            }
            catch (InputMismatchException err){
                System.out.print("Você não informou um número de andar correto, tente novamente.\n");
                scanner.nextLine();
            }

        }while (quantidadeVaga < quantidadeVagaMinimo || quantidadeVaga > quantidadeVagaMaximo);

        return quantidadeVaga;
    }

    // Cadastro do Apartamento.
    public  ArrayList<? extends Financiamento> cadastroFinanciamentoEspecifico(){
        InterfaceApartamento apartamento = new InterfaceApartamento();

        // Leitura dos dados patrão do financiamento.
        ArrayList<Object> dados = cadastroFinanciamento();
        double valor = (double) dados.get(0);
        int prazo =  (int) dados.get(1);
        float taxa = (float) dados.get(2);

        // Leitura dos dados para o Apartamento.
        int numeroApartamento = apartamento.pedirNumeroApartamento();
        int numeroAndar = apartamento.pedirNumeroAndar();
        int quantidadeVaga = apartamento.pedirQuantidadeVaga();

        ArrayList<Apartamento> financiamentoApartamento = new ArrayList<>();

        // Adicionando os valores no Array.
        financiamentoApartamento.add(new Apartamento(valor, prazo, taxa, numeroApartamento, numeroAndar, quantidadeVaga));

        return financiamentoApartamento;
    }
}
