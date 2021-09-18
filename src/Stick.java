public class Stick {
    int length;

    public Stick(int length) {
        this.length = length;
    }

    //getter and setter
    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    //判断是否蚂蚁是否会掉下去
    boolean isOut(Ant ant){
        double location = ant.getLocation();
        if(location <= 0 || location >= 300){
            return true;
        }
        return false;
    }
}
