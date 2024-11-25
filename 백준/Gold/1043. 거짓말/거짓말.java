import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    static int[] arr;

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int p = scanner.nextInt();

        int know = scanner.nextInt();
        ArrayList<Integer> knowList = new ArrayList<>();
        for (int i = 0; i < know; i++) {
            knowList.add(scanner.nextInt());
        }

        arr = new int[n+1];
        for (int i = 0; i <= n; i++) {
            arr[i] = i;
        }
        for (Integer integer : knowList) {
            arr[integer] = 0;
        }

        ArrayList<Integer>[] partyList = new ArrayList[p];
        for (int i = 0; i < p; i++) {
            partyList[i] = new ArrayList<>();

            int people = scanner.nextInt();
            for (int j = 0; j < people; j++) {
                partyList[i].add(scanner.nextInt());
            }
        }

        for (int i = 0; i < p; i++) {
            for (Integer integer : partyList[i]) {
                for (Integer integer1 : partyList[i]) {
                    union(integer, integer1);
                }
            }
        }

        int count = 0;
        for (int i = 0; i < p; i++) {
            boolean isContain = false;
            int current = partyList[i].get(0);
            for (int j = 0; j < knowList.size(); j++) {
                if(find(current).equals(find(knowList.get(j)))) {
                    isContain = true;
                    break;
                }
            }

            if(!isContain) count ++;
        }

        System.out.println(count);
    }

    private static void union(Integer a, Integer b) {

        a = find(a);
        b = find(b);

        if(!a.equals(b)) {
            if(a < b) {
                arr[b] = a;
            } else {
                arr[a] = b;
            }
        }
    }

    private static Integer find(Integer a) {

        if(arr[a] == a) {
            return a;
        }
        return arr[a] = find(arr[a]);
    }
}