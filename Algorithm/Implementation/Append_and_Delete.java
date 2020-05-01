import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Append_and_Delete {

    // Complete the appendAndDelete function below.
    static String appendAndDelete(String s, String t, int k) {
        String result = "No";
        if(s.equals(t))
            result = (k >= s.length()*2 || k % 2 == 0) ? "Yes" : "No";
        else {
            int matchingCharacters = 0;
            for(int i = 0; i < Math.min(s.length(), t.length()); i++) {
                if(s.charAt(i) != t.charAt(i))
                    break;
                matchingCharacters++;
            }
            int nonMatchingCharactersInS = s.length() - matchingCharacters;
            int nonMatchingCharactersInT = t.length() - matchingCharacters;
            int nmcS = nonMatchingCharactersInS;
            int nmcT = nonMatchingCharactersInT;
            boolean conditionA = nmcS + nmcT== k;
            boolean conditionB = (nmcS + nmcT < k && (nmcS + nmcT - k) % 2 == 0 );
            boolean conditionC = s.length() + t.length() <= k;
            result = (conditionA || conditionB || conditionC) ? "Yes" : "No";
        }
        return result;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String s = scanner.nextLine();

        String t = scanner.nextLine();

        int k = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        String result = appendAndDelete(s, t, k);

        bufferedWriter.write(result);
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
