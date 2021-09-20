public class Stick {
    static int begin = 0, end = 300;


    //判断是否蚂蚁是否会掉下去
    static boolean isOut(Ant ant){
        double location = ant.getLocation();
        return location <= begin || location >= end;
    }
}
