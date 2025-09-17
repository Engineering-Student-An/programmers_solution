import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        Info head = new Info(-1, "");
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            int m = Integer.parseInt(st.nextToken());
            Info now = head;
            for (int j = 0; j < m; j++) {
                String word = st.nextToken();
                
                if(!now.set.contains(word)) {
                    Info next = new Info(now.depth + 1, word);
                    now.list.add(next);
                    now.set.add(word);
                    now = next;
                } else {
                    for (Info info : now.list) {
                        if(info.word.equals(word)) {
                            now = info;
                        }
                    }
                }
            }
        }

        sortAndPrint(head);

        System.out.print(sb);
    }

    static void sortAndPrint(Info now) {
        if(now.depth >= 0) sb.append("--".repeat(now.depth)).append(now.word).append("\n");

        if(now.list.isEmpty()) return;

        now.list.sort(new Comparator<Info>() {
            @Override
            public int compare(Info o1, Info o2) {
                return o1.word.compareTo(o2.word);
            }
        });

        for (Info next : now.list) {
            sortAndPrint(next);
        }
    }

    static class Info {
        int depth;
        String word;
        Set<String> set = new HashSet<>();
        List<Info> list = new ArrayList<>();

        public Info(int depth, String word) {
            this.depth = depth;
            this.word = word;
        }
    }
}