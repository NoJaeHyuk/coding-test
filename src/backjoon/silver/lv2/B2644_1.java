package backjoon.silver.lv2;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 문제 분석
 * 주어진 두 사람에 대한 촌수를 구하는 문제이다.
 * 입력값은 전체 사람의 수 n
 * 두번째줄에는 두 사람의 관계 start, end
 * 세번째줄에는 부모자식의 관계 수 m
 * <p>
 * 문제 풀이
 * DFS로 접근
 * 입력값은 인접행렬(배열) 받는다.
 * <p>
 * DFS(start, end, count)
 * 사람에 대한 방문을 체크하는 방문배열 - 일차원배열
 * 1. 방문배열 상태를 체크
 * 2. for문 n번
 * 3. 방문하지 않는 사람 체크, 연결이 된 여부
 * 4. dfs(i, end, count + 1);
 * 5. 재귀가 끝나는 조건  start == end 같아지면 return
 */
public class B2644_1 {
    static int n;
    static int[][] arr;
    static boolean[] visited;
    static int result = -1;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int start = Integer.parseInt(st.nextToken());
        int end = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(br.readLine());

        arr = new int[n + 1][n + 1];
        visited = new boolean[n + 1];

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            // 무방향, 양방향 그래프
            arr[x][y] = arr[y][x] = 1;
        }

        dfs(start, end, 0);
        // 출력값
        System.out.println(result);
    }

    /**
     * 1. 방문배열 상태를 체크
     * 2. for문 n번
     * 3. 방문하지 않는 사람 체크, 연결이 된 여부
     * 4. dfs(i, end, count + 1);
     * 5. 재귀가 끝나는 조건  start == end 같아지면 return
     */
    private static void dfs(int start, int end, int count) {
        visited[start] = true;

        if (start == end) {
            result = count;
            return;
        }

        for (int i = 1; i <= n; i++) {
            if (!visited[i] && arr[start][i] == 1) {
                dfs(i, end, count + 1);
            }
        }
    }
}
