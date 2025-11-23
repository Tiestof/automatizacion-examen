package cl.iplacex.automatizacion;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class AppTest {

    @Test
    void pruebaSumaBasica() {
        App app = new App();
        int resultado = app.sumar(2, 3);

        Assertions.assertEquals(5, resultado,
                "La suma 2 + 3 debe ser 5");
    }
}
