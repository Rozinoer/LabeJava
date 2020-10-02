import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Random;

public class WriteThread extends Thread {
    private  ArrayList ar;

    public WriteThread(ArrayList ar){
        this.ar = ar;
    }
    public void run(){

        Random rnd = new Random();
        DecimalFormat dc = new DecimalFormat("###.###");
        for (int i = 0;i<10;i++){
            ar.add(i, dc.format((double) (Math.random() * 1000)));

            System.out.println("Write: " + ar.get(i) + " to position "+i);
        }
        System.out.println("--------------------------------------------------");
    }
}
