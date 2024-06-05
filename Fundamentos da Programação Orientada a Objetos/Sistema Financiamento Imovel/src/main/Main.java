package main;

/**
 * Fundamentos da Programação Orientada a Objetos
 * Sistema de Simulação de Financiamentos Imobiliários Banco - PUC-PR
 * ATIVIDADE FORMATIVA - Semana 4

 * @Curso: Análise e Desenvolvimento de Sistemas
 * @Autor: Matheus Vinicyus Strada
 */

import java.util.ArrayList;
import java.util.Locale;
import java.util.Scanner;

import model.Financiamento;
import util.InterfaceUsuario;

public class Main {
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        Locale.setDefault(new Locale("pt", "BR"));
        InterfaceUsuario user = new InterfaceUsuario();
        ArrayList<Financiamento> arrayFinanciamento = new ArrayList<Financiamento>();

        int opcao = 0;

        double valor = 0;
        int prazo = 0;
        float taxa = 0;
        do {
            System.out.println("Informe uma das opções abaixo:");
            System.out.println("1 - Informar valores.");
            System.out.println("2 - Imprimir dados.");
            System.out.println("9 - Sair do Sistema");
            opcao = scanner.nextInt();
            switch (opcao) {
                case 1:
                    // Leitura dos valores.
                    valor = user.pedirValorImovel();
                    prazo = user.pedirPrazoFinanciamento();
                    taxa = user.pedirTaxaJuro();
                    arrayFinanciamento.add(new Financiamento(valor, prazo, taxa));
                    break;

                case 2:
                    // Imprimir os dados
                    System.out.println("-----------------------------------------");
                    for (int i = 0; i < arrayFinanciamento.size(); i++){
                        arrayFinanciamento.get(i).apresentarDadosFinanciamento();
                    }
                    break;

                case 9:
                    System.out.println("Obrigado!");
                    break;

                default:
                    System.out.println("Por favor, informe uma opção valida.");
                    break;
            }
        }while (opcao != 9);
    }
}

