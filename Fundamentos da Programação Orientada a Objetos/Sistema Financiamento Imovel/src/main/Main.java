package main;

/**
 * Fundamentos da Programação Orientada a Objetos
 * Sistema de Simulação de Financiamentos Imobiliários Banco - PUC-PR
 * ATIVIDADE SOMATIVA - Semana 8

 * @Curso: Análise e Desenvolvimento de Sistemas
 * @Autor: Matheus Vinicyus Strada
 */

import java.io.*;
import java.util.*;
import model.Financiamento;
import util.InterfaceApartamento;
import util.InterfaceCasa;
import util.InterfaceTerreno;
import util.InterfaceUsuario;


public class Main {
    public static void main(String[] args) throws Exception {
        Locale.setDefault(new Locale("pt", "BR"));
        InterfaceCasa casa = new InterfaceCasa();
        InterfaceApartamento apartamento = new InterfaceApartamento();
        InterfaceTerreno terreno = new InterfaceTerreno();

        int opcao = 0;

        do {
            opcao = menuInicial();
            switch (opcao) {
                case 1:
                    // Casa
                    operacaoDados(casa);
                    break;

                case 2:
                    // Apartamento
                    operacaoDados(apartamento);
                    break;

                case 3:
                    // Terreno
                    operacaoDados(terreno);
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
        System.out.println("===================");
        System.out.println("   Menu Inicial    ");
        System.out.println("===================");
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
        System.out.println("9 - Voltar ao menu inicial.");

        return lerOpcao();
    }

    private static void operacaoDados(InterfaceUsuario interfaceOperacao){
        int opcaoFinancia = 0;
        ArrayList<? extends Financiamento> financiamento;
        StringBuilder dados = new StringBuilder();

        // Renomeando o nome do arquivo;
        String nome = interfaceOperacao.getClass().getName();
        switch (nome){
            case "util.InterfaceCasa":
                nome = "Casa";
                break;
            case "util.InterfaceApartamento":
                nome = "Apartamento";
                break;
            case "util.InterfaceTerreno":
                nome = "Terreno";
                break;
            default:
                nome = "Financiamento";
                break;
        }

        do {
            System.out.println("============================");
            System.out.println("   Opecação Financiamento   ");
            System.out.println("============================");
            opcaoFinancia = menuCRUD();
            switch (opcaoFinancia) {
                // Cadastro
                case 1:
                    financiamento = interfaceOperacao.cadastroFinanciamentoEspecifico();
                    for (Financiamento f : financiamento) {
                        dados.append(f.toString()).append("\n");
                    }
                    // Escrever os dados nos arquivos.
                    escreverArquivoTXT(nome+".txt", dados.toString());
                    escreverArquivoBinario(nome+".bin", dados.toString());
                    // Limpara os dados.
                    dados.setLength(0);
                    break;
                // Leitura
                case 2:
                    System.out.println("---------------------------------------------------------");
                    lerArquivoTXT(nome+".txt");
                    //lerArquivoBinario(nome+".bin");
                    break;
                // Voltar
                case 9:
                    System.out.println("Voltando para o menu.");
                    break;
                default:
                    System.out.println("Por favor, informe uma opção valida.");
                    break;
            }
        }while (opcaoFinancia != 9);
    }

    private static void escreverArquivoTXT(String nomeArquivo, String financiamento){
        FileWriter escritor = null;

        try {
            // Informar o arquivo e os dados que devem ser escritos.
            escritor = new FileWriter(nomeArquivo, true);

            escritor.write(financiamento);

            escritor.close();
        }catch (FileNotFoundException e) {
            System.out.println("Arquivo: "+nomeArquivo+" não foi encontrado, verifiquei.");
        } catch (IOException e) {
            System.out.println("Erro ao tentar abrir o arquivo: "+nomeArquivo+" para escrita.");
        }
    }

    private static void lerArquivoTXT(String nomeArquivo){
        FileReader leitorArquivo = null;

        try {
            // Abrindo o arquivo.
            leitorArquivo = new FileReader(nomeArquivo);

            int caractersLidos = 0;
            while ((caractersLidos = leitorArquivo.read()) != -1){
                // Convertendo ASCII.
                System.out.print((char) caractersLidos);
            }

            leitorArquivo.close();
        } catch (FileNotFoundException e) {
            System.out.println("Arquivo: "+nomeArquivo+" não foi encontrado, verifiquei.");
        } catch (IOException e) {
            System.out.println("Erro ao tentar ler o arquivo: "+nomeArquivo);
        }
    }

    private static void escreverArquivoBinario(String nomeArquivo, String financiamento){
        ObjectOutputStream objectOutputStreams = null;

        try {
            // Informar o arquivo e os dados que devem ser escritos.
            objectOutputStreams = new ObjectOutputStream(new FileOutputStream(nomeArquivo, true));
            objectOutputStreams.writeObject(financiamento);

            // Limpar os dados anteriores
            objectOutputStreams.flush();
            objectOutputStreams.close();
        } catch (IOException e) {
            System.out.println("Erro ao tentar abrir o arquivo: "+nomeArquivo+" para escrita.");
        }
    }

    private static void lerArquivoBinario(String nomeArquivo){
        ObjectInputStream objectInputStream = null;
        try {
            objectInputStream = new ObjectInputStream(new FileInputStream(nomeArquivo));
            Object object = null;

            while ((object = objectInputStream.readObject()) != null){
                System.out.print(object);
            }

            objectInputStream.close();
        } catch (EOFException e){
            System.out.print("\n");
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Erro ao tentar abrir o arquivo: "+nomeArquivo);
        }
    }

}
