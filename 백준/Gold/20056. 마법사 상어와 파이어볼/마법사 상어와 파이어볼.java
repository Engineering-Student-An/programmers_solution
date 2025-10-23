import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    static int n;
    static List<Fireball> arr = new ArrayList<>();
    static int[] dirRow = {-1, -1, 0, 1, 1, 1, 0, -1}, dirCol = {0, 1, 1, 1, 0, -1, -1, -1};


    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            arr.add(new Fireball(Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
        }

        while(k -- > 0) {
            // 이동
            Info[][] info = new Info[n][n]; // 최종 이동 후 파이어볼 정보

            for (Fireball fireball : arr) {
                Fireball move = move(fireball);

                if(info[move.r][move.c] == null) {
                    info[move.r][move.c] = new Info(move.m, 1, move.s, move.d);
                    info[move.r][move.c].dir[move.d] = 1;
                } else {
                    info[move.r][move.c].mSum += move.m;
                    info[move.r][move.c].sSum += move.s;
                    info[move.r][move.c].count++;
                    info[move.r][move.c].dir[move.d] ++;
                }
            }

            arr = new ArrayList<>();
            // 파이어볼 분할
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    Info now = info[i][j];
                    // 파이어볼이 하나만 있는 경우 (질량이 떨어질 일 x)
                    if (now != null && now.count == 1) {
                        arr.add(new Fireball(i, j, now.mSum, now.sSum, now.d));
                    } else if(now != null && now.count >= 2) {  // 파이어볼이 2개 이상인 경우
                        int newM = now.mSum / 5;
                        if(newM <= 0) continue;     // 질량이 0이면 추가 x

                        int newS = now.sSum / now.count;
                        
                        int even = 0;
                        int odd = 0;
                        for (int l = 0; l < 8; l++) {
                            if(l % 2 == 0) even += now.dir[l];
                            else odd += now.dir[l];
                        }
                        
                        if((even == 0 && odd > 0) || (even > 0 && odd == 0)) {
                            for (int l = 0; l < 8; l+=2) {
                                arr.add(new Fireball(i, j, newM, newS, l)); // 0, 2, 4, 6 방향의 4개 파이어볼 추가
                            }
                        } else {
                            for (int l = 1; l < 8; l+=2) {
                                arr.add(new Fireball(i, j, newM, newS, l)); // 1, 3, 5, 7 방향의 4개 파이어볼 추가
                            }
                        }
                    }
                }
            }
        }


        // 남아있는 질량 합 계산
        int result = 0;

        for (Fireball fireball : arr) {
            result += fireball.m;
        }
        System.out.println(result);
    }

    static Fireball move(Fireball fireball) {
        int s = fireball.s % n;
        int nr = fireball.r + (s * dirRow[fireball.d]);
        int nc = fireball.c + (s * dirCol[fireball.d]);

        if(nr < 0) nr += n;
        else if(nr >= n) nr -= n;

        if(nc < 0) nc += n;
        else if(nc >= n) nc -= n;

        return new Fireball(nr, nc, fireball.m, fireball.s, fireball.d);
    }

    static class Info {
        int mSum, count, sSum, d;
        int[] dir;

        public Info(int mSum, int count, int sSum, int d) {
            this.mSum = mSum;
            this.count = count;
            this.sSum = sSum;
            this.d = d;
            dir = new int[8];
        }
    }

    static class Fireball {
        int r, c, m, s, d;

        public Fireball(int r, int c, int m, int s, int d) {
            this.r = r;
            this.c = c;
            this.m = m;
            this.s = s;
            this.d = d;
        }
    }
}