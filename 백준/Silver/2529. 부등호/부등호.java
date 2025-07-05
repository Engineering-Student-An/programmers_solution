import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int n;
    static int[] max, min;
    static char[] arr;
    static boolean[] visit;
    static boolean maxFound, minFound;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());

        arr = new char[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = st.nextToken().charAt(0);
        }

        max = new int[n+1];
        min = new int[n+1];

        for (int i = 9; i >= 0; i--) {
            visit = new boolean[10];
            max[0] = i;
            visit[i] = true;
            maxSelect(1);
            visit[i] = false;
        }

        for (int i = 0; i < 10; i++) {
            visit = new boolean[10];
            min[0] = i;
            visit[i] = true;
            minSelect(1);
            visit[i] = false;
        }


        System.out.print(sb);
    }

    static void maxSelect(int count) {
        if(count == n+1) {
            for (int i = 0; i <= n; i++) {
                sb.append(max[i]);
            }
            sb.append("\n");

            maxFound = true;
            return;
        }

        for (int i = 9; i >= 0; i--) {
            if(!visit[i]) {
                if((arr[count - 1] == '<' && i > max[count-1]) || (arr[count - 1] == '>' && i < max[count - 1])) {
                    visit[i] = true;
                    max[count] = i;
                    maxSelect(count + 1);
                    visit[i] = false;
                }
            }
            if(maxFound) return;
        }
    }

    static void minSelect(int count) {
        if(count == n+1) {
            for (int i = 0; i <= n; i++) {
                sb.append(min[i]);
            }

            minFound = true;
            return;
        }

        for (int i = 0; i < 10; i++) {
            if(!visit[i]) {
                if((arr[count - 1] == '<' && i > min[count-1]) || (arr[count - 1] == '>' && i < min[count - 1])) {
                    visit[i] = true;
                    min[count] = i;
                    minSelect(count + 1);
                    visit[i] = false;
                }
            }
            if(minFound) return;
        }
    }
}