package Lv1.실패율;


import java.util.*;

/**
 * 실패율은 다음과 같이 정의한다.
 * 스테이지에 도달했으나 아직 클리어하지 못한 플레이어의 수 / 스테이지에 도달한 플레이어 수
 * 전체 스테이지의 개수 N, 게임을 이용하는 사용자가 현재 멈춰있는 스테이지의 번호가 담긴 배열 stages가 매개변수로 주어질 때, 실패율이 높은 스테이지부터 내림차순으로 스테이지의 번호가 담겨있는 배열을 return 하도록 solution 함수를 완성하라.
 *
 *
 * 제한사항
 * 스테이지의 개수 N은 1 이상 500 이하의 자연수이다.
 * stages의 길이는 1 이상 200,000 이하이다.
 * stages에는 1 이상 N + 1 이하의 자연수가 담겨있다.
 * 각 자연수는 사용자가 현재 도전 중인 스테이지의 번호를 나타낸다.
 * 단, N + 1 은 마지막 스테이지(N 번째 스테이지) 까지 클리어 한 사용자를 나타낸다.
 * 만약 실패율이 같은 스테이지가 있다면 작은 번호의 스테이지가 먼저 오도록 하면 된다.
 * 스테이지에 도달한 유저가 없는 경우 해당 스테이지의 실패율은 0 으로 정의한다.
 * */
public class FailRate {

    private static int[] solution(int n, int[] stages) {

        int[] clearCount = new int[n+1];  // 단계별 성공한 사람들의 수

        int totalPlayer = stages.length;    // 총 플레이어의 수

        Map<Integer, Double> map = new HashMap<>();

        for (int i = 0; i < stages.length; i++) {
            clearCount[stages[i] - 1] ++;
        }

        for (int i = 0; i < n; i++) {

            totalPlayer = totalPlayer == 0 ? 1 : totalPlayer;   // 총 플레이어의 수가 0일경우 NaN 에러가 나올 수 있기 때문에 분모 1로 처리

            double failRate = (double) clearCount[i] / totalPlayer; // 실패율 = 플레이어의 수 / 스테이지에 도달한 플레이어 수
            map.put(i+1, failRate);
            totalPlayer -= clearCount[i];   // 총 플레이어 = 클리어사람만큼 빼줌
        }
        System.out.println(map);

        List<Integer> list = new ArrayList<>(map.keySet());
        Collections.sort(list, ((o1, o2) -> Double.compare(map.get(o2), map.get(o1))));

        System.out.println(list);

        return list.stream().mapToInt(Integer::intValue).toArray();
    }

    private static void print(int[] result) {
        for (int i = 0; i < result.length; i++) {
            System.out.print(result[i] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {

        int n1 = 5;
        int[] stages1 = {2, 1, 2, 6, 2, 4, 3, 3};
        // 3 4 2 1 5

        int n2 = 4;
        int[] stages2 = {4, 4, 4, 4, 4};
        // 4 1 2 3

        print(solution(n1, stages1));
        print(solution(n2, stages2));

    }

}
