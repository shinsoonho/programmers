package Lv1.최대공약수와최소공배수;

public class CommonDiv {

    private static int gcd(int a, int b) {

        if (a < b) {
            int temp = a;
            a = b;
            b = temp;
        }
        System.out.println("a = " + a);
        System.out.println("b = " + b);

        // gcd(a,b) = gcd(b,r)  유클리드호제법
        while (b > 0) {
            int r = a%b;
            a = b;
            b = r;
        }
        return a;
    }

    private static int[] solution(int n, int m) {
        int min = gcd(n, m);
        int max = n * m / gcd(n, m);

        return new int[]{min, max};
    }

    private static void print(int[] result) {
        for (int i = 0; i < result.length; i++) {
            System.out.print(result[i] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {

        int n1 = 3;
        int m1 = 12;

        int n2 = 2;
        int m2 = 5;

        print(solution(n1, m1));
        print(solution(n2, m2));

    }

}
