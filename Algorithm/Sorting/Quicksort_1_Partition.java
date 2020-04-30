import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Quicksort_1_Partition {

    public static void main(String[] args) throws IOException {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        int pivot = input.nextInt();
        StringBuilder greater = new StringBuilder("");
        for(int i = 1; i < n; i++){
            int num = input.nextInt();
            if(num < pivot){
                System.out.print(num+" ");
                continue;
            }
            else
                greater.append(num+" ");
                
        }
        System.out.print(pivot+" "+greater.toString());      
    }
}
