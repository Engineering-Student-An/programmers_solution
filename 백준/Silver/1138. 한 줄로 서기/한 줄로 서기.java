import java.util.*;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] arr = new int[n+1];

        for (int i = 1; i <= n; i++) {
            arr[i] = scanner.nextInt();
        }

        int[] answer = new int[n+1];

        answer[1+arr[1]] = 1;

        for (int i = 2; i <= n; i++) {
            int count = 0;
            for(int j=1;j<=n;j++){
                if(count == arr[i] && answer[j] == 0){
                    answer[j]= i;
                    break;
                } else {
                    if(answer[j] == 0) count++;
                }
            }
        }
        for (int i=1;i<=n;i++){
            System.out.print(answer[i] + " ");
        }
    }

}
