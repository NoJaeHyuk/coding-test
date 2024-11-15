package fc.heap;

import java.util.Arrays;
import java.util.Collections;

public class MaxHeap<T extends Comparable<T>> implements THeap<T> {

    T[] data;
    int size;
    int maxSize;

    /*
    초기 생성자
     */
    public MaxHeap(int maxSize) {
        // 배열의 0 인덱스를 비우고 시작하니깐 + 1
        this.data = (T[]) new Comparable[maxSize + 1];
        this.size = 0;
        this.maxSize = maxSize;
    }

    /*
    힙의 특징이며 여기선 탐색을 위한 용도
    부모 = 자식 / 2
    왼자식 = 부모*2
    오른자식 = 부모*2+1
    pos : 현재위치
     */
    private int parent(int pos){
        return pos / 2;
    }

    private int leftChild(int pos){
        return pos * 2;
    }

    private int  rightChild(int pos){
        return (pos * 2) + 1;
    }

    /*
    리프 인지 아닌지 확인 여부
    pos > (size / 2) -> 완전이진트리 의 특성상 사이즈반은 부모노드 수 이다. 그러니 말단노드는 이것보단 커야된다.
     */
    private boolean isLeaf(int pos){
        return (pos > (size / 2) && pos <= size);
    }

    /*
    삽입
    - 가장 마지막 위치에 삽입 후 진행하는 방식
     */
    @Override
    public void insert(T val) {
        //리프 위치에 먼저 추가
        this.data[++this.size] = val;

        //현재 삽입된 데이터 위치
        int current = this.size;

        //삽입된 데이터의 부모가 작을때 최대힙 속성에 따라 swap 이 발생하게 된다.
        while (this.data[parent(current)] != null &&
                this.data[current].compareTo(this.data[parent(current)]) > 0){
            //데이터 swap 을 진행하고 current 위치를 갱신한다.
            Collections.swap(Arrays.asList(this.data), current, parent(current));
            current = parent(current);
        }

    }

    /*
    탐색
    배열 형태니깐 재귀 보단 반복문 처리
     */
    @Override
    public boolean contains(T val) {
        for(int i = 1; i <= this.size; i++){
            if(val.equals(this.data[i])){
                return true;
            }
        }
        return false;
    }

    /*
    루트 노드를 삭제한다.
     */
    @Override
    public T pop() {
        //루트노드는 인덱스 1이다.
        T top = this.data[1];

        //삭제연산 1 번 마지막 노드를 루트노드로 가져온다.
        this.data[1] = this.data[this.size--];

        heapify(1);

        this.data[this.size + 1] = null;

        return top;
    }

    /*
    해당 인덱스 idx 가 힙의 특정을 유지하는가 ?
    만족할때까지 swap 하는 메소드
     */
    private void heapify(int idx){
        //리프면 더 이상 비교할게 없으므로 실행 종료
        if(isLeaf(idx)){
            return;
        }

        //최대힙
        // 왼,오 자식들을 모두 비교해서 둘 중 부모보다 크면 안된다.
        T current = this.data[idx];
        T left = this.data[leftChild(idx)];
        T right = this.data[rightChild(idx)];

        //자식들중 부보보다 큰 애들이 있으면 실행
        if(current.compareTo(left) < 0 ||
           current.compareTo(right) < 0){
            // 왼,오 중 큰거랑 바뀌준다.
            if(left.compareTo(right) > 0){
                Collections.swap(Arrays.asList(this.data), idx, leftChild(idx));
                heapify(leftChild(idx));
            }else {
                Collections.swap(Arrays.asList(this.data), idx, rightChild(idx));
                heapify(rightChild(idx));
            }

        }
    }

    /*
    루트를 반환
    - 가장 위에 있는 항목을 반환
     */
    @Override
    public T peek() {
        if(this.size < 1){
            throw new RuntimeException();
        }
        return this.data[1];
    }

    @Override
    public int size() {
        return this.size;
    }
}
