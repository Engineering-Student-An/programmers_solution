import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws Exception {

        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();

        ArrayList<Integer>[] adj = new ArrayList[n+1];
        boolean[] check = new boolean[n+1];

        for (int i = 0; i <= n; i++) {
            adj[i] = new ArrayList<Integer>();
        }

        int m = scanner.nextInt();
        for (int i = 0; i < m; i++) {
            int start = scanner.nextInt();
            int end = scanner.nextInt();

            adj[start].add(end);
            adj[end].add(start);
        }

        int ans = 0;
        boolean[] cnt = cnt(adj, 1, check);
        for (int i = 2; i <= n; i++) {
            if(cnt[i]){
                ans++;
            }
        }
        System.out.println(ans);


    }

    private static boolean[] cnt(ArrayList<Integer>[] adj, int i, boolean[] check) {
        check [i] = true;
        for (Integer integer : adj[i]) {
            if(!check[integer])  {
                check[integer] = true;
                cnt(adj, integer, check);
            }
        }
        return check;


    }


}
