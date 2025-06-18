import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int l = Integer.parseInt(st.nextToken());

        int[][] arr = new int[n][n];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int count = 0;

        // 행
        for (int i = 0; i < n; i++) {
            int c = 0;
            int h;
            boolean[] visit = new boolean[n];
            boolean isPossible = true;

            while(c < n - 1) {

                h = arr[i][c];
                if(h == arr[i][c+1]) {      // 평지
                    c ++;
                } else if(h == arr[i][c+1] + 1) {   // 내리막길
                    for (int j = c + 1; j <= c + l; j++) {
                        if(j >= n || arr[i][j] != h-1 || visit[j]) {
                            isPossible = false;
                            break;
                        }
                        visit[j] = true;
                    }

                    if(!isPossible) break;

                    c += l;
                } else if(h == arr[i][c+1] - 1) {   // 오르막길
                    for (int j = c - l + 1; j <= c; j++) {
                        if(j < 0 || arr[i][j] != h || visit[j]) {
                            isPossible = false;
                            break;
                        }
                        visit[j] = true;
                    }

                    if(!isPossible) break;

                    c ++;
                } else {
                    isPossible = false;
                    break;
                }
            }

            if(isPossible) {
                count ++;
            }
        }

        // 열
        for (int i = 0; i < n; i++) {
            int r = 0;
            int h;
            boolean[] visit = new boolean[n];
            boolean isPossible = true;

            while(r < n - 1) {
                h = arr[r][i];
                if(h == arr[r+1][i]) {      // 평지
                    r ++;
                } else if(h == arr[r+1][i] + 1) {   // 내리막길
                for (int j = r + 1; j <= r + l; j++) {
                    if(j >= n || arr[j][i] != h-1 || visit[j]) {
                        isPossible = false;
                        break;
                    }
                    visit[j] = true;
                }

                if(!isPossible) break;

                r += l;
            } else if(h == arr[r+1][i] - 1) {   // 오르막길
                for (int j = r - l + 1; j <= r; j++) {
                    if(j < 0 || arr[j][i] != h || visit[j]) {
                        isPossible = false;
                        break;
                    }
                    visit[j] = true;
                }

                if(!isPossible) break;

                r ++;
            } else {
                    isPossible = false;
                    break;
                }
            }


            if(isPossible) {
                count ++;
            }
        }

        System.out.println(count);
    }
}