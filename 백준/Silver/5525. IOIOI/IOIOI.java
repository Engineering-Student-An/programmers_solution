import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine().trim());
        int M = Integer.parseInt(br.readLine().trim());
        String S = br.readLine().trim();

        int answer = 0;   // 최종 PN 개수
        int consecutive = 0; // 연속으로 발견한 "IOI"의 개수

        // i는 가운데 문자(O)의 인덱스가 아니라, 가운데를 포함한 "IOI"의 중심 인덱스(중간 문자 O의 인덱스)를 검사하기 위해 1 ~ M-2 범위
        for (int i = 1; i < M - 1; i++) {
            // S[i-1] S[i] S[i+1] 이 "I","O","I" 인지 확인
            if (S.charAt(i - 1) == 'I' && S.charAt(i) == 'O' && S.charAt(i + 1) == 'I') {
                consecutive++;               // 하나의 "IOI" 발견
                if (consecutive == N) {      // N개 연속이면 PN 하나 완성
                    answer++;
                    consecutive--;          // 겹치는 패턴을 위해 1만 남겨둔다
                }
                i++; // 이미 "IOI"의 마지막 'I'까지 검사했으므로 다음 가능한 가운데는 i+2 -> for문의 i++와 합쳐져 +2 이동
            } else {
                consecutive = 0; // 패턴이 끊기면 연속 카운트 초기화
            }
        }

        System.out.println(answer);
    }
}
