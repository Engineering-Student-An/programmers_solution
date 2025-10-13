import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        List<Question> questions = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            String num = sc.next();
            int strike = sc.nextInt();
            int ball = sc.nextInt();
            questions.add(new Question(num, strike, ball));
        }

        int count = 0;

        // 1~9 중 서로 다른 세 자리 수 후보 탐색
        for (int i = 1; i <= 9; i++) {
            for (int j = 1; j <= 9; j++) {
                if (i == j) continue;
                for (int k = 1; k <= 9; k++) {
                    if (i == k || j == k) continue;

                    String candidate = "" + i + j + k;
                    boolean possible = true;

                    for (Question q : questions) {
                        int[] result = check(candidate, q.num);
                        if (result[0] != q.strike || result[1] != q.ball) {
                            possible = false;
                            break;
                        }
                    }

                    if (possible) count++;
                }
            }
        }

        System.out.println(count);
    }

    static int[] check(String a, String b) {
        int strike = 0, ball = 0;
        for (int i = 0; i < 3; i++) {
            if (a.charAt(i) == b.charAt(i)) strike++;
            else if (b.contains(a.charAt(i) + "")) ball++;
        }
        return new int[]{strike, ball};
    }

    static class Question {
        String num;
        int strike, ball;

        Question(String num, int strike, int ball) {
            this.num = num;
            this.strike = strike;
            this.ball = ball;
        }
    }
}
