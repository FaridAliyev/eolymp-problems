package solutions.week6.binaryTernary;

import java.text.DecimalFormat;
import java.util.Scanner;

public class SquareRoot {
    public static final double EPS = 1e-10;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double c = scanner.nextDouble();

        double left = 0, right = c;
        while (right - left > EPS) {
            double middle = (left + right) / 2;
            double y = f(middle);
            if (y > c) right = middle;
            else left = middle;
        }

        DecimalFormat decimalFormat = new DecimalFormat("#." + "0".repeat(6));
        String formattedNumber = decimalFormat.format(left);
        System.out.println(formattedNumber);
    }

    public static double f(double x) {
        return x * x + Math.sqrt(x);
    }
}
