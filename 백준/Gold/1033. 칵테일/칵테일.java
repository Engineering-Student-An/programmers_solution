import java.util.ArrayList;
import java.util.Scanner;
import java.util.Stack;

public class Main {

    static ArrayList<Data>[] adjacentList;

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();

        adjacentList = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            adjacentList[i] = new ArrayList<>();
        }

        long lcm = 1;
        for (int i = 0; i < n-1; i++) {
            int a = scanner.nextInt();
            int b = scanner.nextInt();
            int p = scanner.nextInt();
            int q = scanner.nextInt();

            adjacentList[a].add(new Data(b, p, q));
            adjacentList[b].add(new Data(a, q, p));

            lcm =  lcm * p*q / gcd(p, q);
        }

        long[] result = new long[n];
        result[0] = lcm;

        dfs(n, result);

        long gcd = result[0];
        for (int i = 1; i < n; i++) {
            gcd = gcd(gcd, result[i]);
        }

        for (int i = 0; i < n; i++) {
            System.out.print(result[i]/gcd + " ");
        }
    }

    private static void dfs(int n, long[] result) {

        boolean[] visit = new boolean[n];
        Stack<Integer> stack = new Stack<>();
        stack.add(0);

        while(!stack.isEmpty()) {
            Integer pop = stack.pop();
            visit[pop] = true;

            for (Data data : adjacentList[pop]) {
                if(!visit[data.num]) {
                    stack.add(data.num);
                    visit[data.num] = true;

                    result[data.num] = result[pop] * data.ratio_your / data.ratio_my;
                }
            }
        }
    }

    private static long gcd(long p, long q) {

        long max = Math.max(p, q);
        long min = Math.min(p, q);

        while (true) {
            long mod = max % min;
            if(mod == 0) break;
            max = min;
            min = mod;
        }

        return min;
    }

    static class Data {

        int num;
        int ratio_my;
        int ratio_your;

        public Data(int num, int ratio_my, int ratio_your) {
            this.num = num;
            this.ratio_my = ratio_my;
            this.ratio_your = ratio_your;
        }
    }
}