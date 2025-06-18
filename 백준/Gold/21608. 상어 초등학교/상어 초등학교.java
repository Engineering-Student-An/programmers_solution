import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int n;
    static int[][] like, result;
    static int[] dirRow = {0, 1, 0, -1};
    static int[] dirCol = {1, 0, -1, 0};

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        int m = (int) Math.pow(n, 2);
        like = new int[m + 1][4];

        int[] seq = new int[m];
        for (int i = 0; i < m; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            seq[i] = u;
            for (int j = 0; j < 4; j++) {
                like[u][j] = Integer.parseInt(st.nextToken());
            }
        }

        result = new int[n][n];
        for (int k = 0; k < m; k++) {
            Info best = null;
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if(result[i][j] != 0) continue;

                    if(best == null) best = find(i, j, seq[k]);
                    else best = findBest(best, find(i, j, seq[k]));
                }
            }

            result[best.r][best.c] = seq[k];
        }

        int sum = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                int count = 0;
                for (int k = 0; k < 4; k++) {
                    int nr = i + dirRow[k];
                    int nc = j + dirCol[k];
                    if(nr >= 0 && nc >= 0 && nr < n && nc < n) {
                        for (int l = 0; l < 4; l++) {
                            if(result[nr][nc] == like[result[i][j]][l]) {
                                count ++;
                                break;
                            }
                        }
                    }
                }

                if(count > 0) sum += (int) Math.pow(10, count-1);
            }
        }
        System.out.println(sum);
    }

    static Info findBest(Info o1, Info o2) {
        if(o1.like == o2.like) {
            if(o1.empty == o2.empty) {
                if(o1.r == o2.r) {
                    return (o1.c < o2.c) ? o1 : o2;
                }
                return (o1.r < o2.r) ? o1 : o2;
            }
            return (o1.empty > o2.empty) ? o1 : o2;
        }
        return (o1.like > o2.like) ? o1 : o2;
    }

    static Info find(int r, int c, int now) {
        int empty = 0;
        int l = 0;
        for (int i = 0; i < 4; i++) {
            int nr = r + dirRow[i];
            int nc = c + dirCol[i];

            if(nr >= 0 && nc >= 0 && nr < n && nc < n) {
                if(result[nr][nc] == 0) empty ++;
                else {
                    boolean found = false;
                    for (int j = 0; j < 4; j++) {
                        if(result[nr][nc] == like[now][j]) {
                            found = true;
                            break;
                        }
                    }
                    if(found) l ++;
                }
            }
        }

        return new Info(r, c, l, empty);
    }

    static class Info {
        int r, c, like, empty;

        public Info(int r, int c, int like, int empty) {
            this.r = r;
            this.c = c;
            this.like = like;
            this.empty = empty;
        }
    }
}