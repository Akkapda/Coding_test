import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int g;

        g = sc.nextInt();

        if (g<=100 && g>=0) {
            if (g>=90 && g<=100) {
                System.out.println("A");
            }
            else if (g>=80 && g<=89) {
                System.out.println("B");
            }
            else if (g>=70 && g<=79) {
                System.out.println("C");
            }
            else if (g>=60 && g<=69) {
                System.out.println("D");
            }
            else {
                System.out.println("F");
            }
        }
    }
}