import java.util.HashMap;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int t = scanner.nextInt();

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < t; i++) {
            HashMap<String, Integer> map = new HashMap<>();
            int n = scanner.nextInt();

            for (int j = 0; j < n; j++) {
                String name = scanner.next();
                String kind = scanner.next();

                if(!map.containsKey(kind)) {
                    map.putIfAbsent(kind, 1);
                } else{
                    map.put(kind, map.get(kind) + 1);
                }
            }
            int ans = 1;
            for (Integer value : map.values()) {
                ans *= (value+1);
            }
            sb.append(ans-1);
            sb.append("\n");
        }
        System.out.print(sb);


    }
}