import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int n;
    static Info[] arr = new Info[26];
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            char m = st.nextToken().charAt(0);
            char l = st.nextToken().charAt(0);
            char r = st.nextToken().charAt(0);

            arr[m - 'A'] = new Info(l, r, m);
        }

        vlr(0);
        sb.append("\n");
        lvr(0);
        sb.append("\n");
        lrv(0);

        System.out.println(sb);
    }

    static void vlr(int index) {
        if(arr[index] == null) return;

        sb.append(arr[index].middle);

        if(arr[index].left != '.') vlr(arr[index].left - 'A');
        if(arr[index].right != '.') vlr(arr[index].right - 'A');
    }

    static void lvr(int index) {
        if(arr[index] == null) return;

        if(arr[index].left != '.') lvr(arr[index].left - 'A');
        sb.append(arr[index].middle);
        if(arr[index].right != '.') lvr(arr[index].right - 'A');
    }

    static void lrv(int index) {
        if(arr[index] == null) return;

        if(arr[index].left != '.') lrv(arr[index].left - 'A');
        if(arr[index].right != '.') lrv(arr[index].right - 'A');
        sb.append(arr[index].middle);
    }


    static class Info {
        char left, right, middle;

        public Info(char left, char right, char middle) {
            this.left = left;
            this.right = right;
            this.middle = middle;
        }
    }
}