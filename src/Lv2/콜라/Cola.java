package Lv2.콜라;

/**
 *  문제풀이
 *
 *  n 개의 병이 주어졌을 때 a개당 b개 만큼 빈병이 주어짐 -> n / a * b
 *  남은 병의 갯수 -> n % a
 *  루프당 남은 병의 갯수 -> (n/a*b) + (n%a)
 *  빈병으로 교환이 되지 않는 경우 -> n < a
 *
 *  총 빈병의 갯수 구하기
 *
 * */

public class Cola {

    private static int solution(int a, int b, int n) {

        int result = 0;

        int empty;      // 빈병
        int left;       // 남은병

        while ( n >= a ) {
            empty = n / a * b;
            left = n%a;

            result += empty;

            n = empty + left;
     }

        return result;

    }

    public static void main(String[] args) {

        int a1 = 2;
        int b1 = 1;
        int n1 = 20;

        int a2 = 3;
        int b2 = 1;
        int n2 = 20;

        System.out.println(solution(a1,b1,n1));
        System.out.println(solution(a2,b2,n2));

    }

}
