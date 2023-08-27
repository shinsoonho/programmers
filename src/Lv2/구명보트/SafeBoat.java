package Lv2.구명보트;

import java.util.Arrays;
import java.util.Collections;

/**
 * 구명보트는 작아서 한 번에 최대 2명씩 밖에 탈 수 없고, 무게 제한도 있습니다.
 * 예를 들어, 사람들의 몸무게가 [70kg, 50kg, 80kg, 50kg]이고 구명보트의 무게 제한이 100kg이라면 2번째 사람과 4번째 사람은 같이 탈 수 있지만 1번째 사람과 3번째 사람의 무게의 합은 150kg이므로 구명보트의 무게 제한을 초과하여 같이 탈 수 없습니다.
 * 구명보트를 최대한 적게 사용하여 모든 사람을 구출하려고 합니다.
 *
 *  - 풀이 -
 * 1. 구명보트는 최대 2명까지 탈 수 있지만 무게제한을 넘으면 1명밖에 타지 못한다.
 * 2. 구명보트를 최대한 적게 사용하기 위해선 무게가 가장 높은 사람과 가장 낲은 사람이 함께 타고 나갈 수 있도록 한다.
 * 3. 무게가 가장 낮은 사람과 높은 사람의 합이 limit을 초과하면 높은 사람은 혼자 탄 것으로 간주한다.
 * 4. 무게가 가장 낮은 사람과 높은 사람의 합 limit 이하면 둘이서 탄 것으로 간주한다.
 *
 * */
public class SafeBoat {

    private static int solution(int[] people, int limit) {

        int answer = 0;
        int index = 0;

        Arrays.sort(people);

        for (int i = people.length - 1; i >= index; i--) {
            if (people[index] + people[i] > limit) {
                answer++;
            } else {
                answer++;
                index++;
            }
        }
        return answer;
    }

    public static void main(String[] args) {

        int[] people1 = {70,50,80,50};
        int[] people2 = {70,80,50};

        int limit1 = 100;
        int limit2 = 100;

        System.out.println(solution(people1,limit1));
        System.out.println(solution(people2,limit2));

    }

}
