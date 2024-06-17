import java.io.*;

public class Main {
    static int cnt;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        for(int i = 0; i < n; i++) {
            String str = br.readLine();
            cnt = 0;
            int answer = recursion(str, 0, str.length() - 1);
            System.out.println(answer + " " + cnt);
        }
    }

    static int recursion(String str, int l, int r){
        cnt++;
        if(l >= r) return 1;
        else if(str.charAt(l) != str.charAt(r)) return 0;
        else return recursion(str, l+1, r-1);
    }
}
