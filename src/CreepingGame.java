import java.util.ArrayList;
import java.util.List;

public class CreepingGame {

    List<Ant> antList = new ArrayList<Ant>();

    double playGame(int situation, double incTime){

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

        double runTime = 0;

        while(!antList.isEmpty()){
            drivingGame(incTime);
            runTime += incTime;
        }
        return runTime;
    }

    void drivingGame(double incTime){
        Stick stick = new Stick(300);

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

        List<Integer> index = new ArrayList<Integer>();

        for(int i = 0; i < antList.size(); i++){
            Ant ant = antList.get(i);
            ant.creep(incTime);

            if(stick.isOut(ant)) index.add(i);
        }

        for(int i=0;i<index.size();i++){
            int idx = index.get(i);
            antList.remove(idx);
        }

        index.clear();
        for(int j = 0; j < antList.size(); j++){
            antList.get(j).setHit(0);
        }
    }

    boolean isHit(Ant a1, Ant a2){
        //木杆上是否存在两只蚂蚁在同一位置
        return a1.getLocation() == a2.getLocation();
    }
}
