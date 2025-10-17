import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        double[] arr = new double[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Double.parseDouble(br.readLine());
        }


        double[] result = new double[n];
        double max = -1;
        result[0] = arr[0];
        for (int i = 1; i < n; i++) {
            result[i] = Math.max(arr[i] * result[i - 1], arr[i]);
            max = Math.max(result[i], max);
        }

        System.out.printf("%.3f", max);
    }
}