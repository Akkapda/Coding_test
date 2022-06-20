import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int Y;

        Y = sc.nextInt();

        if (Y >= 1 && Y <= 4000) {
            if (Y % 4 == 0 && Y % 100 != 0) {
                System.out.println("1");
            } else if (Y % 400 == 0) {
                System.out.println("1");
            } else {
                System.out.println("0");
            }
        }
    }
}
