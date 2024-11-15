package fc.heap;

public interface THeap<T> {

    void insert(T val);

    boolean contains(T val);

    T pop();

    T peek();

    int size();
}
