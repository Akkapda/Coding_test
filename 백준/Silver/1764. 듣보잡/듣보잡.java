import java.io.*;
import java.util.Arrays;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        HashMap<String, String> map = new HashMap<>();

        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        for(int i = 0; i < n; i++) {
            String str = br.readLine();
            map.put(str, str);
        }

        String[] strings = new String[m];
        int cnt = 0;

        for(int i = 0; i < m; i++) {
            String temp = br.readLine();
            if (map.containsKey(temp)) {
                strings[cnt++] = temp;
            }
        }

        bw.write(cnt + "\n");
        Arrays.sort(strings,0 , cnt);
        for(int i = 0; i < cnt; i++) {
            bw.write(strings[i] + "\n");
        }

        br.close();
        bw.flush();
        bw.close();
    }
}
