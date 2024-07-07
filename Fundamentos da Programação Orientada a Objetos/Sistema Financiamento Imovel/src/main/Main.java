package main;

/**
 * Fundamentos da Programação Orientada a Objetos
 * Sistema de Simulação de Financiamentos Imobiliários Banco - PUC-PR
 * ATIVIDADE SOMATIVA - Semana 6

 * @Curso: Análise e Desenvolvimento de Sistemas
 * @Autor: Matheus Vinicyus Strada
 */

import java.util.*;

import model.Casa;
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
        double somaValor = 0;
        double somaFinanciamento = 0;

        do {
            opcao = menuInicial();
            switch (opcao) {
                case 1:
                    System.out.println("Casa");
                    do {
                        opcaoFinancia = menuCRUD();
                        switch (opcaoFinancia) {
                            case 1:
                                casa.cadastroFinanciamentoEspecifico();
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
                    opcaoFinancia = menuCRUD();
                    switch (opcaoFinancia) {
                        case 1:
                            apartamento.cadastroFinanciamentoEspecifico();
                            break;
                        case 2:
                            apartamento.imprimirDadosFinanciamento(financiamento);
                            break;
                        default:
                            System.out.println("Voltando ao menu inicial.");
                            break;
                    }
                break;

                case 3:
                    opcaoFinancia = menuCRUD();
                    switch (opcaoFinancia) {
                        case 1:
                            terreno.cadastroFinanciamentoEspecifico();
                            break;
                        case 2:
                            terreno.imprimirDadosFinanciamento(financiamento);
                            break;
                        default:
                            System.out.println("Voltando ao menu inicial.");
                            break;
                    }
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

    public static int lerOpcao() {
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

    public static int menuInicial(){
        System.out.println("Informe um dos Financiamento abaixo:");
        System.out.println("1 - Casa.");
        System.out.println("2 - Apartamento.");
        System.out.println("3 - Terreno.");
        System.out.println("9 - Sair.");

        return lerOpcao();
    }

    public static int menuCRUD(){
        System.out.println("Informe um das opções abaixo:");
        System.out.println("1 - Cadastro.");
        System.out.println("2 - Imprimir.");
        System.out.println("9 - Sair.");

        return lerOpcao();
    }

}
