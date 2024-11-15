package backjoon.gold.lv5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class B14567 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        //인접리스트
        ArrayList<Integer> arr[] = new ArrayList[N + 1];
        for (int i = 1; i <= N; i++){
            arr[i] = new ArrayList<Integer>();
        }

        //진입차수배열
        int parentCnt[] = new int[N + 1];
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            arr[from].add(to);
            parentCnt[to]++;
        }

        Queue<Integer> que = new LinkedList<Integer>();
        for (int i = 1; i <= N; i++){
            if (parentCnt[i] == 0)
                que.add(i);
        }

        int result[] = new int[N + 1];
        int cnt = 1;

        while (!que.isEmpty()) {
            int size = que.size();
            while (size-- != 0) {
                int now = que.poll();
                result[now] = cnt;
                for (int child : arr[now]){
                    if (--parentCnt[child] == 0)
                        que.add(child);
                }

            }
            cnt++;
        }

        //위상정렬은 답이 하나가 아닐 수 있다.
        for(int i = 1 ; i <= N ; i++){
            System.out.print(result[i]+" ");
        }
    }
}
