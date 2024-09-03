package solutions.week6.binaryTernary;

import java.text.DecimalFormat;
import java.util.Scanner;

public class InterestingPolygon {
    private static final double EPS = 1e-12;
    public static final double PI = Math.acos(-1.0);

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        double left = (double) n / 2;
        double right = n * n;
        while (right - left > EPS) {
            double middle = (left + right) / 2;
            double fi = 0;
            for (int i = 1; i <= n; i++) {
                double angle = (2 * middle * middle - i * i) / (2 * middle * middle);
                if ((angle < -1.0) || (angle > 1.0)) {
                    fi = 100;
                    break;
                }
                fi += Math.acos(angle);
            }
            if (fi <= 2 * PI) {
                right = middle;
            } else {
                left = middle;
            }
        }
        DecimalFormat decimalFormat = new DecimalFormat("#." + "0".repeat(8));
        String formattedNumber = decimalFormat.format(left);
        System.out.println(formattedNumber);
    }
}
