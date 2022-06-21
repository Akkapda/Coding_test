import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        int H, M;

        Scanner sc = new Scanner(System.in);

        H = sc.nextInt();
        M = sc.nextInt();

        if (H >= 0 && H <= 24 && M >= 0 && M <= 59) {
            //실행
            if (M >= 45) {
                M = M - 45;
                System.out.println(H +" "+ M);
            }
            else if (M < 45) {
                if (H == 0) {
                    H = 23;
                    M = M - 45 + 60;
                    System.out.println(H +" "+ M);
                }
                else {
                    H = H - 1;
                    M = M - 45 + 60;
                    System.out.println(H +" "+ M);
                }
            }
        }
    }
}