package Lv2.미로탈출;

import java.util.LinkedList;
import java.util.Queue;

/**
 *   문제풀이 - maps[i]는 다음 5개의 문자들로만 이루어져 있습니다.
 * S : 시작 지점
 * E : 출구
 * L : 레버
 * O : 통로
 * X : 벽
 * 시작 지점과 출구, 레버는 항상 다른 곳에 존재하며 한 개씩만 존재합니다.
 * 문은 레버를 당겨서만 열 수 있습니다.
 * 출구는 레버가 당겨지지 않아도 지나갈 수 있으며, 모든 통로, 출구, 레버, 시작점은 여러 번 지나갈 수 있습니다.
 *
 *
 *  1. bfs 방식으로 최단거리를 구한다.
 *  2. 레버를 지났는지 flag를 두어 확인한다.
 *  3. 레버를 지남과 동시에 방문 배열을 다시 초기화하여 그 시점부터 최단거리를 구한다.
 *
 * */

public class Miro {

    private static int bfs(int x, int y, char[][] map, boolean[][] visit, int time) {

        visit[x][y] = true;
        boolean leverFlag = false;

        Queue<int[]> queue = new LinkedList<>();
        int[] posX = {-1, 0, 1, 0};
        int[] posY = {0, -1, 0, 1};

        queue.offer(new int[]{x, y, time});

        while (!queue.isEmpty()) {

            int[] poll = queue.poll();
            x = poll[0];
            y = poll[1];
            time = poll[2];

            if (leverFlag && map[x][y] == 'E') return time;

            for (int i = 0; i < 4; i++) {

                int nextX = x + posX[i];
                int nextY = y + posY[i];

                if (nextX > -1 && nextY > -1 && nextX < map.length && nextY < map[0].length) {
                    if (!visit[nextX][nextY] && map[nextX][nextY] != 'X') {

                        // 레버지점에 오면 flag 변환 및 방문배열 초기화
                        if( map[nextX][nextY] == 'L' ) {
                            leverFlag = true;
                            visit = new boolean[map.length][map[0].length];
                            // 효율 최적화를 위해 큐 비우기 및 반복문 종료
                            queue.clear();
                            visit[nextX][nextY] = true;
                            queue.offer(new int[]{nextX, nextY, time + 1});
                            break;
                        }
                        visit[nextX][nextY] = true;
                        queue.offer(new int[]{nextX, nextY, time + 1});
                    }
                }


            }
        }

        return -1;
    }

    private static int solution(String[] maps) {

        char[][] map = new char[maps.length][maps[0].length()];
        boolean[][] visit = new boolean[map.length][map[0].length];

        int x = 0;
        int y = 0;

        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[i].length; j++) {
                char ch = maps[i].charAt(j);
                map[i][j] = ch;
                if (ch == 'S') {    // 시작지점 초기화
                    x = i;
                    y = j;
                }
            }
        }

        return bfs(x, y, map, visit, 0);
    }

    private static void print(char[][] map) {
        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[i].length; j++) {
                System.out.print(map[i][j] + "\t");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {

        String[] map1 = {"SOOOL","XXXXO","OOOOO","OXXXX","OOOOE"};
        String[] map2 = {"LOOXS","OOOOX","OOOOO","OOOOO","EOOOO"};

        System.out.println(solution(map1));
        System.out.println(solution(map2));
    }

}
