import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int[] result = new int[1002];
        int index = 0;
        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 0; i < n; i++) {
            int now = Integer.parseInt(st.nextToken());

            if(i == 0) result[index] = now;
            else {
                if(now < result[index]) {
                    result[++index] = now;
                } else if(now > result[index]) {
                    int tempIndex = index;
                    while(tempIndex >= 0 && result[tempIndex] <= now) {
                        tempIndex --;
                    }
                    result[tempIndex +1] = now;
                }
            }
        }
        System.out.println(index + 1);
    }
}