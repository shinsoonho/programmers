package Lv1.삼총사;

/**
 * 이 학교 학생 3명의 정수 번호를 더했을 때 0이 되면 3명의 학생은 삼총사라고 한다.
 * 정수 배열 number가 매개변수로 주어질 때, 학생들 중 삼총사를 만들 수 있는 방법의 수를 return 하도록 solution 함수를 완성하세요.
 * */
public class ThreeMan {

    private static int solution(int[] number) {
        int result = 0;

        for (int i = 0; i < number.length-2; i++) {
            for (int j = i+1; j < number.length - 1; j++) {
                for (int k = j+1; k < number.length; k++) {
                    if( number[i] + number[j] + number[k] == 0 ) result++;
                }
            }
        }

        return result;
    }

    public static void main(String[] args) {

        int[] number1 = {-2,3,0,2,-5};
        int[] number2 = {-3,-2,-1,0,1,2,3};
        int[] number3 = {-1,1,-1,1};

        System.out.println(solution(number1));
        System.out.println(solution(number2));
        System.out.println(solution(number3));

    }

}
