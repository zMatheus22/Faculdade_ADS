package model;

public class Terreno extends Financiamento{

    private int tipoZona;

    public Terreno(double valor_Imovel, int prazo_Financiamento, double taxa_Juro, int tipoZona){
        super(valor_Imovel, prazo_Financiamento, taxa_Juro);
        this.tipoZona = tipoZona;
    }

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
    public void imprimirDetalhesEspecificos(){
        System.out.println("O tipo do terreno é " + this.getTipoZona());
        System.out.println("---------------------------------------------------------");
    }
}
