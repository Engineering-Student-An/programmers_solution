import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int count = 0;
        StringBuilder sb = new StringBuilder();
        while(true){
            count ++;
            int n = scanner.nextInt();
            if(n==0) break;

            int[] check = new int[n];
            String[] name = new String[n];
            scanner.nextLine();
            for (int i = 0; i < n; i++) {
                name[i] = scanner.nextLine();
            }
            for(int i=0;i<2*n-1;i++){
                check[scanner.nextInt()-1] ++;
                scanner.next();
            }
            int index = -1;
            for(int i=0;i<n;i++){
                if(check[i]==1) {
                    index=i;
                    break;
                }
            }
            System.out.println(count + " " + name[index]);
        }

    }
}