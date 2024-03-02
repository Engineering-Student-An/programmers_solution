import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int t = scanner.nextInt();
        for (int tt = 0; tt < t; tt++) {
            int n = scanner.nextInt();
            int k = scanner.nextInt();

            int[] arr = new int[n];

            Queue<int[]> queue = new LinkedList<>();

            for (int i = 0; i < n; i++) {
                arr[i] = scanner.nextInt();

                queue.add(new int[]{i, arr[i]});
            }

            int next = -1;
            int ans = 0;
            while(next!=k) {
                int[] temp = queue.poll();
                int x = temp[1];

                boolean chk = false;
                for (int[] ints : queue) {
                    if(ints[1] > x) {
                        chk = true;
                        break;
                    }
                }
                if(chk) {
                    queue.add(temp);
                } else {
                    ans++;
                    next = temp[0];
                }
            }

            System.out.println(ans);


        }

    }

}

