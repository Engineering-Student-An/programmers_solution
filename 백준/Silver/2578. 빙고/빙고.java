import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        Map<Integer, Info> map = new HashMap<>();

        for (int i = 0; i < 5; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 5; j++) {
                int num = Integer.parseInt(st.nextToken());
                map.put(num, new Info(i, j));
            }
        }

        boolean[][] visit = new boolean[5][5];
        for (int i = 0; i < 5; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            boolean isFound = false;
            for (int j = 1; j <= 5; j++) {
                int num = Integer.parseInt(st.nextToken());

                Info info = map.get(num);
                visit[info.r][info.c] = true;

                if(check(visit)) {
                    System.out.println(i * 5 + j);
                    isFound = true;
                    break;
                }
            }
            if(isFound) break;
        }
    }

    static boolean check(boolean[][] visit) {
        int count = 0;
        for (int i = 0; i < 5; i++) {
            boolean bingo = true;
            for (int j = 0; j < 5; j++) {
                if(!visit[i][j]) {
                    bingo = false;
                    break;
                }
            }

            if(bingo) count ++;

            bingo = true;
            for (int j = 0; j < 5; j++) {
                if(!visit[j][i]) {
                    bingo = false;
                    break;
                }
            }

            if(bingo) count ++;
        }

        if(visit[0][0] && visit[1][1] && visit[2][2] && visit[3][3] && visit[4][4]) count ++;
        if(visit[0][4] && visit[1][3] && visit[2][2] && visit[3][1] && visit[4][0]) count ++;

        if(count >= 3) return true;
        return false;
    }

    static class Info {
        int r, c;

        public Info(int r, int c) {
            this.r = r;
            this.c = c;
        }
    }
}