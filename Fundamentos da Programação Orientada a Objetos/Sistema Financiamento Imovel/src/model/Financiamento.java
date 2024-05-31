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

    public double getValorImovel(){
        return this.valorImovel;
    }

    public int getPrazoFinanciamento(){
        return this.prazoFinanciamento;
    }

    public double getTaxaJurosAnual(){
        return this.taxaJurosAnual;
    }

    public void apresentar_Dados_Financiamento(){
        System.out.printf("Valor do Imovel R$ %.2f\n", getValorImovel());
        System.out.printf("O prazo do financiamento %d ano(s)\n", getPrazoFinanciamento());
        System.out.printf("A taxa de juro: %.2f%% \n", getTaxaJurosAnual());
        System.out.printf("Valor da mensal do financiamento:  %.2f\n", calcular_Pagamento_Mes());
        System.out.printf("Valor total do financiamento: %.2f\n", calcular_Total_Pagamento());

    }
}
