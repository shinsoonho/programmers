package Lv1.가장가까운같은글자;

import java.util.HashMap;
import java.util.Map;

public class LeastString {

    private static int[] solution(String s) {

        int[] result = new int[s.length()];

        Map<Character, Integer> map = new HashMap<>();

        for (int i = 0; i < s.length(); i++) {

            char ch = s.charAt(i);

            result[i] = i - map.getOrDefault(ch, i + 1);
            map.put(ch, i);

            /*
            if (!map.containsKey(ch)) {
                // 해당 문자가 없을 경우 key:문자 , value:인덱스
                map.put(ch, i);
                result[i] = -1;
            } else {
                // 해당 문자가 있을 경우 현재 인덱스 - 이전 인덱스
                result[i] = i - map.get(ch);
                map.put(ch, i);
            }

             */

        }

        return result;
    }

    private static void print(int[] result) {
        for (int i = 0; i < result.length; i++) {
            System.out.print(result[i] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {

        String s1 = "banana";
        String s2 = "foobar";

        print(solution(s1));
        print(solution(s2));

    }

}
