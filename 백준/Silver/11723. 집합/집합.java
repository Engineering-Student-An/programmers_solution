import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        List<Integer> list = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            String op = st.nextToken();
            if (op.equals("all")) {
                list = new ArrayList<>();
                for (int j = 1; j <= 20; j++) {
                    list.add(j);
                }
            } else if (op.equals("empty")) {
                list = new ArrayList<>();
            } else {
                Integer x = Integer.parseInt(st.nextToken());
                if (op.equals("add") && !list.contains(x)) {
                    list.add(x);
                } else if (op.equals("remove") && list.contains(x)) {
                    list.remove(x);
                } else if (op.equals("check")) {
                    sb.append(list.contains(x) ? 1 : 0).append("\n");
                } else if (op.equals("toggle")) {
                    if (list.contains(x)) list.remove(x);
                    else list.add(x);
                }
            }
        }
        System.out.print(sb);
    }
}