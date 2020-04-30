import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Plus_Minus {

    // Complete the plusMinus function below.
    static void plusMinus(int[] arr) {
        int p = 0, n = 0, z = 0;
        for(int a : arr)
            if(a > 0)
                p++;
            else if(a < 0)
                n++;
            else
                z++;
        System.out.printf("%.6f \n", (float)p/arr.length);
        System.out.printf("%.6f \n", (float)n/arr.length);
        System.out.printf("%.6f \n", (float)z/arr.length);

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

        plusMinus(arr);

        scanner.close();
    }
}
