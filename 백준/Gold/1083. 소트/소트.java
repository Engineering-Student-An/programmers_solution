import java.util.*;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        List<Integer> arr = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            arr.add(scanner.nextInt());
        }
        int s = scanner.nextInt();
        Integer[] sort = new Integer[n];
        for (int i = 0; i < n; i++) {
            sort[i] = arr.get(i);
        }
        Arrays.sort(sort, Collections.reverseOrder());

        while (!eq(arr, sort) && s > 0) {
            for (int i = 0; i < n-1; i++) {
                int max = arr.get(i);
                for (int j = i+1; j < n; j++) {
                    if(j-i <= s && max<arr.get(j)){
                        max = arr.get(j);
                    }
                }
                s = s - arr.indexOf(max) + i;
                arr.remove(arr.indexOf(max));
                arr.add(i, max);

                if(s<=0) break;
            }

        }

        for (Integer integer : arr) {
            System.out.print(integer + " ");
        }
    }

    private static boolean eq(List<Integer> arr, Integer[] sort) {
        for (int i = 0; i < arr.size(); i++) {
            if(!arr.get(i).equals(sort[i])) return false;
        }
        return true;
    }
}