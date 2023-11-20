package Lv2.뉴스클러스터링;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

/**
 *  - 문제풀이 -
 *  입력으로는 str1과 str2의 두 문자열이 들어온다. 각 문자열의 길이는 2 이상, 1,000 이하이다.
 *  입력으로 들어온 문자열은 두 글자씩 끊어서 다중집합의 원소로 만든다. 이때 영문자로 된 글자 쌍만 유효하고, 기타 공백이나 숫자, 특수 문자가 들어있는 경우는 그 글자 쌍을 버린다.
 *  예를 들어 "ab+"가 입력으로 들어오면, "ab"만 다중집합의 원소로 삼고, "b+"는 버린다.
 *  다중집합 원소 사이를 비교할 때, 대문자와 소문자의 차이는 무시한다. "AB"와 "Ab", "ab"는 같은 원소로 취급한다.
 *  유사도 값은 0에서 1 사이의 실수이므로, 이를 다루기 쉽도록 65536을 곱한 후에 소수점 아래를 버리고 정수부만 출력한다.
 *
 *  1. 대소문자는 구별하지 않기 때문에 문자열을 대문자로 변환
 *  2. list에 2자리씩 문자열을 잘라 add, 문자열 패턴검증을 통해 대문자만 들어오도록 함
 *  3. loop를 돌리기 위해 listA를 기준으로 더 큰 리스트로 치환
 *  4. 교집합이 존재할 경우 변수에 +1 을 더한 후 listB에서 제거
 *  5. zacad = 교집합 / 합집합
 *
 * */

public class NewsClustering {

    private static int solution(String str1, String str2) {

        int result = 0;

        List<String> listA = new ArrayList<>();
        List<String> listB = new ArrayList<>();

        int intersection = 0;   // 교집합
        int union = 0;          // 합집합
        double zacad = 0;       // 자카드 유사도

        str1 = str1.toUpperCase();
        str2 = str2.toUpperCase();

        for (int i = 1; i < str1.length(); i++) {
            String split = str1.substring(i-1, i+1);

            if (Pattern.matches("^[A-Z]*$", split)) {
                listA.add(split);
            }
        }

        for (int i = 1; i < str2.length(); i++) {
            String split = str2.substring(i-1, i+1);

            if (Pattern.matches("^[a-zA-Z]*$", split)) {
                listB.add(split);
            }
        }

        // listA와 listB 모두 공집합일 경우 1을 리턴한다.
        if (listA.size() == 0 && listB.size() == 0) {
            return 1 * 65536;
        }

        // listA를 기준으로 loop를 돌리기 위해 리스트 교체.
        if (listA.size() <= listB.size()) {
            List<String> tempList = new ArrayList<>();
            tempList = listA;
            listA = listB;
            listB = tempList;
        }

        int loopSize = listA.size();

        // listB가 listA에 속해있으면 교집합 count 후 listB에서 제거
        for (int i = 0; i < loopSize; i++) {
            String str = listA.get(i);
            if (listB.contains(str)) {
                intersection++;
                listB.remove(str);
            }
        }

        union = listA.size() + listB.size();

        zacad = intersection / (double) union * 65536;

        return (int) zacad;
    }

    public static void main(String[] args) {

        String str11 = "FRANCE";
        String str12 = "french";
        String str21 = "handshake";
        String str22 = "shake hands";
        String str31 = "aa1+aa2";
        String str32 = "AAAA12";
        String str41 = "E=M*C^2";
        String str42 = "e=m*c^2";

        System.out.println(solution(str11, str12));
        System.out.println(solution(str21, str22));
        System.out.println(solution(str31, str32));
        System.out.println(solution(str41, str42));

    }

}
