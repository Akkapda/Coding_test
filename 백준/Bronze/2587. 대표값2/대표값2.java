import java.io.*;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] array = new int[5];
        int sum = 0;

        for(int i =0 ; i < 5; i++) {
            int temp = Integer.parseInt(br.readLine());
            array[i] = temp;
            sum += temp;
        }

        Arrays.sort(array);

        System.out.println(sum / 5);
        System.out.println(array[2]);
    }
}