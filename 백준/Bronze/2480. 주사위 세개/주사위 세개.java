import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        int A, B, C, D;
        Scanner sc = new Scanner(System.in);

        A = sc.nextInt();
        B = sc.nextInt();
        C = sc.nextInt();

        if (A == B && B == C) {
            D = 10000 + (A * 1000);
            System.out.println(D);
        }
        else if (A == B) {
            D = 1000 + (A * 100);
            System.out.println(D);
        }
        else if (B == C) {
            D = 1000 + (B * 100);
            System.out.println(D);
        }
        else if (A == C) {
            D = 1000 + (A * 100);
            System.out.println(D);
        }
        else {
            if (A > B && A > C) {
                D = A * 100;
                System.out.println(D);
            }
            else if (B > C && B > A) {
                D = B * 100;
                System.out.println(D);
            }
            else {
                D = C * 100;
                System.out.println(D);
            }
        }
    }
}
