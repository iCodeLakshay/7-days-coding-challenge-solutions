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
    public static String highestValuePalindrome(String s, int n, int k) {
        char[] chars = s.toCharArray();
        boolean[] changed = new boolean[n];
        int mismatchCount = 0;

        for (int i = 0; i < n / 2; i++) {
            if (chars[i] != chars[n - 1 - i]) {
                mismatchCount++;
                chars[i] = chars[n - 1 - i] = (char) Math.max(chars[i], chars[n - 1 - i]);
                changed[i] = true;
            }
        }

        if (mismatchCount > k) {
            return "-1";
        }

        int remainingChanges = k - mismatchCount;
        
        for (int i = 0; i < n / 2; i++) {
            if (chars[i] != '9') {
                if (changed[i] && remainingChanges > 0) {
                    chars[i] = chars[n - 1 - i] = '9';
                    remainingChanges--;
                } else if (!changed[i] && remainingChanges > 1) {
                    chars[i] = chars[n - 1 - i] = '9';
                    remainingChanges -= 2;
                }
            }
        }

        if (n % 2 == 1 && remainingChanges > 0) {
            chars[n / 2] = '9';
        }

        return new String(chars);

    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        int n = Integer.parseInt(firstMultipleInput[0]);

        int k = Integer.parseInt(firstMultipleInput[1]);

        String s = bufferedReader.readLine();

        String result = Result.highestValuePalindrome(s, n, k);

        bufferedWriter.write(result);
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
