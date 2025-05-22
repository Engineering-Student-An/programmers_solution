import java.util.*;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int a = scanner.nextInt();
        int b = scanner.nextInt();

        Map<Integer, Long> map = new HashMap<>();
        map.put(a, 1L);

        Queue<Integer> queue = new LinkedList<>();
        queue.add(a);

        while (!queue.isEmpty()) {
            Integer poll = queue.poll();

            if(poll * 2 <= b && map.get(poll * 2) == null) {
                queue.add(poll * 2);
                map.put(poll * 2, map.get(poll) + 1);
            }

            if(poll <= 200000000 && poll * 10 + 1 <= b && map.get(poll * 10 +1) == null) {
                queue.add(poll * 10 + 1);
                map.put(poll * 10 + 1, map.get(poll) + 1);
            }
        }

        System.out.println(map.get(b) == null ? -1 : map.get(b));
    }
}