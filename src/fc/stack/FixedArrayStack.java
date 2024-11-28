package fc.stack;

import java.util.EmptyStackException;
import java.util.Stack;

public class FixedArrayStack<E> extends Stack<E> {
    private final int capacity; // 최대 크기
    private Object[] elements; // 데이터 저장용 배열
    private int size; // 현재 스택에 저장된 데이터 개수

    public FixedArrayStack(int capacity) {
        if (capacity <= 0) {
            throw new IllegalArgumentException("Capacity must be greater than 0");
        }
        this.capacity = capacity;
        this.elements = new Object[capacity];
        this.size = 0;
    }

    // push 메서드 오버라이딩
    @Override
    public E push(E item) {
        if (size >= capacity) {
            throw new IllegalStateException("Stack Overflow: Maximum capacity reached");
        }
        elements[size++] = item;
        return item;
    }

    // pop 메서드 오버라이딩
    @Override
    public E pop() {
        if (isEmpty()) {
            throw new EmptyStackException();
        }
        E item = (E) elements[--size];
        elements[size] = null; // 메모리 누수 방지
        return item;
    }

    // peek 메서드 오버라이딩
    @Override
    public E peek() {
        if (isEmpty()) {
            throw new EmptyStackException();
        }
        return (E) elements[size - 1];
    }

    // 스택 비어있는지 확인
    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    // 스택 크기 반환
    @Override
    public int size() {
        return size;
    }

    // 현재 스택의 최대 크기 반환
    public int getCapacity() {
        return capacity;
    }

    public static void main(String[] args) {
        FixedArrayStack<Integer> stack = new FixedArrayStack<>(3); // 최대 3개 저장 가능
        
        try {
            // 데이터 푸시
            stack.push(10);
            stack.push(20);
            stack.push(30);
            
            System.out.println("Stack size: " + stack.size()); // 3
            System.out.println("Top element: " + stack.peek()); // 30
            
            // 추가 데이터 푸시 (오버플로우 발생)
            stack.push(40); // 예외 발생
        } catch (IllegalStateException e) {
            System.err.println(e.getMessage());
        }
        
        // 데이터 팝
        System.out.println("Popped: " + stack.pop()); // 30
        System.out.println("Stack size after pop: " + stack.size()); // 2
    }
}
