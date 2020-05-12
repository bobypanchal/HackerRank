import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Flatland_Space_Stations {

    // Complete the flatlandSpaceStations function below.
    static int flatlandSpaceStations(int n, int[] c) {
        int[] map = new int[n];
        int[] distanceMap = new int[n];
        
        int leftNearest = n+1;
        int rightNearest = -1;
        int maxDistance  = 0;
        
        for(int i = 0; i < c.length; i++){
            int spacestation = c[i];
            map[spacestation] = 1;
            rightNearest = (spacestation > rightNearest) ? spacestation : rightNearest;
            leftNearest = (spacestation < leftNearest) ? spacestation : leftNearest;
        }
        
        for(int i = 0; i < n; i++){
            if(map[i] == 1){
                distanceMap[i] = 0;
                leftNearest = i;
            }
            else
                distanceMap[i] = (i - leftNearest > 0) ? (i - leftNearest) : n+1;
        }
        for(int i = n-1; i>= 0; i--){
            if(map[i] == 1)
                rightNearest = i;
            else
                if(rightNearest > i)
                    distanceMap[i] = (distanceMap[i] > rightNearest - i) ? rightNearest - i : distanceMap[i];
            maxDistance = (distanceMap[i] > maxDistance) ? distanceMap[i] : maxDistance;
        }

        return maxDistance;

    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String[] nm = scanner.nextLine().split(" ");

        int n = Integer.parseInt(nm[0]);

        int m = Integer.parseInt(nm[1]);

        int[] c = new int[m];

        String[] cItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < m; i++) {
            int cItem = Integer.parseInt(cItems[i]);
            c[i] = cItem;
        }

        int result = flatlandSpaceStations(n, c);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
