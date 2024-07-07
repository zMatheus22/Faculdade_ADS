package test.model;

import model.Terreno;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TerrenoTest {
    @Test
    @DisplayName("Fincanciamento de um terreno com os valor de R$ 500.000,00, 10% de juros, 10 anos.")
    public void test_Calculo_Mes_Terreno(){
        double result = new Terreno(500000, 10,10, 1).calcularPagamentoMes();
        assertEquals(4285.42, result);
    }
}
