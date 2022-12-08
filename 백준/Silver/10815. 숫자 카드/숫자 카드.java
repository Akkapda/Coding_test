import java.io.*;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());

        HashMap<String, String> map = new HashMap<>();

        StringTokenizer st = new StringTokenizer(br.readLine());

        while (st.hasMoreTokens()) {
            map.put(st.nextToken(), "1");
        }

        int m = Integer.parseInt(br.readLine());

        st = new StringTokenizer(br.readLine());

        while (st.hasMoreTokens()) {
            if (map.containsKey(st.nextToken())) {
                bw.write("1 ");
            }
            else {
                bw.write("0 ");
            }
        }

        br.close();
        bw.flush();
        bw.close();
    }
}
