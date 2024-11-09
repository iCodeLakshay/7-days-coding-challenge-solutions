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

    public static String organizingContainers(List<List<Integer>> container) {
        int n = container.size();
        List <Integer> containerSums = new ArrayList<>();
        
        List<Integer> typeSums = new ArrayList<>();
        
        for (int i = 0; i < n; i++) {
            int contSum = 0;
            int typeSum = 0;
            
            for (int j = 0; j < n; j++) {
                contSum += container.get(i).get(j);
                typeSum += container.get(j).get(i);
            }
            containerSums.add(contSum);
            typeSums.add(typeSum);
        }
        Collections.sort(containerSums);
        Collections.sort(typeSums);
        
        return containerSums.equals(typeSums)? "Possible" : "Impossible";
    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int q = Integer.parseInt(bufferedReader.readLine().trim());

        IntStream.range(0, q).forEach(qItr -> {
            try {
                int n = Integer.parseInt(bufferedReader.readLine().trim());

                List<List<Integer>> container = new ArrayList<>();

                IntStream.range(0, n).forEach(i -> {
                    try {
                        container.add(
                            Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                                .map(Integer::parseInt)
                                .collect(toList())
                        );
                    } catch (IOException ex) {
                        throw new RuntimeException(ex);
                    }
                });

                String result = Result.organizingContainers(container);

                bufferedWriter.write(result);
                bufferedWriter.newLine();
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        bufferedReader.close();
        bufferedWriter.close();
    }
}
