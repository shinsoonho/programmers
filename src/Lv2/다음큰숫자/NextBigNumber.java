package Lv2.다음큰숫자;

public class NextBigNumber {

    private static int next(int n) {

        String binary = Integer.toBinaryString(n);
        int cnt = 0;

        for (int i = 0; i < binary.length(); i++) {
            cnt = binary.charAt(i) == '1' ? cnt + 1 : cnt;
        }

        return cnt;
    }

    private static int solution(int n) {

        String binary = Integer.toBinaryString(n);
        int bCnt = 0;
        int nextBCnt = 0;

        for (int i = 0; i < binary.length(); i++) {
            bCnt = binary.charAt(i) == '1' ? bCnt + 1 : bCnt;
        }

        while (bCnt != nextBCnt) {
            nextBCnt = next(++n);
        }

        return n;

    }

    public static void main(String[] args) {

        int n1 = 78;
        int n2 = 15;

        System.out.println(solution(n1));
        System.out.println(solution(n2));

    }

}
