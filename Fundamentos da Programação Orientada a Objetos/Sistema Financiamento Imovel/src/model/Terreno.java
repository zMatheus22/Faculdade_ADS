package model;

import java.text.DecimalFormat;
import java.text.ParseException;

public class Terreno extends Financiamento{
    public Terreno(double valor_Imovel, int prazo_Financiamento, double taxa_Juro){
        super(valor_Imovel, prazo_Financiamento, taxa_Juro);
    }

    @Override
    public double calcularPagamentoMes() {
        double calculo = super.calcularPagamentoMes() * 1.02;

        // Formatando as casas decimais para 2.
        DecimalFormat df = new DecimalFormat("#.00"); // Declarando o limite.
        String result_String = df.format(calculo); // Reescrevendo o valor com o limite.
        double result_Double = 0; // Variavel que irá receber o valor formatado.

        // Tratamento de erro.
        try {
            result_Double = df.parse(result_String).doubleValue(); // Converte a String em Double.
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }

        return result_Double;
    }
}
