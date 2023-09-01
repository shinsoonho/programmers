package 백준.바이러스;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


/**
 *
 * -- 문제 --
 * 어느 날 1번 컴퓨터가 웜 바이러스에 걸렸다. 컴퓨터의 수와 네트워크 상에서 서로 연결되어 있는 정보가 주어질 때, 1번 컴퓨터를 통해 웜 바이러스에 걸리게 되는 컴퓨터의 수를 출력하는 프로그램을 작성하시오.
 *
 *  -- 입력
 * 7
 * 6
 * 1 2
 * 2 3
 * 1 5
 * 5 2
 * 5 6
 * 4 7
 *
 *  -- 출력
 * 4
 *
 * 백준 2606번
 *
 * */

public class Virus {

    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static StringTokenizer st;

    private static int[][] arr;
    private static boolean[] visit;
    private static int Node;    // 노드의 수
    private static int N;       // 간선의 수

    private static int result = 0;

    private static void dfs(int node) {
        visit[node] = true;
        if (node != 1) result++;

        for (int i = 1; i <= Node; i++) {
            if (arr[node][i] == 1 && !visit[i]) {
                dfs(i);
            }
        }

    }

    public static void main(String[] args) throws IOException {

        Node = Integer.parseInt(br.readLine());
        N = Integer.parseInt(br.readLine());

        arr = new int[Node + 1][Node + 1];
        visit = new boolean[Node + 1];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());

            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());

            arr[n][m] = arr[m][n] = 1;
        }

        dfs(1);

        System.out.println(result);
/*

        for (int i[] : arr) {
            for (int j : i) {
                System.out.print(j + " ");
            }
            System.out.println();
        }
*/

    }

}


















