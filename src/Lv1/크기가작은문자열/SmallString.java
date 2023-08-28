package Lv1.크기가작은문자열;

public class SmallString {

    private static int solution(String t, String p) {

        int result = 0;

        int length = p.length();
        long p1 = Long.parseLong(p);

        for (int i = 0; i <= t.length() - length; i++) {
            long temp = Long.parseLong(t.substring(i, i+length));
            result = temp > p1 ? result : result + 1;
        }

        return result;

    }

    public static void main(String[] ags) {

        String t1 = "3141592";
        String t2 = "500220839878";
        String t3 = "10203";

        String p1 = "271";
        String p2 = "7";
        String p3 = "15";


        System.out.println(solution(t1,p1));
        System.out.println(solution(t2,p2));
        System.out.println(solution(t3,p3));


    }

}
