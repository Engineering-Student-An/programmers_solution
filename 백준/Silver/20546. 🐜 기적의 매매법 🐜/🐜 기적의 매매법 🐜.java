import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int[] a = new int[2];
        int[] b = new int[2];
        a[0] = Integer.parseInt(br.readLine());
        b[0] = a[0];

        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] arr = new int[14];
        for (int i = 0; i < 14; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 0; i < 14; i++) {
            int today = arr[i];

            if(today <= a[0]) {
                a[1] += a[0] / today;
                a[0] %= today;
            }

            if(i >= 3) {
                if(arr[i-3] > arr[i-2] && arr[i-2] > arr[i-1] && arr[i-1] > arr[i]) {
                    b[1] += b[0] / today;
                    b[0] %= today;
                } else if(arr[i-3] < arr[i-2] && arr[i-2] < arr[i-1] && arr[i-1] < arr[i]) {
                    b[0] += today * b[1];
                    b[1] = 0;
                }
            }
        }

        int aSum = a[0] + (arr[13] * a[1]);
        int bSum = b[0] + (arr[13] * b[1]);

        if(aSum > bSum) System.out.println("BNP");
        else if(aSum < bSum) System.out.println("TIMING");
        else System.out.println("SAMESAME");
    }
}