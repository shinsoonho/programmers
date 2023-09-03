package Lv1.문자열내림차순으로배치하기;

import java.util.Arrays;
import java.util.Collections;

public class DescString {

    private static String solution(String str) {

        StringBuilder sb = new StringBuilder();

        String[] ch = str.split("");
        Arrays.sort(ch, Collections.reverseOrder());

        for (String c : ch) {
            sb.append(c);
        }

        return sb.toString();

    }

    public static void main(String[] args) {

        System.out.println(solution("Zbcdefg"));

    }

}
