
import java.util.Scanner;

public class Main {
    public static void main(String args[]){
        System.out.println("Create Box or Container");
        System.out.println("1.Box ");
        System.out.println("2.Container");
        Scanner in = new Scanner(System.in);
        int i = in.nextInt();
        switch (i){
            case 1:
                System.out.println("Enter box amount size: ");
                int _amountboxsize = in.nextInt();
                new Box(_amountboxsize);
                break;
            case 2:
                new Container();
                break;
        }
    }
}
