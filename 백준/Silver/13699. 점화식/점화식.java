import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static int n;
    static long[] arr;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        arr = new long[n + 1];
        arr[0] = 1;
        System.out.println(find(n));
    }

    static long find(int num) {
        if(arr[num] != 0) return arr[num];

        for (int i = 0; i < num; i++) {
            arr[num] += find(i) * find(num - 1 - i);
        }

        return arr[num];
    }
}