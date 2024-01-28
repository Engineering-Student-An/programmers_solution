import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Exception {

        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();

        int[] price = new int[n];
        int[] ship = new int[n];

        for (int i = 0; i < n; i++) {
            price[i] = scanner.nextInt();
            ship[i] = scanner.nextInt();
        }

        int ans = 0;
        int ans_pr = 0;

        for (int i = 0; i < n; i++) {
            int temp = 0;
            for (int j = 0; j < n; j++) {
                if(price[i] <= price[j]){
                    if(price[i] - ship[j] > 0) temp += (price[i] - ship[j]);
                }
            }
            if(temp == ans_pr && ans > price[i]){
                ans = price[i];
                ans_pr = temp;
            } else if(temp > ans_pr){
                ans = price[i];
                ans_pr = temp;
            }

        }

        System.out.println(ans);
    }
}
