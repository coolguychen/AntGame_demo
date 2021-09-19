public class Stick {
    static int begin, end;

    public Stick(int begin, int end) {
        this.begin = begin;
        this.end = end;
    }

    public int getBegin() {
        return begin;
    }

    public void setBegin(int begin) {
        this.begin = begin;
    }

    public int getEnd() {
        return end;
    }

    public void setEnd(int end) {
        this.end = end;
    }

    //判断是否蚂蚁是否会掉下去
    boolean isOut(Ant ant){
        double location = ant.getLocation();
        if(location <= begin || location >= end){
            return true;
        }
        return false;
    }
}
