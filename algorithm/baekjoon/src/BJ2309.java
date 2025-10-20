import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BJ2309 {
    public static void main(String[] args) throws Exception {
        //일곱개의 수의 합 = 100

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] height = new int[9];

        for(int i = 0; i < height.length; i++) {
            height[i] = Integer.parseInt(br.readLine());
        }

        //모든 키의 합 - 가짜난쟁이 두명의 키의 합 = 100이 되어야함
        //모든 키의 합
        int total = 0;
        for(int h : height) {
            total += h;
        }

        //가짜난쟁이 두명 찾기
        int fake1 = -1;
        int fake2 = -1;
        for(int i = 0; i < height.length - 1; i++) {
            for(int j = i+1; j < height.length; j++) {
                if(total - (height[i] + height[j]) == 100) {
                    fake1 = i;
                    fake2 = j;
                    break;
                }
            }
            if(fake1 != -1) break;
        }

        // 가짜 둘을 뺀 7명만 따로 담고 정렬
        int[] answer = new int[7];
        int idx = 0;
        for (int i = 0; i < 9; i++) {
            if (i == fake1 || i == fake2) continue;
            answer[idx++] = height[i];
        }

        Arrays.sort(answer);
        for (int h : answer) System.out.println(h);

    }
}
