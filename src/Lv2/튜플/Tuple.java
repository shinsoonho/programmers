package Lv2.튜플;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

/**
 *
 * -- 문제풀이
 * {{2}, {2, 1}, {2, 1, 3}, {2, 1, 3, 4}}
 * {{2, 1, 3, 4}, {2}, {2, 1, 3}, {2, 1}}
 * {{1, 2, 3}, {2, 1}, {1, 2, 4, 3}, {2}}
 * 는 모두 같은 튜플 (2, 1, 3, 4)를 나타냅니다.
 *
 * 1. "{{" , "}}" 는 처음과 끝에만 존재하기 때문에 공백으로 치환해준다.
 * 2. "},{" 로 split 하여 String 배열로 만들어준다.
 * 3. 배열의 요소가 가장 적은 배열이 중복되는 요소가 제일 많기 때문에 길이에 따라 정렬해준다.
 * 4. int 형의 배열로 치환해준다.
 * 5. list에 요소가 없다면 add 해준다.
 *
 * */

public class Tuple {

    private static List<Integer> solution(String s) {

        List<Integer> answer = new ArrayList<>();

        s = s.replace("{{", "");
        s = s.replace("}}", "");

        String[] tuple = s.split("},\\{");

        Arrays.sort(tuple, (o1, o2) -> Integer.compare(o1.length(), o2.length()));

        for (int i = 0; i < tuple.length; i++) {
            String[] numArr = tuple[i].split(",");
            int[] num = Stream.of(numArr).mapToInt(Integer::parseInt).toArray();

            for (int j = 0; j < num.length; j++) {
                if (!answer.contains(num[j])) {
                    answer.add(num[j]);
                    break;
                }
            }
        }

        return answer;
    }

    public static void main(String[] args) {

        String s1 = "{{2},{2,1},{2,1,3},{2,1,3,4}}";
        String s2 = "{{1,2,3},{2,1},{1,2,4,3},{2}}";
        String s3 = "{{20,111},{111}}";
        String s4 = "{{123}}";
        String s5 = "{{4,2,3},{3},{2,3,4,1},{2,3}}";

        System.out.println(solution(s2));


    }

}
