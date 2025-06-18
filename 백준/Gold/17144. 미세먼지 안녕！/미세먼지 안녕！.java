import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    
    static int n, m, t;
    static int[][] arr;
    static int[] dirRow = {0, 1, 0, -1};
    static int[] dirCol = {1, 0, -1, 0};
    
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        t = Integer.parseInt(st.nextToken());

        arr = new int[n][m];
        int machineRow = 0;
        int machineCol = 0;
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
                if(arr[i][j] == -1 && machineRow == 0 && machineCol == 0) {
                    machineRow = i;
                    machineCol = j;
                }
            }
        }

        for (int T = 1; T <= t; T++) {
            diffusion();
            machine(machineRow, machineCol, true);
            machine(machineRow + 1, machineCol, false);
        }

        int count = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if(arr[i][j] > 0) count += arr[i][j];
            }
        }

        System.out.println(count);
    }

    static void machine(int machineRow, int machineCol, boolean isUpper) {

        int[][] temp = new int[n][m];

        int r = machineRow;
        int c = machineCol;

        int dir = 0;
        for (int k = 0; k < 4; k++) {

            while(true) {
                int nextRow = r + dirRow[dir];
                int nextCol = c + dirCol[dir];

                if(isUpper && nextRow >= 0 && nextCol >= 0 && nextRow <= machineRow && nextCol < m) {
                    if(arr[r][c] > 0 && arr[nextRow][nextCol] != -1) {
                        temp[nextRow][nextCol] = arr[r][c];
                    }
                } else if(!isUpper && nextRow >= machineRow && nextCol >= 0 && nextRow < n && nextCol < m) {
                    if(arr[r][c] > 0 && arr[nextRow][nextCol] != -1) {
                        temp[nextRow][nextCol] = arr[r][c];
                    }
                }

                else break;

                r = nextRow;
                c = nextCol;
            }
            dir = (isUpper) ? (dir+3) % 4 : (dir+1) % 4;
        }

        if(isUpper) {

            for (int i = 0; i <= machineRow; i++) {
                if(i > 0 && i < machineRow) {
                    arr[i][0] = (arr[i][0] != -1) ? temp[i][0] : arr[i][0];
                    arr[i][m-1] = (arr[i][m-1] != -1) ? temp[i][m-1] : arr[i][m-1];
                } else {
                    for (int j = 0; j < m; j++) {
                        arr[i][j] = (arr[i][j] != -1) ? temp[i][j] : arr[i][j];
                    }
                }
            }
        } else {
            for (int i = machineRow; i < n; i++) {
                if(i > machineRow && i < n - 1) {
                    arr[i][0] = (arr[i][0] != -1) ? temp[i][0] : arr[i][0];
                    arr[i][m-1] = (arr[i][m-1] != -1) ? temp[i][m-1] : arr[i][m-1];
                } else {
                    for (int j = 0; j < m; j++) {
                        arr[i][j] = (arr[i][j] != -1) ? temp[i][j] : arr[i][j];
                    }
                }
            }
        }
    }
    
    static void diffusion() {
        int[][] temp = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if(arr[i][j] <= 0) continue;
                int count = 0;
                for (int k = 0; k < 4; k++) {
                    int nextRow = i + dirRow[k];
                    int nextCol = j + dirCol[k];
                    if(nextRow >= 0 && nextCol >= 0 && nextRow < n && nextCol < m && arr[nextRow][nextCol] != -1) {
                        temp[nextRow][nextCol] += arr[i][j] / 5;
                        count ++;
                    }
                }

                arr[i][j] -= (arr[i][j] / 5) * count;
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                arr[i][j] += temp[i][j];
            }
        }
    }
}