import java.util.Scanner;

public class Main{
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();

        int[][] arr = new int[n+1][5];

        for(int i=1;i<=n;i++){
            for (int j = 0; j < 5; j++) {
                arr[i][j] = scanner.nextInt();
            }
        }
        int[] max = new int[n+1];
        for(int i=1;i<=n;i++){
            for(int j=0;j<3;j++){
                for(int k=j+1;k<4;k++){
                    for(int l=k+1;l<5;l++){
                        if( (arr[i][j] + arr[i][k] + arr[i][l]) % 10 > max[i]){
                            max[i]=(arr[i][j] + arr[i][k] + arr[i][l]) % 10;
                        }
                    }
                }
            }
        }

        int max_int = -1;
        int max_ind = 1;
        for(int i=1;i<=n;i++){
            if(max[i]>=max_int) {
                max_ind=i;
                max_int = max[i];
            }
        }
        System.out.println(max_ind);
    }
}