package model;

import util.DescontoMaiorDoQueJurosException;
import java.io.Serializable;

public class Casa extends Financiamento implements Serializable {
    // Atributo
    private float areaConstruida;
    private float areaTerreno;

    // Construtor
    public Casa(double valor_Imovel, int prazo_Financiamento, double taxa_Juro, float areaConstruida, float areaTerreno){
        super(valor_Imovel, prazo_Financiamento, taxa_Juro);
        this.areaConstruida = areaConstruida;
        this.areaTerreno = areaTerreno;
    }

    // Métodos
    public float getAreaConstruida(){
        return this.areaConstruida;
    }

    public float getAreaTerreno(){
        return this.areaTerreno;
    }

    private void descontoMaiorDoQueJurosException(double valorDiferenca, double valorAcrecimo) throws DescontoMaiorDoQueJurosException{
        if (valorDiferenca < valorAcrecimo) {
            throw new DescontoMaiorDoQueJurosException("O valor do acrecimo passa a ser R$ " + converterCasasDecimais(valorDiferenca));
        }
    }

    @Override
    public double calcularPagamentoMes(){
        double valorAcrecimo = 80;
        double valorMensal = (this.valorImovel / (this.prazoFinanciamento * 12));
        double valorTotal = valorMensal * (1 + ((this.taxaJurosAnual/100) / 12));
        double valorDiferenca = valorTotal - valorMensal;

        try {
            descontoMaiorDoQueJurosException(valorDiferenca, valorAcrecimo);
        } catch (DescontoMaiorDoQueJurosException e){
            System.out.println(e.getMessage());
            valorAcrecimo = valorDiferenca;
        }

        valorTotal += valorAcrecimo;
        return converterCasasDecimais(valorTotal);
    }

    @Override
    public double calcularTotalFinanciamento() {
        double calculo = this.calcularPagamentoMes() * this.prazoFinanciamento * 12;
        return converterCasasDecimais(calculo);
    }

    @Override
    public String toString() {
        String informacaoBasica = super.toString();
        String msgAreaConstrida = "Área construída: "+ this.getAreaConstruida() +"\n";
        String msgAreaTerreno = "Área do terreno: "+ this.getAreaTerreno() +"\n";
        String msgValorMensalidade = "Valor da mensalidade: R$ "+ this.calcularPagamentoMes() +"\n";
        String msgValorFinanciamento = "Valor total do financiamento: R$ "+ this.calcularTotalFinanciamento()+"\n";
        String msgFim = "---------------------------------------------------------";

        StringBuffer sb = new StringBuffer();

        sb.append(informacaoBasica);
        sb.append(msgAreaConstrida);
        sb.append(msgAreaTerreno);
        sb.append(msgValorMensalidade);
        sb.append(msgValorFinanciamento);
        sb.append(msgFim);

        return sb.toString();
    }
}
