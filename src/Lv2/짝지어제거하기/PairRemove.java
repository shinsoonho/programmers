package Lv2.짝지어제거하기;

import java.util.Stack;

public class PairRemove {

    private static int solution(String s) {

        Stack<Character> stack = new Stack<>();
        stack.push(s.charAt(0));

        for (int i = 1; i < s.length(); i++) {

            char ch = s.charAt(i);

            if (!stack.isEmpty() && stack.peek() == ch) {
                stack.pop();

            } else {
                stack.push(ch);
            }

        }

        return stack.size() == 0 ? 1 : 0;
    }

    public static void main(String[] args) {

        String s1 = "baabaa";
        String s2 = "cdcd";

        System.out.println(solution(s1));
        System.out.println(solution(s2));

    }

}
