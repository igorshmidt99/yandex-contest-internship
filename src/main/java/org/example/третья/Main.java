package org.example.третья;

import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        scanner.nextLine();

        String[] aS = scanner.nextLine().split(" ");
        String[] bS = scanner.nextLine().split(" ");
        String[] cS = scanner.nextLine().split(" ");

        List<Integer> a = fill(aS);
        List<Integer> b = fill(bS);
        List<Integer> c = fill(cS);

        System.out.println(sol(a, b, c));
    }

    public static int sol(List<Integer> a, List<Integer> b, List<Integer> c) {
        Map<Integer, Object> excludedYears = new HashMap<>();
        for (int i = 0; i < a.size(); i++) {
            Integer aVal = a.get(i);
            if (!find(aVal, b, c, excludedYears)) {
                excludedYears.put(i, new Object());
                continue;
            }
            Integer bVal = b.get(i);
            if (!find(bVal, a, c, excludedYears)) {
                excludedYears.put(i, new Object());
                continue;
            }
            Integer cVal = c.get(i);
            if (!find(cVal, a, b, excludedYears)) {
                excludedYears.put(i, new Object());
            }
        }

        return excludedYears.size();
    }

    private static boolean find(Integer target, List<Integer> val1, List<Integer> val2, Map<Integer, Object> excludedYears) {
        boolean isFirstContains = false;
        boolean isSecondContains = false;

        for (int i = 0; i < val1.size(); i++) {
            if (excludedYears.get(i) != null) {
                continue;
            }
            Integer valF1 = val1.get(i);
            if (valF1.equals(target)) {
                isFirstContains = true;
            }
            Integer valF2 = val2.get(i);
            if (valF2.equals(target)) {
                isSecondContains = true;
            }
        }
        return isFirstContains && isSecondContains;
    }

    static List<Integer> fill(String[] events) {
        List<Integer> list = new ArrayList<>();
        for (String sEvent : events) {
            Integer event = Integer.parseInt(sEvent);
            list.add(event);
        }
        return list;
    }
}
