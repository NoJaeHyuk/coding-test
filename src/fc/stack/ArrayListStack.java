package fc.stack;

import java.util.ArrayList;
import java.util.EmptyStackException;
import java.util.Stack;

public class ArrayListStack<E> extends Stack<E> {
    private ArrayList<E> list; // 데이터를 저장할 ArrayList

    // 생성자: ArrayList 초기화
    public ArrayListStack() {
        this.list = new ArrayList<>();
    }

    // push: 데이터를 스택에 추가
    @Override
    public E push(E item) {
        list.add(item); // ArrayList의 끝에 데이터 추가
        return item;    // 추가된 데이터 반환
    }

    // pop: 스택에서 최상단 데이터를 제거하고 반환
    @Override
    public E pop() {
        if (isEmpty()) {
            // 스택이 비어 있으면 예외 발생
            throw new EmptyStackException();
        }
        return list.remove(list.size() - 1); // 마지막 데이터를 제거하고 반환
    }

    // peek: 스택의 최상단 데이터를 반환 (제거하지 않음)
    @Override
    public E peek() {
        if (isEmpty()) {
            // 스택이 비어 있으면 예외 발생
            throw new EmptyStackException();
        }
        return list.get(list.size() - 1); // 마지막 데이터 반환
    }

    // isEmpty: 스택이 비어 있는지 확인
    @Override
    public boolean isEmpty() {
        return list.isEmpty(); // ArrayList가 비어 있는지 확인
    }

    // size: 스택에 저장된 데이터 개수 반환
    @Override
    public int size() {
        return list.size(); // ArrayList의 크기를 반환
    }

    public static void main(String[] args) {
        ArrayListStack<Integer> stack = new ArrayListStack<>();

        // 데이터 추가 (push)
        stack.push(10);
        stack.push(20);
        stack.push(30);

        System.out.println("Stack size: " + stack.size()); // 3
        System.out.println("Top element: " + stack.peek()); // 30

        // 데이터 제거 (pop)
        System.out.println("Popped: " + stack.pop()); // 30
        System.out.println("Stack size after pop: " + stack.size()); // 2
        System.out.println("Top element after pop: " + stack.peek()); // 20
    }
}
