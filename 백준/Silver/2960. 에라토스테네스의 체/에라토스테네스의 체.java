import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        boolean[] visit = new boolean[n+1];
        int count = 0;
        int result = -1;
        for (int i = 2; i <= n; i++) {
            if(!visit[i]) {
                count ++;

                if(count == k) {
                    result = i;
                    break;
                }

                for (int j = 2; j * i <= n; j++) {
                    if(!visit[j*i]) {
                        count ++;
                        visit[j*i] = true;
                        if(count == k) {
                            result = j*i;
                            break;
                        }
                    }
                }
            }
        }

        System.out.println(result);
    }
}