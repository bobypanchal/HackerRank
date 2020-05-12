import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Strange_Counter {

    // Complete the strangeCounter function below.
    static long strangeCounter(long t) {
        long upperBound = 4;
        long lowerBound = 1;
        long upperValue = 6;

        while(t > upperBound){
            lowerBound = upperBound;
            upperBound = (upperBound+upperValue);
            upperValue = upperBound + 2;
        }
        
        if(t == upperBound)
            return upperValue;
        else
            return (lowerBound+2 - (t-lowerBound));    

    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        long t = scanner.nextLong();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        long result = strangeCounter(t);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
