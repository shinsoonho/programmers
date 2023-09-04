package 백준.단지번호붙이기;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class PostNumber {

    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    private static int line;
    private static int[][] map;
    private static boolean[][] visit;
    private static int area = 0;
    private static int areaValue = 0;
    private static List<Integer> list = new ArrayList<>();

    private static int[] posX = {-1,1,0,0};
    private static int[] posY = {0,0,-1,1};

    private static void dfs(int a, int b) {

        visit[a][b] = true;
        areaValue++;

        for (int i = 0; i < 4; i++) {

            int tempA = a + posX[i];
            int tempB = b + posY[i];

            if (tempA > -1 && tempB > -1 && tempA < line && tempB < line) {
                if (map[tempA][tempB] == 1 && !visit[tempA][tempB]) {
                    dfs(tempA, tempB);
                }
            }

        }

    }

    public static void main(String[] args) throws IOException {

        line = Integer.parseInt(br.readLine());

        map = new int[line][line];
        visit = new boolean[line][line];

        for (int i = 0; i < line; i++) {
            String str = br.readLine();
            for (int j = 0; j < str.length(); j++) {
                map[i][j] = str.charAt(j) - '0';
            }
        }

        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[i].length; j++) {
                if (map[i][j] == 1 && !visit[i][j]) {
                    area ++;
                    dfs(i, j);
                    list.add(areaValue);
                    areaValue = 0;
                }
            }
        }
        Collections.sort(list);

        System.out.println(area);

        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }

    }

}
