package fc.LinkedList;

/**
 * 연결리스트 구현
 */
public class LinkedList {
    Node head;

    LinkedList() {

    }

    LinkedList(Node node) {
        this.head = node;
    }

    // 연결리스트가 비어있는지 확인
    public boolean isEmpty() {
        if (this.head == null) {
            return true;
        }
        return false;
    }

    // 연결 리스트의 맨 뒤에 데이터를 추가
    public void addData(int data) {
        if (this.head == null) {
            this.head = new Node(data, null);
        } else {
            Node curNode = this.head;
            // 마지막 데이터를 찾는 과정
            while (curNode.next != null) {
                curNode = curNode.next;
            }
            curNode.next = new Node(data, null);
        }
    }

    // 연결 리스트의 맨 뒤의 데이터 삭제
    public void removeData() {
        if (this.isEmpty()) {
            System.out.println("empty");
            return;
        }

        Node cur = this.head;
        // 삭제 노드의 이전 노드의 next를 지워주기 위한 노드이다.(prev)
        Node prev = cur;

        while (cur.next != null) {
            prev = cur;
            cur = cur.next;
        }

        if (cur == this.head) {
            this.head = null;
        } else {
            prev.next = null;
        }
    }

    // 연결 리스트에서 데이터 찾기
    public void findData(int data) {
        if (this.isEmpty()) {
            System.out.println("empty");
            return;
        }

        Node cur = this.head;

        while (cur != null) {
            if(cur.data == data){
                System.out.println("find");
                return;
            }
            cur = cur.next;
        }
        System.out.println("not find");
    }


    // 노드
    // 값과 포인터로 구현됨
    static class Node {
        int data;
        Node next;

        public Node() {
        }

        public Node(int data, Node next) {
            this.data = data;
            this.next = next;
        }
    }
}
