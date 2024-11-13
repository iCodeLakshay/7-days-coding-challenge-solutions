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

    /*
     * Complete the 'countSort' function below.
     *
     * The function accepts 2D_STRING_ARRAY arr as parameter.
     */

    public static void countSort(List<List<String>> arr) {
        int n = arr.size();
        int maxIndex = 0;

        // Calculate the maximum integer index to define the range of our helper array
        for (List<String> pair : arr) {
            int index = Integer.parseInt(pair.get(0));
            maxIndex = Math.max(maxIndex, index);
        }

        // Initialize the helper array of lists for counting sort
        List<String>[] helper = new ArrayList[maxIndex + 1];
        for (int i = 0; i <= maxIndex; i++) {
            helper[i] = new ArrayList<>();
        }

        // Populate the helper array and replace strings in the first half with "-"
        for (int i = 0; i < n; i++) {
            int index = Integer.parseInt(arr.get(i).get(0));
            String value = (i < n / 2) ? "-" : arr.get(i).get(1);
            helper[index].add(value);
        }

        // Output the result in the correct stable order
        StringBuilder result = new StringBuilder();
        for (List<String> list : helper) {
            for (String s : list) {
                result.append(s).append(" ");
            }
        }
        System.out.println(result.toString().trim());
    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(bufferedReader.readLine().trim());

        List<List<String>> arr = new ArrayList<>();

        IntStream.range(0, n).forEach(i -> {
            try {
                arr.add(
                    Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                        .collect(toList())
                );
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        Result.countSort(arr);

        bufferedReader.close();
    }
}
