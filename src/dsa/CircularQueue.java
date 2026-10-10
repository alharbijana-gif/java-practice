package dsa;

/** Fixed-capacity queue (FIFO) using a circular array. */
public class CircularQueue<T> {
    private final Object[] data;
    private int head, size;

    public CircularQueue(int capacity) {
        data = new Object[capacity];
    }

    public void enqueue(T value) {
        if (size == data.length) throw new IllegalStateException("Queue is full");
        data[(head + size) % data.length] = value;
        size++;
    }

    @SuppressWarnings("unchecked")
    public T dequeue() {
        if (size == 0) throw new IllegalStateException("Queue is empty");
        T value = (T) data[head];
        data[head] = null;
        head = (head + 1) % data.length;
        size--;
        return value;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int size() {
        return size;
    }
}
