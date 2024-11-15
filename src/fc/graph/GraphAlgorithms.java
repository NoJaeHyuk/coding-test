package fc.graph;

import java.util.*;

public class GraphAlgorithms {

    /*
    bfs 구현
    list 와 queue 사용
     */
    public static List<Integer> bfs(IGraph iGraph, int from){
        List<Integer> result = new ArrayList<>();  // 탐색 결과
        Set<Integer> visited = new HashSet<>();    // 방문여부 체크 , 체크 안하면 무한루프
        Queue<Integer> queue = new LinkedList<>();
        //시작데이터를 넣고 시작
        queue.add(from);
        visited.add(from);

        //큐에 값이 없을때 까지 동작
        while (!queue.isEmpty()){
            //큐에서 꺼내서 결과값에 세팅
            Integer next = queue.poll();
            result.add(next);
            //getNodes 는 out-degree 를 찾는거
            for (Integer n : iGraph.getNodes(next)){
                if(!visited.contains(n)){
                    queue.add(n);
                    visited.add(n);
                }
            }
        }

        return result;
    }

    public static List<Integer> dfs(IGraph graph, int from){
        List<Integer> result = new ArrayList<>();
        Set<Integer> visited = new HashSet<>();

        Stack<Integer> stack = new Stack<>();

        stack.push(from);
        visited.add(from);

        while (stack.size() > 0){
            Integer next = stack.pop();
            result.add(next);

            for (Integer n : graph.getNodes(next)){
                if(!visited.contains(n)){
                    stack.push(n);
                    visited.add(n);
                }
            }
        }

        return result;
    }

    /*
    queue 를 이용한 위상정렬
     */
    public static List<Integer> topologicalSortIndegree(IGraph graph){
        // <vertex, indegree 갯수>
        Map<Integer, Integer> indegreeCounter = graph.getIndegrees();

        List<Integer> result = new LinkedList<>();
        Queue<Integer> queue = new LinkedList<>();

        for (int v : graph.getVertexes()){
            int count = indegreeCounter.getOrDefault(v,0);
            //indegree 개수가 0인 값들이 큐에 삽입된다.
            if(count == 0){
                queue.offer(v);
            }
        }

        while (!queue.isEmpty()){
            int node = queue.poll();
            result.add(node);

            //연결된 Edge 제거과정
            //node 와 연결된 node들을 다 가져운다.
            for(int nn : graph.getNodes(node)){
                //node 들 중 인접노드가 있으면 실행한다.
                if(indegreeCounter.containsKey(nn)){
                    int count = indegreeCounter.get(nn);
                    //edge 를 지운다느건 결국엔 진입차수의 -1 하는것과 같다.
                    if(count - 1 == 0){
                        queue.offer(nn);
                    }
                    indegreeCounter.put(nn, count-1);
                }
            }
        }
        return result;
    }

    /*
    스텍 구현
     */
    public static List<Integer> topologicalSort(IGraph graph){
        List<Integer> result = new ArrayList<>();
        Stack<Integer> stack = new Stack<>();
        Set<Integer> visited = new HashSet<>();

        Set<Integer> vertexes = graph.getVertexes();
        for(Integer vertex : vertexes){
            if(!visited.contains(vertex)){
                //DFS
                topologicalSort(graph,vertex,visited,stack);
            }
        }

        while (stack.size() > 0){
            result.add(stack.pop());
        }

        return result;
    }

    private static void topologicalSort(IGraph iGraph, int vertex, Set<Integer> visited, Stack<Integer> stack){
        visited.add(vertex);
        List<Integer> nodes = iGraph.getNodes(vertex);
        for(Integer n : nodes){
            if(!visited.contains(n)){
                topologicalSort(iGraph,n,visited,stack);
            }
        }

        stack.push(vertex);
    }

    /**
     * 우선 순위 큐를 이용한 다익스트라
     * @param graph
     * @param src
     * @param dst
     * @return
     */
    public static int dijkstraShortestPath(IGraph graph, int src, int dst) {
        int size = 0;
        for (int n : graph.getVertexes()) {
            if (size < n) {
                size = n;
            }
        }

        int[] dist = new int[size + 1];
        for (int i = 0; i < dist.length; i++) {
            dist[i] = Integer.MAX_VALUE;
        }

        dist[src] = 0;
        PriorityQueue<Pair> pq = new PriorityQueue<>();
        pq.add(new Pair(src, 0));

        while (!pq.isEmpty()) {
            Pair top = pq.poll();
            if (dist[top.vertex] < top.distance) {
                continue;
            }
            for (int node : graph.getNodes(top.vertex)) {
                if (dist[node] > dist[top.vertex] + graph.getDistance(top.vertex, node)) {
                    dist[node] = dist[top.vertex] + graph.getDistance(top.vertex, node);
                    pq.add(new Pair(node, dist[node]));
                }
            }
        }
        return dist[dst];
    }

    private static class Pair implements Comparable<Pair> {
        int vertex;
        int distance;

        public Pair(int vertex, int distance) {
            this.vertex = vertex;
            this.distance = distance;
        }

        @Override
        public int compareTo(Pair o) {
            return distance - o.distance;
        }
    }
}
