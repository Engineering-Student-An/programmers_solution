import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        String line = scanner.next();
        boolean[] plus = new boolean[line.length()];

        if(!line.startsWith("-")) {
            line = "+" + line;
            plus[0] = true;
        } else {
            plus[0] = false;
        }

        int num = 0;
        int index = 0;
        int[] nums = new int[line.length()];
        for (int i = 1; i < line.length(); i++) {

            if(line.charAt(i) == '+' || line.charAt(i) == '-') {
                nums[index] = num;
                plus[++index] = line.charAt(i) == '+';
                num = 0;
            } else {
                num = num*10 + Integer.parseInt(String.valueOf(line.charAt(i)));
            }
        }
        nums[index] = num;

        int sum = 0;
        int i = 0;
        while(i<=index) {
            if(plus[i]) {
                sum += nums[i];
                i++;
            } else {
                int partSum = 0;
                while(true) {

                    partSum += nums[i];
                    i++;
                    if(i > index || !plus[i]) break;
                }
                sum -= partSum;
            }
        }

        System.out.println(sum);
    }
}