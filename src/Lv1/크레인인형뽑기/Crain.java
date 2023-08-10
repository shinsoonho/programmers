package Lv1.크레인인형뽑기;

import java.util.Stack;

public class Crain {

    private static int solution(int[][] board, int[] moves) {

        int result = 0;

        Stack<Integer> stack = new Stack<>();
        print(board);

        for (int i = 0; i < moves.length; i++) {
            for (int j = 0; j < board.length; j++) {
                int currentPick = board[j][moves[i]-1];     // 현재 고른 수

                // 0이 아닐때만 Stack에 Push or Pop
                if (currentPick != 0) {
                    // Stack의 Top이 현재 고른 수와 같다면 제거하고 result 에 2를 더함
                    if (!stack.isEmpty() && stack.peek() == board[j][moves[i] - 1]) {
                        stack.pop();
                        result += 2;
                        System.out.println("pop =>" + currentPick);
                    } else {
                        stack.push(currentPick);
                        System.out.println("push =>" + currentPick);
                    }
                    board[j][moves[i]-1] = 0;
                    print(board);
                    System.out.println("stack = " + stack);
                    System.out.println();
                    break;
                }
            }
        }

        return result;
    }

    private static void print(int[][] board) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {

        int[][] board = {{0,0,0,0,0},{0,0,1,0,3},
                         {0,2,5,0,1},{4,2,4,4,2},{3,5,1,3,1}};
        int moves[] = {1,5,3,5,1,2,1,4};

        System.out.println(solution(board, moves));


    }

}
