import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = br.readLine();

        char[] arr = {'U', 'C', 'P', 'C'};
        int index = 0;
        for (int i = 0; i < line.length(); i++) {
            if(arr[index] == line.charAt(i)) {
                index ++;
            }

            if(index == 4) break;
        }

        System.out.println((index == 4) ? "I love UCPC" : "I hate UCPC");
    }
}