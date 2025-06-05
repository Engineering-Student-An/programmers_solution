import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            String line = br.readLine();

            sb.append(find(line, 0, line.length() - 1, 1)).append("\n");
        }
        System.out.print(sb);
    }

    static int find(String line, int l, int r, int count) {

        int result = (count == 1) ? 0 : 1;

        while(l < r) {
            char left = line.charAt(l);
            char right = line.charAt(r);

            if(count == 2 && left != right) {
                return 2;
            }
            if(count == 1 && left != right) {
                if(line.charAt(l + 1) == right && left == line.charAt(r - 1)) {
                    return Math.min(find(line, l + 1, r, 2), find(line, l, r - 1, 2));
                } else if (line.charAt(l + 1) == right) {
                    return find(line, l + 1, r, 2);
                } else if(left == line.charAt(r - 1)) {
                    return find(line, l, r - 1, 2);
                } else {
                    return 2;
                }
            }
            l ++;
            r --;
        }
        return result;
    }
}