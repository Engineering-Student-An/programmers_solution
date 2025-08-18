import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int r, c;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        c = Integer.parseInt(st.nextToken());
        r = Integer.parseInt(st.nextToken());

        int n = Integer.parseInt(br.readLine());

        Info[] arr = new Info[n];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            arr[i] = new Info(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
        }

        st = new StringTokenizer(br.readLine());
        Info start = new Info(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));

        int sum = 0;
        for (int i = 0; i < n; i++) {
            Info now = arr[i];

            int dist = 0;
            if(start.dir == now.dir) {
                dist = Math.abs(start.num - now.num);
            } else if((Math.abs(now.dir - start.dir) == 1 && (now.dir == 1 || start.dir == 1))) {          // 북-남 (건너편)
                dist = r + Math.min(now.num + start.num, c-now.num + c-start.num);
            } else if((Math.abs(now.dir - start.dir) == 1 && (now.dir == 4 || start.dir == 4))) {   // 서-동 (건너편)
                dist = c + Math.min(now.num + start.num, r-now.num + r-start.num);
            } else {    // 건너편 제외
                if(start.dir == 1) {
                    if(now.dir == 3) dist = start.num + now.num;
                    else if(now.dir == 4) dist = (c-start.num) + now.num;
                } else if(start.dir == 2) {
                    if(now.dir == 3) dist = start.num + (r-now.num);
                    else if(now.dir == 4) dist = (c-start.num) + (r-now.num);
                } else if(start.dir == 3) {
                    if(now.dir == 1) dist = start.num + now.num;
                    else if(now.dir == 2) dist = (r-start.num) + now.num;
                } else {
                    if(now.dir == 1) dist = start.num + (c-now.num) ;
                    else if(now.dir == 2) dist = (r-start.num) + (c-now.num);
                }
            }

            sum += dist;
        }

        System.out.println(sum);
    }

    static class Info {
        int dir, num;

        public Info(int dir, int num) {
            this.dir = dir;
            this.num = num;
        }
    }
}
