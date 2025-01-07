package org.example.первая;

import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] rc = scanner.nextLine().split(" ");
        int r = Integer.parseInt(rc[0]);
        int c = Integer.parseInt(rc[1]);

        List<String> hor = new ArrayList<>(r);
        for (int i = 0; i < r; i++) {
            hor.add(scanner.nextLine());
        }
        System.out.println(sol(c, hor));
    }

    public static String sol(int c, List<String> hor) {
        Map<Integer, String> vert = new HashMap<>();
        for (int i = 0; i < hor.size(); i++) {
            String horWord = hor.get(i);
            for (int j = 0; j < c; j++) {
                String s1 = vert.get(j);
                if (s1 == null) {
                    s1 = "";
                }
                s1 += horWord.charAt(j);
                vert.put(j, s1);
            }
        }
        TreeSet<String> words = new TreeSet<>(String::compareTo);
        addWords(hor, words);
        addWords(vert.values(), words);
        return words.pollFirst();
    }

    private static void addWords(Collection<String> fromCross, TreeSet<String> words) {
        for (String word : fromCross) {
            if (!word.contains("#")) {
                words.add(word);
            }
        }
    }


}
