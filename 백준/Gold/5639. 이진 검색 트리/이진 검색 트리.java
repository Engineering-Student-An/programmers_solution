import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class Main {

    static Map<Integer, Info> map = new HashMap<>();
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int root = 0;
        while (true) {
            String line = br.readLine();
            if(line == null || line.isEmpty()) break;

            int n = Integer.parseInt(line);
            // 루트 노드
            if(map.isEmpty()) {
                map.put(n, new Info(n, Integer.MAX_VALUE));
                root = n;
            } else {
                int index = root;
                while(true) {

                    Info now = map.get(index);

                    if(n < now.n) {
                        if(now.l == 0) {
                            now.l = n;
                            map.replace(now.n, now);
                            map.put(n, new Info(n, now.n));

                            break;
                        } else {
                            index = now.l;
                        }
                    } else {
                        if(now.r == 0) {
                            now.r = n;
                            map.replace(now.n, now);
                            map.put(n, new Info(n, now.n));

                            break;
                        } else {
                            index = now.r;
                        }
                    }
                }
            }
        }
        
        print(root);

        System.out.print(sb);
    }

    static void print(int n) {
        Info now = map.get(n);

        if(now.l != 0) print(now.l);
        if(now.r != 0) print(now.r);

        sb.append(now.n).append("\n");
    }

    static class Info {
        int n, l, r, p;

        public Info() {
        }

        public Info(int n, int p) {
            this.n = n;
            this.p = p;
        }

        public Info(int n, int l, int r, int p) {
            this.n = n;
            this.l = l;
            this.r = r;
            this.p = p;
        }
    }
}