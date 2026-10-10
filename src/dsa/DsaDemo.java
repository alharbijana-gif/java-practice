package dsa;

import java.util.Arrays;
import java.util.Random;

/** Runs simple checks on every data structure and algorithm in this package. */
public class DsaDemo {
    private static int failures = 0;

    private static void check(String name, boolean ok) {
        System.out.println((ok ? "PASS  " : "FAIL  ") + name);
        if (!ok) failures++;
    }

    public static void main(String[] args) {
        // Linked list
        MyLinkedList<Integer> list = new MyLinkedList<>();
        list.addLast(2);
        list.addLast(3);
        list.addFirst(1);
        check("linked list order", list.toString().equals("[1 -> 2 -> 3]"));
        list.reverse();
        check("linked list reverse", list.toString().equals("[3 -> 2 -> 1]"));
        check("linked list remove", list.remove(2) && !list.contains(2) && list.size() == 2);

        // Stack
        ArrayStack<String> stack = new ArrayStack<>();
        for (String s : new String[] {"a", "b", "c", "d", "e"}) stack.push(s);
        check("stack pop order", stack.pop().equals("e") && stack.peek().equals("d"));
        check("balanced brackets", ArrayStack.isBalanced("{[()]}") && !ArrayStack.isBalanced("{[(])}"));

        // Queue
        CircularQueue<Integer> q = new CircularQueue<>(3);
        q.enqueue(1);
        q.enqueue(2);
        q.enqueue(3);
        q.dequeue();
        q.enqueue(4); // wraps around
        check("queue wrap-around", q.dequeue() == 2 && q.dequeue() == 3 && q.dequeue() == 4 && q.isEmpty());

        // Binary search tree
        BinarySearchTree<Integer> bst = new BinarySearchTree<>();
        for (int v : new int[] {50, 30, 70, 20, 40, 60, 80}) bst.insert(v);
        check("bst in-order is sorted", bst.inOrder().toString().equals("[20, 30, 40, 50, 60, 70, 80]"));
        check("bst height", bst.height() == 3);
        bst.remove(50);
        check("bst remove root", !bst.contains(50) && bst.inOrder().size() == 6);

        // Sorting and searching
        int[] data = new Random(42).ints(200, 0, 1000).toArray();
        int[] expected = data.clone();
        Arrays.sort(expected);
        String[] names = {"bubble", "insertion", "merge", "quick"};
        for (String n : names) {
            int[] copy = data.clone();
            switch (n) {
                case "bubble" -> Sorting.bubbleSort(copy);
                case "insertion" -> Sorting.insertionSort(copy);
                case "merge" -> Sorting.mergeSort(copy);
                default -> Sorting.quickSort(copy);
            }
            check(n + " sort", Arrays.equals(copy, expected));
        }
        check("binary search", Sorting.binarySearch(expected, expected[57]) >= 0 && Sorting.binarySearch(expected, -5) == -1);

        System.out.println(failures == 0 ? "\nAll checks passed." : "\n" + failures + " check(s) failed.");
    }
}
