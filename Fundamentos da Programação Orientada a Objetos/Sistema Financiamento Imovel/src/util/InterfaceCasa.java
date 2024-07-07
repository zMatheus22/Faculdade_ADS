package util;

import model.Casa;
import model.Financiamento;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;
/**
 * Interface da Casa
 */
public class InterfaceCasa extends InterfaceUsuario {
    Scanner scanner = new Scanner(System.in);

    // Pedir ao usuário qual é o tamanho da área construida.
    public float pedirAreaContruida(){
        int areaMinimaConstrucao = 50; // 50 m²
        int areaMaximaConstrucao = 2000; // 2.000 m²
        float area = 0;

        do{
            System.out.print("Informe a área construída em metros: ");
            try{
                area = scanner.nextFloat();
            }
            catch (InputMismatchException err){
                System.out.print("Você informou um área de construção inválida, tente novamente.\n");
                scanner.nextLine();
            }

            if(area <= 0){
                System.out.println("A área construida não pode ser negatica ou igual a zero!");
            }
            else if(area < areaMinimaConstrucao){
                System.out.printf("A área construida deve ser maior que %d m²\n", areaMinimaConstrucao);
            }
            else if(area > areaMaximaConstrucao){
                System.out.printf("A área construida deve ser menor que %d m²\n", areaMaximaConstrucao);
            }

        }while (area < areaMinimaConstrucao || area > areaMaximaConstrucao);

        return area;
    }

    // Pedir ao usuário qual é o tamanho da área terreno.
    public float pedirAreaTerreno(){
        int areaMinimaTerreno = 60; // 60 m²
        int areaMaximaTerreno = 3000; // 5.000 m²
        float area = 0;

        do{
            System.out.print("Informe a área do terreno, em metros: ");
            try{
                area = scanner.nextFloat();
            }
            catch (InputMismatchException err){
                System.out.print("Você informou um área de terreno inválida, tente novamente.\n");
                scanner.nextLine();
            }

            if(area <= 0){
                System.out.println("A área terreno não pode ser negatica ou igual a zero!");
            }
            else if(area < areaMinimaTerreno){
                System.out.printf("A área terreno deve ser maior que %d m²\n", areaMinimaTerreno);
            }
            else if(area > areaMaximaTerreno){
                System.out.printf("A área construida deve ser menor que %d m²\n", areaMaximaTerreno);
            }

        }while (area < areaMinimaTerreno || area > areaMaximaTerreno);

        return area;
    }

    // Cadastro do fianciamento da casa.
    public ArrayList<? extends Financiamento> cadastroFinanciamentoEspecifico(){
        InterfaceCasa casa = new InterfaceCasa();
        ArrayList<Casa> financiamentoCasa = new ArrayList<>();

        // Leitura dos dados patrão do financiamento.
        ArrayList<Object> dados = cadastroFinanciamento();
        double valor = (double) dados.get(0);
        int prazo = (int) dados.get(1);
        float taxa = (float) dados.get(2);

        // Leitura dos dados para a Casa.
        float areaConstruida = casa.pedirAreaContruida();
        float areaTerreno = casa.pedirAreaTerreno();

        // Adicionando os valores no Array.
        financiamentoCasa.add(new Casa(valor, prazo, taxa, areaConstruida, areaTerreno));

        return financiamentoCasa;
    }

    // Imprimir os dados do financiamento da casa.
    @Override
    public void imprimirDadosFinanciamento(ArrayList<? extends Financiamento> financiamento) {
        for (Financiamento casa : financiamento) {
            imprimirDadosBasicos(casa);
            casa.imprimirDetalhesEspecificos();
        }
    }

}
