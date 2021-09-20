import javax.swing.*;
import java.util.jar.JarEntry;

public class PlayRoom {
    double incTime;
    double max;
    double min;


    public PlayRoom(double incTime, double max, double min) {
        this.incTime = incTime;
        this.max = max;
        this.min = min;
    }

    public double getMax() {
        return max;
    }

    public double getMin() {
        return min;
    }

    /**
     * PlayRoom start a game
     */
    public void start(MyPanel myPanel, JPanel panel2, JPanel panel3) throws InterruptedException {

        /*
        在PlayRoom向CreepingGame中传入不同初始方向可能情况时，
        我们想到总共有2^5=32种情况，所以可以直接传入0-31的数字，
        然后通过这32个数字的二进制码（0代表左，1代表右）
        来表示不同的初始方向，比如数字1，二进制码为00001，
        即2-5号蚂蚁方向为左，1号蚂蚁方向为右。
         */
        double time;
        for(int i = 0; i<32; i++){
            //更新方向和轮数
            String direction = time2Direction(i);
            System.out.println(direction);
            JLabel timeLabel = (JLabel)panel2.getComponent(0);
            JLabel directionLabel = (JLabel)panel2.getComponent(1);
            timeLabel.setText("第"+(i+1)+"轮");
            directionLabel.setText("方向："+direction);
            panel2.paint(panel2.getGraphics());

            //开始游戏，根据返回结果修改最大最小值
            CreepingGame creepingGame = new CreepingGame();
            System.out.println("Playing CreepingGame"+i+"......");
            time = creepingGame.playGame(i,incTime, myPanel);
            if(time >= max) max = time;
            if(time < min) min = time;

            //由此更新显示结果
            JLabel curTimeLabel = (JLabel)panel3.getComponent(0);
            JLabel maxTimeLabel = (JLabel)panel3.getComponent(1);
            JLabel minTimeLabel = (JLabel)panel3.getComponent(2);
            curTimeLabel.setText("上轮时间："+time);
            if(max==0)
                minTimeLabel.setText("最大时间：未知");
            else
                maxTimeLabel.setText("最大时间："+max);
            if(Math.abs(min-1.0e7)<0.001)
                minTimeLabel.setText("最小时间：未知");
            else
                minTimeLabel.setText("最小时间："+min);
            panel3.paint(panel3.getGraphics());
            System.out.println("本轮时间"+time);
        }
        System.out.println("max:"+ max);
        System.out.println("min:"+ min);
    }

    /**
        用于将轮数转换成方向的字符串表示
     */
    String time2Direction(int direction){
        StringBuilder res = new StringBuilder();
        for(int i = 0; i<5; i++){
            if(direction%2==0)
                res.append("左 ");
            else
                res.append("右 ");
            direction>>=1;
        }
        return res.toString();
    }

}
