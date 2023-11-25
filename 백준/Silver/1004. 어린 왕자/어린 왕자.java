import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int t = scanner.nextInt();

        for (int i = 0; i < t; i++) {
            int startX = scanner.nextInt(); int startY = scanner.nextInt();
            int endX = scanner.nextInt(); int endY = scanner.nextInt();
            int count = 0;

            int n = scanner.nextInt();
            for (int j = 0; j < n; j++) {

                int circleX = scanner.nextInt();    int circleY = scanner.nextInt();    int circleR = scanner.nextInt();

                // 시작점이 입력받은 원 안에 있는지 검사
                if(check(startX, startY, circleX, circleY, circleR) && !check(endX, endY, circleX, circleY, circleR)) {
                    count++;
//                    System.out.println("끝에 놈만 원 외부");
//                    System.out.println("circleR = " + circleR);
                }
                else if(!check(startX, startY, circleX, circleY, circleR) && check(endX, endY, circleX, circleY, circleR)) {
                    count++;
//                    System.out.println("첫에 놈만 원 외부");
//                    System.out.println("circleR = " + circleR);
                }

            }
            System.out.println(count);
        }
    }

    // false => 원 내부
    public static Boolean check(int x1, int y1, int x2, int y2, int r) {
        if( (x1-x2) * (x1-x2) + (y1-y2) * (y1-y2) <= r*r )
        {
//            System.out.println((x1-x2) * (x1-x2) + (y1-y2) * (y1-y2));
//            System.out.println(r*r);
            return false;
        }
        else return true;
    }
}