import java.util.Scanner;

public class Main {
    public static int n, s;
    public static int count = 0;
    public static void dfs(int index, int sum, int[] arr){
        if(index==n) return;
        if(sum + arr[index] ==s) count ++;

        dfs(index+1, sum, arr);

        dfs(index+1, sum+arr[index], arr);
    }

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt();
        s = scanner.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
        }

        dfs(0,0, arr);

        System.out.println(count);
    }
}