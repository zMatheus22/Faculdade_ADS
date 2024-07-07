package main;

/**
 * Fundamentos da Programação Orientada a Objetos
 * Sistema de Simulação de Financiamentos Imobiliários Banco - PUC-PR
 * ATIVIDADE SOMATIVA - Semana 7

 * @Curso: Análise e Desenvolvimento de Sistemas
 * @Autor: Matheus Vinicyus Strada
 */

import java.util.*;
import model.Financiamento;
import util.InterfaceApartamento;
import util.InterfaceCasa;
import util.InterfaceTerreno;


public class Main {
    public static void main(String[] args) throws Exception {
        Locale.setDefault(new Locale("pt", "BR"));
        ArrayList<? extends Financiamento> financiamento = new ArrayList<>();

        InterfaceCasa casa = new InterfaceCasa();
        InterfaceApartamento apartamento = new InterfaceApartamento();
        InterfaceTerreno terreno = new InterfaceTerreno();

        int opcao = 0;
        int opcaoFinancia = 0;

        do {
            opcao = menuInicial();
            switch (opcao) {
                case 1:
                    // Casa
                    do {
                        System.out.println("===================");
                        System.out.println("        Casa       ");
                        System.out.println("===================");
                        opcaoFinancia = menuCRUD();
                        switch (opcaoFinancia) {
                            case 1:
                                financiamento = casa.cadastroFinanciamentoEspecifico();
                                break;
                            case 2:
                                casa.imprimirDadosFinanciamento(financiamento);
                                break;
                            default:
                                System.out.println("Voltando ao menu inicial.");
                                break;
                        }
                    } while (opcaoFinancia != 9);

                    break;

                case 2:
                    // Apartamento
                    do {
                        System.out.println("===================");
                        System.out.println("    Apartamento    ");
                        System.out.println("===================");
                        opcaoFinancia = menuCRUD();
                        switch (opcaoFinancia) {
                            case 1:
                                financiamento = apartamento.cadastroFinanciamentoEspecifico();
                                break;
                            case 2:
                                apartamento.imprimirDadosFinanciamento(financiamento);
                                break;
                            default:
                                System.out.println("Voltando ao menu inicial.");
                                break;
                        }
                    }while (opcaoFinancia != 9);

                break;

                case 3:
                    // Terreno
                    do {
                        System.out.println("===================");
                        System.out.println("      Terreno      ");
                        System.out.println("===================");
                        opcaoFinancia = menuCRUD();
                        switch (opcaoFinancia) {
                            case 1:
                                financiamento = terreno.cadastroFinanciamentoEspecifico();
                                break;
                            case 2:
                                terreno.imprimirDadosFinanciamento(financiamento);
                                break;
                            default:
                                System.out.println("Voltando ao menu inicial.");
                                break;
                        }
                    }while (opcaoFinancia != 9);
                break;

                case 9:
                    System.out.println("Sistema finalizando, Obrigado!");
                    break;

                default:
                    System.out.println("Por favor, informe uma opção valida.");
                    break;
            }
        }while (opcao != 9);
    }

    private static int lerOpcao() {
        int opcao = 0;
        Scanner sc = new Scanner(System.in);
        do {
            System.out.println("Digite uma opção válido: ");
            try {
                opcao = sc.nextInt();
                return opcao;
            }catch (InputMismatchException e){
                System.out.println("Você não informou um número, tente novamente!");
                sc.next();
            }
        }while (true);
    }

    private static int menuInicial(){
        System.out.println("Informe um dos Financiamento abaixo:");
        System.out.println("1 - Casa.");
        System.out.println("2 - Apartamento.");
        System.out.println("3 - Terreno.");
        System.out.println("9 - Sair.");

        return lerOpcao();
    }

    private static int menuCRUD(){
        System.out.println("Informe um das opções abaixo:");
        System.out.println("1 - Cadastro.");
        System.out.println("2 - Imprimir.");
        System.out.println("9 - Sair.");

        return lerOpcao();
    }

}
