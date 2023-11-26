import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        Boolean[][] arr = new Boolean[n][n];

        for (int i = 0; i < n; i++) {
            String string = scanner.next();
            for (int j = 0; j < n; j++) {
                if(string.charAt(j)=='N') arr[i][j] = false;
                else arr[i][j] = true;
            }
        }

        int[] friend = new int[n];
        for (int i = 0; i < n; i++) {           // 현재
            Set<Integer> set = new HashSet<>();

            for (int j = 0; j < n; j++) {     // 중간 다리
                if(arr[i][j] && i!=j){
                    if(!set.contains(j)){
                        set.add(j);
                    }

                    for (int k = 0; k < n; k++) {   // 2-친구
                        if(k!=i && k!=j && arr[j][k]){
                            if(!set.contains(k)){
                                set.add(k);
                            }
                        }
                    }
                }
            }
            friend[i]=set.size();
        }
        Arrays.sort(friend);
        System.out.println(friend[friend.length-1]);
    }
}