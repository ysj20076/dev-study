import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ10828 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[] stack = new int[N];
        int size = 0;

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            String command = st.nextToken();

            switch (command) {
                case "push":
                    int x = Integer.parseInt(st.nextToken());
                    stack[size++] = x;
                    break;

                case "pop":
                    if (size == 0) {
                        sb.append(-1).append('\n');
                    } else {
                        sb.append(stack[--size]).append('\n');
                    }
                    break;

                case "size":
                    sb.append(size).append('\n');
                    break;

                case "empty":
                    sb.append(size == 0 ? 1 : 0).append('\n');
                    break;

                case "top":
                    if (size == 0) {
                        sb.append(-1).append('\n');
                    } else {
                        sb.append(stack[size - 1]).append('\n');
                    }
                    break;
            }
        }

        System.out.print(sb);
    }
}
