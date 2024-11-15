package backjoon.gold.lv4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;


public class B1197 {
    static int[] parents;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int v = Integer.parseInt(st.nextToken());
        int e = Integer.parseInt(st.nextToken());

        List<Edge> edges = new ArrayList<>(e);
        parents = new int[v+1];

        //가중치 행렬
        for(int i = 0; i < e; i++){
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            edges.add(new Edge(s,d,w));
        }

        //가중치가 적은 순으로 오름차순한다.
        Collections.sort(edges);

        //대표행렬
        for(int i = 1; i < v+1; i++){
            parents[i] = i;
        }

        int sum = 0;
        int cnt = 0;

        //가중치가 낮은 에지부터 연결 시도한다.
        for(int i = 0; i < e; i++){
            Edge edge = edges.get(i);

            int idx1 = find(edge.getStart());
            int idx2 = find(edge.getEnd());

            //대표노드가 같다는건 사이클이니 체크를 안한다.
            //edge start 가 대표노드이므로
            //parents[idx2] = idx1
            if(idx1 != idx2){
                parents[idx2] = idx1;
                cnt++;
                sum += edge.getWeight();
            }

            //최소 신장 트리 구성하는 애지의 개수는 항상 N-1 개이다.
            if(cnt == v-1){
                break;
            }
        }

        System.out.println(sum);
    }

    private static int find(int a) {
        if (a == parents[a]) {
            return a;
        } else {
            //대표노드가 아니면 지정된 노드로 찾아감
            return parents[a] = find(parents[a]); //빠져나오면 대표노드로 값을 갱신
        }
    }

    static class Edge implements Comparable<Edge>{
        private int start;
        private int end;
        private int weight;

        public Edge(int start, int end, int weight) {
            this.start = start;
            this.end = end;
            this.weight = weight;
        }

        public int getStart() {
            return start;
        }

        public int getEnd() {
            return end;
        }

        public int getWeight() {
            return weight;
        }

        @Override
        public int compareTo(Edge o) {
            return this.weight - o.weight;
        }
    }
}
