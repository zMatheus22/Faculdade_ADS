package model;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class Apartamento extends Financiamento {

    public Apartamento(double valor_Imovel, int prazo_Financiamento, double taxa_Juro){
        super(valor_Imovel, prazo_Financiamento, taxa_Juro);
    }

    @Override
    public double calcularPagamentoMes() {
        //            (500000           * (1 + (0,10/12))
        double base = super.valorImovel * (1 + ((super.taxaJurosAnual / 100)/ 12));
        //                 (10                       * 12))
        double expoente1 = (super.prazoFinanciamento * 12);
        //      (base^expoente1) /((1 + (0,10 / 12))
        double expoente2 = base / (1 + super.getTaxaJurosMensal());
        //                ^ (10                       * 12) - 1)
        double expoente3 =  (super.prazoFinanciamento * 12) - 1;

        String test2 = "Base: "+base+", Expoente01: "+expoente1+", Expoente02: "+expoente2+", Expoente03: "+expoente3;
        System.out.printf(test2);
        return 0;
    }
}
