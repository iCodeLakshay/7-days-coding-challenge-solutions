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

    private static final String[] words = {
        "zero", "one", "two", "three", "four", "five", "six", "seven", "eight","nine", "ten","eleven", "twelve", "thirteen", "fourteen", "fifteen", "sixteen", "seventeen", "eighteen","nineteen", "twenty", "twenty one", "twenty two", "twenty three", "twenty four","twenty five", "twenty six", "twenty seven", "twenty eight","twenty nine"
    };

    public static String timeInWords(int h, int m) {
        switch (m) {
            case 0:
                return words[h] + " o' clock";
            case 15:
                return "quarter past " + words[h];
            case 30:
                return "half past " + words[h];
            case 45:
                return "quarter to " + words[(h % 12) + 1];
            default:
                if (m < 30) {
                    return words[m] + " minute" + (m == 1 ? "" : "s") + " past " + words[h];
                } else {
                    return words[60 - m] + " minute" + ((60 - m) == 1 ? "" : "s") + " to " + words[(h % 12) + 1];
                }
        }
    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int h = Integer.parseInt(bufferedReader.readLine().trim());

        int m = Integer.parseInt(bufferedReader.readLine().trim());

        String result = Result.timeInWords(h, m);

        bufferedWriter.write(result);
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
