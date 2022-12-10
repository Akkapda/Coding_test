import java.io.*;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        HashMap<String, String> a = new HashMap<>();
        HashMap<String, String> b = new HashMap<>();

        st = new StringTokenizer(br.readLine());

        while (st.hasMoreTokens()) {
            a.put(st.nextToken(), "1");
        }

        st = new StringTokenizer(br.readLine());

        while (st.hasMoreTokens()) {
            b.put(st.nextToken(), "1");
        }

        int cnt = 0;
        for(String key : b.keySet()) {
            if (a.containsKey(key)) {
                cnt++;
            }
        }
        int aNum = a.size() - cnt;
        cnt = 0;
        for(String key : a.keySet()) {
            if (b.containsKey(key)) {
                cnt++;
            }
        }
        int bNum = b.size() - cnt;

        bw.write((aNum + bNum) + "");

        br.close();
        bw.flush();
        bw.close();
    }
}
