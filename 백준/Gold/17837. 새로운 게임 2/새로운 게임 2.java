import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    static int n, k;
    static int[][] arr;
    static int[] dirRow = {0, 0, -1, 1};
    static int[] dirCol = {1, -1, 0, 0};
    static Info[] infos;
    static int[][][] loc;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        arr = new int[n + 2][n + 2];
        for (int i = 1; i <= n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j <= n + 1; j++) {
                if (j == 0 || j == n + 1) arr[i][j] = 2;
                else arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        for (int i = 0; i <= n + 1; i++) {
            arr[0][i] = 2;
            arr[n+1][i] = 2;
        }

        loc = new int[10][n+1][n+1];
        infos = new Info[k + 1];
        for (int i = 1; i <= k; i++) {
            st = new StringTokenizer(br.readLine());
            int r = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            int dir = Integer.parseInt(st.nextToken());

            infos[i] = new Info(r, c, dir - 1);
            loc[0][r][c] = i;
        }

        int count;
        boolean isFound = false;
        for (count = 1; count <= 1000; count++) {
            for (int i = 1; i <= k; i++) {
                Info afterMoveIndex = move(i);

                if (countHorse(afterMoveIndex.r, afterMoveIndex.c) >= 4) {
                    isFound = true;
                    break;
                }
            }

            if (isFound) break;

        }


        System.out.println((count > 1000) ? -1 : count);
    }

    static int countHorse(int r, int c) {
        int count = 0;
        for (int i = 0; i < 10; i++) {
            if(loc[i][r][c] == 0) return count;
            count ++;
        }

        return count;
    }

    static Info move(int num) {
        Info now = infos[num];

        int nr = now.r + dirRow[now.dir];
        int nc = now.c + dirCol[now.dir];

        if(arr[nr][nc] == 2) {  // 파란색 칸
            if(now.dir == 0) now.dir = 1;
            else if(now.dir == 1) now.dir = 0;
            else if(now.dir == 2) now.dir = 3;
            else now.dir = 2;

            // 반대 방향의 좌표
            nr = now.r + dirRow[now.dir];
            nc = now.c + dirCol[now.dir];

            // 반대도 파란색 칸이라면 이동 중지
            if(arr[nr][nc] == 2) return new Info(now.r, now.c, -1);
        }

        // 옮길 말들 시작~끝 인덱스 찾기
        int start = 0, end = 0;
        List<Integer> move = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            if(loc[i][now.r][now.c] == num) start = i;
            else if(loc[i][now.r][now.c] == 0) {
                end = i - 1;
                break;
            }
        }

        // 리스트로 옮길 말들 복사
        for (int i = start; i <= end; i++) {
            move.add(loc[i][now.r][now.c]);
            loc[i][now.r][now.c] = 0;
        }

        // 옮길 위치에서 쌓을 인덱스 찾기
        for (int i = 0; i < 10; i++) {
            if(loc[i][nr][nc] == 0) {
                start = i;
                break;
            }
        }

        if(arr[nr][nc] == 0) {  // 옮길 곳이 흰 칸이라면
            int m = 0;
            for (int i = start; i < start + move.size(); i++) {
                Integer moveNum = move.get(m ++);
                loc[i][nr][nc] = moveNum;
                infos[moveNum].r = nr;
                infos[moveNum].c = nc;

            }
        } else if(arr[nr][nc] == 1) {   // 빨간 칸
            int m = move.size() - 1;
            for (int i = start; i < start + move.size(); i++) {
                Integer moveNum = move.get(m --);
                loc[i][nr][nc] = moveNum;
                infos[moveNum].r = nr;
                infos[moveNum].c = nc;
            }
        }

        return new Info(nr, nc, 0);
    }

    static class Info {
        int r, c, dir;

        public Info(int r, int c, int dir) {
            this.r = r;
            this.c = c;
            this.dir = dir;
        }
    }
}