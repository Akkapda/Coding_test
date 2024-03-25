import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        int[] array = new int[n];
        array[0] = 1;

        for(int i = 1; i < array.length; i++) {
            if (i == 1) {
                array[i] = 2;
            } else {
                array[i] = (array[i - 1] + array[i - 2]) % 15746;
            }
        }

        System.out.println(array[n - 1]);
    }
}