import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Fraudulent_Activity_Notifications {

    // Complete the activityNotifications function below.
    static int activityNotifications(int[] expenditures, int d) {
        int[] counts = new int[201];
        for (int i = 0; i < d; i++) {
            counts[expenditures[i]]++;
        }

        int result = 0;
        for (int i = d; i < expenditures.length; i++) {
            int lower = 0;
            int leftNum = 0;
            while ((leftNum + counts[lower]) * 2 <= d) {
                leftNum += counts[lower];
                lower++;
            }

            int upper = counts.length - 1;
            int rightNum = 0;
            while ((rightNum + counts[upper]) * 2 <= d) {
                rightNum += counts[upper];
                upper--;
            }

            if (expenditures[i] >= lower + upper) 
                result++;

            counts[expenditures[i - d]]--;
            counts[expenditures[i]]++;
        }
        return result;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String[] nd = scanner.nextLine().split(" ");

        int n = Integer.parseInt(nd[0]);

        int d = Integer.parseInt(nd[1]);

        int[] expenditure = new int[n];

        String[] expenditureItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < n; i++) {
            int expenditureItem = Integer.parseInt(expenditureItems[i]);
            expenditure[i] = expenditureItem;
        }

        int result = activityNotifications(expenditure, d);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
