import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    static int[][] arr;
    static List<Info> blank = new ArrayList<>();
    static boolean[][][] check = new boolean[2][9][10];
    static boolean[][][] boxCheck = new boolean[3][3][10];
    static boolean found = false;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        arr = new int[9][9];
        for (int i = 0; i < 9; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 9; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
                if(arr[i][j] == 0) blank.add(new Info(i, j));
                else {
                    check[0][i][arr[i][j]] = true; // 가로줄
                    check[1][j][arr[i][j]] = true; // 세로줄
                    boxCheck[i / 3][j / 3][arr[i][j]] = true; // 박스
                }
            }
        }

        find(0);

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                sb.append(arr[i][j]).append(" ");
            }
            sb.append("\n");
        }

        System.out.print(sb);
    }

    static void find(int index) {
        if(index == blank.size()) {
            for (int i = 0; i < 2; i++) {
                for (int j = 0; j < 9; j++) {
                    for (int k = 1; k <= 9; k++) {
                        if(!check[i][j][k]) return;
                    }
                }
            }

            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    for (int k = 1; k <= 9; k++) {
                        if(!boxCheck[i][j][k]) return;
                    }
                }
            }

            found = true;
            return;
        }

        Info now = blank.get(index);
        for (int i = 1; i <= 9; i++) {
            if(!check[0][now.r][i] && !check[1][now.c][i] && !boxCheck[now.r / 3][now.c / 3][i]) {
                check[0][now.r][i] = true;
                check[1][now.c][i] = true;
                boxCheck[now.r / 3][now.c / 3][i] = true;

                arr[now.r][now.c] = i;

                find(index + 1);

                if(found) return;

                arr[now.r][now.c] = 0;

                check[0][now.r][i] = false;
                check[1][now.c][i] = false;
                boxCheck[now.r / 3][now.c / 3][i] = false;
            }

            if(found) return;
        }
    }

    static class Info {
        int r, c;

        public Info(int r, int c) {
            this.r = r;
            this.c = c;
        }
    }
}