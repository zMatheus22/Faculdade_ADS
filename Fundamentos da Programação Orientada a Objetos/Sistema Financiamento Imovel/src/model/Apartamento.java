package model;

import java.lang.reflect.Array;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.util.ArrayList;
import java.math.BigDecimal;

public class Apartamento extends Financiamento {

    public Apartamento(double valor_Imovel, int prazo_Financiamento, double taxa_Juro){
        super(valor_Imovel, prazo_Financiamento, taxa_Juro);
    }

    @Override
    public double calcularPagamentoMes() {
        int mesAno = 12;
        int prazo = getPrazoFinanciamento();
        double valor = getValorImovel();
        double taxa = getTaxaJurosMensal();
        int messes = prazo * mesAno;

        // Formatando as casas decimais para 2.
        DecimalFormat df = new DecimalFormat("#.00"); // Declarando o limite.
        double result_Double = 0; // Variavel que irá receber o valor formatado.

        // Cálculo da fórmula
        double numerator = valor * Math.pow(1 + taxa, messes);
        double denominator = Math.pow(1 + taxa, (messes - 1));
        double calculo = numerator / denominator;
        String result_String = df.format(calculo); // Reescrevendo o valor com o limite.

        // Tratamento de erro.
        try {
            result_Double = df.parse(result_String).doubleValue(); // Converte a String em Double.
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
        return result_Double;
    }
}
