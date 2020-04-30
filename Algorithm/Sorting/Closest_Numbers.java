import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Closest_Numbers {

    // Complete the closestNumbers function below.
    static int[] closestNumbers(int[] array) {
        Arrays.sort(array);
        int minAbs = Integer.MAX_VALUE;
        StringBuilder pairs = new StringBuilder("");
        List<Integer> ar = new ArrayList<>();
        for(int i = 0; i < array.length-1; i++){
            int absDiff;
            
            if((array[i]<0 && array[i+1]<0)||(array[i]>0 && array[i+1]>0))
                absDiff = Math.abs(array[i] - array[i+1]);
            else
                absDiff = Math.abs(array[i]) + Math.abs(array[i+1]);
            
            if(absDiff < minAbs){
                minAbs = absDiff;
                ar.clear();
                ar.add(array[i]);
                ar.add(array[i+1]);
            }
            else if(absDiff == minAbs){
                ar.add(array[i]);
                ar.add(array[i+1]);
            }
        }
        int a[] = new int[ar.size()];
        for(int i=0; i<ar.size(); i++)
            a[i] = ar.get(i);
        return a;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int[] arr = new int[n];

        String[] arrItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < n; i++) {
            int arrItem = Integer.parseInt(arrItems[i]);
            arr[i] = arrItem;
        }

        int[] result = closestNumbers(arr);

        for (int i = 0; i < result.length; i++) {
            bufferedWriter.write(String.valueOf(result[i]));

            if (i != result.length - 1) {
                bufferedWriter.write(" ");
            }
        }

        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
