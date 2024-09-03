package solutions.week6.binaryTernary;

import java.text.DecimalFormat;
import java.util.Scanner;

public class CrossedLadders {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNextDouble()) {
            double x = scanner.nextDouble();
            double y = scanner.nextDouble();
            double c = scanner.nextDouble();
            double left = 0;
            double right = Math.min(x, y);
            double mid = (left + right) / 2;
            double c1;
            do {
                double a = Math.sqrt(x * x - mid * mid);
                double b = Math.sqrt(y * y - mid * mid);
                c1 = (a * b) / (a + b);
                if (c1 < c) {
                    right = mid;
                } else {
                    left = mid;
                }
                mid = (left + right) / 2;
            } while (Math.abs(c1 - c) > 0.00001);
            DecimalFormat decimalFormat = new DecimalFormat("#." + "0".repeat(3));
            String formattedNumber = decimalFormat.format(mid);
            System.out.println(formattedNumber);
        }
    }
}
