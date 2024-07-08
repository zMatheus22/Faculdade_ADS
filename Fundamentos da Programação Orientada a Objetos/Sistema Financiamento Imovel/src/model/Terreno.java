package model;

import java.io.Serializable;

public class Terreno extends Financiamento implements Serializable {

    // Atributo
    private int tipoZona;

    // Contrutor
    public Terreno(double valor_Imovel, int prazo_Financiamento, double taxa_Juro, int tipoZona){
        super(valor_Imovel, prazo_Financiamento, taxa_Juro);
        this.tipoZona = tipoZona;
    }

    // Metodos
    public String getTipoZona(){
        return switch (this.tipoZona) {
            case 1 -> "Residencial";
            case 2 -> "Comercial";
            case 3 -> "Rural/Agrícola";
            case 4 -> "Industrial";
            default -> "Tipo de zona não cadastrada.";
        };
    }

    @Override
    public double calcularPagamentoMes() {
        double calculo = (this.valorImovel / (this.prazoFinanciamento * 12)) * (1 + ((this.taxaJurosAnual/100) / 12)) * 1.02;

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
        String msgTipoTerreno = "O tipo do terreno é "+ this.getTipoZona()+"\n";
        String msgValorMensalidade = "Valor da mensalidade: R$ "+ this.calcularPagamentoMes() +"\n";
        String msgValorFinanciamento = "Valor total do financiamento: R$ "+ this.calcularTotalFinanciamento()+"\n";
        String msgFim = "---------------------------------------------------------";

        StringBuffer sb = new StringBuffer();

        sb.append(informacaoBasica);
        sb.append(msgTipoTerreno);
        sb.append(msgValorMensalidade);
        sb.append(msgValorFinanciamento);
        sb.append(msgFim);

        return sb.toString();
    }
}
