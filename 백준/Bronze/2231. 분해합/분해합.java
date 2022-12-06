import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        int cnt = Conter(n);
        int result = 0;

        for(int i = 0; i < (cnt * 9); i++) {
            switch (cnt) {
                case 1:
                    result = i + i;
                    break;
                case 2:
                    if (n > 18) {
                        result = Devide_Sum(n - (cnt * 9) + i);
                    }
                    else {
                        result = i + (i / 10) + (i % 10);
                    }
                    break;
                case 3:
                case 4:
                case 5:
                case 6:
                case 7:
                    result = Devide_Sum(n - (cnt * 9) + i);
                    break;
            }
            if (result == n) {
                if (n > 18) {
                    System.out.println(n - (cnt * 9) + i);
                }
                else
                    System.out.println(i);
                br.close();
                return;
            }
        }
        System.out.println(0);
        br.close();
    }

    public static int Conter(int n) {
        int cnt = 0;
        while (n > 0) {
            n /= 10;
            cnt++;
        }

        return cnt;
    }

    public static int Devide_Sum(int n) {
        int temp = n;
        int result = n;
        while (temp > 0) {
            result += (temp % 10);
            temp /= 10;
        }

        return result;
    }
}
