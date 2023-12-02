import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int ans = 0;

        String[] arr = new String[n];

        for(int i=0;i<n;i++){
            arr[i] = scanner.next();
        }
        for (int i = 0; i < n; i++) {
            Boolean isPrefix = false;
            for (int j = 0; j < n; j++) {
                if(i!=j){
                    if(arr[j].startsWith(arr[i])) {
                        isPrefix = true;
                        break;
                    }
                }
            }
            if(isPrefix){
                arr[i] = "";
            }
        }
        int size = 0;
        for(int i=0;i<n;i++){
            if(arr[i]!="") size++;
        }
        System.out.println(size);
    }
}