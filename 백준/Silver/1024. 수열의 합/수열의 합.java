import java.util.Scanner;

import static java.lang.System.exit;

public class Main {
    public static void main(String[] args) {

        // 입력
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int least = scanner.nextInt();

        int sum = 0;
        int maxLeast = -1;

        // 찐 최소 구하기
        for(int i=0;i<1000000000;i++){
            sum += i;
            if(sum >= n){
                maxLeast = i+1;
                break;
            }
        }

        Boolean check = false;
        // least가 진짜 최소보다 더 큰 경우 (불가능) => -1출력, 프로그램 종료
        if(least > maxLeast || least >100){
            check = true;
            System.out.println(-1);
        } else if (least == maxLeast) {
            sum=0;
            for (int i = 0; i < maxLeast; i++) {
                sum+=i;
            }
            if(sum==n){
                check = true;
                for(int i=0;i<least;i++){
                    System.out.print(i + " ");
                }
            }
        } else if(check==false){

            // least 부터 100개 까지 검증
            for (int i = least; i <= 100; i++) {

                if (n % i == 0) {
                    if ((n / i) - (i / 2) < 0) continue;
                    sum = 0;
                    for (int j = (n / i) - (i / 2); j < (n / i) - (i / 2) + i; j++) {
                        sum += j;
                    }
                    if (sum == n) {
                        check = true;
                        for (int j = (n / i) - (i / 2); j < (n / i) - (i / 2) + i; j++) {
                            System.out.print(j + " ");
                        }
                        break;
                    }

                } else if (n % i == (i / 2)) {
                    if ((n / i) - (i / 2) + 1 < 0) continue;
                    sum = 0;
                    for (int j = (n / i) - (i / 2) + 1; j < (n / i) - (i / 2) + i + 1; j++) {
                        sum += j;
                    }
                    if (sum == n) {
                        check = true;
                        for (int j = (n / i) - (i / 2) + 1; j < (n / i) - (i / 2) + i + 1; j++) {
                            System.out.print(j + " ");
                        }
                        break;
                    }
                }
            }
        }
        if(!check) System.out.println(-1);
    }
}
