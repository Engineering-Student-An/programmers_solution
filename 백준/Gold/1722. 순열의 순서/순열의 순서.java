import java.util.Scanner;

public class Main {

    static boolean[] visit;

    public static void main(String[] args) {
        
        Scanner scanner = new Scanner(System.in);
        
        int n = scanner.nextInt();
        visit = new boolean[n+1];

        int Q = scanner.nextInt();
        StringBuilder sb = new StringBuilder();

        // 미리 초기화
        long[] arr = new long[n+1];
        arr[n] = 1;
        int count = 2;
        for (int i = n-1; i > 0; i--) {
            arr[i] = arr[i+1] * (count ++);
        }

        if(Q == 1) {
            long k = scanner.nextLong();

            for (int i = 1; i < n; i++) {
                for (int cnt = 1; cnt <= n; cnt++) {
                    if(k <= arr[i+1] * cnt) {
                        int index = 0;
                        int check = 0;
                        while(check < cnt) {
                            index ++;
                            if(!visit[index]) {
                                check ++;
                            }
                        }
                        visit[index] = true;
                        sb.append(index).append(" ");
                        k -= (arr[i+1] * (cnt - 1));
                        break;
                    }
                }
            }

            for (int i = 1; i <= n; i++) {
                if(!visit[i]) sb.append(i);
            }
            System.out.print(sb);
        } else {
            long result = 1;
            for (int i = 1; i < n; i++) {
                int num = scanner.nextInt();

                int cnt = 0;
                for (int j = 1; j <= num; j++) {
                    if(!visit[j]) {
                        cnt ++;
                    }
                }

                visit[num] = true;
                result += (arr[i+1] * (cnt - 1));

            }

            System.out.println(result);
        }
    }
}