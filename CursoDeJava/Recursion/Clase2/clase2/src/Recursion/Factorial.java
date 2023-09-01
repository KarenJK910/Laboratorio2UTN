package Recursion;

public class Factorial {
    // Versión recursiva del cálculo factorial
    public static long calcularFactorial(int n) {
        if (n < 0) {
            throw new IllegalArgumentException("El factorial no está definido para números negativos.");
        }
        if (n <= 1) {
            return 1;
        }
        return n * calcularFactorial(n - 1);
    }

    // Versión iterativa del cálculo factorial
    public static long calcularFactorialIterativo(int n) {
        if (n < 0) {
            throw new IllegalArgumentException("El factorial no está definido para números negativos.");
        }
        long resultado = 1;
        for (int i = 1; i <= n; i++) {
            resultado *= i;
        }
        return resultado;
    }
    public static void main(String[] args) {
        int numero = 5;
        long resultadoRecursivo = calcularFactorial(numero);
        long resultadoIterativo = calcularFactorialIterativo(numero);

        System.out.println("Factorial recursivo de " + numero + " es: " + resultadoRecursivo);
        System.out.println("Factorial iterativo de " + numero + " es: " + resultadoIterativo);
    }
}
