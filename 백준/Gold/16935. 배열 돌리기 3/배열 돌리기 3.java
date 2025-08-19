import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int n, m;
    static int[][] arr;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        int t = Integer.parseInt(st.nextToken());

        arr = new int[n][m];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        st = new StringTokenizer(br.readLine());
        for (int tt = 0; tt < t; tt++) {
            int yeonsan = Integer.parseInt(st.nextToken());

            switch (yeonsan) {
                case 1:
                    updown();
                    break;
                case 2:
                    leftright();
                    break;
                case 3:
                    rotateRight();
                    break;
                case 4:
                    rotateLeft();
                    break;
                case 5:
                    groupRotateRight();
                    break;
                case 6:
                    groupRotateLeft();
                    break;
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                sb.append(arr[i][j]).append(" ");
            }
            sb.append("\n");
        }

        System.out.print(sb);
    }

    static void updown() {
        for (int i = 0; i < n/2; i++) {
            for (int j = 0; j < m; j++) {
                swap(i, j, (n - 1 - i), j);
            }
        }
    }

    static void leftright() {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m/2; j++) {
                swap(i, j, i, (m - 1 - j));
            }
        }
    }

    static void rotateRight() {
        int[][] temp = new int[m][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                temp[j][n-1-i] = arr[i][j];
            }
        }

        swapNAndM();
        copyArr(temp);
    }

    static void rotateLeft() {
        int[][] temp = new int[m][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                temp[m-1-j][i] = arr[i][j];
            }
        }

        swapNAndM();
        copyArr(temp);

    }

    static void groupRotateRight() {
        int[][] temp = new int[n][m];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                // 1 -> 2
                if(i < n/2 && j < m/2) temp[i][j+m/2] = arr[i][j];
                // 2 -> 3
                else if(i < n/2 && j >= m/2) temp[i+n/2][j] = arr[i][j];
                // 3 -> 4
                else if(i >= n/2 && j >= m/2) temp[i][j-m/2] = arr[i][j];
                // 4 -> 1
                else temp[i-n/2][j] = arr[i][j];
            }
        }

        copyArr(temp);
    }

    static void groupRotateLeft() {
        int[][] temp = new int[n][m];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                // 1 -> 4
                if(i < n/2 && j < m/2) temp[i+n/2][j] = arr[i][j];
                // 2 -> 1
                else if(i < n/2 && j >= m/2) temp[i][j-m/2] = arr[i][j];
                // 3 -> 2
                else if(i >= n/2 && j >= m/2) temp[i-n/2][j] = arr[i][j];
                // 4 -> 3
                else temp[i][j+m/2] = arr[i][j];
            }
        }

        copyArr(temp);
    }

    static void swapNAndM() {
        int temp = n;
        n = m;
        m = temp;
    }

    static void swap(int r1, int c1, int r2, int c2) {
        int temp = arr[r1][c1];
        arr[r1][c1] = arr[r2][c2];
        arr[r2][c2] = temp;
    }

    static void copyArr(int[][] temp) {
        arr = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                arr[i][j] = temp[i][j];
            }
        }
    }
}