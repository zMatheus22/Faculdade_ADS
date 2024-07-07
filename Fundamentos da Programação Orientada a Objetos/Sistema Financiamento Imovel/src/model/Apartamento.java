package model;

import java.lang.reflect.Array;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.util.ArrayList;
import java.math.BigDecimal;

public class Apartamento extends Financiamento {
    // Incluir um atributo para o número de vagas da garagem, e outro atributo para o número do andar.
    private int numeroAndar;
    private int numeroApartamento;
    private int quantidadeVaga;

    public Apartamento(double valor_Imovel, int prazo_Financiamento, double taxa_Juro, int numeroApartamento, int numeroAndar , int quantidadeVaga){
        super(valor_Imovel, prazo_Financiamento, taxa_Juro);
        this.numeroApartamento = numeroApartamento;
        this.numeroAndar = numeroAndar;
        this.quantidadeVaga = quantidadeVaga;
    }

    public int getNumeroApartamento(){
        return this.numeroApartamento;
    }

    public int getNumeroAndar(){
        return this.numeroAndar;
    }

    public int getQuantidadeVaga(){
        return this.quantidadeVaga;
    }

    @Override
    public double calcularPagamentoMes() {
        int mesAno = 12;
        int prazo = this.getPrazoFinanciamento();
        double valor = this.getValorImovel();
        double taxa = this.getTaxaJurosMensal();
        int messes = prazo * mesAno;

        // Cálculo da fórmula
        double numerator = valor * Math.pow(1 + taxa, messes);
        double denominator = Math.pow(1 + taxa, (messes - 1));
        double calculo = numerator / denominator;

        return converterCasasDecimais(calculo);
    }

    @Override
    public void imprimirDetalhesEspecificos(){
        System.out.println("Número do apartamento: " + this.getNumeroApartamento());
        System.out.println("Número do andar: " + this.getNumeroAndar());
        System.out.println("Quantidade de vagas na garagem: " + this.getQuantidadeVaga());
        System.out.println("---------------------------------------------------------");
    }

    @Override
    public double calcularTotalFinanciamento() {
        double calculo = this.calcularPagamentoMes() * this.prazoFinanciamento * 12;
        return converterCasasDecimais(calculo);
    }
}
