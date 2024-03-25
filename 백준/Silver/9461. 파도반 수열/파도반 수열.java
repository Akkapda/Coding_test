import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        long[] array = new long[100];
        array[0] = 1;
        array[1] = 1;
        array[2] = 1;

        for(int i = 3; i < array.length; i++) {
            array[i] = array[i - 2] + array[i - 3];
        }

        int n = Integer.parseInt(br.readLine());

        for(int i = 0; i < n; i++) {
            int temp = Integer.parseInt(br.readLine());
            bw.write(array[temp - 1] + "\n");
        }

        bw.flush();
        bw.close();
        br.close();
    }
}
