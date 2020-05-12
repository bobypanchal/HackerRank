import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Happy_Ladybugs {

    // Complete the happyLadybugs function below.
    static String happyLadybugs(String b) {
        HashMap<Character, Integer> colorFreq = new HashMap<>();
            
        for(int i = 0; i < b.length(); i++){
            Character letter = (Character) b.charAt(i);
            if(colorFreq.containsKey(letter))
                colorFreq.put(letter, colorFreq.get(letter)+1);
            else
                colorFreq.put(letter, 1);
        }
        
        for(Map.Entry<Character,Integer> frequency : colorFreq.entrySet())          
            if(frequency.getValue() < 2 && !frequency.getKey().equals((Character)'_'))
                return "NO";
        
        if(!colorFreq.containsKey('_')){
            int count = 0;
            char last = b.charAt(0);
            for(int i = 0; i < b.length(); i++){
                char curr = b.charAt(i);
                if(curr == last){
                    count++;
                } else {
                    if(count < 2)
                        return "NO";
                    else
                        count = 1;
                }
                last = curr;
            }
            return "YES";
        }
        else
            return "YES";
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int g = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int gItr = 0; gItr < g; gItr++) {
            int n = scanner.nextInt();
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            String b = scanner.nextLine();

            String result = happyLadybugs(b);

            bufferedWriter.write(result);
            bufferedWriter.newLine();
        }

        bufferedWriter.close();

        scanner.close();
    }
}
