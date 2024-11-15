package inflearn.ch09;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Problem_7 {
    static int[] parents;

    public static void main(String[] args) throws IOException {
        int answer = 0;

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int v = Integer.parseInt(st.nextToken());
        int e = Integer.parseInt(st.nextToken());

        List<Edge> list = new ArrayList<>();
        parents = new int[v+1];

        for(int i = 0; i <= v; i++){
            parents[i] = i;
        }

        for (int i = 0; i < e; i++) {
            st = new StringTokenizer(br.readLine());

            int cs = Integer.parseInt(st.nextToken());
            int ce = Integer.parseInt(st.nextToken());
            int cw = Integer.parseInt(st.nextToken());

            list.add(new Edge(cs, ce, cw));
        }

        Collections.sort(list);

        for(Edge edge : list){
            int fv1 = find(edge.start);
            int fv2 = find(edge.end);

            if(fv1 != fv2){
                answer += edge.weight;
                union(edge.start, edge.end);
            }
        }

    }

    private static void union(int s, int e) {
        s = find(s);
        e = find(e);

        if (s != e) {
            parents[s] = e;
        }
    }

    private static int find(int a) {
        if(a == parents[a]){
            return a;
        }

        return parents[a] = find(parents[a]);
    }



    static class Edge implements Comparable<Edge> {
        private int start;
        private int end;
        private int weight;

        public Edge(int start, int end, int weight) {
            this.start = start;
            this.end = end;
            this.weight = weight;
        }

        @Override
        public int compareTo(Edge o) {
            return this.weight - o.weight;
        }
    }

}
