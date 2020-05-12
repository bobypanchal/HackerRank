import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Cavity_Map {

    // Complete the cavityMap function below.
    static String[] cavityMap(String[] grid) {
        int n = grid.length;
        int[] map = new int[n*n];
        String[] result = new String[n];

        int index = 0;
        for(int i = 0; i < n; i++)
            for(int j = 0; j < n; j++)
                map[index++] = Character.getNumericValue(grid[i].charAt(j));;
        
        String str = "";
        int count = 0;
        for(int i = 0; i < n*n; i++){    
            if(i % n != 0 && (i-(n-1)) % n != 0 && i > n-1 && i < (n*n)-n){
                int L = map[i-1];    
                int R = map[i+1];
                int T = map[i-n];
                int B = map[i+n];
                if(L < map[i]  && R < map[i] && T < map[i] && B < map[i]){
                    str += 'X';
                    continue;
                }
            }
            str += map[i];

            if((i-(n-1)) % n == 0){
                result[count++] = str;
                str = "";
            }
        }
        return result;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        String[] grid = new String[n];

        for (int i = 0; i < n; i++) {
            String gridItem = scanner.nextLine();
            grid[i] = gridItem;
        }

        String[] result = cavityMap(grid);

        for (int i = 0; i < result.length; i++) {
            bufferedWriter.write(result[i]);

            if (i != result.length - 1) {
                bufferedWriter.write("\n");
            }
        }

        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
