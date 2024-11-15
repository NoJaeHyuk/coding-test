package backjoon.gold.lv5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class B15681 {
    static boolean visit[];
    static int dp[];

    static List<Integer>[] list;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int n = Integer.parseInt(st.nextToken());
        int r = Integer.parseInt(st.nextToken());
        int q = Integer.parseInt(st.nextToken());

        visit = new boolean[n+1];
        dp = new int[n+1];
        list = new ArrayList[n+1];

        for(int i=0; i<list.length; i++) {
            list[i] = new ArrayList<>();
        }

        //각 접점 마다 연결된 접점 리스트 뽑아야
        //간선은 (n-1)
        //DFS 탐색을 위한 용도
        for(int i = 1; i < n; i++){
            st = new StringTokenizer(br.readLine(), " ");
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());

            list[u].add(v);
            list[v].add(u);
        }

        //DFS + DP 로 풀어보자
        //DFS -> 루트 r 부터 탐색
        //DFS로 푸니깐 트리 자료구조를 직접 구현할 필요는 없다.
        //방문하면 visit 기록하며 탐색
        dfs(r);
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < q; i++){
            int query = Integer.parseInt(br.readLine());

            sb.append(dp[query] +"\n");
        }

        System.out.println(sb.toString());
    }

    public static int dfs(int cur){
        //일반적인 DP 재귀 탈출 방법
        if(dp[cur] != 0){
            return dp[cur];
        }
        visit[cur] = true;
        int res = 1;

        for(int i = 0; i < list[cur].size(); i++){
            //방문한 노드는 가지 않음
            if(visit[list[cur].get(i)]){
                continue;
            }
            res += dfs(list[cur].get(i));
        }

        dp[cur] = res;

        return dp[cur];
    }

}
