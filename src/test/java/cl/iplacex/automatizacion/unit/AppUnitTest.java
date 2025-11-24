package cl.iplacex.automatizacion.unit;

import cl.iplacex.automatizacion.App;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * Pruebas unitarias básicas de la clase App.
 */
public class AppUnitTest {

    @Test
    void pruebaSumaBasica() {
        App app = new App();
        int resultado = app.sumar(2, 3);

        Assertions.assertEquals(5, resultado,
                "La suma 2 + 3 debe ser 5");
    }
}
