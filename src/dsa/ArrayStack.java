package dsa;

import java.util.Arrays;

/** Stack (LIFO) backed by a resizable array. */
public class ArrayStack<T> {
    private Object[] data = new Object[4];
    private int size;

    public void push(T value) {
        if (size == data.length) data = Arrays.copyOf(data, size * 2);
        data[size++] = value;
    }

    @SuppressWarnings("unchecked")
    public T pop() {
        if (size == 0) throw new IllegalStateException("Stack is empty");
        T value = (T) data[--size];
        data[size] = null;
        return value;
    }

    @SuppressWarnings("unchecked")
    public T peek() {
        if (size == 0) throw new IllegalStateException("Stack is empty");
        return (T) data[size - 1];
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int size() {
        return size;
    }

    /** Classic stack application: checks that (), [] and {} are balanced. */
    public static boolean isBalanced(String text) {
        ArrayStack<Character> stack = new ArrayStack<>();
        for (char c : text.toCharArray()) {
            if (c == '(' || c == '[' || c == '{') {
                stack.push(c);
            } else if (c == ')' || c == ']' || c == '}') {
                if (stack.isEmpty()) return false;
                char open = stack.pop();
                if ((c == ')' && open != '(') || (c == ']' && open != '[') || (c == '}' && open != '{')) {
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }
}
