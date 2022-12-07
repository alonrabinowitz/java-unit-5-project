import processing.core.PApplet;

public class Main extends PApplet {
    Paper p;
    Rock r;
    Scissors s;
    public void settings(){
        size(600,600);
    }
    public void setup(){
    p = new Paper(loadImage("paper.png"));
    r = new Rock(loadImage("rock.png"));
    s = new Scissors(loadImage("scissors.png"));
    }
    public void draw(){
    image(p.p1, 300,300);
    image(s.p1, 500,500);
    image(r.p1,100,100);

    }

    public static void main(String[] args) {
        PApplet.main("Main");
    }
}
