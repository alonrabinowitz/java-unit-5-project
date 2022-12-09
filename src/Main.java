import processing.core.PApplet;

import java.util.ArrayList;

public class Main extends PApplet {
    public ArrayList<Rock> rocks;
    public ArrayList<Paper> papers;
    public ArrayList<Scissors> scissors;

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
        fill(0);
        text("Rocks: " + rocks.size(), 100, 15);
        text("Papers: " + papers.size(), 100, 30);
        text("Scissors: " + scissors.size(), 100, 45);
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
//        checkCollision(rocks, papers, scissors);
//        int prCount = 0;
//        for(Paper currP : papers){
//            for(int i = rocks.size()-1; i >= 0; i--){
//                Rock currR = rocks.get(i);
//                if(currP.x + currP.iW >= currR.x && currP.x <= currR.x + currR.iW && currP.y + currP.iH >= currR.y && currP.y <= currR.y + currR.iH) {
//                    rocks.remove(currR);
//                    prCount--;
//                }
//            }
//        }
        // Paper vs. Rock
        for(Paper currP : papers){
            for(int i = rocks.size()-1; i >= 0; i--){
                Rock currR = rocks.get(i);
                if(currP.x + currP.iW >= currR.x && currP.x <= currR.x + currR.iW && currP.y + currP.iH >= currR.y && currP.y <= currR.y + currR.iH) {
                    rocks.remove(currR);
                }
            }
        }
        //Rock vs. Scissors
        for(Rock currR : rocks){
            for(int i = scissors.size()-1; i >= 0; i--){
                Scissors currS = scissors.get(i);
                if(currS.x + currS.iW >= currR.x && currS.x <= currR.x + currR.iW && currS.y + currS.iH >= currR.y && currS.y <= currR.y + currR.iH) {
                    scissors.remove(currS);
                }
            }
        }
        // Scissors vs. Paper
        for(Scissors currS : scissors){
            for(int i = papers.size()-1; i >= 0; i--){
                Paper currP = papers.get(i);
                if(currP.x + currP.iW >= currS.x && currP.x <= currS.x + currS.iW && currP.y + currP.iH >= currS.y && currP.y <= currS.y + currS.iH) {
                    papers.remove(currP);
                }
            }
        }
    }

    public void checkCollision(ArrayList<Rock> rList, ArrayList<Paper> pList, ArrayList<Scissors> sList){
        // Paper vs. Rock
        for(Paper currP : pList){
            for(int i = rocks.size()-1; i >= 0; i--){
                Rock currR = rocks.get(i);
                if(currP.x + currP.iW >= currR.x && currP.x <= currR.x + currR.iW && currP.y + currP.iH >= currR.y && currP.y <= currR.y + currR.iH) {
                    rocks.remove(currR);
                }
            }
        }
        //Rock vs. Scissors
        for(Rock currR : rocks){
            for(int i = scissors.size()-1; i >= 0; i--){
                Scissors currP = scissors.get(i);
                if(currP.x + currP.iW >= currR.x && currP.x <= currR.x + currR.iW && currP.y + currP.iH >= currR.y && currP.y <= currR.y + currR.iH) {
                    rocks.remove(currR);
                }
            }
        }
        // Scissors vs. Paper
        for(Scissors currS : scissors){
            for(int i = pList.size()-1; i >= 0; i--){
                Paper currP = pList.get(i);
                if(currP.x + currP.iW >= currS.x && currP.x <= currS.x + currS.iW && currP.y + currP.iH >= currS.y && currP.y <= currS.y + currS.iH) {
                    pList.remove(currP);
                }
            }
        }
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
