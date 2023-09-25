package Lv2.피보나치수;

public class Fibonacci {

    private static int fibo(int n) {
        int[] arr = new int[n + 1];

        arr[0] = 0;
        arr[1] = 1;

        for (int i = 2; i <= n; i++) {
            arr[i] = (arr[i - 1] + arr[i - 2]) % 1234567;
        }
        return arr[n];
    }

    public static void main(String[] args) {

        int n1 = 3;
        int n2 = 5;

        System.out.println(fibo(n1));
        System.out.println(fibo(n2));

    }

}
