package Lv2.이진변환반복하기;

public class BinaryTransSearch {

    private static int[] solution(String s) {

        int rNum = 0;
        int removeNum = 0;

        while (!s.equals("1")) {

            StringBuilder sb = new StringBuilder();
            StringBuilder newSb = new StringBuilder();

            for (char ch : s.toCharArray()) {
                if (ch != '0') {
                    sb.append("1");
                } else {
                    removeNum ++;
                }
            }
            int length = sb.length();

            while (length > 0) {
                newSb = length %2 == 0 ? newSb.append("0") : newSb.append("1");
                length /= 2;
            }

            s = newSb.reverse().toString();
            rNum ++;

        }

        return new int[]{rNum, removeNum};
    }

    private static void print(int[] result) {
        for (int i = 0; i < result.length; i++) {
            System.out.print(result[i] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {

        String s1 = "110010101001";
        String s2 = "01110";
        String s3 = "1111111";

        print(solution(s1));
        print(solution(s2));
        print(solution(s3));

    }

}
