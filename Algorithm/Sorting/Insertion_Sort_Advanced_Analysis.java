import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.Collections; 
import java.util.stream.Collectors;
import java.util.regex.*;

public class Insertion_Sort_Advanced_Analysis {

    private static class Counter {
        private long value;
        void inc(final int delta) {
            this.value += delta;
        }

        @Override
        public String toString() {
            return String.valueOf(this.value);
        }
    }
 
    private static final class Node {
        private final int value;
        private Node next;
        private Node(final int value) {
            this.value = value;
        }
    }
 
    public static void main(final String[] args) {
        final Scanner in = new Scanner(System.in);
        final int testCasesCount = in.nextInt();
        for(int j = 0; j < testCasesCount; j++) {
            final int numbersToSortCount = in.nextInt();
            final Node[] numbersToSort = new Node[numbersToSortCount];
            final Counter shifts = new Counter();
            numbersToSort[0] = new Node(in.nextInt());
            for(int i = 1; i < numbersToSortCount; i++) {
                numbersToSort[i] = new Node(in.nextInt());
                numbersToSort[i - 1].next = (numbersToSort[i]);
            }
            mergeSort(numbersToSort, 0, numbersToSortCount - 1, shifts);
            System.out.println(shifts);
        }
    }
 
    private static Node mergeSort(final Node[] numbersToSort, final int l, final int r, final Counter shifts) {
        if(l < r) {
            final int m = (l + r) / 2;
            final Node left = mergeSort(numbersToSort, l, m, shifts);
            final Node right = mergeSort(numbersToSort, m + 1, r, shifts);
            return merge(left, l, m, right, m + 1, r, shifts);
        }
        return numbersToSort[l];
    }
 
    private static Node merge(Node left,
                              int l1,
                              final int r1,
                              Node right,
                              int l2,
                              final int r2,
                              final Counter shifts) {
        final int rightRangeBegin = l2;
        final Node first;
        Node current;
        if(left.value <= right.value) {
            current = first = left;
            left = left.next;
            l1++;
        }
        else {
            current = first = right;
            right = right.next;
            shifts.inc(rightRangeBegin - l1);
            l2++;
        }
        while(l1 <= r1 && l2 <= r2) {
            if(left.value <= right.value) {
                current = current.next = left;
                left = left.next;
                l1++;
            }
            else {
                current = current.next = right;
                right = right.next;
                shifts.inc(rightRangeBegin - l1);
                l2++;
            }
        }
        if(l1 <= r1) {
            current.next = left;
        }
        else {
            current.next = right;
        }
        return first;
    }
}
