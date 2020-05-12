import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Fair_Rations {

    // Complete the fairRations function below.
    static int fairRations(int[] B) {
        int bread = 0;
        int currentBread = 0;
        
        for(int i = 0; i < B.length; i++){
            currentBread += B[i];
            if(i == B.length-1){
                if(currentBread % 2 == 1)
                    return -1;
                else
                    return bread;
            }
            if(currentBread % 2 == 1){
                currentBread = 1;
                bread += 2;
                continue;
            }
            currentBread = 0;
        }
        return -1;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int N = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int[] B = new int[N];

        String[] BItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < N; i++) {
            int BItem = Integer.parseInt(BItems[i]);
            B[i] = BItem;
        }

        int result = fairRations(B);

        if(result != -1)
            bufferedWriter.write(String.valueOf(result));
        else 
            bufferedWriter.write("NO");
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
