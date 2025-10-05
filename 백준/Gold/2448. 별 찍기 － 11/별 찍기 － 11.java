import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static int n;
    static boolean[][] arr;
    static boolean[][] tri = new boolean[3][5];

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        tri[0][2] = true;
        tri[1][1] = tri[1][3] = true;
        for (int i = 0; i < 5; i++) tri[2][i] = true;

        arr = new boolean[n][n * 2 - 1];
        find(0, 0, n);

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n * 2 - 1; j++) {
                sb.append(arr[i][j] ? "*" : " ");
            }
            sb.append("\n");
        }

        System.out.print(sb);
    }

    static void find(int r, int c, int num) {
        if(num < 3) return;
        if(num == 3) {
            for (int i = r; i < r + 3; i++) {
                for (int j = c; j < c + 5; j++) {
                    arr[i][j] = tri[i - r][j - c];
                }
            }

            return;
        }

        // 상단
        find(r, c + (num / 2), num / 2);

        // 좌하단
        find(r + (num / 2), c, num / 2);

        // 우하단
        find(r + (num / 2), c + num, num / 2);
    }
}

/*
                       *
                      * *
                     *****
                    *     *
                   * *   * *
                  ***** *****
                 *           *
                * *         * *
               *****       *****
              *     *     *     *
             * *   * *   * *   * *
            ***** ***** ***** *****
           *                       *
          * *                     * *
         *****                   *****
        *     *                 *     *
       * *   * *               * *   * *
      ***** *****             ***** *****
     *           *           *           *
    * *         * *         * *         * *
   *****       *****       *****       *****
  *     *     *     *     *     *     *     *
 * *   * *   * *   * *   * *   * *   * *   * *
***** ***** ***** ***** ***** ***** ***** *****
 */