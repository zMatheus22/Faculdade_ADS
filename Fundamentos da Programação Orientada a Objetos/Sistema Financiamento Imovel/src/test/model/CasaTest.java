package test.model;

import model.Casa;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CasaTest {
    @Test
    @DisplayName("Fincanciamento de um casa com os valor de R$ 500.000,00, 10% de juros, 10 anos")
    public void test_calculo_Mes_Casa(){
        Casa c = new Casa(500000,10, 10, 10000, 20000);
        double result = c.calcularPagamentoMes();
        assertEquals(4236.11, result);
    }

    @Test
    @DisplayName("Financimanto de um casa com o valor de R$ 375.000,00, 15,75% de juros, 5 anos")
    public void test_calculo_Mes_Casa2() {
        Casa c = new Casa(375000, 5, 15.75, 10000, 20000);
        double result = c.calcularPagamentoMes();
        assertEquals(6412.03, result);
    }
}
