package 백준.유기농배추;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Baechu {

    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static StringTokenizer st;

    private static int[][] map;
    private static boolean[][] visit;

    private static int roop;
    private static int width;
    private static int height;

    private static int[] posX = {-1,1,0,0};
    private static int[] posY = {0,0,-1,1};

    private static void print(int[][] map) {
        for (int[] i : map) {
            for (int j : i) {
                System.out.print(j + " ");
            }
            System.out.println();
        }
    }

    private static void dfs(int n, int m) {

        visit[n][m] = true;

        for (int i = 0; i < 4; i++) {
            int tempX = n;
            int tempY = m;

            tempX += posX[i];
            tempY += posY[i];

            if (tempX > -1 && tempY > -1 && tempX < height && tempY < width) {

                if (map[tempX][tempY] == 1 && !visit[tempX][tempY]) {
                    dfs(tempX, tempY);
                }
            }

        }


    }

    public static void main(String[] args) throws IOException {

        roop = Integer.parseInt(br.readLine());

        for (int r = 0; r < roop; r++) {
            st = new StringTokenizer(br.readLine());

            width = Integer.parseInt(st.nextToken());
            height = Integer.parseInt(st.nextToken());
            int put = Integer.parseInt(st.nextToken());

            map = new int[height][width];
            visit = new boolean[height][width];

            for (int i = 0; i < put; i++) {
                st = new StringTokenizer(br.readLine());

                int n = Integer.parseInt(st.nextToken());
                int m = Integer.parseInt(st.nextToken());

                map[m][n] = 1;
            }

            int section = 0;

            for (int i = 0; i < map.length; i++) {
                for (int j = 0; j < map[i].length; j++) {
                    if (map[i][j] == 1 && !visit[i][j]) {
                        section++;
                        dfs(i, j);
                    }
                }
            }

            System.out.println(section);

        }

    }

}
