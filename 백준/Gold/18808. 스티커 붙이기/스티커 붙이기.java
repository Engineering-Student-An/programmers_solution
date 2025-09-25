import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int n, m, k, r, c;
    static boolean[][] arr, sticker;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        arr = new boolean[n][m];
        for (int i = 0; i < k; i++) {

            st = new StringTokenizer(br.readLine());
            r = Integer.parseInt(st.nextToken());
            c = Integer.parseInt(st.nextToken());
            sticker = new boolean[r][c];

            for (int j = 0; j < r; j++) {
                st = new StringTokenizer(br.readLine());
                for (int l = 0; l < c; l++) {
                    sticker[j][l] = (Integer.parseInt(st.nextToken()) == 1);
                }
            }

            for (int j = 0; j < 4; j++) {
                if(j > 0) sticker = rotate();

                if(check()) break;
            }
        }

        int count = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if(arr[i][j]) count ++;
            }
        }
        System.out.println(count);
    }

    static boolean[][] rotate() {
        boolean[][] rotate = new boolean[c][r];
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                rotate[j][r - 1 - i] = sticker[i][j];
            }
        }


        int temp = r;
        r = c;
        c = temp;

        return rotate;
    }

    static boolean check() {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if(i + r - 1 < n && j + c - 1 < m) {
                    boolean pass = false;
                    for (int l = 0; l < r; l++) {
                        for (int o = 0; o < c; o++) {
                            if (sticker[l][o] && arr[i + l][j + o]) {
                                pass = true;
                                break;
                            }
                        }
                        if (pass) break;
                    }

                    if(!pass) {
                        for (int l = 0; l < r; l++) {
                            for (int o = 0; o < c; o++) {
                                if(sticker[l][o]) arr[i + l][j + o] = sticker[l][o];
                            }
                        }
                        return true;
                    }
                }


            }
        }

        return false;
    }
}