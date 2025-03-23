import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int[] parent;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int p = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int k = Integer.parseInt(st.nextToken());

        parent = new int[n+1];
        for (int i = 1; i <= n; i++) {
            parent[i] = i;
        }

        int[] knowList = new int[k];
        for (int i = 0; i < k; i++) {
            knowList[i] = Integer.parseInt(st.nextToken());
            parent[knowList[i]] = 0;
        }

        int[][] partyList = new int[p][n];
        for (int i = 0; i < p; i++) {
            st = new StringTokenizer(br.readLine());
            int peopleCount = Integer.parseInt(st.nextToken());
            for (int j = 0; j < peopleCount; j++) {
                partyList[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 0; i < p; i++) {
            for (int j = 1; j < n; j++) {
                if(partyList[i][j] == 0) break;

                union(partyList[i][j-1], partyList[i][j]);
            }
        }

        int count = 0;
        for (int i = 0; i < p; i++) {
            boolean isPossible = true;
            for (int j = 0; j < n; j++) {
                if(partyList[i][j] == 0) break;

                if(find(partyList[i][j]) == 0) {
                    isPossible = false;
                    break;
                }
            }

            if(isPossible) count ++;
        }

        System.out.println(count);
    }

    static void union(int a, int b) {
        a = find(a);
        b = find(b);

        if(a!=b) {
            parent[Math.max(a, b)]=Math.min(a, b);
        }
    }

    static int find(int a) {
        if(a == parent[a]) return a;

        return parent[a] = find(parent[a]);
    }
}