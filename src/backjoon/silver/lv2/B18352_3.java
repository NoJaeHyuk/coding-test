package backjoon.silver.lv2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * 문제
 * 단방향으로 이루어진 그래프
 * 도시에서 도시로 이동하면 +1
 * 최단거리로 주어진 k인 모든 도시를 한줄씩 오름차순으로 출력
 * <p>
 * BFS로 진행
 * 인접리스트로 입력값 표현
 * 방문한 도시를 int[]로 활용 - 인덱스가 도시
 * 방문도시배열을 -1로 초기화
 * <p>
 * 큐 조건
 * 방문도시배열의 값이 -1이라면(방문하지 않았다면)
 * 거리를 표기해주고 add
 * <p>
 * BFS 끝나고 거리배열을 돌면서 k와 같은 거리의 도시 값 출력
 */
public class B18352_3 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int x = Integer.parseInt(st.nextToken());

        List<List<Integer>> list = new ArrayList<>();
        int[] distance = new int[n + 1];
        Arrays.fill(distance, -1);

        for (int i = 0; i <= n; i++) {
            list.add(new ArrayList<>());
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            list.get(a).add(b);
        }

        Queue<Integer> queue = new LinkedList<>();
        queue.add(x);
        distance[x] = 0;

        while (!queue.isEmpty()) {
            int current = queue.poll();

            for (Integer next : list.get(current)) {
                if (distance[next] == -1) { // -1이면 방문하지 않음
                    distance[next] = distance[current] + 1;
                    queue.add(next);
                }
            }
        }

        // 출력
        boolean flag = false;

        for (int i = 0; i < distance.length; i++) {
            if (k == distance[i]) {
                System.out.println(i);
                flag = true;
            }
        }

        // -1
        if (!flag) {
            System.out.println(-1);
        }
    }
}
