package model;

import java.text.DecimalFormat;
import java.text.ParseException;

/**
 * Financiamento
 */
public abstract class Financiamento {
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

    public abstract double calcularPagamentoMes();

    public String toString() {
        String msgValorImovel = "Valor do imóvel: R$ "+ this.getValorImovel() +"\n";
        String msgPrazo = "Prazo do financiamento: "+ this.getPrazoFinanciamento()+" anos\n";
        String msgTaxaMensal = "Taxa de juros mensal: "+ converterCasasDecimais(this.getTaxaJurosMensal()*100)+" %\n";
        String msgTaxaAnual = "Taxa de juros anual: "+ this.getTaxaJurosAnual()*100+" %\n";

        StringBuffer sb = new StringBuffer();

        sb.append(msgValorImovel);
        sb.append(msgPrazo);
        sb.append(msgTaxaMensal);
        sb.append(msgTaxaAnual);

        return sb.toString();
        // Os demais dados estaram nas interfaces de cada financiamento.
    }

    public abstract double calcularTotalFinanciamento();

    public double converterCasasDecimais(double number){
        // Formatando as casas decimais para 2.
        DecimalFormat df = new DecimalFormat("#.00"); // Declarando o limite.
        String result_String = df.format(number); // Reescrevendo o valor com o limite.
        double numberConvertido = 0; // Variavel que irá receber o valor formatado.

        try {
            numberConvertido = df.parse(result_String).doubleValue(); // Converte a String em Double.
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }

        return numberConvertido;
    }
}
