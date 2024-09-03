package solutions.week5.mergeSort;

import java.util.Scanner;

public class SortingTime {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        Time[] arr = new Time[n + 1];
        for (int i = 1; i <= n; i++) {
            int hours = scanner.nextInt();
            int minutes = scanner.nextInt();
            int seconds = scanner.nextInt();
            arr[i] = new Time(hours, minutes, seconds);
        }
        split(arr, 1, n);
        for (int i = 1; i <= n; i++) {
            System.out.println(arr[i]);
        }
    }

    public static void merge(Time[] a, int bleft, int bright, int cleft, int cright) {
        int i, left = bleft, len = cright - bleft + 1;
        Time[] res = new Time[len];
        for (i = 0; i < len; i++) {
            if ((bleft > bright) || (cleft > cright)) break;
            if (!compare(a[bleft], a[cleft])) res[i] = a[bleft++];
            else res[i] = a[cleft++];
        }
        while (bleft <= bright) res[i++] = a[bleft++];
        while (cleft <= cright) res[i++] = a[cleft++];
        for (i = left; i < left + len; i++) a[i] = res[i - left];
    }


    public static void split(Time[] a, int l, int r) {
        if (l < r) {
            int middle = (l + r) / 2;
            split(a, l, middle);
            split(a, middle + 1, r);
            merge(a, l, middle, middle + 1, r);
        }
    }

    public static boolean compare(Time a, Time b) {
        if ((a.hours == b.hours) && (a.minutes == b.minutes)) return a.seconds > b.seconds;
        if (a.hours == b.hours) return a.minutes > b.minutes;
        return a.hours > b.hours;
    }

    private record Time(int hours, int minutes, int seconds) {
        @Override
        public String toString() {
            return String.format("%d %d %d", hours, minutes, seconds);
        }
    }
}
