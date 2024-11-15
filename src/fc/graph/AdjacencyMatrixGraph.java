package fc.graph;

import java.util.*;

/*
인접 정렬
 */
public class AdjacencyMatrixGraph implements IGraph{
    private Integer[][] matrix;      //인접배열에 사용될 2차원 배열
    private Set<Integer> vertexes;   //vertexes 집합
    Map<Integer, Integer> indegrees;
    // indegrees.get(3) = 5 -> 노드 3을 가르키는 노드의 갯수가 5


    /*
    Vertex 수 기준으로 초기화 해주는 생성자
     */
    public AdjacencyMatrixGraph(int numOfVertex) {
        this.vertexes = new HashSet<>();
        this.indegrees = new HashMap<>();
        this.matrix = new Integer[numOfVertex][];
        for (int i=0; i < numOfVertex; i++){
            this.matrix[i] = new Integer[numOfVertex];
        }
    }

    /*
    가중치그래프에서 add
     */
    @Override
    public void add(int from, int to, Integer distance) {
        this.vertexes.add(from);
        this.vertexes.add(to);

        // 해당 노드의 차수가 있을수도 없을수도 있다.
        // 있으면 차수값 없으면 0을 넣어주고 count 증가시킨다. (in-degree 이므로 도착노드의 값을 증가)
        // map.add(1,3)
        // map.getOrDefault(1, 0) -> 3
        // map.getOrDefault(2, 0) -> 0
        int count = this.indegrees.getOrDefault(to,0);
        indegrees.put(to, count+1);

        //해당 위치에 가중치 값 삽입
        matrix[from][to] = distance;
        //만약 양방향 그래프 일 경우 추가
        //matrix[to][from] = distance;

    }

    /*
    가중치가 아닌 상황
     */
    @Override
    public void add(int from, int to) {
        this.vertexes.add(from);
        this.vertexes.add(to);

        // 해당 노드의 차수가 있을수도 없을수도 있다.
        // 있으면 차수값 없으면 0을 넣어주고 count 증가시킨다. (in-degree 이므로 도착노드의 값을 증가)
        // map.add(1,3)
        // map.getOrDefault(1, 0) -> 3
        // map.getOrDefault(2, 0) -> 0
        int count = this.indegrees.getOrDefault(to,0);
        indegrees.put(to, count+1);

        //해당 위치에 연결이 되었다는 1값 추가
        matrix[from][to] = 1;
        //만약 양방향 그래프 일 경우 추가
        //matrix[to][from] = 1;
    }

    @Override
    public Integer getDistance(int from, int to) {
        return matrix[from][to];
    }

    @Override
    public Map<Integer, Integer> getIndegrees() {
        return this.indegrees;
    }

    @Override
    public Set<Integer> getVertexes() {
        return this.vertexes;
    }

    public Integer[][] getMatrix() {
        return this.matrix;
    }


    /*
    vertax 가 가르키고 있는 node 들
    out-degree
     */
    @Override
    public List<Integer> getNodes(int vertex) {
        List<Integer> result = new ArrayList<>();
        //2차원 배열은 열의 갯수로 반복문
        for(int i = 0; i < this.matrix[vertex].length; i++){
            if(this.matrix[vertex][i] != null){
                result.add(i);
            }
        }

        return result;
    }
}
