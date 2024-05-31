package model;

/**
 * Financiamento
 */
public class Financiamento {
    // Atributo
    private double valorImovel;
    private int prazoFinanciamento;
    private double taxaJurosAnual;

    // Construtor
    public Financiamento(double valor_Imovel, int prazo_Financiamento, double taxa_Juro){
        this.valorImovel = valor_Imovel;
        this.prazoFinanciamento = prazo_Financiamento;
        this.taxaJurosAnual = taxa_Juro;
    }

    // Métodos

    public double calcular_Pagamento_Mes(){
        return (this.valorImovel / (this.prazoFinanciamento * 12)) * (1 + (this.taxaJurosAnual / 12));
    }

    public double calcular_Total_Pagamento(){
        return calcular_Pagamento_Mes() * this.prazoFinanciamento * 12;
    }
}
