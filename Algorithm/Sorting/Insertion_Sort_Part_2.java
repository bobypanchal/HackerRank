import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Insertion_Sort_Part_2 {

    // Complete the insertionSort2 function below.
    private static void printArray(int[] ar) {
        for(int n: ar)
            System.out.print(n+" ");
        System.out.println("");
    }
    
    static void insertionSort2(int n, int[] ar) {
        for(int i = 1; i < ar.length; i++){
            for(int j = i; j > 0; j--){
                if(ar[j-1] <= ar[j]){
                    printArray(ar);
                    break;
                }
                else{
                    int tmp = ar[j];
                    ar[j] = ar[j-1];
                    ar[j-1] = tmp;
                    if(j-1 ==0)
                        printArray(ar);
                }
            }
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

        insertionSort2(n, arr);

        scanner.close();
    }
}
