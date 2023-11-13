package cracking.interview;

import java.util.HashMap;
import java.util.Map;
import java.util.PrimitiveIterator.OfInt;

public class ArraysAndStrings {
    // 1.1
    public static boolean isUnique(String str) {
        for (int i = 0; i < str.length() - 1; i++) {
            for (int j = i + 1; j < str.length(); j++) {
                if (str.charAt(i) == str.charAt(j)) {
                    return false;
                }
            }
        }

        return true;
    }

    // 1.2
    public static boolean checkPermutation(String str1, String str2) {
        if (str1 == null || str2 == null) {
            return false;
        }

        if (str1.length() != str2.length()) {
            return false;
        }

        OfInt s1 = str1.chars().sorted().iterator();
        OfInt s2 = str2.chars().sorted().iterator();

        while (s1.hasNext() && s2.hasNext())
            if (s1.next() != s2.next())
                return false;

        return true;
    }

    // 1.3
    public static char[] URLify(char[] str, int len) {
        int i = 0;
        while (i < str.length) {
            if (str[i] == ' ') {
                for (int j = str.length - 1; j > i + 2; j--) {
                    str[j] = str[j - 2];
                }

                str[i] = '%';
                str[i + 1] = '2';
                str[i + 2] = '0';

                i = i + 3;
            } else {
                i++;
            }
        }

        return str;
    }

    // 1.4
    public static boolean palindromPermutation(String str) {
        Map<Character, Integer> charCounts = new HashMap<>();

        String clean = str.replaceAll(" ", "").toLowerCase();
        System.out.println("Clean: " + clean);

        for (int i = 0; i < clean.length(); i++) {
            if (charCounts.containsKey(clean.charAt(i)))
                charCounts.put(clean.charAt(i), charCounts.get(clean.charAt(i)) + 1);
            else
                charCounts.put(clean.charAt(i), 1);
        }

        System.out.println(charCounts.values());
        // Must have 1 or 0 odd occurence characters
        return charCounts.values().stream().filter(occ -> {
            return occ % 2 == 1;
        }).count() <= 1;
    }

}