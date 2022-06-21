import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        int N;
        int F = 0;
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();

        if (N >= 1 && N <= 10000) {
            for (int i = 1; i <= N; i++) {
                F = F + i;
            }
            System.out.println(F);
        }
    }
}