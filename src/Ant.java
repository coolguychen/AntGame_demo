public class Ant {
    int id;
    double velocity;
    double location;
    int hit = 0;

    //constructor
    public Ant(int id, int velocity, int location) {
        this.id = id;
        this.velocity = velocity;
        this.location = location;
    }

    //setter and getter
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getVelocity() {
        return velocity;
    }

    public void setVelocity(int velocity) {
        this.velocity = velocity;
    }

    public double getLocation() {
        return location;
    }

    public void setLocation(int location) {
        this.location = location;
    }

    public int getHit() {
        return hit;
    }

    public void setHit(int hit) {
        this.hit = hit;
    }

    //creep
    void creep(double incTime){
        if(this.hit == 1){
            this.velocity *= (-1);
        }
        this.location = this.location + this.velocity*incTime;
    }
}

