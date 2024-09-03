package solutions.week6.binaryTernary;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class CountTheIntegersOfTheForm {
    private static final long max = 1000000000000000000L;
    private static final List<Long> list = new ArrayList<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        fillArray();
        while (scanner.hasNextLong()) {
            long a = scanner.nextLong();
            long b = scanner.nextLong();
            System.out.println(upperBound(0, list.size(), b) - upperBound(0, list.size(), a - 1));
        }
    }

    public static long upperBound(long left, long right, long x) {
        while (left < right) {
            int middle = (int) ((left + right) / 2);
            if (x >= list.get(middle)) left = middle + 1;
            else right = middle;
        }
        return left;
    }

    public static void fillArray() {
        long x = 1, y = 1;
        while (x <= max) {
            while (x * y <= max) {
                list.add(x * y);
                y *= 3;
            }
            x *= 2;
            y = 1;
        }
        Collections.sort(list);
    }
}
