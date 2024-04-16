import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        String numbers = br.readLine();
        int sum = 0;

        for(int i = 0; i < numbers.length(); i++) {
            sum += numbers.charAt(i) - 48;
        }

        System.out.println(sum);

        br.close();
    }
}
