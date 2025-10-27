import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        char[] arr = new char[n];
        String line = br.readLine();
        for (int i = 0; i < n; i++) {
            arr[i] = line.charAt(i);
        }

        // 첫 구간 확인
        int s = 0, k = 0;
        for (int i = 0; i < n / 2; i++) {
            if (arr[i] == 's') s++;
            else k++;
        }
        if (s == n / 4) {
            System.out.println(1);
            System.out.println(n / 2);
        } else {
            int start = 0;
            for (int i = n / 2; i < n; i++) {
                if (arr[start] == 's') s--;
                else k--;

                if (arr[i] == 's') s++;
                else k++;

                if (s == n / 4) {
                    System.out.println(2);
                    System.out.println((start + 1) + " " + (i + 1));
                    break;
                }

                start ++;
            }
        }
    }
}