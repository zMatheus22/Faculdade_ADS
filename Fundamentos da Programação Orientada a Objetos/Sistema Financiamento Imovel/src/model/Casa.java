package model;

public class Casa extends Financiamento{

    public Casa(double valor_Imovel, int prazo_Financiamento, double taxa_Juro){
        super(valor_Imovel, prazo_Financiamento, taxa_Juro);
    }

    public double calcularPagamentoMes(){
        return super.calcularPagamentoMes() + 80;
    }
}
