package solutions.week6.binaryTernary;

import java.text.DecimalFormat;
import java.util.Scanner;

public class TheRootOfACubicEquation {
    public static final double EPS = 1e-10;
    private static final Scanner scanner = new Scanner(System.in);
    private static final int a = scanner.nextInt();
    private static final int b = scanner.nextInt();
    private static final int c = scanner.nextInt();
    private static final int d = scanner.nextInt();

    public static void main(String[] args) {
        int res = 0;
        double right = 1;
        while (!(f(right) * f(-right) < 0)) {
            right *= 2;
        }
        double left = -right;
        while (right - left > EPS) {
            double middle = (left + right) / 2;
            double y = f(middle);
            if (y * f(right) > res) right = middle;
            else left = middle;
        }
        DecimalFormat decimalFormat = new DecimalFormat("#." + "0".repeat(6));
        String formattedNumber = decimalFormat.format(left);
        System.out.println(formattedNumber);
    }

    public static double f(double x) {
        return a * (x * x * x) + b * (x * x) + c * x + d;
    }
}
