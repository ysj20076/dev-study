import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BJ2798 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[] a = new int[N];
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++) {
            a[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(a);
        int best = 0;

        //N장의 카드 중 서로 다른 3장을 뽑는 모든 경우의 수!
        //3중 for문 사용 -> i < j < k 성립, 중복 없이
        for(int i = 0; i < N-2; i++) {
            for(int j = i+1; j < N-1; j++) {
                for(int k = j + 1; k < N; k++) {
                    int sum = a[i] + a[j] + a[k];

                    if(sum > M) break;
                    if(sum > best) best = sum;
                }
            }
        }

        System.out.println(best);


    }
}
