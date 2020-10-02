import java.util.ArrayList;

public class ReadThread extends Thread {
    public ArrayList ar;
    public ReadThread(ArrayList ar){
        this.ar = ar;
    }

    public void run(){
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        for (int i = 0;i<10;i++){
            System.out.println("Read: "+(ar.get(i))+" from position "+i);
        }
    }
}
