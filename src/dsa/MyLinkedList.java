package dsa;

/** Singly linked list with generic elements. */
public class MyLinkedList<T> {
    private static class Node<T> {
        T value;
        Node<T> next;

        Node(T value) {
            this.value = value;
        }
    }

    private Node<T> head;
    private int size;

    public void addFirst(T value) {
        Node<T> node = new Node<>(value);
        node.next = head;
        head = node;
        size++;
    }

    public void addLast(T value) {
        Node<T> node = new Node<>(value);
        if (head == null) {
            head = node;
        } else {
            Node<T> cur = head;
            while (cur.next != null) cur = cur.next;
            cur.next = node;
        }
        size++;
    }

    public T removeFirst() {
        if (head == null) throw new IllegalStateException("List is empty");
        T value = head.value;
        head = head.next;
        size--;
        return value;
    }

    /** Removes the first occurrence of value. Returns true if something was removed. */
    public boolean remove(T value) {
        Node<T> prev = null, cur = head;
        while (cur != null) {
            if (cur.value.equals(value)) {
                if (prev == null) head = cur.next;
                else prev.next = cur.next;
                size--;
                return true;
            }
            prev = cur;
            cur = cur.next;
        }
        return false;
    }

    public boolean contains(T value) {
        for (Node<T> cur = head; cur != null; cur = cur.next) {
            if (cur.value.equals(value)) return true;
        }
        return false;
    }

    /** Reverses the list in place. */
    public void reverse() {
        Node<T> prev = null, cur = head;
        while (cur != null) {
            Node<T> next = cur.next;
            cur.next = prev;
            prev = cur;
            cur = next;
        }
        head = prev;
    }

    public int size() {
        return size;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("[");
        for (Node<T> cur = head; cur != null; cur = cur.next) {
            sb.append(cur.value);
            if (cur.next != null) sb.append(" -> ");
        }
        return sb.append("]").toString();
    }
}
