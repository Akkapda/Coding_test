import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
	    int a, b;
        int temp;

        Scanner sc = new Scanner(System.in);

        a = sc.nextInt();
        b = sc.nextInt();

        temp = b;

        while (b > 0) {
            System.out.println(a * (b % 10));
            b = b / 10;
        }
        System.out.println(a * temp);
    }
}