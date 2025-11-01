import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        char c = st.nextToken().charAt(0);

        int m = 0;
        if(c == 'Y') m = 1;
        else if(c == 'F') m = 2;
        else m = 3;

        Set<String> set = new HashSet<>();
        for (int i = 0; i < n; i++) {
            String line = br.readLine();
            set.add(line);
        }

        System.out.println(set.size() / m);
    }
}