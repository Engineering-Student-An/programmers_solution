import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main{
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();

        Queue<Integer> queue = new LinkedList<>();

        for (int i = 1; i <= n; i++) {
            queue.add(i);
        }

        while(!queue.isEmpty()){
            int up = queue.poll();
            System.out.print(up + " ");
            if(queue.isEmpty()) break;
            int down = queue.poll();
            queue.add(down);
        }
    }
}