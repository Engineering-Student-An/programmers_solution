import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = br.readLine();

        int sum = 0;
        int index = -1;
        for (int i = 0; i < 12; i++) {
            if(line.charAt(i) != '*') {
                int c = line.charAt(i) - '0';
                sum += (i % 2 != 0) ? c * 3 : c;
            } else {
                index = i;
            }
        }

        int[] arr = new int[10];
        for (int i = 0; i < 10; i++) {
            if(index % 2 != 0) {
                arr[i] = sum + (i * 3);
            } else  arr[i] = sum + i;
        }

        for (int i = 0; i < 10; i++) {
            if((arr[i] + (line.charAt(12) - '0')) % 10 == 0) {
                System.out.println(i);
                break;
            }
        }
    }
}
