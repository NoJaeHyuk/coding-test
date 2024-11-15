package backjoon.gold.lv5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class B13023 {
    static boolean[] visited;
    static int N;
    static int M;
    static List<Integer>[] arrList;
    static int result = 0; // 정답 여부

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        arrList = new ArrayList[N];

        for (int i = 0; i < N; i++) {
            arrList[i] = new ArrayList<>();
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            arrList[a].add(b);
            arrList[b].add(a);
        }

        for(int i = 0; i < N; i++) {
            visited = new boolean[N];
            solution(i, 0);
            if(result == 1) {
                break;
            }
        }

        System.out.println(result);
    }

    public static void solution(int x,int count){
        if(count == 4) {
            result = 1;
            return;
        }

        visited[x] = true;
        for(int nxt : arrList[x]) {
            if(!visited[nxt]) {
                solution(nxt, count + 1);
            }
        }
        visited[x] = false;
    }
}
