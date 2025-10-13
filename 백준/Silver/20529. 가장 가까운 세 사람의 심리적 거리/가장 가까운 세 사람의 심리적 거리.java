import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        while(T -- > 0) {
            int n = Integer.parseInt(br.readLine());
            if(n >= 33) {
                br.readLine();
                sb.append(0).append("\n");
            }
            else {
                String[] arr = new String[n];
                StringTokenizer st = new StringTokenizer(br.readLine());
                for (int i = 0; i < n; i++) {
                    arr[i] = st.nextToken();
                }

                int min = Integer.MAX_VALUE;
                for (int i = 0; i < n-2; i++) {
                    for (int j = i+1; j < n-1; j++) {
                        for (int k = j+1; k < n; k++) {
                            min = Math.min(min, calc(new String[]{arr[i], arr[j], arr[k]}));
                        }
                    }
                }

                sb.append(min).append("\n");
            }
        }

        System.out.print(sb);
    }

    static int calc(String[] arr) {

        int count = 0;

        for (int i = 0; i < 3; i++) {
            String a = arr[i];
            String b = arr[(i + 1) % 3];
            for (int k = 0; k < 4; k++) {
                if(a.charAt(k) != b.charAt(k)) {
                    count ++;
                }
            }
        }

        return count;
    }
}