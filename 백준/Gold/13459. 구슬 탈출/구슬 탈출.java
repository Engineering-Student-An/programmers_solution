import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static int n, m;
    static char[][] arr;
//    static boolean[][] visit;
    static int holeRow, holeCol;
    static int[] dirRow = {0, 1, 0, -1};
    static int[] dirCol = {1, 0, -1, 0};

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        arr = new char[n][m];
//        visit = new boolean[n][m];
        Info start = new Info();
        start.count = 0;
        for (int i = 0; i < n; i++) {
            String line = br.readLine();
            for (int j = 0; j < m; j++) {
                arr[i][j] = line.charAt(j);
                if(arr[i][j] == 'R') {
                    start.redRow = i;
                    start.redCol = j;
                    arr[i][j] = '.';
                }

                if(arr[i][j] == 'B') {
                    start.blueRow = i;
                    start.blueCol = j;
                    arr[i][j] = '.';
                }

                if(arr[i][j] == 'O') {
                    holeRow = i;
                    holeCol = j;
                    arr[i][j] = '.';
                }
            }
        }

        System.out.println(bfs(start) ? 1 : 0);
    }

    static boolean bfs(Info start) {
//        visit[start.redRow][start.redCol] = true;

        Queue<Info> queue = new LinkedList<>();
        queue.add(start);

        boolean found = false;
        while(!queue.isEmpty()) {
            Info now = queue.poll();

            if(now.count >= 10) continue;

            for (int i = 0; i < 4; i++) {
                int nextRedRow = now.redRow + dirRow[i];
                int nextRedCol = now.redCol + dirCol[i];
                int nextBlueRow = now.blueRow + dirRow[i];
                int nextBlueCol = now.blueCol + dirCol[i];

                if ((nextRedRow >= 0 && nextRedCol >= 0 && nextRedRow < n && nextRedCol < m && arr[nextRedRow][nextRedCol] != '#')
                        || (nextBlueRow >= 0 && nextBlueCol >= 0 && nextBlueRow < n && nextBlueCol < m && arr[nextBlueRow][nextBlueCol] != '#')) {
                    Info next = findNextInfo(now, i);
                    if(next == null) continue;

                    if(now.redRow == next.redRow && now.redCol == next.redCol && now.blueRow == next.blueRow && now.blueCol == next.blueCol) continue;

                    if(next.redRow == holeRow && next.redCol == holeCol && next.count <= 10) {
                        found = true;
                        break;
                    }

//                    System.out.println("next.count = " + next.count);
//                    for (int j = 0; j < n; j++) {
//                        for (int k = 0; k < m; k++) {
//                            if(next.redRow == j && next.redCol == k) System.out.print('R');
//                            else if(next.blueRow == j && next.blueCol == k) System.out.print('B');
//                            else System.out.print(arr[j][k]);
//                        }
//                        System.out.println();
//                    }
//                    System.out.println();
//                    for (int j = 0; j < n; j++) {
//                        for (int k = 0; k < m; k++) {
//                            System.out.print((visit[j][k]) ? "O" : "X");
//                        }
//                        System.out.println();
//                    }
//                    System.out.println();
//                    System.out.println();
                    queue.add(next);
                }
            }
        }

        return found;
    }

    static Info findNextInfo(Info info, int i) {

        Info now = new Info(info.redRow, info.redCol, info.blueRow, info.blueCol, info.count);

        boolean redHole = false;
        // 파란공 먼저 움직여야 할 경우
        if((i == 0 && now.blueRow == now.redRow && now.blueCol > now.redCol) || (i == 1 && now.blueRow > now.redRow && now.blueCol == now.redCol)
                || (i ==2 && now.blueRow == now.redRow && now.blueCol < now.redCol) || (i == 3 && now.blueRow < now.redRow && now.blueCol == now.redCol)) {
            // 파란공 움직이기 => 파란공이 먼저 구멍에 들어가면 Null 리턴
            while(true) {
                int br = now.blueRow + dirRow[i];
                int bc = now.blueCol + dirCol[i];

                if(br >= 0 && bc >= 0 && br < n && bc < m && arr[br][bc] != '#') {
                    if(br == holeRow && bc == holeCol) {
                        return null;
                    }
                    now.blueRow = br;
                    now.blueCol = bc;
                } else break;
            }
            // 빨간공 움직이기
            while(true) {
                int rr = now.redRow + dirRow[i];
                int rc = now.redCol + dirCol[i];

                if(rr >= 0 && rc >= 0 && rr < n && rc < m && arr[rr][rc] != '#' && (rr != now.blueRow || rc != now.blueCol)) {
                    if(rr == holeRow && rc == holeCol) {
                        now.redRow = rr;
                        now.redCol = rc;
                        now.count ++;
//                        visit[rr][rc] = true;

                        return now;
                    }
//                    visit[rr][rc] = true;
                    now.redRow = rr;
                    now.redCol = rc;
                } else break;
            }
        }
        // 아닌 모든 경우
        else {
            // 빨간공 움직이기
            while(true) {
                int rr = now.redRow + dirRow[i];
                int rc = now.redCol + dirCol[i];

                if(rr >= 0 && rc >= 0 && rr < n && rc < m && arr[rr][rc] != '#') {
                    if(rr == holeRow && rc == holeCol) {
                        now.redRow = rr;
                        now.redCol = rc;
//                        now.count ++;
//                        visit[rr][rc] = true;
                        break;
                    }
//                    visit[rr][rc] = true;
                    now.redRow = rr;
                    now.redCol = rc;
                } else break;
            }

            // 파란공 움직이기 => 파란공이 먼저 구멍에 들어가면 Null 리턴
            while(true) {
                int br = now.blueRow + dirRow[i];
                int bc = now.blueCol + dirCol[i];

                if(br >= 0 && bc >= 0 && br < n && bc < m && arr[br][bc] != '#') {

                    if(br == holeRow && bc == holeCol) {
                        return null;
                    }

                    if(br == now.redRow && bc == now.redCol) break;

                    now.blueRow = br;
                    now.blueCol = bc;
                } else break;
            }
        }

        now.count ++;
        return now;
    }

    static class Info {
        int redRow, redCol;
        int blueRow, blueCol;
        int count;

        public Info() {
        }

        public Info(int redRow, int redCol, int blueRow, int blueCol, int count) {
            this.redRow = redRow;
            this.redCol = redCol;
            this.blueRow = blueRow;
            this.blueCol = blueCol;
            this.count = count;
        }
    }
}