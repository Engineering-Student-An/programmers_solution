import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static Line[] arr;
    static int[] parent;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        arr = new Line[n];
        parent = new int[n];
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int x1 = Integer.parseInt(st.nextToken());
            int y1 = Integer.parseInt(st.nextToken());
            int x2 = Integer.parseInt(st.nextToken());
            int y2 = Integer.parseInt(st.nextToken());

            parent[i] = i;
            arr[i] = new Line(x1, y1, x2, y2);
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if(i!=j) {
                    int ccw1 = ccw(arr[i].x1, arr[i].y1, arr[i].x2, arr[i].y2, arr[j].x1, arr[j].y1);
                    int ccw2 = ccw(arr[i].x1, arr[i].y1, arr[i].x2, arr[i].y2, arr[j].x2, arr[j].y2);
                    int ccw3 = ccw(arr[j].x1, arr[j].y1, arr[j].x2, arr[j].y2, arr[i].x1, arr[i].y1);
                    int ccw4 = ccw(arr[j].x1, arr[j].y1, arr[j].x2, arr[j].y2, arr[i].x2, arr[i].y2);
                    int result1 = ccw1 * ccw2;
                    int result2 = ccw3 * ccw4;

                    if (result1 == 0 && result2 == 0) {
                        if(isOverlap(arr[i].x1, arr[i].y1, arr[i].x2, arr[i].y2, arr[j].x1, arr[j].y1, arr[j].x2, arr[j].y2)) {
                            union(i, j);
                        }
                    } else if (result1 <= 0 && result2 <= 0) {
                        union(i, j);
                    }
                }
            }
        }

        int[] check = new int[3000];
        int maxSum = -1;
        int count = 0;
        for (int i = 0; i < n; i++) {
            find(i);
        }
        for (int i = 0; i < n; i++) {
            check[parent[i]] ++;
        }

        for (int i = 0; i < 3000; i++) {
            if(check[i] > 0) {
                count ++;
                maxSum = Math.max(maxSum, check[i]);
            }
        }

        System.out.println(count);
        System.out.println(maxSum);
    }

    static boolean isOverlap(int x1, int y1, int x2, int y2, int x3, int y3, int x4, int y4) {

        if(Math.max(x1, x2) < Math.min(x3, x4) || Math.max(x3, x4) < Math.min(x1, x2) ||
                Math.max(y1, y2) < Math.min(y3, y4) || Math.max(y3, y4) < Math.min(y1, y2)) return false;
        return true;
    }

    static int ccw(int x1, int y1, int x2, int y2, int x3, int y3) {
        long result = ((long) x1 * y2 + (long) x2 * y3 + (long) x3 * y1) - ((long) x2 * y1 + (long) x3 * y2 + (long) x1 * y3);
        if(result < 0) return -1;
        else if(result > 0) return 1;
        else return 0;
    }

    static void union(int i, int j) {
        i = find(i);
        j = find(j);

        if(i!=j) {
            parent[j] = i;
        }
    }

    static int find(int i) {
        if(parent[i] == i) return i;

        return parent[i] = find(parent[i]);
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