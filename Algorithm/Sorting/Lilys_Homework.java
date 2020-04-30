import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.regex.*;
import java.util.stream.*;
import java.util.function.Function;

public class Lilys_Homework {

    // Complete the lilysHomework function below.
    static int findSwapNum(int[] arr, int[] target) {
        int[] current = Arrays.copyOf(arr, arr.length);
        Map<Integer, Integer> valueToIndex = IntStream.range(0, current.length).boxed().collect(Collectors.toMap(i -> current[i], Function.identity()));

        int swapNum = 0;
        for (int i = 0; i < current.length; i++) {
            if (current[i] != target[i]) {
                int otherIndex = valueToIndex.get(target[i]);

                valueToIndex.put(target[i], i);
                valueToIndex.put(current[i], otherIndex);

                //SWAP
                int temp = current[i];
                current[i] = current[otherIndex];
                current[otherIndex] = temp;

                swapNum++;
            }
        }
        return swapNum;
    }
    
    static int lilysHomework(int[] arr) {
        
        int[] ascending = Arrays.copyOf(arr, arr.length);
        Arrays.sort(ascending);

        int[] descending = new int[arr.length];
        int temp = arr.length-1;
        for(int i=0; i<arr.length; i++){
            descending[temp] = ascending[i];
            temp--;
        }
        return Math.min(findSwapNum(arr, ascending), findSwapNum(arr, descending));
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

        int result = lilysHomework(arr);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
