import java.util.ArrayList;
import java.util.Scanner;

public class Container {
    protected  int nowboxsize=0;
    protected ArrayList<Ball> balls = new ArrayList<Ball>();
    private Ball Createball(int _weight){
        Ball bl = new Ball(_weight);
        return bl;
    }
    protected void Addball(int _weight){
        if(Check(_weight)) {
            balls.add(Createball(_weight));
            System.out.println("Ball was added");
        }else System.out.println("Ball is exist ");
    }
    protected void Addball(int _weight,int boxsize){
        if(Check(_weight)&& nowboxsize+Amountsize()<boxsize ) {
            nowboxsize+=_weight;
            balls.add(Createball(_weight));
            System.out.println("Ball was added");
        }else System.out.println("Ball is exist/out of memory ");
    }
    protected void Deleteball(){
        System.out.println("Enter ball size for delete:");
        Scanner in = new Scanner(System.in);
        int _weight = in.nextInt();
            balls.remove(Search(_weight));
            System.out.println("Ball was delete;");
    }
    protected int Amountball(){
        return balls.size();
    }
    protected int Amountsize(){
        int _amountsize=0;
        for(int i =0;i<balls.size();i++){
            _amountsize+=balls.get(i).GetWeight();
        }
        return _amountsize;
    }
    protected void Clean(){
        for(int i =0;i<balls.size();i++){
            balls.remove(i);
        }
    }
    protected boolean Check(int _weight){
            for (int i = 0; i < balls.size(); i++) {
                if (balls.get(i).GetWeight() == _weight) {
                    return false;
                }
            }
        return true;
    }
    protected int Search(int _weight){
        for(int i =0;i<balls.size();i++){
            if (_weight==balls.get(i).GetWeight()){
                return i;
            }

        }
        return 0;
    }
    protected void Showsize(){
        for(int i =0;i<balls.size();i++){
            System.out.println(balls.get(i).GetWeight());
        }
    }
    void Action(){
        System.out.println("Choose your Action: ");
        System.out.println("1.Add ball ");
        System.out.println("2.Delete ball ");
        System.out.println("3.Show amount balls in container ");
        System.out.println("4.Show amount balls size`s in container ");
        System.out.println("5.Clean the container ");
        System.out.println("6.Check stock ");
        System.out.println("7.Show all ball size`s ");
        System.out.println("8.End ");
        Scanner in = new Scanner(System.in);
        int act = in.nextInt();
        switch (act){
            case 1:
                System.out.println("Enter ball size:");
                int _weight = in.nextInt();
                Addball(_weight);
                Action();
                break;
            case 2:
                Deleteball();
                Action();
                break;
            case 3:
                System.out.println("Amount balls in Container: "+Amountball());
                Action();
                break;
            case 4:
                System.out.println("Amount size of balls : " +Amountsize());
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
                if(Check(__weight)) System.out.println("Ball found"); else System.out.println("Ball not found");
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
    Container(){

    }

}
