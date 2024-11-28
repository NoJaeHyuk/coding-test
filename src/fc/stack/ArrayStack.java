package fc.stack;

import java.util.EmptyStackException;
import java.util.Stack;

public class ArrayStack<E> extends Stack<E> {
    private static final int DEFAULT_CAPACITY = 10; // 초기 배열 크기
    private Object[] elements; // 데이터 저장용 배열
    private int size; // 현재 스택에 저장된 데이터 개수

    public ArrayStack() {
        elements = new Object[DEFAULT_CAPACITY];
        size = 0;
    }

    // push 메서드 오버라이딩
    @Override
    public E push(E item) {
        ensureCapacity(); // 배열 크기 확인 및 확장
        elements[size++] = item;
        return item;
    }

    // pop 메서드 오버라이딩
    @Override
    public E pop() {
        if (isEmpty()) {
            throw new EmptyStackException();
        }
        @SuppressWarnings("unchecked")
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

    // 배열 크기 확장
    private void ensureCapacity() {
        if (size == elements.length) {
            int newCapacity = elements.length * 2; // 크기를 두 배로 확장
            Object[] newElements = new Object[newCapacity];
            System.arraycopy(elements, 0, newElements, 0, elements.length);
            elements = newElements;
        }
    }

    public static void main(String[] args) {
        ArrayStack<Integer> stack = new fc.stack.ArrayStack<Integer>();
        
        // 데이터 푸시
        stack.push(10);
        stack.push(20);
        stack.push(30);
        
        // 스택 상태 확인
        System.out.println("Top element: " + stack.peek()); // 30
        System.out.println("Stack size: " + stack.size()); // 3
        
        // 데이터 팝
        System.out.println("Popped: " + stack.pop()); // 30
        System.out.println("Top element after pop: " + stack.peek()); // 20
        System.out.println("Stack size after pop: " + stack.size()); // 2
    }
}
