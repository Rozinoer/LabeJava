public class PingPongThread extends Thread {
    PingPongThread(String name){
        this.setName(name);
    }
    public void run(){

        Ball ball = Ball.getBall();
        while(ball.isInGame()){
            kickBall(ball);
            /*try {
                Thread.sleep(1000);
            } catch (InterruptedException e){
                System.out.println("Interrupt");
            }*/
        }
    }
    private void kickBall(Ball ball){
        if(!ball.getSide().equals(getName())){
            ball.kick(getName());
        }
    }
}
