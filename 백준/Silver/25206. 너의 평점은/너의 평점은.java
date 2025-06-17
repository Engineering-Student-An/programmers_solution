import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        double sum = 0.0;
        double scoreSum = 0.0;
        for (int i = 0; i < 20; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String name = st.nextToken();
            double num = Double.parseDouble(st.nextToken());
            String scoreString = st.nextToken();

            double score = 0.0;
            if(scoreString.equals("P")) continue;

            if(scoreString.equals("A+")) score = 4.5;
            else if(scoreString.equals("A0")) score = 4.0;
            else if(scoreString.equals("B+")) score = 3.5;
            else if(scoreString.equals("B0")) score = 3.0;
            else if(scoreString.equals("C+")) score = 2.5;
            else if(scoreString.equals("C0")) score = 2.0;
            else if(scoreString.equals("D+")) score = 1.5;
            else if(scoreString.equals("D0")) score = 1.0;
            else if(scoreString.equals("F")) score = 0.0;

            sum += num;
            scoreSum += (num * score);
        }

        System.out.println(scoreSum / sum);
    }
}