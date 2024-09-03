package solutions.quiz1;

import java.util.Scanner;

public class ACMSort {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        Team[] arr = new Team[n + 1];
        for (int i = 1; i <= n; i++) {
            String name = scanner.next();
            int solved = scanner.nextInt();
            int penaltyTime = scanner.nextInt();
            arr[i] = new Team(name, solved, penaltyTime, i);
        }
        split(arr, 1, n);
        for (int i = 1; i <= n; i++) {
            System.out.println(arr[i]);
        }
    }

    public static void merge(Team[] a, int bleft, int bright, int cleft, int cright) {
        int i, left = bleft, len = cright - bleft + 1;
        Team[] res = new Team[len];
        for (i = 0; i < len; i++) {
            if ((bleft > bright) || (cleft > cright)) break;
            if (compare(a[bleft], a[cleft])) res[i] = a[bleft++];
            else res[i] = a[cleft++];
        }
        while (bleft <= bright) res[i++] = a[bleft++];
        while (cleft <= cright) res[i++] = a[cleft++];
        for (i = left; i < left + len; i++) a[i] = res[i - left];
    }

    public static boolean compare(Team team1, Team team2) {
        if (team1.solved != team2.solved) return team1.solved > team2.solved;
        else {
            if (team1.penaltyTime != team2.penaltyTime) {
                return team1.penaltyTime < team2.penaltyTime;
            } else {
                return team1.id < team2.id;
            }
        }
    }


    public static void split(Team[] a, int l, int r) {
        if (l < r) {
            int middle = (l + r) / 2;
            split(a, l, middle);
            split(a, middle + 1, r);
            merge(a, l, middle, middle + 1, r);
        }
    }

    private record Team(String name, int solved, int penaltyTime, int id) {
        @Override
        public String toString() {
            return String.format("%s %d %d", name, solved, penaltyTime);
        }
    }
}

