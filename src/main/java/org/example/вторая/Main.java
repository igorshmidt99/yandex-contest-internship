package org.example.вторая;

import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int b = Integer.parseInt(scanner.nextLine().split(" ")[1]);
        String[] array = scanner.nextLine().split(" ");
        List<Integer> p = new ArrayList<>();
        for (String s : array) {
            p.add(Integer.parseInt(s));
        }

        System.out.println(sol(p, b));
    }

    public static int sol(List<Integer> p, long b) {
        Set<List<Integer>> enters = new HashSet<>();
        int sol = 0;
        for (int i = 0; i < p.size(); i++) {
            int bound = p.size();
            for (int j = bound; j >= i; j -= 2) {
                if ((j - i) % 2 == 0) {
                    j--;
                }
                List<Integer> integers = p.subList(i, j);
                if (!enters.contains(integers)) {
                    enters.add(integers);
                    int indexM = (integers.size() - 1) / 2;
                    Integer mediana = integers.get(indexM);
                    if (mediana == b) {
                        sol++;
                    }
                }
            }
        }
        return sol;
    }

}