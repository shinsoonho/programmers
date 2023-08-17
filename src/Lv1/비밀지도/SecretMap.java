package Lv1.비밀지도;

public class SecretMap {

    private static String[] solution(int n, int[] arr1, int[] arr2) {

        String[] result = new String[n];

        for (int i = 0; i < n; i++) {
            StringBuilder sb = new StringBuilder();
            for (int j = n-1; j >= 0; j--) {
                sb = arr1[i] % 2 != 0 || arr2[i] % 2 != 0 ? sb.append("#") : sb.append(" ");
                arr1[i] /= 2;
                arr2[i] /= 2;
            }
            result[i] = sb.reverse().toString();
        }
        return result;
    }

    private static void print(String[] result) {
        for (int i = 0; i<result.length; i++) {
            System.out.println(result[i] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {

        int n1 = 5;
        int[] arr11 = {9, 20, 28, 18, 11};
        int[] arr12 = {30, 1, 21, 17, 28};

        int n2 = 6;
        int[] arr21 = {46, 33, 33 ,22, 31, 50};
        int[] arr22 = {27 ,56, 19, 14, 14, 10};

        print(solution(n1, arr11, arr12));
        print(solution(n2, arr21, arr22));

    }

}
