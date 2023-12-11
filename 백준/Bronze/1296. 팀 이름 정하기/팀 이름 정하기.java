import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        String name = scanner.next();
        int[] arr = new int[4];
        for (int i = 0; i < name.length(); i++) {
            if(name.charAt(i) == 'L') {
                arr[0] ++;
            } else if(name.charAt(i) == 'O'){
                arr[1] ++;
            } else if(name.charAt(i) == 'V'){
                arr[2] ++;
            } else if(name.charAt(i) == 'E'){
                arr[3] ++;
            }

        }
        int n = scanner.nextInt();
        String[] team = new String[n];
        int max = -1;
        String maxString = "";

        for (int i = 0; i < n; i++) {
            team[i] = scanner.next();
        }
        Arrays.sort(team);

        for (int i = 0; i < n; i++) {
            int l=arr[0], o=arr[1], v=arr[2], e=arr[3];

            for (int j = 0; j < team[i].length(); j++) {
                if(team[i].charAt(j)=='L') l ++;
                else if(team[i].charAt(j) == 'O') o++;
                else if(team[i].charAt(j) == 'V') v++;
                else if(team[i].charAt(j) == 'E') e++;
            }

            int sum = ( (l+o) * (l+v) * (l+e) * (o+v) * (o+e) * (v+e)) % 100;
            if(sum > max){
                max = sum;
                maxString = team[i];
            }
        }

        System.out.println(maxString);
    }
}