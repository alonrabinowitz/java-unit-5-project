import processing.core.PApplet;

import java.util.ArrayList;

public class Main extends PApplet {
    ArrayList<Rock> rocks;
    ArrayList<Paper> papers;
    ArrayList<Scissors> scissors;

    public void settings(){
        size(600,600);
    }
    public void setup(){
    p = new Paper(3,3,3,3,loadImage("paper.png"));
    r = new Rock(3,3,3,3,loadImage("rock.png"));
    s = new Scissors(3,3,3,3,loadImage("scissors.png"));
    }
    public void draw(){
        background(204);
        for(Paper currPaper : papers){
            currPaper.act();
            currPaper.move();
            image(currPaper.p1, currPaper.x, currPaper.y);
        }
        for(Scissors currScissors : scissors){
            currScissors.act();
            currScissors.move();
            image(currScissors.p1, currScissors.x, currScissors.y);
        }
        for(Rock currRock : rocks){
            currRock.act();
            currRock.move();
            image(currRock.p1, currRock.x, currRock.y);
        }
    }

    public void addRock(){
        int x = (int)(Math.random()*600);
        int y = (int)(Math.random()*600);
        int xs = (int)(Math.random()*8+2);
        int ys = (int)(Math.random()*8+2);
        rocks.add(new Rock(x,y,xs,ys,loadImage("rock.png")));
    }
    public void addPaper(){
        int x = (int)(Math.random()*600);
        int y = (int)(Math.random()*600);
        int xs = (int)(Math.random()*8+2);
        int ys = (int)(Math.random()*8+2);
        papers.add(new Paper(x,y,xs,ys,loadImage("paper.png")));
    }
    public void addScissors(){
        int x = (int)(Math.random()*600);
        int y = (int)(Math.random()*600);
        int xs = (int)(Math.random()*8+2);
        int ys = (int)(Math.random()*8+2);
        scissors.add(new Scissors(x,y,xs,ys,loadImage("scissors.png")));
    }
    public static void main(String[] args) {
        PApplet.main("Main");
    }
}
