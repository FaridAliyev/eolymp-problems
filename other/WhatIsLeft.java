package solutions.other;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class WhatIsLeft {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Integer> list = new ArrayList<>();
        int n = scanner.nextInt();
        for (int i = 1; i <= n; i += 2) {
            list.add(i);
        }
        int step = 1;
        while (list.size() > 1) {
            List<Integer> temp = new ArrayList<>();
            switch (step) {
                case 1 -> {
                    for (int i = 0; i < list.size(); i++) {
                        if ((i + 1) % 3 != 0) {
                            temp.add(list.get(i));
                        }
                    }
                }
                case 2 -> {
                    for (int i = 1; i < list.size(); i += 2) {
                        temp.add(list.get(i));
                    }
                }
                case 3 -> {
                    for (int i = 0; i < list.size(); i += 2) {
                        temp.add(list.get(i));
                    }
                }
            }
            list = temp;
            step = step + 1 > 3 ? 1 : step + 1;
        }
        System.out.println(list.get(0));
    }
}
