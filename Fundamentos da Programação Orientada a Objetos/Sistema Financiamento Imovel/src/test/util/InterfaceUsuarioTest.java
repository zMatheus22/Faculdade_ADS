package test.util;

import org.junit.jupiter.api.Test;
import util.InterfaceUsuario;
import java.io.ByteArrayInputStream;

import static org.junit.jupiter.api.Assertions.*;


public class InterfaceUsuarioTest {
    private ByteArrayInputStream inputByte; // Stream para entrada simulada
    private InterfaceUsuario user = new InterfaceUsuario();

    @Test
    public void test_Metodo_Pedir_Valor_Com_Valor_Positivo_Dentro_Intervalo() {
        // Simular a entrada do usuário
        String input = "50000\n";  // Valor a ser simulado como entrada
        inputByte = new ByteArrayInputStream(input.getBytes());
        System.setIn(inputByte);

        double valor = user.pedirValorImovel();

        // Verificar se o valor retornado é igual a 50000
        assertEquals(500000, valor, "O valor do imóvel deve ser 50000");
    }
}
