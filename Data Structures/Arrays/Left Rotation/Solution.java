import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int d = in.nextInt();
        int[] a = new int[n];
        for(int i = 0; i < n; i++) 
            a[(n-d+i)%n] = in.nextInt();

        for (int i = 0; i < n; i++) 
           System.out.print(a[i] + " ");

        scanner.close();
    }
}
