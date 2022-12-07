import processing.core.PApplet;

public class Main extends PApplet {
    Paper p;
    Rock r;
    Scissors s;
    public void settings(){
        size(600,600);
    }
    public void setup(){
    p = new Paper(3,3,3,3,loadImage("paper.png"));
    r = new Rock(3,3,3,3,loadImage("rock.png"));
    s = new Scissors(3,3,3,3,loadImage("scissors.png"));
    }
    public void draw(){
    image(p.p1, 300,300);
    image(s.p1, 500,500);
    image(r.p1,100,100);
    p.move();
    r.move();
    s.move();
    p.act();
    s.act();
    r.act();
    }

    public static void main(String[] args) {
        PApplet.main("Main");
    }
}
