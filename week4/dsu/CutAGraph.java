package solutions.week4.dsu;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CutAGraph {
    private static final int[] arr = new int[50001];
    private static final int[] depth = new int[50001];
    private static final List<Command> commands = new ArrayList<>();
    private static final List<String> outputs = new ArrayList<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        int k = scanner.nextInt();
        for (int i = 1; i <= n; i++) {
            arr[i] = i;
            depth[i] = 0;
        }

        for (int i = 1; i <= m; i++) {
            int a = scanner.nextInt();
            int b = scanner.nextInt();
        }

        for (int i = 0; i < k; ++i) {
            String op = scanner.next();
            int a = scanner.nextInt();
            int b = scanner.nextInt();
            commands.add(new Command(op, a, b));
        }

        for (int i = k - 1; i >= 0; i--) {
            Command command = commands.get(i);
            String op = command.op;
            int a = command.a;
            int b = command.b;
            switch (op) {
                case "ask" -> {
                    if (representative(a) == representative(b)) {
                        outputs.add("YES");
                    } else outputs.add("NO");
                }
                case "cut" -> union(a, b);
            }
        }

        for (int i = outputs.size() - 1; i >= 0; i--) {
            System.out.println(outputs.get(i));
        }
    }

    public static void union(int a, int b) {
        int r1 = representative(a);
        int r2 = representative(b);
        if (r1 == r2) return;
        if (depth[r1] > depth[r2]) {
            int temp = r1;
            r1 = r2;
            r2 = temp;
        }

        arr[r1] = r2;
        if (depth[r2] == depth[r1]) depth[r2]++;
    }

    public static int representative(int v) {
        if (v == arr[v]) return v;
        return arr[v] = representative(arr[v]);
    }

    private record Command(String op, int a, int b) {

    }
}
