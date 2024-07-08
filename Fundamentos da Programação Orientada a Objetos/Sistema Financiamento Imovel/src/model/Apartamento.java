package model;

import java.io.Serializable;

public class Apartamento extends Financiamento implements Serializable {
    // Incluir um atributo para o número de vagas da garagem, e outro atributo para o número do andar.
    private int numeroAndar;
    private int numeroApartamento;
    private int quantidadeVaga;

    // Construtor
    public Apartamento(double valor_Imovel, int prazo_Financiamento, double taxa_Juro, int numeroApartamento, int numeroAndar , int quantidadeVaga){
        super(valor_Imovel, prazo_Financiamento, taxa_Juro);
        this.numeroApartamento = numeroApartamento;
        this.numeroAndar = numeroAndar;
        this.quantidadeVaga = quantidadeVaga;
    }

    // Metodos
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
    public double calcularTotalFinanciamento() {
        double calculo = this.calcularPagamentoMes() * this.prazoFinanciamento * 12;
        return converterCasasDecimais(calculo);
    }

    @Override
    public String toString(){
        String informacaoBasica = super.toString();
        String msgNumeroApartamento = "Número do apartamento: "+this.getNumeroApartamento() +"\n";
        String msgNumeroAndar = "Número do andar: "+ this.getNumeroAndar() +"\n";
        String msgQtdVaga = "Quantidade de vagas na garagem: "+ this.getQuantidadeVaga() +"\n";
        String msgValorMensalidade = "Valor da mensalidade: R$ "+ this.calcularPagamentoMes() +"\n";
        String msgValorFinanciamento = "Valor total do financiamento: R$ "+ this.calcularTotalFinanciamento()+"\n";
        String msgFim = "---------------------------------------------------------";

        StringBuffer sb = new StringBuffer();

        sb.append(informacaoBasica);
        sb.append(msgNumeroApartamento);
        sb.append(msgNumeroAndar);
        sb.append(msgQtdVaga);
        sb.append(msgValorMensalidade);
        sb.append(msgValorFinanciamento);
        sb.append(msgFim);

        return sb.toString();
    }
}
