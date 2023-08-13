import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Ingrese el primer número: ");
        int num1 = scanner.nextInt();

        System.out.println("Ingrese el segundo número: ");
        int num2 = scanner.nextInt();

        System.out.println("Ingrese el tercer número: ");
        int num3 = scanner.nextInt();

        int v1, v2, v3;

        if (num1 >= num2 && num1 >= num3) {
            v1 = num1;
            if (num2 >= num3) {
                v2 = num2;
                v3 = num3;
            } else {
                v2 = num3;
                v3 = num2;
            }
        } else if (num2 >= num1 && num2 >= num3) {
            v1 = num2;
            if (num1 >= num3) {
                v2 = num1;
                v3 = num3;
            } else {
                v2 = num3;
                v3 = num1;
            }
        } else {
            v1 = num3;
            if (num1 >= num2) {
                v2 = num1;
                v3 = num2;
            } else {
                v2 = num2;
                v3 = num1;
            }
        }

        System.out.println("Números ordenados de mayor a menor: " + v1 + ", " + v2 + ", " + v3);

        scanner.close();
    }
}
