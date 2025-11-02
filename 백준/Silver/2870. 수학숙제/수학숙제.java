import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());

        PriorityQueue<String> queue = new PriorityQueue<>(new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                if(o1.equals(o2)) return 1;

                if(o1.length() > o2.length()) return 1;
                else if(o1.length() < o2.length()) return -1;
                else {
                    for (int i = 0; i < o1.length(); i++) {
                        char c1 = o1.charAt(i);
                        char c2 = o2.charAt(i);

                        if(c1 > c2) return 1;
                        else if(c1 < c2) return -1;
                    }
                }

                return 1;
            }
        });
        for (int i = 0; i < t; i++) {
            String line = br.readLine();

            int n = line.length();
            int index = 0;

            while(index < n) {
                char c = line.charAt(index);
                if(c >= 'a' && c <= 'z') {
                    index ++;
                } else {
                    String num = "";
                    while(index < n && line.charAt(index) >= '0' && line.charAt(index) <= '9') {
                        if(num.isEmpty() && line.charAt(index) == '0') {
                            index ++;
                            continue;
                        }

                        num += line.charAt(index);
                        index ++;
                    }
                    queue.add(num.isEmpty() ? "0" : num);
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        while (!queue.isEmpty()) {
            sb.append(queue.poll()).append("\n");
        }

        System.out.print(sb);
    }
}