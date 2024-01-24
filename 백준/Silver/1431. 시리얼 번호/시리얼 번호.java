import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        String[] arr = new String[n];
        for (int i = 0; i < n; i++) {
            arr[i] = scanner.next();
        }

        for (int i = 0; i < n - 1; i++) {
            for (int j = i + 1; j < n; j++) {

                if(arr[i].length() > arr[j].length()){
                    swap(arr, i, j);
                } else if(arr[i].length() == arr[j].length()){
                    boolean chk = false;
                    int sum_i = 0;
                    int sum_j = 0;
                    for (int ii = 0; ii < arr[i].length(); ii++) {
                        if(arr[i].charAt(ii) >= '0' && arr[i].charAt(ii) <= '9') sum_i += (int) (arr[i].charAt(ii)-'0');
                    }
                    for (int jj = 0; jj < arr[j].length(); jj++) {
                        if(arr[j].charAt(jj) >= '0' && arr[j].charAt(jj) <= '9') sum_j += (int) (arr[j].charAt(jj)-'0');
                    }

                    if(sum_i > sum_j){
                        swap(arr, i, j);
                    } else if(sum_i == sum_j && arr[i].compareTo(arr[j]) > 0){
                        swap(arr, i, j);
                    }
                }
            }
        }

        for (String string : arr) {
            System.out.println(string);
        }


    }

    private static void swap(String[] arr, int i, int j) {
        String temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}