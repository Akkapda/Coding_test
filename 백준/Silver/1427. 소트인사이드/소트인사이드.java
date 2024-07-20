import java.io.*;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String str = br.readLine();
        int[] array = new int[str.length()];

        for(int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            array[i] = Integer.parseInt(c + "");
        }

        Arrays.sort(array);

        for(int i = array.length - 1; i > -1; i--) {
            bw.write(array[i] + "");
        }
        bw.flush();
        bw.close();
        br.close();
    }
}