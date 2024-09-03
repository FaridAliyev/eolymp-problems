package solutions.week6.binaryTernary;

import java.text.DecimalFormat;
import java.util.Scanner;

public class TernarySearch {
    private static final Scanner scanner = new Scanner(System.in);
    private static final double EPS = 10e-7;
    private static final double a = scanner.nextDouble();
    private static final double b = scanner.nextDouble();

    public static void main(String[] args) {
        double x = triple( -100, 100);
        DecimalFormat decimalFormat = new DecimalFormat("#." + "0".repeat(2));
        String formattedNumber = decimalFormat.format(x);
        System.out.println(formattedNumber);
    }

    public static double triple(double a, double b) {
        double g, h;
        while (b - a > EPS) {
            g = a + (b - a) / 3;
            h = a + 2 * (b - a) / 3;
            if (f(g) <= f(h)) b = h;
            else a = g;
        }
        return (a + b) / 2;
    }

    public static double f(double x) {
        return x * x + a * x + b;
    }
}
