import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String line = br.readLine();


        int n = 0;
        for (int i = 0; i < line.length(); i++) {
            if(line.charAt(i) == '+' || line.charAt(i) == '-') n ++;
        }

        int[] arr = new int[++n];

        int num = line.charAt(0) - '0';
        int index = 0;
        boolean isPlus = true;
        for (int i = 1; i < line.length(); i++) {

            char now = line.charAt(i);
            if(now != '+' && now != '-') {
                num *= 10;
                if(isPlus) {
                    num += (now -'0');
                } else {
                    num -= (now - '0');
                }
                if(i == line.length() - 1){
                    arr[index] = num;
                    break;
                }
            } else {
                arr[index ++] = num;
                num = (now == '+') ? line.charAt(++i) - '0' : (line.charAt(++i) - '0') * -1;
                isPlus = (now == '+');

                if(i == line.length() - 1) {
                    arr[index] = num;
                    break;
                }
            }
        }
        if(line.length() == 1) {
            arr[index] = num;
        }

        index = 0;
        long result = 0;
        while(index < n) {
            if(arr[index] >= 0) {
                result += arr[index ++];
            } else if(arr[index] < 0) {
                long sum = arr[index] * -1;
                index ++;
                while(index < n && arr[index] >= 0) {
                    sum += arr[index ++];
                }
                result -= sum;
            }
        }

        System.out.println(result);
    }
}