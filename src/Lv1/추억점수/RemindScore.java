package Lv1.추억점수;

import java.util.HashMap;
import java.util.Map;

public class RemindScore {

    private static int[] solution(String[] name, int[] yearning, String[][] photo) {

        int[] result = new int[photo.length];

        Map<String, Integer> map = new HashMap<>();

        // key:name , value:점수
        for (int i = 0; i < name.length; i++) {
            map.put(name[i], yearning[i]);
        }

        for (int i = 0; i < photo.length; i++) {
            int score = 0;  // 결과배열에 담을 점수합
            for (int j = 0; j < photo[i].length; j++) {
                if ( map.containsKey(photo[i][j]) ) {
                    score += map.get(photo[i][j]);
                }
            }
            result[i] = score;
        }

        return result;
    }

    // 출력문
    private static void print(int[] result) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < result.length; i++) {
            sb.append(result[i]).append(" ");
        }
        sb.append("\n");
        System.out.println(sb);
    }

    public static void main(String[] args) {
        // 테스트케이스
        String[] name1 = {"may", "kein", "kain", "radi"};
        int[] yearning1 = {5, 10, 1, 3};
        String[][] photo1 = {{"may", "kein", "kain", "radi"}
                            ,{"may", "kein", "brin", "deny"}
                            , {"kon", "kain", "may", "coni"}};

        String[] name2 = {"kali", "mari", "don"};
        int[] yearning2 = {11, 1, 55};
        String[][] photo2 = {{"kali", "mari", "don"}
                            , {"pony", "tom", "teddy"}
                            , {"con", "mona", "don"}};

        String[] name3 = {"may", "kein", "kain", "radi"};
        int[] yearning3 = {5, 10, 1, 3};
        String[][] photo3 = {{"may"},{"kein", "deny", "may"}, {"kon", "coni"}};

        print(solution(name1, yearning1, photo1));
        print(solution(name2, yearning2, photo2));
        print(solution(name3, yearning3, photo3));
    }

}
