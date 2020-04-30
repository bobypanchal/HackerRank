import java.io.*;
import java.math.*;
import java.text.*;
import java.util.*;
import java.util.regex.*;

public class Time_Conversion {

    /*
     * Complete the timeConversion function below.
     */
    static String timeConversion(String s) {
        if(s.charAt(s.length()-2) == 'P'){
            if(!s.substring(0,2).equals("12")){
                int t = 12 + Integer.parseInt(s.substring(0,2));
                s = t + s.substring(2, s.length()-2);
            } else {
                s = s.substring(0, s.length()-2);
            }
            return s;
        } else {
            if(s.substring(0,2).equals("12"))
                s = "00" + s.substring(2, s.length()-2);
            else
                s = s.substring(0, s.length()-2);
            return s;
        }
    }

    private static final Scanner scan = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String s = scan.nextLine();

        String result = timeConversion(s);

        bw.write(result);
        bw.newLine();

        bw.close();
    }
}
