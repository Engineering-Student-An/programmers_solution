import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();

        int[][] arr = new int[n + 1][6];
        int[] count = new int[n+1];

        for(int i=1;i<=n;i++){
            for(int j=1;j<=5;j++){
                arr[i][j] = scanner.nextInt();
            }
        }

        for(int i=1;i<=n;i++){
            for(int j=i+1;j<=n;j++){
                for(int k=1;k<=5;k++){
                    if(arr[i][k]==arr[j][k]){
                        count[i]++;
                        count[j]++;
                        break;
                    }
                }
            }
        }
        int max=-1;
        int answer=0;
        for(int i=1;i<=n;i++){
            if(max<count[i]){
                max=count[i];
                answer=i;
            }
        }
        System.out.println(answer);
    }
}