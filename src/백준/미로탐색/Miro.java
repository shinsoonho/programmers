package 백준.미로탐색;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 *
 *  백준 2178번
 *  bfs 방식풀이
 *
 * */

public class Miro {

    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static StringTokenizer st;

    private static int[][] map;
    private static boolean[][] visit;
    private static Queue<int[]> queue = new LinkedList<>();

    private static int width;
    private static int height;
    private static int dist = 0;

    private static int[] posX = {-1,1,0,0};
    private static int[] posY = {0,0,-1,1};

    private static int bfs(int n, int m) {
        visit[n][m] = true;
        queue.offer(new int[]{n, m, dist});     // queue에 x좌표, y좌표, 거리를 저장할 배열 생성

        while (!queue.isEmpty()) {

            int[] now = queue.poll();
            int dist = now[2] + 1;      // 큐에 들어온 순간 이전거리 + 1

            if (now[0] == width - 1 && now[1] == height - 1) {
                return dist;            // 마지막 자리이면 현재 거리를 반환한다
            }

            for (int i = 0; i < 4; i++) {
                int nextX = now[0] + posX[i];
                int nextY = now[1] + posY[i];

                if (nextX > -1 && nextY > -1 && nextX < width && nextY < height) {
                    if (map[nextY][nextX] == 1 && !visit[nextY][nextX]) {
                        visit[nextY][nextX] = true;
                        queue.offer(new int[]{nextX, nextY, dist});
                    }
                }
            }

        }

        return dist;

    }

    public static void main(String[] args) throws IOException {

        st = new StringTokenizer(br.readLine());

        height = Integer.parseInt(st.nextToken());
        width = Integer.parseInt(st.nextToken());

        map = new int[height][width];
        visit = new boolean[height][width];

        for (int i = 0; i < height; i++) {
            String str = br.readLine();
            for (int j = 0; j < width; j++) {
                map[i][j] = str.charAt(j) - '0';
            }
        }

        System.out.println(bfs(0, 0));
    }
}