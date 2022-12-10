import java.io.*;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st =  new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        HashMap<String, String> map1 = new HashMap<>();
        HashMap<String, String> map2 = new HashMap<>();

        for(int i = 1; i <= n; i++) {
            String str = br.readLine();
            map1.put(str, Integer.toString(i));
            map2.put(Integer.toString(i), str);
        }

        String question;

        for(int i = 0; i < m; i++) {
            question = br.readLine();

            if (map1.containsKey(question)) {
                bw.write(map1.get(question) + "\n");
            }
            else {
                bw.write(map2.get(question) + "\n");
            }
        }

        br.close();
        bw.flush();
        bw.close();
    }
}
