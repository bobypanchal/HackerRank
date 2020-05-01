import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Equalize_the_Array {

    public static void main(String[] args) throws IOException {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        int itemsToDelete = 0;
        int highestFrequency = 1;
        HashMap<Integer, Integer> numberFrequency = new HashMap<>();
        for(int i = 0; i < n; i++) {
            int curr = input.nextInt();
            if(numberFrequency.get(curr) == null)
                numberFrequency.put(curr, 1);
            else {
                int newFrequency = numberFrequency.get(curr) + 1;
                numberFrequency.put(curr, newFrequency);
                highestFrequency = (newFrequency > highestFrequency) ? newFrequency : highestFrequency;
            }
        }
        itemsToDelete = n - highestFrequency;
        System.out.println(itemsToDelete);
    }
}
