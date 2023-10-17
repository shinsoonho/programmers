package Lv2.게임맵최단거리;

import java.util.LinkedList;
import java.util.Queue;

public class GameMapBFS {

    /*
    private static int[][] map;
    private static boolean[][] visit;

    private static Queue<int[]> queue = new LinkedList<>();

    private static int[] posX = {-1, 1, 0, 0};
    private static int[] posY = {0, 0, -1, 1};

    private static int bfs(int n, int m) {

        visit[n][m] = true;
        queue.offer(new int[]{n, m, 1});

        int width = map.length;
        int height = map[0].length;

        while (!queue.isEmpty()) {
            int[] now = queue.poll();
            int depth = now[2];

            if( now[0] == width-1 && now[1] == height-1 ) return depth;

            for (int i = 0; i < 4; i++) {
                int nextX = now[0] + posX[i];
                int nextY = now[1] + posY[i];


                if (nextX > -1 && nextY > -1 && nextX < width && nextY < height) {
                    //System.out.println("nextX = " + nextX + ", nextY = " + nextY + ", depth = " + depth);
                    if (map[nextX][nextY] != 0 && !visit[nextX][nextY]) {
                        visit[nextX][nextY] = true;
                        queue.offer(new int[]{nextX, nextY, depth + 1});
                    }
                }
            }

        }

        return -1;
    }

     */

    private static int solution(int[][] map) {

        boolean[][] visit;

        Queue<int[]> queue = new LinkedList<>();

        int[] posX = {-1, 1, 0, 0};
        int[] posY = {0, 0, -1, 1};

        visit = new boolean[map.length][map[0].length];

        //return bfs(0,0);

        visit[0][0] = true;
        queue.offer(new int[]{0, 0, 1});

        int width = map.length;
        int height = map[0].length;

        while (!queue.isEmpty()) {
            int[] now = queue.poll();
            int depth = now[2];

            if( now[0] == width-1 && now[1] == height-1 ) return depth;

            for (int i = 0; i < 4; i++) {
                int nextX = now[0] + posX[i];
                int nextY = now[1] + posY[i];


                if (nextX > -1 && nextY > -1 && nextX < width && nextY < height) {
                    //System.out.println("nextX = " + nextX + ", nextY = " + nextY + ", depth = " + depth);
                    if (map[nextX][nextY] != 0 && !visit[nextX][nextY]) {
                        visit[nextX][nextY] = true;
                        queue.offer(new int[]{nextX, nextY, depth + 1});
                    }
                }
            }

        }
        return -1;
    }

    public static void main(String[] args) {

        int[][] map1 = new int[][]{{1, 0, 1, 1, 1}, {1, 0, 1, 0, 1}, {1, 0, 1, 1, 1}, {1, 1, 1, 0, 1}, {0, 0, 0, 0, 1}};
        System.out.println(solution(map1));
        int[][] map2 = new int[][]{{1,0,1,1,1},{1,0,1,0,1},{1,0,1,1,1},{1,1,1,0,0},{0,0,0,0,1}};
        System.out.println(solution(map2));
    }

}
