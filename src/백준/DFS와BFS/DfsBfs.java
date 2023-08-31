package 백준.DFS와BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * @Param N 정점의 개수
 * @Param M 간선의 개수
 * @Param V 시작할 정점의 번호
 *
 * 1. 첫째 줄에 정점의 개수 N(1 ≤ N ≤ 1,000), 간선의 개수 M(1 ≤ M ≤ 10,000), 탐색을 시작할 정점의 번호 V가 주어진다.
 * 2. 다음 M개의 줄에는 간선이 연결하는 두 정점의 번호가 주어진다.
 * 3. 어떤 두 정점 사이에 여러 개의 간선이 있을 수 있다. 입력으로 주어지는 간선은 양방향이다.
 *
 * @Return 백준 1260번
 *
 *
 *  -- 입력 --
 *  4 5 1
 *  1 2
 *  1 3
 *  1 4
 *  2 4
 *  3 4
 *
 *  -- 출력 --
 *  1 2 4 3
 *  1 2 3 4
 *
 * */



public class DfsBfs {

    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static StringTokenizer st;

    private static boolean[] visit;
    private static int[][] edge;

    private static int N;
    private static int M;
    private static int V;

    private static void dfs(int Node) {
        System.out.print(Node + " ");
        visit[Node] = true;

        for (int i = 1; i <= N; i++) {
            if (edge[i][Node] == 1 && !visit[i]) {
                dfs(i);
            }
        }
    }

    private static void bfs(int Node) {
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(Node);
        visit[Node] = true;

        while (!queue.isEmpty()) {

            Node = queue.poll();
            System.out.print(Node + " ");

            for (int i = 1; i <= N; i++) {

                if (edge[i][Node] == 1 && !visit[i]) {
                    queue.offer(i);
                    visit[i] = true;
                }
            }

        }
    }

    public static void main(String[] args) throws IOException {

        st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        V = Integer.parseInt(st.nextToken());

        visit = new boolean[N + 1];
        edge = new int[N + 1][N + 1];

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());

            // edge 배열에 맞는 인덱스에 연결된 노드 추가해주기(양방향 간선이기 때문에 양쪽에 추가)
            edge[n][m] = edge[m][n] = 1;
        }

        dfs(V);
        System.out.println();
        visit = new boolean[N + 1]; // bfs 를 위해 초기화
        bfs(V);

    }

}














