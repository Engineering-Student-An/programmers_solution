import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[] lines = {3, 2, 1, 2, 4, 3, 1, 3, 1, 1, 3, 1, 3, 2, 1, 2, 2, 2, 1, 2, 1, 1, 1, 2, 2, 1};
        int[] num = new int[n + m];
        st = new StringTokenizer(br.readLine());

        String a = st.nextToken();
        String b = st.nextToken();

        for (int i = 0; i < Math.min(n, m); i++) {
            num[i * 2] = lines[a.charAt(i) - 'A'];
            num[i * 2 + 1] = lines[b.charAt(i) - 'A'];
        }

        int index = Math.min(n, m) * 2;
        int c = Math.min(n, m);
        while (index < n + m) {
            if(n > m) num[index] = lines[a.charAt(c) - 'A'];
            else num[index] = lines[b.charAt(c) - 'A'];
            c ++;
            index ++;
        }

        for (int i = 0; i < n + m - 2; i++) {
            int[] temp = new int[n + m];

            for (int j = 0; j < num.length - i - 1; j++) {
                temp[j] = (num[j] + num[j + 1]) % 10;
            }

            for (int j = 0; j < num.length - i - 1; j++) {
                num[j] = temp[j];
            }
        }

        if(num[0] == 0) System.out.println(num[1] + "%");
        else System.out.println(num[0] + "" + num[1] + "%");
    }
}