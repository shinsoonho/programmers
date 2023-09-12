package Lv2.카펫;

/**
 *
 *  테두리는 1줄 이므로 yellow 의 width+2, height+2 가 된다.
 *  yellow의 약수를 구해주고 약수+2 끼리의 곱이 yellow+brown 이 되면 참
 *  width >= height
 *
 * */

public class Carpet {

    private static int[] solution(int brown, int yellow) {

        int width = 0;
        int height = 0;

        for (int i = 1; i <= yellow; i++) {

            if (yellow % i == 0) {
                width = yellow / i + 2;
                height = i + 2;
            }

            if (width * height == yellow + brown) {
                break;
            }
        }

        return new int[]{width, height};
    }

    private static void print(int[] result) {
        for (int i : result) {
            System.out.print(i + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {

        int brown1 = 10;
        int yellow1 = 2;

        int brown2 = 8;
        int yellow2 = 1;

        int brown3 = 24;
        int yellow3 = 24;

        print(solution(brown1, yellow1));
        print(solution(brown2, yellow2));
        print(solution(brown3, yellow3));

    }

}
