package Recursion;

public class SumatoriaRecursiva {
    public static int calcularSumatoria(int n) {
        if (n <= 0) {
            return 0;
        }
        return n + calcularSumatoria(n - 1);
    }
    public static void main(String[] args) {
        int n = 5;
        int resultado = calcularSumatoria(n);
        System.out.println("La sumatoria de los números desde 1 hasta " + n + " es: " + resultado);
    }
}
