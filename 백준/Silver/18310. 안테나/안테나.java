import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);

        if(n % 2 == 1) System.out.println(arr[n / 2]);
        else {
            int first = arr[n / 2 - 1];
            int second = arr[n / 2];

            long firstSum = 0, secondSum = 0;
            for (int i = 0; i < n; i++) {
                firstSum += Math.abs(first - arr[i]);
                secondSum += Math.abs(second - arr[i]);
            }

            if(firstSum <= secondSum) {
                System.out.println(first);
            } else System.out.println(second);
        }
    }
}