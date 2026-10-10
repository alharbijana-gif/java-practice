package dsa;

/** Classic sorting and searching algorithms on int arrays. */
public class Sorting {

    /** O(n^2). */
    public static void bubbleSort(int[] a) {
        for (int i = 0; i < a.length - 1; i++) {
            boolean swapped = false;
            for (int j = 0; j < a.length - 1 - i; j++) {
                if (a[j] > a[j + 1]) {
                    swap(a, j, j + 1);
                    swapped = true;
                }
            }
            if (!swapped) return; // already sorted
        }
    }

    /** O(n^2), fast on nearly sorted data. */
    public static void insertionSort(int[] a) {
        for (int i = 1; i < a.length; i++) {
            int key = a[i], j = i - 1;
            while (j >= 0 && a[j] > key) {
                a[j + 1] = a[j];
                j--;
            }
            a[j + 1] = key;
        }
    }

    /** O(n log n), needs O(n) extra space. */
    public static void mergeSort(int[] a) {
        if (a.length < 2) return;
        int mid = a.length / 2;
        int[] left = java.util.Arrays.copyOfRange(a, 0, mid);
        int[] right = java.util.Arrays.copyOfRange(a, mid, a.length);
        mergeSort(left);
        mergeSort(right);
        int i = 0, j = 0, k = 0;
        while (i < left.length && j < right.length) {
            a[k++] = left[i] <= right[j] ? left[i++] : right[j++];
        }
        while (i < left.length) a[k++] = left[i++];
        while (j < right.length) a[k++] = right[j++];
    }

    /** O(n log n) on average, in place. */
    public static void quickSort(int[] a) {
        quickSort(a, 0, a.length - 1);
    }

    private static void quickSort(int[] a, int lo, int hi) {
        if (lo >= hi) return;
        int pivot = a[hi], i = lo;
        for (int j = lo; j < hi; j++) {
            if (a[j] < pivot) swap(a, i++, j);
        }
        swap(a, i, hi);
        quickSort(a, lo, i - 1);
        quickSort(a, i + 1, hi);
    }

    /** Returns the index of target in a sorted array, or -1. O(log n). */
    public static int binarySearch(int[] sorted, int target) {
        int lo = 0, hi = sorted.length - 1;
        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            if (sorted[mid] == target) return mid;
            if (sorted[mid] < target) lo = mid + 1;
            else hi = mid - 1;
        }
        return -1;
    }

    private static void swap(int[] a, int i, int j) {
        int t = a[i];
        a[i] = a[j];
        a[j] = t;
    }
}
