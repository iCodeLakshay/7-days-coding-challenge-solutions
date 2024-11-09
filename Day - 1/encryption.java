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

    public static String encryption(String s) {
        String noSpace = s.replaceAll("\\s","");
        int len = noSpace.length();
        
        int rows = (int) Math.floor(Math.sqrt(len));
        int cols = (int) Math.ceil(Math.sqrt(len));

        if(rows*cols < len)
            rows++;
        
        char [][]grids = new char[rows][cols];
        int index = 0;
        
        for(int i = 0; i < rows; i++) {
            for(int j = 0; j < cols; j++) {
                if(index < len) {
                    grids[i][j] = noSpace.charAt(index++);
                } else{
                    grids[i][j] = '\0';
                }
            }
        }
        StringBuilder encryptedText = new StringBuilder();
        for (int j = 0; j < cols; j++) {
            for (int i = 0; i < rows; i++) {
                if (grids[i][j] != '\0') {
                    encryptedText.append(grids[i][j]);
                }
            }
            encryptedText.append(" ");
        }
        return encryptedText.toString();
    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String s = bufferedReader.readLine();

        String result = Result.encryption(s);

        bufferedWriter.write(result);
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
