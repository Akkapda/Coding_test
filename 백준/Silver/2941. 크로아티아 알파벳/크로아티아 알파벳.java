import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String str = br.readLine();

        str = str.replace("c=", "c");
        str = str.replace("c-", "c");
        str = str.replace("dz=", "z");
        str = str.replace("z=", "z");
        str = str.replace("s=", "s");
        str = str.replace("nj", "n");
        str = str.replace("lj", "l");
        str = str.replace("d-", "d");

        System.out.println(str.length());
        br.close();
    }
}
