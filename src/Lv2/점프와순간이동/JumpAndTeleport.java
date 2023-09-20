package Lv2.점프와순간이동;


/**
 *
 *  문제풀이
 *
 *  사용하는 건전지의 최솟값 구하기
 *   - K만큼 이동하면 K만큼의 건전지가 소비된다.
 *   - 순간이동을 하면 현재 거리*2가 되며 건전지는 소비되지 않는다.
 *
 *  1. 최종거리 / 2 의 나머지가 1이라면 1만큼 이동하고, 나머지가 0 이면 건전지가 소비되지 않는다.
 *  2. 최종거리 % 2 가 홀수일때 건전지 ++
 *
 *
 * */

public class JumpAndTeleport {

    private static int solution(int n) {

        int result = 0;

        while (n > 0) {
            result = n % 2 == 0 ? result : result + 1;
            n /= 2;
        }

        return result;
    }

    public static void main(String[] args) {

        int N1 = 5;
        int N2 = 6;
        int N3 = 5000;

        System.out.println(solution(N1));
        System.out.println(solution(N2));
        System.out.println(solution(N3));

    }

}
