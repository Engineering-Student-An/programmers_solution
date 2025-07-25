import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());

        Map<Integer, Info> map = new HashMap<>();
        for (int i = 0; i < m; i++) {
            int now = Integer.parseInt(st.nextToken());

            if(map.containsKey(now)) {
                Info info = map.get(now);
                info.recommend ++;
                map.replace(now, info);
            } else if(map.size() < n) {
                Info info = new Info(1, i);
                map.put(now, info);
            } else {
                int min = Integer.MAX_VALUE;
                int date = Integer.MAX_VALUE;
                int replaceKey = 0;
                for (Map.Entry<Integer, Info> entry : map.entrySet()) {
                    int key = entry.getKey();
                    Info info = entry.getValue();

                    if(min > info.recommend) {
                        min = info.recommend;
                        date = info.date;
                        replaceKey = key;
                    } else if(min == info.recommend && date > info.date) {
                        min = info.recommend;
                        date = info.date;
                        replaceKey = key;
                    }
                }

                map.remove(replaceKey);
                map.put(now, new Info(1, i));
            }
        }

        int[] result = new int[n];
        int index = 0;
        for (Integer i : map.keySet()) {
            result[index ++] = i;
        }

        Arrays.sort(result);

        for (int i = 0; i < n; i++) {
            if(result[i] != 0) System.out.print(result[i] + " ");
        }
    }

    static class Info {
        int recommend, date;

        public Info(int recommend, int date) {
            this.recommend = recommend;
            this.date = date;
        }
    }
}