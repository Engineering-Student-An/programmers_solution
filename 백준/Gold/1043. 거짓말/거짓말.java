import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        ArrayList<Integer> truthKnow = new ArrayList<>();

        int truth = scanner.nextInt();
        for(int i=0;i<truth;i++){
            truthKnow.add(scanner.nextInt());
        }

        int[] parent = new int[n+1];
        for(int i=1;i<=n;i++) parent[i]=i;

        ArrayList[] party = new ArrayList[m];
        for(int i=0;i<m;i++){
            party[i] = new ArrayList<>();
            int p = scanner.nextInt();
            for (int j = 0; j < p; j++) {
                party[i].add(scanner.nextInt());
            }
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < party[i].size(); j++) {
                for (int k = 0; k < party[i].size(); k++) {

                        union((Integer) party[i].get(j),(Integer) party[i].get(k), parent);


                }
            }
        }
        int sum = 0;
        for (int i = 0; i < m; i++) {
            if(!isContain(party[i], truthKnow,parent)) {
                sum++;
            }
        }
        System.out.println(sum);
    }

    private static boolean isContain(ArrayList<Integer> arrayList, ArrayList<Integer> truthKnow, int[] parent) {
        for(int i=0;i<arrayList.size();i++){
            for (int j = 0; j < truthKnow.size(); j++) {
                if(find( arrayList.get(i), parent) == find(truthKnow.get(j), parent)) return true;
            }
        }

        return false;
    }


    private static int find(int i, int[] parent) {
        if(parent[i]==i) return i;
        return find(parent[i], parent);
    }
    private static void union(int j, int k, int[] parent) {
        if (find(j, parent) != find(k, parent)) {
            parent[find(j,parent)] = find(k, parent);
        }
    }


}