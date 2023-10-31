package Lv2.캐시;

import java.util.LinkedList;
import java.util.Queue;

/**
 *
 *  캐시 교체 알고리즘은 LRU(Least Recently Used)을 사용한다.
 *  cache hit 일 경우 실행시간은 1이다.
 *  cache miss 일 경우 실행시간은 5이다.
 *
 *  -- 문제풀이
 *  Queue에 순서대로 넣는다.
 *  들어올 도시의 이름이 list에 있다면 제거하고 처음으로 넣는다.
 *  들어올 도시의 이름이 list에 없고 list의 크기가 캐시크기와 같다면 마지막 도시이름은 제거하고 들어올 도시의 이름을 처음으로 넣는다.
 *
 * */

public class Cache {

    private static int CACHE_HIT = 1;
    private static int CACHE_MISS = 5;

    private static int solution(int cacheSize, String[] cities) {

        int answer = 0;

        Queue<String> cache = new LinkedList<>();

        if (cacheSize == 0) return cities.length * CACHE_MISS;

        for (int i = 0; i < cities.length; i++) {

            String city = cities[i].toLowerCase();

            if (!cache.contains(city)) {
                if (cache.size() == cacheSize) {
                    cache.poll();
                }
                cache.offer(city);
                answer += CACHE_MISS;

            } else {
                cache.remove(city);
                cache.offer(city);
                answer += CACHE_HIT;
            }
            //System.out.println("i = " + i + ", queue = " + cache);
        }

        return answer;
    }

    public static void main(String[] args) {

        int cacheSize1 = 3;
        int cacheSize2 = 3;
        int cacheSize3 = 2;
        int cacheSize4 = 5;
        int cacheSize5 = 2;
        int cacheSize6 = 0;

        String[] cities1 = {"Jeju", "Pangyo", "Seoul", "NewYork", "LA", "Jeju", "Pangyo", "Seoul", "NewYork", "LA"};
        String[] cities2 = {"Jeju", "Pangyo", "Seoul", "Jeju", "Pangyo", "Seoul", "Jeju", "Pangyo", "Seoul"};
        String[] cities3 = {"Jeju", "Pangyo", "Seoul", "NewYork", "LA", "SanFrancisco", "Seoul", "Rome", "Paris", "Jeju", "NewYork", "Rome"};
        String[] cities4 = {"Jeju", "Pangyo", "Seoul", "NewYork", "LA", "SanFrancisco", "Seoul", "Rome", "Paris", "Jeju", "NewYork", "Rome"};
        String[] cities5 = {"Jeju", "Pangyo", "NewYork", "newyork"};
        String[] cities6 = {"Jeju", "Pangyo", "Seoul", "NewYork", "LA"};

        System.out.println(solution(cacheSize1, cities1));
        System.out.println(solution(cacheSize2, cities2));
        System.out.println(solution(cacheSize3, cities3));
        System.out.println(solution(cacheSize4, cities4));
        System.out.println(solution(cacheSize5, cities5));
        System.out.println(solution(cacheSize6, cities6));


    }

}
