import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ10845 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        int queue[] = new int[N];
        int front = 0;
        int back = 0;

        StringBuilder sb = new StringBuilder();

        for(int i = 0; i < N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            String command = st.nextToken();
            switch(command) {
                case "push":
                    int X = Integer.parseInt(st.nextToken());
                    queue[back++] = X;
                    break;
                case "pop":
                    if(front == back) sb.append(-1).append("\n");
                    else {
                        sb.append(queue[front]).append("\n");
                        front++;
                    }
                    break;
                case "size":
                    sb.append(back - front).append("\n");
                    break;
                case "empty":
                    sb.append(front == back ? 1 : 0).append("\n");
                    break;
                case "front":
                    if(front == back) sb.append(-1).append("\n");
                    else sb.append(queue[front]).append("\n");
                    break;
                case "back":
                    if(front == back) sb.append(-1).append("\n");
                    else sb.append(queue[back - 1]).append("\n");
                    break;
            }
        }
        System.out.println(sb.toString());

    }
}
