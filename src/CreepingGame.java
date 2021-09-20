import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class CreepingGame {

    List<Ant> antList = new ArrayList<>();
    double runTime;

    /**
        开始一局游戏，返回用时
     */
    double playGame(int situation, double incTime, MyPanel panel) {

        //initialize an ant list
        int[] location = {30,80,110,160,250};
        Color[] colors = {Color.PINK, Color.YELLOW, Color.BLUE,Color.GREEN, Color.MAGENTA};
        //计算每只蚂蚁的初始方向，具体思路见文档
        for(int i =0;i<5;i++){
            int v = situation%2;
            situation >>= 1;

            double velocity = 5;
            if(v == 0) velocity *= -1;
            Ant ant = new Ant(i,velocity,location[i], colors[i]);

            antList.add(ant);
        }

        panel.setAntList(antList);
        panel.paint(panel.getGraphics());
        try {
            Thread.sleep(700);
        }
        catch (InterruptedException e) {
            e.printStackTrace();
        }
        //在蚂蚁列表不为空（即蚂蚁仍未全部掉下杆子）时向前推进游戏，并画出当下的蚂蚁位置状况
        while(!antList.isEmpty()){
            drivingGame(incTime);
            runTime += incTime;
            panel.setAntList(antList);
            panel.paint(panel.getGraphics());
            try {
                Thread.sleep(45);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        return runTime;
    }

    /**
        推进游戏
     */
    void drivingGame(double incTime){
        //判断是否相撞，如果相撞，给蚂蚁置标志位
        for(int k = 0; k < antList.size()-1; k++){
            for(int j = k+1; j < antList.size(); j++){
                if(isHit(antList.get(k),antList.get(j))){
                    //if two ants hit
                    antList.get(k).setHit(1);// is hit
                    antList.get(j).setHit(1);
                }
            }
        }

        List<Integer> index = new ArrayList<>();

        for(int i = 0; i < antList.size(); i++){
            Ant ant = antList.get(i);
            ant.creep(incTime);

            if(Stick.isOut(ant)) index.add(i);
        }

        for(int idx: index){
            antList.remove(idx);
        }

        index.clear();
        for(Ant ant: antList){
            ant.setHit(0);
        }
    }

    /*
        判断蚂蚁的碰撞情况
    */
    boolean isHit(Ant a1, Ant a2){
        //木杆上是否存在两只蚂蚁在同一位置
        return a1.getLocation() == a2.getLocation();
    }
}
