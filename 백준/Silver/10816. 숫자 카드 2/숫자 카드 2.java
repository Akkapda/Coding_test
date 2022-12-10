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
            String str = st.nextToken();
            if (map.containsKey(str)) {
                map.put(str, Integer.toString(Integer.parseInt(map.get(str)) + 1));
            }
            else map.put(str, "1");
        }

        int m = Integer.parseInt(br.readLine());

        st = new StringTokenizer(br.readLine());

        while (st.hasMoreTokens()) {
            String temp = st.nextToken();
            if (map.containsKey(temp)) {
                bw.write(map.get(temp) + " ");
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
