package Lv2.JadenCase문자열만들기;

public class JadenCase {

    private static String solution(String s) {

        StringBuilder sb = new StringBuilder();

        boolean upper = true;   // 첫 문자 대문자인지 판별(0번인덱스 대문자)

        for (char ch : s.toCharArray()) {
            sb = upper ? sb.append(Character.toUpperCase(ch)) : sb.append(Character.toLowerCase(ch));
            upper = ch == ' ' ? true : false;   // ch가 공백이면 대문자, 아니면 소문자
        }

        return sb.toString();
    }

    public static void main(String[] args) {

        String s1 = "3people UnFollowed   me";
        String s2 = "for the last week";

        System.out.println(solution(s1));
        System.out.println(solution(s2));

    }

}
