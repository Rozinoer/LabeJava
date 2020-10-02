import java.util.ArrayList;

public class Main {
    public static void main (String[] args){
        ArrayList ar = new ArrayList(10);
        new WriteThread(ar).start();
        new ReadThread(ar).start();


    }
}
