import java.io.*;
import java.util.*;
import java.lang.Math;

public class Non_Divisible_Subset {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int N = input.nextInt();
        int K = input.nextInt();
        int nonDivisibleSubsetCardinality = 0;
        int[] modulusBuckets = new int[K];
        for(int i = 0; i < N; i++) {
            int bucket = input.nextInt() % K;
            modulusBuckets[bucket] += 1;
        }
        nonDivisibleSubsetCardinality += (modulusBuckets[0] >= 1) ? 1 : 0;
        nonDivisibleSubsetCardinality += (K%2 == 0 && modulusBuckets[K/2] >= 1) ? 1 : 0;
        int maxBuckets = 0;
        if(K%2 == 0)
            maxBuckets = (K/2)-1;
        else
            maxBuckets = K/2;
        for(int i = 1; i <= maxBuckets; i++)
            nonDivisibleSubsetCardinality += Math.max(modulusBuckets[i], modulusBuckets[K-i]);
        System.out.println(nonDivisibleSubsetCardinality);
    }
}
