package model;

import java.text.DecimalFormat;
import java.text.ParseException;

/**
 * Financiamento
 */
public class Financiamento {
    // Atributo
    protected double valorImovel;
    protected int prazoFinanciamento;
    protected double taxaJurosAnual;

    // Construtor
    public Financiamento(double valor_Imovel, int prazo_Financiamento, double taxa_Juro){
        this.valorImovel = valor_Imovel;
        this.prazoFinanciamento = prazo_Financiamento;
        this.taxaJurosAnual = taxa_Juro;
    }

    // Métodos
    public double calcularPagamentoMes(){
        double calculo = (this.valorImovel / (this.prazoFinanciamento * 12)) * (1 + ((this.taxaJurosAnual/100) / 12));

        // Formatando as casas decimais para 2.
        DecimalFormat df = new DecimalFormat("#.00"); // Declarando o limite.
        String result_String = df.format(calculo); // Reescrevendo o valor com o limite.
        double result_Double = 0; // Variavel que irá receber o valor formatado.
        // Tratamento de erro.
        try {
            result_Double = df.parse(result_String).doubleValue(); // Converte a String em Double.
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
        return result_Double;
    }

    public double calcularTotalFinanciamento(){
        return this.calcularPagamentoMes() * this.prazoFinanciamento * 12;
    }

    public double getValorImovel(){
        return this.valorImovel;
    }

    public int getPrazoFinanciamento(){
        return this.prazoFinanciamento;
    }

    public double getTaxaJurosAnual(){
        return this.taxaJurosAnual / 100;
    }

    public double getTaxaJurosMensal(){
        return getTaxaJurosAnual() / 12;
    }

    public void apresentarDadosFinanciamento(){
        System.out.printf("Valor do Imovel R$ %.2f\n", getValorImovel());
        System.out.printf("O prazo do financiamento %d ano(s)\n", getPrazoFinanciamento());
        System.out.printf("A taxa de juro: %.2f%% \n", getTaxaJurosAnual());
        System.out.printf("Valor da mensalidade: R$ %.2f\n", calcularPagamentoMes());
        System.out.printf("Valor do financiamento: R$ %.2f\n", calcularTotalFinanciamento());
        System.out.println("-----------------------------------------");
    }
}
