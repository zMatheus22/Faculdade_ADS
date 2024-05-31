package main;

/**
 * Fundamentos da Programação Orientada a Objetos
 * Sistema de Simulação de Financiamentos Imobiliários Banco - PUC-PR
 * ATIVIDADE FORMATIVA - Semana 2

 * @Curso: Análise e Desenvolvimento de Sistemas
 * @Autor: Matheus Vinicyus Strada
 */

import java.util.Locale;
import util.InterfaceUsuario;

public class Main {
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

