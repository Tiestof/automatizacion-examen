package cl.iplacex.automatizacion.integracion;

import cl.iplacex.automatizacion.App;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * Prueba de integración de ejemplo.
 * En un proyecto real, aquí se probaría la integración
 * con otros componentes (BD, servicios externos, etc.).
 */
public class AppIntegrationTest {

    @Test
    void pruebaFlujoCompletoSuma() {
        App app = new App();

        int a = 10;
        int b = 15;
        int resultado = app.sumar(a, b);

        // En una integración real, se validarían varios pasos del flujo.
        Assertions.assertEquals(25, resultado,
                "La suma 10 + 15 debe ser 25 en el flujo de integración");
    }
}
