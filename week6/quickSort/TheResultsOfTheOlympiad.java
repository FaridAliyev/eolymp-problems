package solutions.week6.quickSort;

import java.util.Scanner;

public class TheResultsOfTheOlympiad {
    private static final Member[] arr = new Member[102];

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        for (int i = 0; i < n; i++) {
            int score = scanner.nextInt();
            arr[i] = new Member(i, score);
        }
        quickSort(0, n - 1);
        printArray(n);
    }

    public static void quickSort(int L, int R) {
        if (L < R) {
            int q = partition(L, R);
            quickSort(L, q);
            quickSort(q + 1, R);
        }
    }

    public static int partition(int L, int R) {
        Member x = arr[L];
        int i = L - 1, j = R + 1;
        while (true) {
            do j--; while (compare(arr[j], x));
            do i++; while (compare(x, arr[i]));
            if (i < j) swap(i, j);
            else return j;
        }
    }

    public static void swap(int index1, int index2) {
        Member temp = arr[index1];
        arr[index1] = arr[index2];
        arr[index2] = temp;
    }

    public static boolean compare(Member a, Member b) {
        if (a.score == b.score) return a.id > b.id;
        return a.score < b.score;
    }

    public static void printArray(int n) {
        for (int i = 0; i < n; i++) {
            System.out.print(arr[i] + " ");
        }
    }

    private record Member(int id, int score) {
        @Override
        public String toString() {
            return String.valueOf(id + 1);
        }
    }
}
