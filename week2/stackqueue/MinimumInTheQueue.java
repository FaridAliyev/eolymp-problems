package solutions.week2.stackqueue;

import java.util.Scanner;

public class MinimumInTheQueue {
    private static int bvalue = 0, evalue = 0, bmn = 0, emn = 0;
    private static long[] value;
    private static long[] mn;

    public static void main(String[] args) {
        int i;
        long res = 0;
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int a = scanner.nextInt();
        int b = scanner.nextInt();
        int c = scanner.nextInt();
        long x = scanner.nextLong();

        init(n);
        for (i = 1; i <= n; i++) {
            x =  (a * x * x + b * x + c) / 100 % 1000000L;
            if (x % 5 < 2) pop();
            else push(x);
            res += getMin();
        }
        System.out.println(res);
    }

    public static void init(int n) {
        value = new long[n];
        mn = new long[n];
    }

    public static void pop() {
        if (bvalue != evalue) {
            if (value[bvalue] == mn[bmn]) bmn++;
            bvalue++;
        }
    }

    public static long getMin() {
        return bmn != emn ? mn[bmn] : 0;
    }

    public static void push(long x) {
        value[evalue++] = x;
        while (bmn != emn && x < mn[emn - 1]) emn--;
        mn[emn++] = x;
    }
}
