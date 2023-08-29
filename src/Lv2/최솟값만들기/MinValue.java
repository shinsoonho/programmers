package Lv2.최솟값만들기;

import java.util.Arrays;
import java.util.Collections;

public class MinValue {

    //


    private static int solution(int[] a, int[] b) {

        int sum = 0;

        Arrays.sort(a);
        Arrays.sort(b);

        for (int i = 0; i < a.length; i++) {
            sum += a[i]*b[a.length-1-i];
        }

        return sum;
    }

    public static void main(String[] args) {

        int[] a1 = {1,4,2};
        int[] b1 = {5,4,4};

        int[] a2 = {1,2};
        int[] b2 = {3,4};

        System.out.println(solution(a1,b1));
        System.out.println(solution(a2,b2));
    }

}
