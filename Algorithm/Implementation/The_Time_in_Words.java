import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class The_Time_in_Words {

    // Complete the timeInWords function below.
    static String timeInWords(int h, int m) {
        h = h%12;
        m = m%60;
        HashMap<Integer, String> words = new HashMap<>();
        words.put(1,"one");
        words.put(2,"two");
        words.put(3,"three");
        words.put(4,"four");
        words.put(5,"five");
        words.put(6,"six");
        words.put(7,"seven");
        words.put(8,"eight");
        words.put(9,"nine");
        words.put(10,"ten");
        words.put(11,"eleven");
        words.put(12,"twelve");
        words.put(13,"thirteen");
        words.put(14,"fourteen");
        words.put(15,"fifteen");
        words.put(16,"sixteen");
        words.put(17,"seventeen");
        words.put(18,"eighteen");
        words.put(19,"nineteen");
        String returnStr = "";
        if(m == 0){
            returnStr = words.get(h) + " o' clock";
        } else if(m > 0 && m < 30){
            if(m < 15){
                returnStr = words.get(m) + " minute past " + words.get(h);
            } else if(m == 15) {
                returnStr = "quarter past " + words.get(h);
            } else {
                if(m < 20)
                    returnStr = words.get(m) + " minutes past " + words.get(h);
                else if(m == 20)
                    returnStr = "twenty minutes past " + words.get(h);
                else
                    returnStr = "twenty " + words.get(m-20) + " minutes past " + words.get(h);
            }
        } else if(m == 30) {
            returnStr = "half past " + words.get(h);
        } else {
            if(m < 45){
                if((60 - m) == 20)
                    returnStr = "twenty minutes to " + words.get(h+1);
                else if((60 - m) > 20)
                    returnStr = "twenty " + words.get(60-m-20) + " minutes to " + words.get(h+1);
                else
                    returnStr = words.get(60 - m) + " minutes to " + words.get(h+1);
            } else if(m == 45){
                returnStr = "quarter to " + words.get(h+1);
            } else {
                returnStr = words.get(60 - m) + " minutes to " + words.get(h+1);
            }
        }
        return returnStr;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int h = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int m = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        String result = timeInWords(h, m);

        bufferedWriter.write(result);
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
