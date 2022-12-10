import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String str = br.readLine();

        HashMap<String, String> map = new HashMap<>();
        char[] cArray = new char[str.length()];

        for(int i = 0; i < str.length(); i++) {
            cArray[i] = str.charAt(i);
        }

        //i가 자리수 - 1
        int i = 0;
        //문자열원본이 될 때 까지 (자리수 인덱스가 s.length - 1)
        while (i < cArray.length) {
            int j = 0;
            while (i + j < cArray.length) {
                int tempi = i;
                StringBuilder sb = new StringBuilder();
                for(int q = 0; q <= tempi; q++) {
                    sb.append(cArray[j+q]);
                }
                map.put(sb.toString(), "");
                j++;
            }
            i++;
        }

        System.out.println(map.size());

        br.close();
    }
}
