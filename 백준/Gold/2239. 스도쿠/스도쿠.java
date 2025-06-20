import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {

    static int[][] arr = new int[9][9];
    static boolean[][] rowVisit = new boolean[9][10];
    static boolean[][] colVisit = new boolean[9][10];
    static boolean[][][] boxVisit = new boolean[3][3][10];
    static boolean isFound = false;
    static List<Info> zeros = new ArrayList<>();

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int zero = 0;
        for (int i = 0; i < 9; i++) {
            String line = br.readLine();
            for (int j = 0; j < 9; j++) {
                arr[i][j] = line.charAt(j) - '0';
                if(arr[i][j] != 0) {
                    rowVisit[i][arr[i][j]] = true;
                    colVisit[j][arr[i][j]] = true;
                    boxVisit[i / 3][j / 3][arr[i][j]] = true;
                } else {
                    zeros.add(new Info(i, j));
                }
            }
        }

        find(0);
    }

    static void find(int index) {
        if(index == zeros.size()) {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < 9; i++) {
                for (int j = 0; j < 9; j++) {
                    sb.append(arr[i][j]);
                }
                sb.append("\n");
            }
            System.out.print(sb);
            isFound = true;
            return;
        }

        if(isFound) return;

        Info info = zeros.get(index);
        int r = info.r;
        int c = info.c;
        for (int i = 1; i <= 9; i++) {
            if(!rowVisit[r][i] && !colVisit[c][i] && !boxVisit[r/3][c/3][i]) {
                arr[r][c] = i;
                rowVisit[r][i] = true;
                colVisit[c][i] = true;
                boxVisit[r/3][c/3][i] = true;
                find(index + 1);
                arr[r][c] = 0;
                rowVisit[r][i] = false;
                colVisit[c][i] = false;
                boxVisit[r/3][c/3][i] = false;
            }

            if(isFound) return;
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