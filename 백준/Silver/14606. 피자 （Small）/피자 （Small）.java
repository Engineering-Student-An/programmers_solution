import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static int n;
    static int[] arr;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        arr = new int[n + 1];
        System.out.println(find(n));
    }

    static int find(int now) {
        if (now <= 1) return 0;

        if (arr[now] != 0) return arr[now];

        int a = (now % 2 == 0) ? now / 2 : now / 2 + 1;
        int b = now / 2;

        return a * b + find(a) + find(b);
    }
}