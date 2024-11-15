package fc;

import java.util.ArrayList;
import java.util.List;

public class BinarySearchTree<T extends Comparable<T>> implements ITree<T> {

    private Node root;
    private int size; //트리의 사이즈

    public BinarySearchTree() {
        this.root = null;
        this.size = 0;
    }

    /*
    트리의 최소값 찾기
    가장 왼쪽 값 찾기
     */
    public T min(){
        return this.minNode(this.root);
    }

    private T minNode(Node node){
        T minData = node.data;
        while (node.left != null){
            minData = node.left.data;
            node = node.left;
        }

        return minData;
    }

    /*
    트리의 최대값값 찾기
    가장 오른쪽 값 찾기
    */
    public T max(){
        return this.maxNode(this.root);
    }

    private T maxNode(Node node){
        T maxData = node.data;
        while (node.right != null){
            maxData = node.right.data;
            node = node.right;
        }

        return maxData;
    }

    /*
    삽입기능
     */
    @Override
    public void insert(T val) {
        this.root = this.insertNode(this.root,val);
        this.size++;
    }

    private Node insertNode(Node node, T val){
        //값 비교를 통해 노드가 어디에 위치할 것인지 찾아야한다.

        //트리가 공백이면 새로운 노드를 반환
        if(node == null){
            return new Node(val);
        }

        //노드를 탐색해서 해당 위치를 찾으면 삽입
        if(val.compareTo(node.data) < 0){
            node.left = insertNode(node.left,val);
        } else if (val.compareTo(node.data) > 0) {
            node.right = insertNode(node.right,val);
        }

        return node;
    }


    /*
    삭제기능
     */
    @Override
    public void delete(T val) {
        this.deleteNode(root, val);
    }

    private Node deleteNode(Node node, T val){
        //해당 노드를 찾을 수 없을때
        if(node == null) return null;

        //삭제할 노드를 찾는 과정
        if(val.compareTo(node.data) < 0){
            node.left = deleteNode(node.left, val);
        } else if (val.compareTo(node.data) > 0) {
            node.right = deleteNode(node.right, val);
        } else {
            //삭제할 노드를 찾은 경우
            // val == node.data
            this.size--;

            //삭제 특징 1,2을 여기서 수행합니다.
            //1의 경우 자식들이 둘다 null 이니 멀 넣어도 null을 삽입하게 된다.
            //2의 경우 아래 설명처럼 진행
            //왼쪽 자식이 없는 경우 - 오른쪽 자식 노드 연결
            if(node.left == null){
                return node.right;
            }
            // 오른쪽 자식 노드가 없는 경우 - 왼쪽 자식 노드 연결
            else if(node.right == null){
                return node.left;
            }

            //세번째 경우
            //오른쪽 서브트리에서 최소값 가져와 삽입해준다.
            node.data = this.minNode(node.right);
            //후계 노드 삭제
            node.right = deleteNode(node.right, node.data);
        }

        return node;
    }

    /*
    검색 기능
    해당 겂 여부에 따라 boolean 데이터 리턴
     */
    @Override
    public boolean contains(T val) {
        return this.containsNode(root, val);
    }

    private boolean containsNode(Node node, T val){
        // 탐색의 실패한 경우 ( 마지막 노드 까지 도달 )
        if(node == null) return false;

        // a.compareTo(b)
        // a < b -> -1
        // a == b -> 0
        // a > b -> 1

        // 트리에 노드값이 존재할 때
        if(val.compareTo(node.data) == 0){
            return true;
        }

        // 찾고자 하는 값이 노드보다 작은 경우
        // 작으니 왼쪽 노드를 찾아야 한다.
        if(val.compareTo(node.data) < 0){
            return containsNode(node.left, val);
        }

        // 찾고자 하는 값이 노드보다 큰 경우
        // 오른쪽 노드를 찾아야 한다.
        // val.compareTo(node.data) > 0
        return containsNode(node.right, val);
    }

    @Override
    public int size() {
        return this.size;
    }

    /*
    전위탐색
     */
    public List<T> preOrder() {
        return this.preorderTree(root, new ArrayList<>());
    }

    /*
    전위탬색 사용하기 위한 메서드
    재귀함수 방식
    노드 -> 왼 -> 오
     */
    private List<T> preorderTree(Node node, List<T> visited){
        // 더 이상 접근 로트가 없으면 중지
        if(node == null) return visited;

        visited.add(node.data);
        preorderTree(node.left, visited);
        preorderTree(node.right, visited);

        return visited;
    }

    /*
    중위탐색
     */
    public List<T> inOrder() {
        return this.inorderTree(root, new ArrayList<>());
    }

    /*
    중위탬색 사용하기 위한 메서드
    재귀함수 방식
    완 -> 노 -> 오
     */
    private List<T> inorderTree(Node node, List<T> visited){
        // 더 이상 접근 로트가 없으면 중지
        if(node == null) return visited;

        preorderTree(node.left, visited);
        visited.add(node.data);
        preorderTree(node.right, visited);

        return visited;
    }

    /*
    후위탐색
     */
    public List<T> postOrder() {
        return this.postorderTree(root,new ArrayList<>());
    }

    /*
    전위탬색 사용하기 위한 메서드
    재귀함수 방식
    완 -> 오 -> 노
     */
    private List<T> postorderTree(Node node, List<T> visited){
        // 더 이상 접근 로트가 없으면 중지
        if(node == null) return visited;

        preorderTree(node.left, visited);
        preorderTree(node.right, visited);
        visited.add(node.data);

        return visited;
    }

    private class Node{
        T data;
        Node left;
        Node right;

        Node(T data){
            this.data = data;
        }

        Node(T data, Node left, Node right){
            this.data = data;
            this.left = left;
            this.right = right;
        }
    }
}
