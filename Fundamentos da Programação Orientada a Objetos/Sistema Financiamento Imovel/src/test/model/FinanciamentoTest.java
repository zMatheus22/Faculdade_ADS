package test.model;

import model.Financiamento;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class FinanciamentoTest {
    @Test
    @DisplayName("Passando o valor de 100 mil, no prazo de 10 anos com uma taxa de 10%, o pago mensal teve ser R$ 834.03.")
    public void test_calculo_Mes(){
        double result = new Financiamento(100000,10,1).calcularPagamentoMes();
        assertEquals(834.03, result);
    }

    @Test
    @DisplayName("Passando o valor de 345 mil, no prazo de 25 anos com uma taxa de 11.25%, o pago mensal teve ser R$ 1160.78.")
    public void test_calculo_Mes_2(){
        double result = new Financiamento(345000, 25, 11.25).calcularPagamentoMes();
        assertEquals(1160.78, result);
    }

    @Test
    @DisplayName("Fincanciamento do valor de R$ 500.000,00, 10% de juros, 10 anos, o pago mensal teve ser R$ 4201,39")
    public void test_calculo_Mes_3(){
        double result = new Financiamento(500000, 10, 10).calcularPagamentoMes();
        assertEquals(4201.39, result);
    }
}
