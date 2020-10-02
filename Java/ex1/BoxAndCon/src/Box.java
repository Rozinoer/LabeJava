import java.util.Scanner;

class Box extends Container {
    private int amountboxsize;

    private void setAmountboxsize(int _amountboxsize) {
        amountboxsize = _amountboxsize;
    }

    private int getAmountboxsize() {
        return amountboxsize;
    }

    void Action() {
        System.out.println("Choose your Action: ");
        System.out.println("1.Add ball ");
        System.out.println("2.Delete ball ");
        System.out.println("3.Show amount balls in box ");
        System.out.println("4.Show amount balls size`s in box ");
        System.out.println("5.Clean the container ");
        System.out.println("6.Check stock ");
        System.out.println("7.Show all ball size`s ");
        System.out.println("8.End ");
        Scanner in = new Scanner(System.in);
        int act = in.nextInt();
        switch (act) {
            case 1:
                System.out.println("Enter ball size:");
                int _weight = in.nextInt();
                Addball(_weight, getAmountboxsize());
                Action();
                break;
            case 2:
                Deleteball();
                Action();
                break;
            case 3:
                System.out.println("Amount balls in Container: " + Amountball());
                Action();
                break;
            case 4:
                System.out.println("Amount size of balls : " + Amountsize());
                Action();
                break;
            case 5:
                Clean();
                System.out.println("Container is clean");
                Action();
                break;
            case 6:
                Scanner _in = new Scanner(System.in);
                int __weight = _in.nextInt();
                if (Check(__weight)) System.out.println("Ball found");
                else System.out.println("Ball not found");
                Action();
                break;
            case 7:
                System.out.println("Ball sizes :");
                Showsize();
                Action();
                break;
            case 8:
                break;
        }
    }
    Box(int _amountboxsize){
        setAmountboxsize(_amountboxsize);
        Action();
    }
}

