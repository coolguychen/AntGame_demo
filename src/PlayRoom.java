import javax.swing.*;

public class PlayRoom {
    double incTime;
    double max;
    double min;


    public PlayRoom(double incTime, double max, double min) {
        this.incTime = incTime;
        this.max = max;
        this.min = min;
    }

    public static void main(String args[]) throws InterruptedException {
        PlayRoom playRoom = new PlayRoom(0.5,0,10000000);
        playRoom.start();
    }

    public double getMax() {
        return max;
    }

    public double getMin() {
        return min;
    }

    public void start() throws InterruptedException {
        //PlayRoom start a game
        /**
        在PlayRoom向CreepingGame中传入不同初始方向可能情况时，
        我们想到总共有2^5=32种情况，所以可以直接传入0-31的数字，
        然后通过这32个数字的二进制码（0代表左，1代表右）
        来表示不同的初始方向，比如数字1，二进制码为00001，
        即2-5号蚂蚁方向为左，1号蚂蚁方向为右。
         */
        MyPanel myPanel = new MyPanel();
        double time = 0;
        for(int i = 0; i<32; i++){
            CreepingGame creepingGame = new CreepingGame();
            System.out.println("Playing CreepingGame"+i+"......");
            time = creepingGame.playGame(i,incTime);
            if(time >= max) max = time;
            else if(time < min) min = time;
        }
        System.out.println("max:"+ max);
        System.out.println("min:"+ min);
    }


}
