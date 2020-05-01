import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class ACM_ICPC_Team {

    // Complete the acmTeam function below.
    static int[] acmTeam(String[] topic) {
        int a[] = new int[]{0, 0};
        for(int i = 0; i < topic.length; i++)
            for(int j = i+1; j < topic.length; j++) {
                String member1 = topic[i];
                String member2 = topic[j];
                int skillSet = 0;
                for(int k = 0; k < topic[0].length(); k++)
                    if(member1.charAt(k) == '1' || member2.charAt(k) == '1')
                        skillSet++;
                a[1] += (a[0] == skillSet) ? 1 : 0;
                if(skillSet > a[0]){
                    a[0] = skillSet;
                    a[1] = 1;
                }
            }
        return a;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String[] nm = scanner.nextLine().split(" ");

        int n = Integer.parseInt(nm[0]);

        int m = Integer.parseInt(nm[1]);

        String[] topic = new String[n];

        for (int i = 0; i < n; i++) {
            String topicItem = scanner.nextLine();
            topic[i] = topicItem;
        }

        int[] result = acmTeam(topic);

        for (int i = 0; i < result.length; i++) {
            bufferedWriter.write(String.valueOf(result[i]));

            if (i != result.length - 1) {
                bufferedWriter.write("\n");
            }
        }

        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
