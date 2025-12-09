import java.util.*;
import java.io.*;
import java.lang.*;

public class BJ1181
{
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        ArrayList<String> list = new ArrayList<String>();
        ArrayList<String> result = new ArrayList<String>();

        int N = Integer.parseInt(br.readLine());

        //1. N개만큼 단어입력받기
        for(int i = 0; i < N; i++) {
            list.add(br.readLine());
        }

        //2. 길이비교
        //2-1. 중복제거, List말고 Set을 썼으면 더 편했을수도...
        for(int i = 0; i < N; i++) {
            String word = list.get(i);
            //만약에 result에 word가 없으면
            if (!result.contains(word)) {
                result.add(word);
            }
        }

		//2-2. 길이가 짧은 순부터 + 사전순 정렬
        Collections.sort(result, new Comparator<String>() {
            @Override
            public int compare(String s1, String s2) {
                if(s1.length() == s2.length()) {
                    return s1.compareTo(s2);
                }
                return s1.length() - s2.length();
            }
        });

		//3. 출력
		for(String str : result) {
            System.out.println(str);
        }
    }
}