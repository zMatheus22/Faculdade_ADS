package test.model;

import jdk.jfr.Description;
import model.Financiamento;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class FinanciamentoTest {

    private ByteArrayInputStream inputStream;

    @Test
    @Description("Testando o valor que deve ser pago mensalmente.")
    public void test_calculo_Mes(){
        double result = new Financiamento(100000,10,1).calcularPagamentoMes();
        assertEquals(834.03, result);
    }
}
