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
        papers = new ArrayList<>();
        scissors = new ArrayList<>();
        rocks = new ArrayList<>();

        for(int i = 0; i < 30; i++){
            addRock();
            addPaper();
            addScissors();
        }
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
        if(keyPressed){
            if(key == 'r'){
                addRockMouse();
            }
            if(key == 'p'){
                addPaperMouse();
            }
            if(key == 's'){
                addScissorsMouse();
            }
        }
//        int prCount = 0;
//        for(Paper currP : papers){
//            for(Rock currR : rocks){
//                prCount++;
//                if(currP.x + currP.iW >= currR.x && currP.x <= currR.x + currR.iW && currP.y + currP.iH >= currR.y && currP.y <= currR.y + currR.iH){
//                    rocks.remove(prCount);
//                    prCount--;
//                }
//            }
//        }
    }

    public void addRock(){
        int x = (int)(Math.random()*600);
        int y = (int)(Math.random()*600);
        int xs = (int)(Math.random()*3+2);
        int ys = (int)(Math.random()*3+2);
        rocks.add(new Rock(x,y,xs,ys,loadImage("rock.png")));
    }
    public void addRockMouse(){
        int x = mouseX;
        int y = mouseY;
        int xs = (int)(Math.random()*3+2);
        int ys = (int)(Math.random()*3+2);
        rocks.add(new Rock(x,y,xs,ys,loadImage("rock.png")));
    }
    public void addPaper(){
        int x = (int)(Math.random()*600);
        int y = (int)(Math.random()*600);
        int xs = (int)(Math.random()*3+2);
        int ys = (int)(Math.random()*3+2);
        papers.add(new Paper(x,y,xs,ys,loadImage("paper.png")));
    }
    public void addPaperMouse(){
        int xs = (int)(Math.random()*3+2);
        int ys = (int)(Math.random()*3+2);
        papers.add(new Paper(mouseX,mouseY,xs,ys,loadImage("paper.png")));
    }
    public void addScissors(){
        int x = (int)(Math.random()*600);
        int y = (int)(Math.random()*600);
        int xs = (int)(Math.random()*3+2);
        int ys = (int)(Math.random()*3+2);
        scissors.add(new Scissors(x,y,xs,ys,loadImage("scissors.png")));
    }
    public void addScissorsMouse(){
        int xs = (int)(Math.random()*3+2);
        int ys = (int)(Math.random()*3+2);
        scissors.add(new Scissors(mouseX,mouseY,xs,ys,loadImage("scissors.png")));
    }
    public static void main(String[] args) {
        PApplet.main("Main");
    }
}
