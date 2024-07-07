package model;

public class Casa extends Financiamento{
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

    @Override
    public void imprimirDetalhesEspecificos(){
        System.out.println("Área construída: " + this.getAreaConstruida());
        System.out.println("Área do terreno: " + this.getAreaTerreno());
        System.out.println("---------------------------------------------------------");
    }

    @Override
    public double calcularPagamentoMes(){
        double valorSeguro = 80;
        double calculo = (this.valorImovel / (this.prazoFinanciamento * 12)) * (1 + ((this.taxaJurosAnual/100) / 12));
        calculo += valorSeguro;
        return converterCasasDecimais(calculo);
    }

    @Override
    public double calcularTotalFinanciamento() {
        double calculo = this.calcularPagamentoMes() * this.prazoFinanciamento * 12;
        return converterCasasDecimais(calculo);
    }
}
