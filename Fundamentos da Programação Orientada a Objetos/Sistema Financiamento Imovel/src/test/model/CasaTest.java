package test.model;

import model.Casa;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CasaTest {
    @Test
    @DisplayName("Fincanciamento de um casa com os valor de R$ 500.000,00, 10% de juros, 10 anos")
    public void test_calculo_Mes_Casa(){
        Casa c = new Casa(500000,10, 10);
        double result = c.calcularPagamentoMes();
        assertEquals(4281.39, result);
    }
}
