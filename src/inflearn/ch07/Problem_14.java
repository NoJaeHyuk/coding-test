package inflearn.ch07;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Problem_14 {
    static int n, m, answer=0;
    static ArrayList<ArrayList<Integer>> graph;
    static int[] ch, dis;

    public static void main(String[] args){
        Scanner kb = new Scanner(System.in);
        n=kb.nextInt();
        m=kb.nextInt();
        graph=new ArrayList<ArrayList<Integer>>();
        for(int i=0; i<=n; i++){
            graph.add(new ArrayList<Integer>());
        }
        ch=new int[n+1];
        dis=new int[n+1];
        for(int i=0; i<m; i++){
            int a=kb.nextInt();
            int b=kb.nextInt();
            graph.get(a).add(b);
        }
        BFS(1);
        for(int i=2; i<=n; i++){
            System.out.println(i+" : "+dis[i]);
        }
    }

    private static void BFS(int v) {
        ch[v] = 1;
        dis[v] = 0; // 0 레벨이라는 뜻
        Queue<Integer> q = new LinkedList<>();
        q.offer(v);

        while (!q.isEmpty()){
            int len = q.size();

            for(int i = 0; i < len; i++){
                int cur = q.poll();

                for(int j : graph.get(cur)){
                    if(ch[j] == 0){
                        ch[j] = 1;
                        q.offer(j);
                        dis[j] = dis[cur] + 1;
                    }
                }
            }
        }
    }
}
