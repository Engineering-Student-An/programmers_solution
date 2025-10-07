import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int n, h;
    static boolean[][] arr;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        h = Integer.parseInt(st.nextToken());

        arr = new boolean[h + 1][n];
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            arr[a][b] = true;
        }

        if(m == 0) System.out.println(0);
        else {
            boolean isFound = isPossible();
            if(isFound) System.out.println(0);
            else {
                for (int k = 1; k < 4; k++) {
                    if (find(k, 0)) {
                        isFound = true;
                        System.out.println(k);
                        break;
                    }
                }
            }

            if(!isFound) System.out.println(-1);
        }
    }

    static boolean find(int k, int count) {
        if(k == count) {
            return isPossible();
        }

        for (int i = 1; i <= h; i++) {
            for (int j = 1; j < n; j++) {
                if(!arr[i][j]) {
                    boolean isOkay = true;

                    if(j + 1 < n && arr[i][j+1]) isOkay = false;
                    if(j - 1 >= 1 && arr[i][j-1]) isOkay = false;

                    if(isOkay) {
                        arr[i][j] = true;
                        if(find(k, count + 1)) return true;
                        arr[i][j] = false;
                    }
                }
            }
        }

        return false;
    }

    static boolean isPossible() {
        for (int k = 1; k <= n; k++) {
            int now = k;
            for (int i = 1; i <= h; i++) {
                if(now - 1 >= 1 && arr[i][now - 1]) now --;
                else if(now < n && arr[i][now]) now ++;
            }

            if(now != k) return false;
        }

        return true;
    }
}