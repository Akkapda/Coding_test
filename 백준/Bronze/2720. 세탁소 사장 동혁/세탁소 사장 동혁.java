import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int quarter = 0;
        int dime = 0;
        int nickel = 0;
        int penny = 0;

        int t = Integer.parseInt(br.readLine());
        for(int i = 0; i < t; i++) {
            int c = Integer.parseInt(br.readLine());

            quarter = c / 25;
            c -= quarter * 25;
            dime = c / 10;
            c -= dime * 10;
            nickel = c / 5;
            c -= nickel * 5;
            penny = c;

            bw.write(quarter + " " + dime + " " + nickel + " " + penny + "\n");
        }
        bw.flush();
        bw.close();
        br.close();
    }
}
