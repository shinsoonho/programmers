package Lv1.푸드파이트대회;

import java.util.Stack;

public class FoodFight {

    private static String solution(int[] food) {

        StringBuilder sb = new StringBuilder();

        Stack<Integer> stack = new Stack<>();

        for (int i = 1; i < food.length; i++) {
            for (int j = 0; j < food[i] / 2; j++) {
                stack.push(i);
                sb.append(i);
            }
        }
        sb.append(0);

        while (!stack.isEmpty()) {
            sb.append(stack.pop());
        }

        return sb.toString();
    }

    public static void main(String[] args) {

        int[] food1 = {1, 3, 4, 6};
        int[] food2 = {1, 7, 1, 2};

        System.out.println(solution(food1));
        System.out.println(solution(food2));

    }


}
