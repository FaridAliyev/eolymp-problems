package solutions.week5.mergeSort;

import java.util.Scanner;

public class TheResultsOfTheOlympiad {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        Member[] arr = new Member[n + 1];
        for (int i = 1; i <= n; i++) {
            int score = scanner.nextInt();
            arr[i] = new Member(i, score);
        }
        split(arr, 1, n);
        for (int i = 1; i <= n; i++) {
            System.out.print(arr[i] + " ");
        }
    }

    public static void merge(Member[] a, int bleft, int bright, int cleft, int cright) {
        int i, left = bleft, len = cright - bleft + 1;
        Member[] res = new Member[len];
        for (i = 0; i < len; i++) {
            if ((bleft > bright) || (cleft > cright)) break;
            if (!compare(a[bleft], a[cleft])) res[i] = a[bleft++];
            else res[i] = a[cleft++];
        }
        while (bleft <= bright) res[i++] = a[bleft++];
        while (cleft <= cright) res[i++] = a[cleft++];
        for (i = left; i < left + len; i++) a[i] = res[i - left];
    }


    public static void split(Member[] a, int l, int r) {
        if (l < r) {
            int middle = (l + r) / 2;
            split(a, l, middle);
            split(a, middle + 1, r);
            merge(a, l, middle, middle + 1, r);
        }
    }

    public static boolean compare(Member a, Member b) {
        if (a.score == b.score) return a.id > b.id;
        return a.score < b.score;
    }

    private record Member(int id, int score) {
        @Override
        public String toString() {
            return String.valueOf(id);
        }
    }
}
