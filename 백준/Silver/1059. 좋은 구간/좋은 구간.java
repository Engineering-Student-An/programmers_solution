import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
        }
        int goal = scanner.nextInt();

        Arrays.sort(arr);

        int start = 0, end = 0;
        for(int i=0;i<n;i++){
            if(arr[i]<goal) {
                start = arr[i];
            }
            if(arr[i]==goal){
                start = arr[i];
                end = arr[i];
            }
        }
        for(int i=0;i<n;i++){
            if(arr[i]>goal) {
                end = arr[i];
                break;
            }
        }
        int ans = 0;
        for (int i = start+1; i <= goal; i++) {
            for (int j = goal; j < end; j++) {
                if(i==j) continue;
                ans++;
            }
        }

        System.out.println(ans);
    }
}