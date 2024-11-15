package fc.graph;

import java.util.List;
import java.util.Map;
import java.util.Set;

public interface IGraph {
    // from 출발노드, to 도착노드
    void add(int from, int to);
    // distance 가중치 그래프에서 사용될 가중치
    void add(int from, int to, Integer distance);
    // 가중치를 가져온다
    Integer getDistance(int from, int to);
    // 그래프 중 vertex 들이 가신 차수 <노드, 차수의 수>
    Map<Integer, Integer> getIndegrees();
    // 그래프에 존재하는 모든 vertex 의 수
    Set<Integer> getVertexes();
    // Outdegree
    List<Integer> getNodes(int vertex);

}
