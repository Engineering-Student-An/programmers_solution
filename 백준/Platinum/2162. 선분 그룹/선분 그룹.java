import javax.sound.sampled.Line;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int n;
    static Line[] arr;
    static int[] parents;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        arr = new Line[n];
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            arr[i] = new Line(Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken()));
        }

        parents = new int[n];
        for (int i = 0; i < n; i++) {
            parents[i] = i;
        }

        for (int i = 0; i < n; i++) {
            for (int j = i+1; j < n; j++) {
                if(isCross(arr[i], arr[j])) union(i, j);
            }
        }

        for (int i = 0; i < n; i++) {
            find(i);
        }

        int[] count = new int[n];
        for (int i = 0; i < n; i++) {
            count[parents[i]] ++;
        }

        int cnt = 0;
        int max = -1;
        for (int i = 0; i < n; i++) {
            if(count[i] != 0) {
                cnt ++;
                max = Math.max(max, count[i]);
            }
        }

        System.out.println(cnt + "\n" + max);
    }
    
    static void union(int a, int b) {
        a = find(a);
        b = find(b);
        
        if(a != b) parents[Math.max(a, b)] = Math.min(a, b);
    }
    
    static int find(int a) {
        if(a == parents[a]) return a;
        
        return parents[a] = find(parents[a]);
    }

    static boolean isCross(Line one, Line two) {

        int ccw123 = ccw(one.x1, one.y1, one.x2, one.y2, two.x1, two.y1);
        int ccw124 = ccw(one.x1, one.y1, one.x2, one.y2, two.x2, two.y2);
        int ccw341 = ccw(two.x1, two.y1, two.x2, two.y2, one.x1, one.y1);
        int ccw342 = ccw(two.x1, two.y1, two.x2, two.y2, one.x2, one.y2);

        // 두 선분이 견친 경우
        if(ccw123 * ccw124 == 0 && ccw341 * ccw342 == 0) {
            return Math.min(one.x1, one.x2) <= Math.max(two.x1, two.x2) && Math.min(two.x1, two.x2) <= Math.max(one.x1, one.x2) &&
                    Math.min(one.y1, one.y2) <= Math.max(two.y1, two.y2) && Math.min(two.y1, two.y2) <= Math.max(one.y1, one.y2);
        } else return ccw123 * ccw124 <= 0 && ccw341 * ccw342 <= 0;
    }

    static int ccw(int x1, int y1, int x2, int y2, int x3, int y3) {

        int result = (x1 * y2 + x2 * y3 + x3 * y1) - (x3 * y2 + x2 * y1 + x1 * y3);
        if(result < 0) return -1;
        else if(result == 0) return 0;
        return 1;
    }

    static class Line {
        int x1;
        int y1;
        int x2;
        int y2;

        public Line(int x1, int y1, int x2, int y2) {
            this.x1 = x1;
            this.y1 = y1;
            this.x2 = x2;
            this.y2 = y2;
        }
    }
}