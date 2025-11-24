package cl.iplacex.automatizacion.acceptance;

import cl.iplacex.automatizacion.App;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * Prueba de aceptación (Acceptance Test):
 * Simula un escenario completo de usuario final.
 */
public class AppAcceptanceTest {

    @Test
    void escenarioCompleto() {
        App app = new App();

        int r1 = app.sumar(5, 5);
        int r2 = app.sumar(r1, 10);

        Assertions.assertEquals(20, r2,
                "El flujo funcional debe cumplir el escenario completo.");
    }
}
