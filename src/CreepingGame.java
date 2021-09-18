import java.util.ArrayList;
import java.util.List;

public class CreepingGame {

    List<Ant> antList = new ArrayList<Ant>();
    double runTime;


    double playGame(int situation, double incTime){
        //todo
        //initialize an ant list
        int location[] = {30,80,110,160,250};

        for(int i =0;i<5;i++){
            /**
             *
             */
            int v = situation%2;
            situation >>= 1;

            double velocity = 5;
            if(v == 0) velocity *= -1;
            Ant ant = new Ant(i,velocity,location[i]);

            antList.add(ant);
        }

        runTime = 0;

        while(!antList.isEmpty()){
            drivingGame(incTime);
            runTime += incTime;
        }
        return runTime;
    }

    void drivingGame(double incTime){
        Stick stick = new Stick(300);

        //todo
        //判断是否相撞，如果相撞，给蚂蚁置标志位
        for(int i = 0; i<5;i++){
            for(int j=i+1;j<5;j++){
                if(isHit(antList.get(i),antList.get(j))){
                    //if two ants hit
                    antList.get(i).setHit(1);// is hit
                    antList.get(j).setHit(1);
                }
            }
        }

        List<Integer> index = new ArrayList<Integer>();

        for(int i = 0; i < antList.size(); i++){
            Ant ant = antList.get(i);
            ant.creep(incTime);

            if(stick.isOut(ant)) index.add(i);
        }

        for(int i=0;i<index.size();i++){
            antList.remove(index.get(i));
        }

        index.clear();
    }

    boolean isHit(Ant a1, Ant a2){
        //todo
        //木杆上是否存在两只蚂蚁在同一位置

        return a1.getLocation() == a2.getLocation();
    }
}
