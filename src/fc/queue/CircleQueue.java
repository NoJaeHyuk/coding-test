package fc.queue;

/**
 * 배열로 구현한 원형큐
 */
public class CircleQueue {
    private int[] que;     // 큐의 배열
    private int capacity;  // 큐의 용량
    private int front;     // 맨 앞의 요소 커서
    private int rear;      // 맨 뒤에 요소 커서
    private int num;       // 현재 데이터의 개수

    public CircleQueue(int maxLen) {
        this.front = this.num = this.rear = 0;
        this.capacity = maxLen;
        que = new int[maxLen];
    }

    // 큐에 데이터를 인큐
    public int enqueue(int data) {
        if (this.num >= this.capacity) {
            throw new RuntimeException("큐가 가득 찼습니다.");
        }
        que[this.rear++] = data;
        this.num++;
        if (this.rear == this.capacity) {
            this.rear = 0;
        }
        return data;
    }

    // 큐에 데이터를 디큐
    public int deque() {
        if (num <= 0) {
            throw new RuntimeException("큐가 비어 있습니다.");
        }

        int data = que[front++];
        num--;
        if (front == capacity) {
            front = 0;
        }
        return data;
    }

    // 큐에서 데이터를 피크(프런트 요소)
    public int peek() {
        if (num <= 0) {
            throw new RuntimeException("큐가 비어 있습니다.");
        }
        return que[front];
    }

    // 큐를 비움
    public void clear() {
        num = front = rear = 0;
    }

    // 큐에서 특정 데이터가 인덱스를 반환(없을 시 -1 반환)
    public int indexOf(int x) {
        for (int i = 0; i < num; i++) {
            int idx = (i + front) % capacity;
            if (que[idx] == x) {
                return idx;
            }
        }
        return -1;
    }

    public int getCapacity() {
        return capacity;
    }

    public int size() {
        return num;
    }

    public boolean isEmpty() {
        return num <= 0;
    }

    public boolean isFull() {
        return num >= capacity;
    }
}
