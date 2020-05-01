import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Encryption {

    // Complete the encryption function below.
    static String encryption(String s) {
        String str = "";
        int rows = (int) Math.sqrt(s.length());
        int columns = (s.length() > rows*rows) ? rows+1 : rows;
        rows = (s.length() > rows*columns) ? rows+1 : rows;
        for(int i = 0; i < columns; i++) {
            int a = i;
            for(int j = 0; j < rows; j++) {
                if(a < s.length())
                    str += s.charAt(a);
                a += columns;
            }
            if(i+1 != columns)
                str += " ";
        }
        return str;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String s = scanner.nextLine();

        String result = encryption(s);

        bufferedWriter.write(result);
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
