package fc.LinkedList;

/**
 * https://st-lab.tistory.com/169
 * 양방향 연결 리스트
 */
public class DoubleLinkedList extends LinkedList {
    NodeBi head;
    NodeBi tail;

    public DoubleLinkedList(NodeBi node) {
        this.head = node;
        this.tail = node;
    }

    public boolean isEmpty() {
        if (this.head == null) {
            return true;
        }
        return false;
    }

    public void addData(int data, Integer beforeData) {
        if (this.head == null) {
            this.head = new NodeBi(data, null, null);
            this.tail = this.head;
        } else if (beforeData == null) {
            // 마지막에 연결
            // tail 노드의 next에 새로운 노드데이터를 연결 시키고 새로운 노드의 prev는 tail 노드로 연결시킨다.(tail 노드가 이전노드가 되므로)
            // 그리고 tail의 포인트를 새로 추가한 노드로 변경시킨다.
            this.tail.next = new NodeBi(data, null, this.tail);
            this.tail = this.tail.next;
        } else {
            // 중간 삽입
            NodeBi cur = this.head;
            NodeBi pre = cur;
            while (cur != null) {
                if (cur.data == beforeData) {
                    if (cur == this.head) {
                        this.head = new NodeBi(data, this.head, null);
                        this.head.next.prev = this.head; // 변경 헤드의 다음 노드의 이전 노드의 현재 변경 노드를 연결한다는 의미
                    } else {
                        // 변경 위치 이전 노드의 다음을 변경 노드로 연결하고
                        // 이전 노드의 다음노드의 이전 노드를 변경노드로 연결한다.
                        // pre -> new -> next
                        pre.next = new NodeBi(data, cur, pre);
                        cur.prev = pre.next;
                    }
                    break;
                }
                pre = cur;
                cur = cur.next;
            }
        }
    }


    public void removeData(int data) {
        if (this.isEmpty()) {
            System.out.println("empty");
            return;
        }

        NodeBi cur = this.head;
        NodeBi pre = cur;

        while (cur != null) {
            if (cur.data == data) {
                if (cur == this.head && cur == this.tail) {
                    this.head = null;
                    this.tail = null;
                } else if (cur == this.head) {
                    this.head = cur.next;
                    this.head.prev = null;
                } else if (cur == this.tail) {
                    this.tail = this.tail.prev;
                    this.tail.next = null;
                } else {
                    pre.next = cur.next;
                    cur.next.prev = pre;
                }
                break;
            }
            pre = cur;
            cur = cur.next;
        }

    }

    static class NodeBi {
        int data;
        NodeBi next;
        NodeBi prev;

        public NodeBi(int data, NodeBi next, NodeBi prev) {
            this.data = data;
            this.next = next;
            this.prev = prev;
        }
    }

}
