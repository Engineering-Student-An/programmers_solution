import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int n;
    static char[][] arr;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());

        arr = new char[n][3];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());

            String p = st.nextToken();
            String l = st.nextToken();
            String r = st.nextToken();
            arr[p.charAt(0) - 'A'][1] = p.charAt(0);
            arr[p.charAt(0) - 'A'][0] = l.charAt(0);
            arr[p.charAt(0) - 'A'][2] = r.charAt(0);
        }

        vlr(0);
        sb.append("\n");
        lvr(0);
        sb.append("\n");
        lrv(0);

        System.out.print(sb);
    }

    static void vlr(int index) {
        sb.append(arr[index][1]);

        if(arr[index][0] != '.') vlr(arr[index][0] - 'A');
        if(arr[index][2] != '.') vlr(arr[index][2] - 'A');
    }

    static void lvr(int index) {

        if(arr[index][0] != '.') lvr(arr[index][0] - 'A');
        sb.append(arr[index][1]);
        if(arr[index][2] != '.') lvr(arr[index][2] - 'A');
    }

    static void lrv(int index) {

        if(arr[index][0] != '.') lrv(arr[index][0] - 'A');
        if(arr[index][2] != '.') lrv(arr[index][2] - 'A');
        sb.append(arr[index][1]);
    }
}