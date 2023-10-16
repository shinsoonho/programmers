package Lv2.예상대진표;

public class Tournament {

    private static int solution(int n, int a, int b) {

        int answer = 0;
        boolean isSameLevel = false;

        while (!isSameLevel) {
            answer++;

            a = a % 2 == 0 ? a / 2 : a / 2 + 1;
            b = b % 2 == 0 ? b / 2 : b / 2 + 1;

            if (a == b) isSameLevel = true;
        }

        return answer;
    }

    public static void main(String[] args) {

        int N = 8;
        int A = 4;
        int B = 7;

        System.out.println(solution(N,A,B));

    }

}
