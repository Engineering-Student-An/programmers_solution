import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        while(T -- > 0) {
            int k = Integer.parseInt(br.readLine());

            PriorityQueue<Integer> minQueue = new PriorityQueue<>();
            PriorityQueue<Integer> maxQueue = new PriorityQueue<>((o1, o2) -> Integer.compare(o2, o1));
            Map<Integer, Integer> map = new HashMap<>();


            for (int i = 0; i < k; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                char c = st.nextToken().charAt(0);
                int n = Integer.parseInt(st.nextToken());

                if(c == 'I') {
                    minQueue.add(n);
                    maxQueue.add(n);
                    if(map.get(n) != null) map.replace(n, map.get(n) + 1);
                    else map.put(n, 1);
                } else {
                    if(n == -1) {
                        while(!minQueue.isEmpty()) {
                            Integer del = minQueue.poll();

                            if(map.get(del) != null) {
                                if(map.get(del) > 1) map.replace(del, map.get(del) - 1);
                                else if(map.get(del) == 1) map.remove(del);
                                break;
                            }
                        }
                    } else {
                        while(!maxQueue.isEmpty()) {
                            Integer del = maxQueue.poll();

                            if(map.get(del) != null) {
                                if(map.get(del) > 1) map.replace(del, map.get(del) - 1);
                                else if(map.get(del) == 1) map.remove(del);
                                break;
                            }
                        }
                    }
                }
            }

            boolean isEmpty = true;
            while (!maxQueue.isEmpty()) {
                Integer m = maxQueue.poll();
                if(map.get(m) != null && map.get(m) >= 1) {
                    sb.append(m).append(" ");
                    isEmpty = false;
                    break;
                }
            }

            if(!isEmpty) {
                while (!minQueue.isEmpty()) {
                    Integer m = minQueue.poll();
                    if(map.get(m) != null && map.get(m) >= 1) {
                        sb.append(m).append(" ");
                        break;
                    }
                }
            } else sb.append("EMPTY");
            sb.append("\n");
        }

        System.out.print(sb);
    }
}