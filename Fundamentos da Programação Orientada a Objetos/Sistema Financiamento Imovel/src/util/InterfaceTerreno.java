package util;

import model.Financiamento;
import model.Terreno;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Interface da Terreno
 */
public class InterfaceTerreno extends InterfaceUsuario{
    Scanner scanner = new Scanner(System.in);

    // Pedir ao usuário qual é o tamanho da área construida.
    public int pedirTipoZona(){
        int tipoZonaCadastradaMinimo = 1;
        int tipoZonaCadastradaMaximo = 4;
        int tipo = 0;

        do{
            System.out.println("Tipo do zonas cadastradas");
            System.out.println("1 - Residencial");
            System.out.println("2 - Comercial");
            System.out.println("3 - Rural/Agrícola");
            System.out.println("4 - Industrial");

            System.out.print("Informa o número da zona cadastrada: ");

            try{
                tipo = scanner.nextInt();
            }
            catch (InputMismatchException err){
                System.out.print("Você informou um tipo não cadastrado, tente novamente.\n");
                scanner.nextLine();
            }

        }while (tipo < tipoZonaCadastradaMinimo || tipo > tipoZonaCadastradaMaximo);

        return tipo;
    }

    // Cadastro do fianciamento do Terreno.
    @Override
    public  ArrayList<? extends Financiamento> cadastroFinanciamentoEspecifico(){
        InterfaceTerreno terreno = new InterfaceTerreno();
        ArrayList<Terreno> financiamentoTerreno = new ArrayList<>();

        // Leitura dos dados patrão do financiamento.
        ArrayList<Object> dados = cadastroFinanciamento();
        double valor = (double) dados.get(0);
        int prazo = (int) dados.get(1);
        float taxa = (float) dados.get(2);

        // Leitura do dado para o Terreno.
        int tipoZona = terreno.pedirTipoZona();

        // Adicionando os valores no Array.
        financiamentoTerreno.add(new Terreno(valor, prazo, taxa, tipoZona));

        return financiamentoTerreno;
    }
}
