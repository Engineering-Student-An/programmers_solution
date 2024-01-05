import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();

        int[][] arr = new int[n][3];

        for(int i=0;i<n;i++){
            for(int j=0;j<3;j++){
                arr[i][j] = scanner.nextInt();
            }
        }

        Arrays.sort(arr, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o2[2]-o1[2];
            }
        });

        int[] chk = new int[3];
        int count = 0;
        for(int i=0;i<2;i++){
            chk[i] = arr[i][0];
        }

        if(chk[0] == chk[1]){
            int index=-1;
            for(int i=2;i<n;i++){
                if(arr[i][0] != chk[0]){
                    index=i;
                    break;
                }
            }
            System.out.println(arr[0][0] + " " + arr[0][1]);
            System.out.println(arr[1][0] + " " + arr[1][1]);
            System.out.println(arr[index][0] + " " + arr[index][1]);

        } else{
            for(int i=0;i<3;i++){
                for(int j=0;j<2;j++){
                    System.out.print(arr[i][j] + " ");
                }
                System.out.println();
            }
        }
    }
}