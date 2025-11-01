import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String line = br.readLine();
        String[] arr = line.split(":");

        int a = Integer.parseInt(arr[0]);
        int b = Integer.parseInt(arr[1]);

        long lcs = lcs(a, b);
        System.out.println((a / lcs) + ":" + (b / lcs));
    }

    static long lcs(int a, int b) {
        if(a > b) {
            int temp = a;
            a = b;
            b = temp;
        }

        while(a > 0) {
            int mod = b % a;
            b = a;
            a = mod;
        }

        return b;
    }
}