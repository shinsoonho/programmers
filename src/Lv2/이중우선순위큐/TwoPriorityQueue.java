package Lv2.이중우선순위큐;

import java.util.*;

/**
 *  - 문제풀이 -
 *  이중 우선순위 큐가 할 연산 operations가 매개변수로 주어질 때, 모든 연산을 처리한 후 큐가 비어있으면 [0,0] 비어있지 않으면 [최댓값, 최솟값]을 return 하도록 solution 함수를 구현해주세요.
 *  1. 최소힙과 최대힙을 만들어 이중우선순위큐를 만든다.
 *  2. I일 때는 최대힙과 최소힙 모두 숫자를 삽입한다.
 *  3. D일 때 -1은 최소값을 삭제하기 때문에 최소힙에서 poll, 최대힙에서 해당 숫자 remove
 *  4. D일 때 1은 최대값을 삭제하기 때문에 최대힙에서 poll, 최소힙에서 해당 숫자 remove
 *
 * */

public class TwoPriorityQueue {

    private static List<Integer> solution(String[] operations) {

        List<Integer> result = new ArrayList<>();

        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());

        for (int i = 0; i < operations.length; i++) {
            String input = operations[i].split(" ")[0];
            int num = Integer.parseInt(operations[i].split(" ")[1]);

            // I일 때 최대힙과 최소힙 모두 숫자 삽입
            if (input.equals("I")) {
                minHeap.offer(num);
                maxHeap.offer(num);

                // D 이지만 I이 없을 경우에는 해당 연산 무시
            } else if (input.equals("D") && !minHeap.isEmpty() && !maxHeap.isEmpty()) {
                if (num == 1) {
                    // 최대값을 삭제하기 위해 maxHeap에서 poll을 하고 minHeap에서 해당 숫자 remove
                    minHeap.remove(maxHeap.poll());
                } else if (num == -1) {
                    // 위와 반대
                    maxHeap.remove(minHeap.poll());
                }
            }
        }

        return minHeap.isEmpty() && maxHeap.isEmpty() ?
                new ArrayList<>(Arrays.asList(0,0)) : new ArrayList<>(Arrays.asList(maxHeap.poll(), minHeap.poll()));

    }


    public static void main(String[] args) {

        String[] operations1 = {"I 16", "I -5643", "D -1", "D 1", "D 1", "I 123", "D -1"};
        String[] operations2 = {"I -45", "I 653", "D 1", "I -642", "I 45", "I 97", "D 1", "D -1", "I 333"};

        System.out.println(solution(operations1));
        System.out.println(solution(operations2));

    }

}
