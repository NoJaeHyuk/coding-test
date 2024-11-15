package backjoon.gold.lv4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class B1753 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int V = Integer.parseInt(st.nextToken());
        int E = Integer.parseInt(st.nextToken());

        int K = Integer.parseInt(br.readLine());

        ArrayList<Node>[] nodes = new ArrayList[V+1];
        for(int i = 1; i <= V; i++){
            nodes[i] = new ArrayList<Node>();
        }

        //다익스트라 인접리스트 생성
        for(int i = 0; i < E; i++){
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());

            nodes[u].add(new Node(v,w));
        }

        solution(V,E,K,nodes);
    }

    public static void solution(int V, int E, int K, ArrayList<Node>[] nodes){
        boolean[] visit = new boolean[V+1];
        int[] min_distance = new int[V+1];

        PriorityQueue<Node> queue = new PriorityQueue<>();

        //최단경로 초기화
        for(int i = 0; i <= V; i++){
            min_distance[i] = Integer.MAX_VALUE; // 이론엔 무한대값을 삽입하지만 코드상에는 큰 수를 활용
        }

        //시작값은 0으로 할당
        queue.add(new Node(K,0));
        min_distance[K] = 0;

        while (!queue.isEmpty()){
            Node curNode = queue.poll();
            //만약 이미 방문했으면 다시 큐에 넣지 않음
            if(visit[curNode.vertex]){
                continue;
            }
            visit[curNode.vertex] = true;

            //큐에 연결된 인접리스트 배열
            //ex) 1 이면 2,3
            for(int i = 0; i < nodes[curNode.vertex].size(); i ++){
                Node tep = nodes[curNode.vertex].get(i);

                //값이 작으면 최단경로 갱신
                //min_distance[curNode.vertex] + tep.value < min_distance[tep.vertex]
                //다익스트라 기본이론
                //Distance[next] > Distance[Prev] + cur_value 면 갱신한다.
                if((min_distance[curNode.vertex] + tep.value) < min_distance[tep.vertex]){
                    min_distance[tep.vertex] = min_distance[curNode.vertex] + tep.value;
                    queue.add(new Node(tep.vertex, min_distance[tep.vertex]));
                }
            }
        }

        for(int i = 1; i <= V; i++){
            if(visit[i]){
                System.out.println(min_distance[i]);
            }else{
                System.out.println("INF");
            }
        }
    }

    private static class Node implements Comparable<Node>{
        int vertex;
        int value;

        public Node(int vertex, int value) {
            this.vertex = vertex;
            this.value = value;
        }

        //우선순위 큐 활용하기 위해 선언
        @Override
        public int compareTo(Node o) {
            if(this.value > o.value){
                return 1;
            }else{
                return -1;
            }
        }
    }
}
