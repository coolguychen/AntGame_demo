import java.awt.*;

public class Ant {
    int id;
    double velocity;
    double location;
    int hit = 0;
    Color color;

    //constructor
    public Ant(int id, double velocity, double location, Color color) {
        this.id = id;
        this.velocity = velocity;
        this.location = location;
        this.color = color;
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

    public Color getColor() {
        return color;
    }

    //creep
    void creep(double incTime){
        if(this.hit == 1){
            this.velocity *= (-1);
        }
        this.location = this.location + this.velocity*incTime;
    }
}

