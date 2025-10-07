import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        long[] x = new long[5];
        long[] y = new long[5];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= 2; i++) {
            x[i] = Long.parseLong(st.nextToken());
            y[i] = Long.parseLong(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 3; i <= 4; i++) {
            x[i] = Long.parseLong(st.nextToken());
            y[i] = Long.parseLong(st.nextToken());
        }

        int abc = ccw(x[1], y[1], x[2], y[2], x[3], y[3]);
        int abd = ccw(x[1], y[1], x[2], y[2], x[4], y[4]);

        int cda = ccw(x[3], y[3], x[4], y[4], x[1], y[1]);
        int cdb = ccw(x[3], y[3], x[4], y[4], x[2], y[2]);

        if(abc * abd < 0 && cda * cdb < 0) System.out.println(1);
        else System.out.println(0);
    }

    static int ccw(long x1, long y1, long x2, long y2, long x3, long y3) {

        long result = (x1 * y2 + x2 * y3 + x3 * y1) - (x3 * y2 + x2 * y1 + x1 * y3);

        if(result > 0) return 1;
        else if(result < 0) return -1;
        else return 0;
    }
}