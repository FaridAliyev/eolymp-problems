package solutions.week4.dsu;

import java.util.Scanner;

public class DangerousRoute {
    private static final int[] arr = new int[1000001];
    private static final int[] depth = new int[1000001];

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        for (int i = 1; i <= n; i++) {
            arr[i] = i;
            depth[i] = 0;
        }
        Road[] roads = new Road[m + 1];
        for (int i = 1; i <= m; i++) {
            int city1 = scanner.nextInt();
            int city2 = scanner.nextInt();
            int danger = scanner.nextInt();
            roads[i] = new Road(city1, city2, danger);
        }

        buildHeap(roads, m);
        heapSort(roads, m);
        for (int i = 1; i < roads.length; i++) {
            union(roads[i].city1, roads[i].city2);
            if (representative(1) == representative(n)) {
                System.out.println(roads[i].danger);
                return;
            }
        }
    }

    public static int left(int i) {
        return 2 * i;
    }

    public static int right(int i) {
        return 2 * i + 1;
    }

    public static boolean compare(Road a, Road b) {
        return a.danger > b.danger;
    }

    public static void heapify(Road[] a, int i, int n) {
        int largest = 0;
        int l = left(i);
        int r = right(i);

        if (l <= n && compare(a[l], a[i])) largest = l;
        else largest = i;
        if (r <= n && compare(a[r], a[largest])) largest = r;

        if (largest != i) {
            Road temp = a[i];
            a[i] = a[largest];
            a[largest] = temp;
            heapify(a, largest, n);
        }
    }

    public static void buildHeap(Road[] a, int n) {
        for (int i = n / 2; i > 0; i--)
            heapify(a, i, n);
    }

    public static void heapSort(Road[] a, int n) {
        buildHeap(a, n);
        for (int i = n; i >= 2; i--) {
            Road temp = a[i];
            a[i] = a[1];
            a[1] = temp;
            heapify(a, 1, i - 1);
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

    private record Road(int city1, int city2, int danger) {

    }
}
