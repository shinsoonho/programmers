package Lv1.개인정보수집유효기간;

import java.util.*;

/**
 * 문제 설명
 * 고객의 약관 동의를 얻어서 수집된 1~n번으로 분류되는 개인정보 n개가 있습니다. 약관 종류는 여러 가지 있으며 각 약관마다 개인정보 보관 유효기간이 정해져 있습니다. 당신은 각 개인정보가 어떤 약관으로 수집됐는지 알고 있습니다. 수집된 개인정보는 유효기간 전까지만 보관 가능하며, 유효기간이 지났다면 반드시 파기해야 합니다.
 *
 * 예를 들어, A라는 약관의 유효기간이 12 달이고, 2021년 1월 5일에 수집된 개인정보가 A약관으로 수집되었다면 해당 개인정보는 2022년 1월 4일까지 보관 가능하며 2022년 1월 5일부터 파기해야 할 개인정보입니다.
 * 당신은 오늘 날짜로 파기해야 할 개인정보 번호들을 구하려 합니다.
 *
 * 모든 달은 28일까지 있다고 가정합니다.
 *  */

public class PersonalInformation {

    private static int[] solution(String today, String[] terms, String[] privacies) {

        List<Integer> list = new ArrayList<>();

        String[] todays = today.split("\\.");
        int[] todayArr = strToInt(todays);      // 오늘날짜

        Map<String, Integer> termsMap = new HashMap<>();

        for (int i = 0; i < terms.length; i++) {
            String[] term = terms[i].split(" ");
            termsMap.put(term[0], Integer.parseInt(term[1]));
        }

        for (int i = 0; i < privacies.length; i++) {
            String[] collectDay = privacies[i].split(" ");
            String[] collectDays = collectDay[0].split("\\.");

            int[] collectDayArr = strToInt(collectDays);    // 수집일자

            boolean delete = check(todayArr, collectDayArr, termsMap.get(collectDay[1]));

            if (delete) list.add(i+1);
        }

        return list.stream().mapToInt(Integer::intValue).toArray();
    }

    // String -> int 로 변환
    private static int[] strToInt(String[] days) {
        int year = Integer.parseInt(days[0]);
        int month = Integer.parseInt(days[1]);
        int day = Integer.parseInt(days[2]);

        return new int[]{year, month, day};
    }

    // 파기기준이 true 인지 false 인지 리턴
    private static boolean check(int[] todayArr, int[] collectDayArr, int month) {

        // 오늘날짜
        int endDate = (todayArr[0] * 12 * 28) + (todayArr[1] * 28) + (todayArr[2]);

        // 수집일짜 + 약관일자
        int myEndDate = (collectDayArr[0] * 12 * 28) + ((collectDayArr[1] + month) * 28) + (collectDayArr[2]);

        // 오늘 날짜가 수집일짜+약관일자보다 크면 파기
        return endDate >= myEndDate;
    }

    private static void print(int[] result) {
        for (int i = 0; i < result.length; i++) {
            System.out.print(result[i] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {

        String today1 = "2022.05.19";
        String[] terms1 = {"A 6", "B 12", "C 3"};
        String[] privacies1 = {"2021.05.02 A", "2021.07.01 B", "2022.02.19 C", "2022.02.20 C"};
        // 1 3

        String today2 = "2020.01.01";
        String[] terms2 = {"Z 3", "D 5"};
        String[] privacies2 = {"2019.01.01 D", "2019.11.15 Z", "2019.08.02 D", "2019.07.01 D", "2018.12.28 Z"};
        // 1 4 5

        print(solution(today1, terms1, privacies1));
        print(solution(today2, terms2, privacies2));

    }

}
