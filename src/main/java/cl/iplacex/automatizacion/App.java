package cl.iplacex.automatizacion;

public class App {
    public int sumar(int a, int b) {
        return a + b;
    }

    public static void main(String[] args) {
        App app = new App();
        int resultado = app.sumar(2, 3);
        System.out.println("Resultado de 2 + 3 = " + resultado);
    }
}
