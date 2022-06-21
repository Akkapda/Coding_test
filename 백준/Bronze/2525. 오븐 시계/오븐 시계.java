import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        int A, B, C;

        Scanner sc = new Scanner(System.in);

        A = sc.nextInt();
        B = sc.nextInt();
        C = sc.nextInt();

        if (A >= 0 && A <= 23 && B >= 0 && B <= 59 && C >=0 && C <= 1000) {
            if (B + C >= 60) {
                if (A + ((B + C) / 60) >= 24) {
                    A = A + ((B + C) / 60) -24;
                    B = (B + C) % 60;
                    System.out.println(A + " " + B);
                }
                else {
                    A = A + ((B + C) / 60);
                    B = (B + C) % 60;
                    System.out.println(A + " " + B);
                }
            }
            else {
                B = B + C;
                System.out.println(A + " " + B);
            }
        }
    }
}
