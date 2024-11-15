package fc.graph;

import java.util.*;

/*
인접 정렬
 */
public class AdjacencyListGraph implements IGraph{
    private List<List<Node>> graph;      //vertex 만큼 사용되는 리스트로 리스트+리스트 형태로 많이 구현
    private Set<Integer> vertexes;   //vertexes 집합
    Map<Integer, Integer> indegrees;
    // indegrees.get(3) = 5 -> 노드 3을 가르키는 노드의 갯수가 5


    /*
    Vertex 수 기준으로 초기화 해주는 생성자
     */
    public AdjacencyListGraph(int numOfVertex) {
        this.vertexes = new HashSet<>();
        this.indegrees = new HashMap<>();
        this.graph = new ArrayList<>(numOfVertex);
        for (int i=0; i < numOfVertex; i++){
            this.graph.add(new ArrayList<>());
        }
    }

    @Override
    public void add(int from, int to, Integer distance) {
        vertexes.add(from);
        vertexes.add(to);

        int count = indegrees.getOrDefault(to,0);
        indegrees.put(to, count+1);

        List<Node> neighbors = this.graph.get(from);
        neighbors.add(new Node(from, to, distance));
    }

    @Override
    public void add(int from, int to) {
        vertexes.add(from);
        vertexes.add(to);

        int count = indegrees.getOrDefault(to,0);
        indegrees.put(to, count+1);

        List<Node> neighbors = this.graph.get(from);
        neighbors.add(new Node(from, to));
    }

    @Override
    public Integer getDistance(int from, int to) {
        for(Node node : this.graph.get(from)){
            if(node.to.equals(to)){
                return node.weight;
            }
        }

        return null;
    }

    @Override
    public Map<Integer, Integer> getIndegrees() {
        return this.indegrees;
    }

    @Override
    public Set<Integer> getVertexes() {
        return this.vertexes;
    }

    @Override
    public List<Integer> getNodes(int vertex) {
        List<Integer> nodes = new ArrayList<>();
        for(Node node : this.graph.get(vertex)){
            nodes.add(node.to);
        }
        return nodes;
    }

    private class Node{
        Integer from;
        Integer to;
        int weight;

        Node(int from, int to){
            this.from = from;
            this.to = to;
            this.weight = 1;
        }

        Node(int from, int to, int weight){
            this.from = from;
            this.to = to;
            this.weight = weight;
        }
    }
}
