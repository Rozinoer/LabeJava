import java.util.concurrent.TimeUnit;
import java.util.*;

public class Main
{
    private boolean taken = false;
    public synchronized void take() throws InterruptedException
    {
        while(taken)
            wait();
        taken = true;
    }
    public synchronized void free()
    {
        taken = false;
        notifyAll();
    }
}
class Client implements Runnable
{
    private Main room;
    private final int id;
    private final int live;
    private Random rand = new Random(100);
    private void pause() throws InterruptedException
    {
        TimeUnit.MILLISECONDS.sleep(rand.nextInt(live*100));
    }
    public Client(Main room, int id, int live)
    {
        this.room = room;
        this.id = id;
        this.live = live;
    }
    public void run()
    {
        try
        {
            while(!Thread.interrupted())
            {
                System.out.println(this+" "+"Zanyl");
                pause();
                System.out.println(this+" "+"Jivet");
                room.take();
                System.out.println(this+" "+"Osvobodil");
                pause();
                room.free();
            }
        }
        catch(InterruptedException e)
        {
            System.out.println(this+" "+"interrupted");
        }
    }
    public String toString()
    {
        return "Client №"+id;
    }
}
class Test
{
    public static void main(String[] args)
    {
        Main thread = new Main();
        for(int i=0; i<=50; i++)
        {
            Thread t = new Thread(new Client(thread, i, 10));
            t.start();
        }
    }
}
