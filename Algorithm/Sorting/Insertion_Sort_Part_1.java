import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Insertion_Sort_Part_1 {

    // Complete the insertionSort1 function below.
    static void printArr(int[] ar){
        for(int a : ar)
            System.out.print(a + " ");
        System.out.println("");
    }

    static void insertionSort1(int n, int[] ar) {
        int tmp = ar[ar.length-1];
        for(int i=ar.length-2; i>=0; i--){
            if(tmp >= ar[i]){
                ar[i+1] = tmp;
                printArr(ar);
                break;
            }
            ar[i+1] = ar[i];
            printArr(ar);
        }
        if(tmp < ar[0]){
            ar[0] = tmp; 
            printArr(ar);
        } 
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int[] arr = new int[n];

        String[] arrItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < n; i++) {
            int arrItem = Integer.parseInt(arrItems[i]);
            arr[i] = arrItem;
        }

        insertionSort1(n, arr);

        scanner.close();
    }
}
