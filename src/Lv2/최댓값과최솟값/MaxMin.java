package Lv2.최댓값과최솟값;

public class MaxMin {

    private static String solution(String s) {
        String[] str = s.split(" ");

        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;

        for (String s1 : str) {
            int temp = Integer.parseInt(s1);
            min = min > temp ? temp : min;
            max = max < temp ? temp : max;
        }

        return new StringBuilder().append(min + " " + max).toString();
    }

    public static void main(String[] args) {

        String s1 = "1 2 3 4";
        String s2 = "-1 -2 -3 -4";
        String s3 = "-1 -1";

        System.out.println(solution(s1));
        System.out.println(solution(s2));
        System.out.println(solution(s3));

    }

}
