package inflearn.ch07;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Problem_8 {
    static int[] dir = {1,-1,5};
    static int[] ch;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int s = Integer.parseInt(st.nextToken());
        int e = Integer.parseInt(st.nextToken());

        ch = new int[10001];
        solution(s, e);
    }

    public static void solution(int s, int e){
        System.out.println(BFS(s, e));
    }

    private static int BFS(int s, int e) {
        int L = 0;
        Queue<Integer> q = new LinkedList<>();
        q.offer(s);
        //방문기록 남기기
        ch[s] = 1;

        while (!q.isEmpty()){
            int len = q.size();
            for(int i = 0; i < len; i++){
                int x = q.poll();
                if(x == e){
                    return L;
                }

                for(int j = 0; j < dir.length; j++){
                    int cx = x + dir[j];
                    if(cx > 0 && cx < ch.length && ch[cx] == 0){
                        ch[cx] = 1;
                        q.offer(cx);
                    }
                }
            }
            L++;
        }

        return 0;
    }

}
