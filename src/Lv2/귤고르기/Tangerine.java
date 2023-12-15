package Lv2.귤고르기;

import java.util.*;

/**
 *
 *  귤의 크기가 tangerine 일 때 k개를 판매한다면, 귤의 크기의 종류가 최소가 되도록 구하기
 *
 *  1. Map key에 귤의 크기를 저장, value에 갯수를 저장
 *  2. list에 value를 내림차순으로 정렬
 *  3. k에서 list를 순차적으로 빼면서 k의 값이 0 이하일 때 최소의 갯수가 됨
 *
 * */

public class Tangerine {

    private static int solution(int k, int[] tangerine) {

        int result = 0;

        Map<Integer, Integer> map = new HashMap<>();
        List<Integer> list = new ArrayList<>();

        for (int i = 0; i < tangerine.length; i++) {
            map.put(tangerine[i], map.getOrDefault(tangerine[i], 0) + 1);
        }

        for (int key : map.keySet()) {
            list.add(map.get(key));
        }

        Collections.sort(list, Collections.reverseOrder());

        for (int i = 0; i < list.size(); i++) {
            k -= list.get(i);
            result ++;
            if( k <= 0 ) return result;
        }

        return result;
    }

    public static void main(String[] args) {

        int k1 = 6;
        int k2 = 4;
        int k3 = 2;

        int[] tangerine1 = {1,3,2,5,4,5,2,3};
        int[] tangerine2 = {1,3,2,5,4,5,2,3};
        int[] tangerine3 = {1,1,1,1,2,2,2,3};

        System.out.println(solution(k1, tangerine1));
        System.out.println(solution(k2, tangerine2));
        System.out.println(solution(k3, tangerine3));

    }

}
