import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Modified_Kaprekar_Numbers {

    // Complete the kaprekarNumbers function below.
    static void kaprekarNumbers(int p, int q) {
        boolean check = true;
        if(p == 1){
            System.out.print(p + " ");
            check = false;
        }

        for(long i=p; i<q+1; i++){
            long tempSqre = i*i;
            String temp = String.valueOf(tempSqre);
            if(temp.length() > 1){
                long left = Long.parseLong(temp.substring(0, temp.length()/2));
                long right = Long.parseLong(temp.substring(temp.length()/2, temp.length()));
                if((left + right) == i){
                    System.out.print(i + " ");
                    check = false;
                }
            }
        }
        if(check)
            System.out.println("INVALID RANGE");
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int p = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int q = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        kaprekarNumbers(p, q);

        scanner.close();
    }
}
