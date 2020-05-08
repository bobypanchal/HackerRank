import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Caesar_Cipher {

    // Complete the caesarCipher function below.
    static String caesarCipher(String s, int k) {
        StringBuffer result = new StringBuffer();
        for (int i = 0; i < s.length(); i++) {
            if ((int)s.charAt(i) > 64 && (int)s.charAt(i) < 91) {
                char ch = (char) (((int) s.charAt(i) + k - 65) % 26 + 65);
                result.append(ch);
            } else if((int)s.charAt(i) > 96 && (int)s.charAt(i) < 123){
                char ch = (char) (((int) s.charAt(i) + k - 97) % 26 + 97);
                result.append(ch);
            } else {
                result.append(s.charAt(i));
            }
        }
        return result.toString();

    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        String s = scanner.nextLine();

        int k = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        String result = caesarCipher(s, k);

        bufferedWriter.write(result);
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
