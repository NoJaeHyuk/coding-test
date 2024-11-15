package fc.LinkedList;

/**
 * 데이터 중간 삽입 삭제 구현
 */
public class LinkedList2 extends LinkedList {

    LinkedList2(Node node) {
        this.head = node;
    }

    // 연결리스트 데이터추가
    // before_data 가 null인 경우, 가장 뒤에 추가
    // before_data 에 값이 있을 경우, 해당 값을 가진 노드 앞에 추가
    public void addData(int data, Integer beforeData) {
        if (this.head == null) {
            this.head = new Node(data, null);
        } else if (beforeData == null) {
            Node cur = this.head;
            while (cur.next != null) {
                cur = cur.next;
            }
            cur.next = new Node(data, null);
        } else {
            Node cur = this.head;
            Node pre = cur;
            while (cur != null) {
                // 이전 노드 데이터 찾는 과정
                // 이전 노드가 해더면 해더에 새로운 데이터와 next에 헤더값을 넣어 진행
                // 헤더가 아니라면 이전 값의 next의 새로운 데이터 노드를 생성
                // 노드에 데이터와 next는 pre가 이전에 가르키던 다음 노드(cur)를 넣어준다.
                if(cur.data == beforeData) {
                    if (cur == this.head) {
                        this.head = new Node(data, this.head);
                    } else {
                        pre.next = new Node(data, cur);
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

        Node cur = this.head;
        Node pre = cur;

        while (cur != null) {
            if (cur.data == data) {
                if (cur == this.head) {
                    this.head = cur.next;
                } else {
                    // 이전노드의 next는 지우고자 하는 노드의 다음 노드를 연결시켜 준다.
                    pre.next = cur.next;
                }
                break;
            }

            pre = cur;
            cur = cur.next;
        }
    }

}
