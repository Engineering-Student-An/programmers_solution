import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int a = Integer.parseInt(br.readLine());
        boolean[][] apples = new boolean[n+1][n+1];
        StringTokenizer st;
        for (int i = 0; i < a; i++) {
            st = new StringTokenizer(br.readLine());
            int row = Integer.parseInt(st.nextToken());
            int col = Integer.parseInt(st.nextToken());

            apples[row][col] = true;
        }

        int actTimes = Integer.parseInt(br.readLine());
        Act[] acts = new Act[actTimes];
        for (int i = 0; i < actTimes; i++) {
            st = new StringTokenizer(br.readLine());
            int time = Integer.parseInt(st.nextToken());
            char act = st.nextToken().charAt(0);

            acts[i] = new Act(time, act);
        }

        boolean[][] check = new boolean[n + 1][n + 1];
        check[1][1] = true;
        Deque<Info> deque = new LinkedList<>();

        deque.add(new Info(1, 1));
        int time = 0;
        int index = 0;

        int[] rowDir = {0, 1, 0, -1};
        int[] colDir = {1, 0, -1, 0};
        int dirIdx = 0;
        while (true) {
            time ++;

            Info now = deque.getFirst();
            int nextRow = now.row + rowDir[dirIdx];
            int nextCol = now.col + colDir[dirIdx];

            if(nextRow <= 0 || nextCol <= 0 || nextRow > n || nextCol > n) {
                break;
            } else if(check[nextRow][nextCol]) {
                break;
            }


            deque.addFirst(new Info(nextRow, nextCol));
            check[nextRow][nextCol] = true;

            if(!apples[nextRow][nextCol]) {
                Info remove = deque.removeLast();
                check[remove.row][remove.col] = false;
            } else {
                apples[nextRow][nextCol] = false;
            }

            if(index < acts.length && acts[index].time == time) {
                if(acts[index].act == 'D') {
                    dirIdx = (dirIdx + 1) % 4;
                } else {
                    dirIdx = (dirIdx + 4 - 1) % 4;
                }
                index ++;
            }
        }

        System.out.println(time);
    }

    static class Act {
        int time;
        char act;

        public Act(int time, char act) {
            this.time = time;
            this.act = act;
        }
    }

    static class Info {
        int row;
        int col;

        public Info(int row, int col) {
            this.row = row;
            this.col = col;
        }
    }
}