import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {

    static boolean[][] visit;
    static Move[] moves;
    static StringBuilder sb;
    static int[] possible = new int[3];

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        possible[0] = scanner.nextInt();
        possible[1] = scanner.nextInt();
        possible[2] = scanner.nextInt();

        visit = new boolean[possible[0]+1][possible[2]+1];

        moves = new Move[6];
        int index = 0;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if(i != j) {
                    moves[index ++] = new Move(i, j);
                }
            }
        }

        sb = new StringBuilder();
        bfs();

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i <= possible[2]; i++) {
            if(visit[0][i]) {
                sb.append(i).append(" ");
            }
        }

        System.out.println(sb);
    }

    static void bfs() {
        // a , c
        visit[0][possible[2]] = true;
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{0, 0, possible[2]});

        while (!queue.isEmpty()) {
            int[] poll = queue.poll();

            for (int i = 0; i < 6; i++) {

                int[] temp = {poll[0], poll[1], poll[2]};
                int start = temp[moves[i].start];
                int end = temp[moves[i].end];

                if(start <= 0) continue;

                int difference = Math.min(possible[moves[i].end] - end, start);

                temp[moves[i].start] -= difference;
                temp[moves[i].end] += difference;

                if(!visit[temp[0]][temp[2]]) {
                    visit[temp[0]][temp[2]] = true;
                    queue.add(new int[] {temp[0], temp[1], temp[2]});
                }
            }
        }
    }

    static class Now {
        int a;
        int b;
        int c;

        public Now (int a, int b, int c) {
            this.a = a;
            this.b = b;
            this.c = c;
        }
    }

    static class Move {
        int start;
        int end;

        public Move(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }
}