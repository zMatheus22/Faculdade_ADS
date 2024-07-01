package test.model;

import model.Apartamento;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ApartamentoTest {
    @Test
    @DisplayName("Fincanciamento de um apartamento com os valor de R$ 500.000,00, 10% de juros, 10 anos.")
    public void test_calculo_Mes_Apartamento(){
        Apartamento a = new Apartamento(500000,10,10);
        double result = a.calcularPagamentoMes();
        assertEquals(6607.54, result);
    }
}
