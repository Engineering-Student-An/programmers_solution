import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Exception {

        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        String[] arr = new String[n];

        for (int i = 0; i < n; i++) {
            arr[i] = scanner.next();
        }

        boolean[] chk = new boolean[n];
        int ans = 0;
        for (int i = 0; i < n; i++) {
            if(!chk[i]){
                chk[i]=true;
                ans ++;
                for (int j = i+1; j < n; j++) {
                    if(arr[i].length() == arr[j].length() && !chk[j]){
                        for (int k = 0; k < arr[j].length(); k++) {
                            if((arr[j].substring(k) + arr[j].substring(0,k)).equals(arr[i])){
                                chk[j]=true;
                                break;
                            }
                        }
                    }
                }
            }
        }

        System.out.println(ans);
    }
}
