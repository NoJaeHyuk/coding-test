package backjoon.gold.lv4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

/*
타임머신
 */
public class B11657 {
    static long distance[];
    static Edge[] edges;

    public static void main(String[] args) throws IOException {

        List<Edge>[] list = new ArrayList[5];

        for(int i = 0; i < 5; i++){
            list[i] = new ArrayList<Edge>();
        }

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        edges = new Edge[m];
        distance = new long[n+1];

        for(int i = 0; i < m; i++){
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());

            edges[i] = new Edge(s,e,w);
        }

        for(int i = 0; i <= n; i++){
            distance[i] = Long.MAX_VALUE;
        }

        distance[1] = 0;

        solution(n,m);
    }

    public static void solution(int n, int m){

        for(int i = 1; i < n; i++){
            for(int j = 0; j < m; j++){
                Edge c_edge = edges[j];
                //벨만포드 갱신 조건
                //d[s] != 무한대
                //d[e] > d[s] + w
                //d[s] + w 로 갱신
                if(distance[c_edge.start] != Long.MAX_VALUE &&
                   distance[c_edge.end] > distance[c_edge.start] + c_edge.wight){
                    distance[c_edge.end] = distance[c_edge.start] + c_edge.wight;
                }
            }
        }

        //음수사이클이 있는지 확인한다.
        //값 변화가 있으면 사이클이 존재한다는 의미
        for(int i = 0; i < m; i++){
            Edge edge = edges[i];
            if(distance[edge.start] != Long.MAX_VALUE &&
                    distance[edge.end] > distance[edge.start] + edge.wight){
                System.out.println(-1);
                return;
            }
        }

        //결과값 출력
        //가는 경로가 없으면 -1 (무한대)
        for(int i = 2; i <= n; i++){
            if(distance[i] == Long.MAX_VALUE){
                System.out.println(-1);
            }else{
                System.out.println(distance[i]);
            }
        }

    }

    static class Edge{
        private int start;
        private int end;
        private int wight;

        public Edge(int start, int end, int wight) {
            this.start = start;
            this.end = end;
            this.wight = wight;
        }
    }



}
