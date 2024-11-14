import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

class Result {
    public static String isValid(String s) {
        Map<Character, Integer> charFrequency = new HashMap<>();
        for (char c : s.toCharArray()) {
            charFrequency.put(c, charFrequency.getOrDefault(c, 0) + 1);
        }

        // Step 2: Count frequencies of frequencies
        Map<Integer, Integer> freqOfFreq = new HashMap<>();
        for (int freq : charFrequency.values()) {
            freqOfFreq.put(freq, freqOfFreq.getOrDefault(freq, 0) + 1);
        }

        // Step 3: Check conditions
        if (freqOfFreq.size() == 1) {
            // All characters have the same frequency
            return "YES";
        } else if (freqOfFreq.size() == 2) {
            // There are two distinct frequencies
            int freq1 = (int) freqOfFreq.keySet().toArray()[0];
            int count1 = freqOfFreq.get(freq1);
            int freq2 = (int) freqOfFreq.keySet().toArray()[1];
            int count2 = freqOfFreq.get(freq2);

            // Check if we can make it valid by removing one character
            if ((count1 == 1 && (freq1 == 1 || freq1 - freq2 == 1)) || 
                (count2 == 1 && (freq2 == 1 || freq2 - freq1 == 1))) {
                return "YES";
            }
        }

        // If neither condition holds, it's not valid
        return "NO";
    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String s = bufferedReader.readLine();

        String result = Result.isValid(s);

        bufferedWriter.write(result);
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
