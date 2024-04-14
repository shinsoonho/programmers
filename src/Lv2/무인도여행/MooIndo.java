package Lv2.무인도여행;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 *
 *  문제풀이
 *  . 지도는 1 x 1크기의 사각형들로 이루어진 직사각형 격자 형태이며, 격자의 각 칸에는 'X' 또는 1에서 9 사이의 자연수가 적혀있습니다. 지도의 'X'는 바다를 나타내며, 숫자는 무인도를 나타냅니다. 이때, 상, 하, 좌, 우로 연결되는 땅들은 하나의 무인도를 이룹니다.
 *
 *  1. DFS 문제풀이
 *
 * */

public class MooIndo {

    private static void print(char[][] map) {

        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[i].length; j++) {
                System.out.print(map[i][j] + "\t");
            }
            System.out.println();
        }
    }

    private static int dfs(int x, int y, char[][] map, boolean[][] visit, int day) {

        visit[x][y] = true;
        day += map[x][y] - '0';

        int[] posX = {-1, 0, 1, 0};
        int[] posY = {0, -1, 0, 1};

        for (int i = 0; i < 4; i++) {
            int nextX = x + posX[i];
            int nextY = y + posY[i];

            if (nextX > -1 && nextY > -1 && nextX < map.length && nextY < map[0].length) {
                if (!visit[nextX][nextY] && map[nextX][nextY] != 'X') {
                    day = dfs(nextX, nextY, map, visit, day);
                }
            }
        }

        return day;
    }

    private static List<Integer> solution(String[] maps) {

        List<Integer> result = new ArrayList<>();

        char[][] map = new char[maps.length][maps[0].length()];
        boolean[][] visit = new boolean[map.length][map[0].length];

        for (int i = 0; i < maps.length; i++) {
            for (int j = 0; j < maps[i].length(); j++) {
                map[i][j] = maps[i].charAt(j);
            }
        }
        print(map);

        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[i].length; j++) {
                if (!visit[i][j] && map[i][j] != 'X') {
                    System.out.println("map = " + map[i][j]);
                    int day = dfs(i, j, map, visit, 0);
                    result.add(day);
                }
            }
        }

        if (result.isEmpty()) {
            result.add(-1);
        } else {
            Collections.sort(result);
        }

        return result;
    }

    public static void main(String[] args) {
        String[] map1 = {"X591X","X1X5X","X231X", "1XXX1"};
        String[] map2 = {"XXX","XXX","XXX"};

        System.out.println(solution(map1));
//        System.out.println(solution(map2));
    }
}
