public interface Deque<T> {
    //  contains all of the methods that
    // appear in both ArrayDeque and LinkedListDeque.

    void addFirst(T item);

    void addLast(T item);

    boolean isEmpty();

    int size();

    void printDeque();

    T removeFirst();

    T removeLast();

    T get(int index);
}
