import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class Main {

    static final long MOD = 1_000_000_007L;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int M = Integer.parseInt(br.readLine());

        long result = 0;

        for (int i = 0; i < M; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            long N = Long.parseLong(st.nextToken());
            long S = Long.parseLong(st.nextToken());

            long invN = modPow(N, MOD - 2, MOD); // N의 역원 구하기
            long value = (S % MOD) * invN % MOD; // (S × N^-1) mod MOD

            result = (result + value) % MOD;
        }

        System.out.println(result);
    }

    // 모듈러 거듭제곱 (빠른 거듭제곱)
    static long modPow(long base, long exp, long mod) {
        long result = 1;
        base %= mod;

        while (exp > 0) {
            if ((exp & 1) == 1)
                result = (result * base) % mod;
            base = (base * base) % mod;
            exp >>= 1;
        }

        return result;
    }
}
