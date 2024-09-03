package solutions.week6.binaryTernary;

import java.text.DecimalFormat;
import java.util.Scanner;

public class DenseForest {
    private static final double EPS = 10e-7;
    private static final Scanner scanner = new Scanner(System.in);
    private static final double vp = scanner.nextDouble();
    private static final double vf = scanner.nextDouble();
    private static final double a = scanner.nextDouble();

    public static void main(String[] args) {
        double left = 0, right = 1, f, g;
        while (right - left >= EPS) {
            f = left + (right - left) / 3;
            g = right - (right - left) / 3;
            if (t(f) < t(g)) right = g;
            else left = f;
        }
        DecimalFormat decimalFormat = new DecimalFormat("#." + "0".repeat(8));
        String formattedNumber = decimalFormat.format(left);
        System.out.println(formattedNumber);
    }

    public static double t(double x) {
        return Math.sqrt(x * x + (1 - a) * (1 - a)) / vp +
                Math.sqrt(a * a + (1 - x) * (1 - x)) / vf;
    }
}
