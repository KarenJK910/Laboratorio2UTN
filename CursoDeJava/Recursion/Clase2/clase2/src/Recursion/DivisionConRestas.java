package Recursion;

public class DivisionConRestas {
    // Versión recursiva de la división
    public static int divisionRecursiva(int dividend, int divisor) {
        if (divisor == 0) {
            throw new ArithmeticException("Divisor no puede ser cero.");
        }
        if (dividend < divisor) {
            return 0;
        }
        return 1 + divisionRecursiva(dividend - divisor, divisor);
    }

    // Versión iterativa de la división
    public static int divisionIterativa(int dividend, int divisor) {
        if (divisor == 0) {
            throw new ArithmeticException("Divisor no puede ser cero.");
        }
        int quotient = 0;
        while (dividend >= divisor) {
            dividend -= divisor;
            quotient++;
        }
        return quotient;
    }
    public static void main(String[] args) {
        int dividend = 10;
        int divisor = 2;

        int resultadoRecursivo = divisionRecursiva(dividend, divisor);
        int resultadoIterativo = divisionIterativa(dividend, divisor);

        System.out.println("Resultado recursivo: " + resultadoRecursivo);
        System.out.println("Resultado iterativo: " + resultadoIterativo);
    }
}
